package Laba11;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cpu extends Thread {
    private final CpuQueue queue1;
    private final CpuQueue queue2;
    private final CpuQueue queue3;
    private final int minServiceTime;
    private final int maxServiceTime;
    private final Random random = new Random();
    private int interruptedProcesses = 0;
    private Integer currentProcess = null;
    private int remainingTime = 0;
    private final Lock lock = new ReentrantLock();

    public Cpu(CpuQueue queue1, CpuQueue queue2, CpuQueue queue3,
               int minServiceTime, int maxServiceTime) {
        this.queue1 = queue1;
        this.queue2 = queue2;
        this.queue3 = queue3;
        this.minServiceTime = minServiceTime;
        this.maxServiceTime = maxServiceTime;
    }

    public void addProcessToQueue(int processId) {
        int processType = processId / 10;

        lock.lock();
        try {
            if (currentProcess == null) {
                int serviceTime = minServiceTime + random.nextInt(maxServiceTime - minServiceTime + 1);
                setCurrentProcess(processId, serviceTime);
            } else {
                lock.unlock();
                if (processType == 1) {
                    queue1.add(processId);
                } else {
                    queue2.add(processId);
                }
                lock.lock();
            }

            if (currentProcess != null && currentProcess / 10 != processType) {
                System.out.println("Прерывание процесса " + currentProcess + " из-за нового процесса типа " + processType);
                queue3.add(currentProcess);
                interruptedProcesses++;
                currentProcess = null;
                remainingTime = 0;
            }
        } finally {
            lock.unlock();
        }
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Integer processId = getNextProcess();
                if (processId == null) {
                    Thread.sleep(100);
                    continue;
                }

                int serviceTime = minServiceTime + random.nextInt(maxServiceTime - minServiceTime + 1);
                System.out.println("Начата обработка процесса " + processId + ". Время обработки: " + serviceTime + " мс");
                setCurrentProcess(processId, serviceTime);

                while (getRemainingTime() > 0 && !Thread.currentThread().isInterrupted()) {
                    Thread.sleep(100);
                    decrementRemainingTime(100);
                }
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                clearCurrentProcess();
                System.out.println("Завершена обработка процесса " + processId);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private Integer getNextProcess() {
        lock.lock();
        try {
            if (!queue1.isEmpty()) return queue1.remove();
            if (!queue3.isEmpty()) return queue3.remove();
            if (!queue2.isEmpty()) return queue2.remove();
            return null;
        } finally {
            lock.unlock();
        }
    }

    private void setCurrentProcess(int processId, int serviceTime) {
        lock.lock();
        try {
            currentProcess = processId;
            remainingTime = serviceTime;
        } finally {
            lock.unlock();
        }
    }

    private void clearCurrentProcess() {
        lock.lock();
        try {
            currentProcess = null;
            remainingTime = 0;
        } finally {
            lock.unlock();
        }
    }

    private void decrementRemainingTime(int value) {
        lock.lock();
        try {
            remainingTime -= value;
        } finally {
            lock.unlock();
        }
    }

    private int getRemainingTime() {
        lock.lock();
        try {
            return remainingTime;
        } finally {
            lock.unlock();
        }
    }

    public boolean isProcessing() {
        lock.lock();
        try {
            return currentProcess != null || !queue1.isEmpty() || !queue2.isEmpty() || !queue3.isEmpty();
        } finally {
            lock.unlock();
        }
    }

    public int getInterruptedProcesses() {
        return interruptedProcesses;
    }
}