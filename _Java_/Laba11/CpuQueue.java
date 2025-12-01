package Laba11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CpuQueue {
    private final Queue<Integer> queue = new LinkedList<>();
    private int maxSize = 0;
    private final String name;
    private final Lock lock = new ReentrantLock();

    public CpuQueue(String name) {
        this.name = name;
    }

    public void add(int processId) {
        lock.lock();
        try {
            queue.add(processId);
            if (queue.size() > maxSize) {
                maxSize = queue.size();
            }
            System.out.println("Процесс " + processId + " добавлен в очередь " + name +
                    ". Текущий размер: " + queue.size());
        } finally {
            lock.unlock();
        }
    }

    public Integer remove() {
        lock.lock();
        try {
            if (queue.isEmpty()) {
                return null;
            }
            int processId = queue.remove();
            System.out.println("Процесс " + processId + " извлечен из очереди " + name +
                    ". Осталось процессов: " + queue.size());
            return processId;
        } finally {
            lock.unlock();
        }
    }

    public boolean isEmpty() {
        lock.lock();
        try {
            return queue.isEmpty();
        } finally {
            lock.unlock();
        }
    }

    public int getMaxSize() {
        return maxSize;
    }
}