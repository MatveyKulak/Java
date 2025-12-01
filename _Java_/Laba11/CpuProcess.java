package Laba11;

import java.util.Random;

public class CpuProcess extends Thread {
    private final int processCount;
    private final int minInterval;
    private final int maxInterval;
    private final int processType;
    private final Cpu cpu;
    private final Random random = new Random();

    public CpuProcess(int processCount, int minInterval, int maxInterval,
                      int processType, Cpu cpu) {
        this.processCount = processCount;
        this.minInterval = minInterval;
        this.maxInterval = maxInterval;
        this.processType = processType;
        this.cpu = cpu;
    }

    public void run() {
        for (int i = 0; i < processCount; i++) {
            try {
                int interval = minInterval + random.nextInt(maxInterval - minInterval + 1);
                Thread.sleep(interval);

                int processId = processType * 10 + i;
                System.out.println("Сгенерирован процесс " + processId + " (тип " + processType + ")");
                cpu.addProcessToQueue(processId);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}