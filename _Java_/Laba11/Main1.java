package Laba11;

public class Main1 {
    public static void main(String[] args) throws InterruptedException{
        CpuQueue queue1 = new CpuQueue("Q1 (для процессов типа 1)");
        CpuQueue queue2 = new CpuQueue("Q2 (для процессов типа 2)");
        CpuQueue queue3 = new CpuQueue("Q3 (для прерванных процессов типа 2)");

        Cpu cpu = new Cpu(queue1, queue2, queue3, 800, 2000);
        CpuProcess process1 = new CpuProcess(5, 500, 1500, 1, cpu);
        CpuProcess process2 = new CpuProcess(5, 300, 1000, 2, cpu);

        cpu.start();
        process1.start();
        process2.start();

        process1.join();
        process2.join();

        while (!queue1.isEmpty() || !queue2.isEmpty() || !queue3.isEmpty() || cpu.isProcessing()) {
            Thread.sleep(1000);
        }

        cpu.interrupt();
        cpu.join();

        System.out.println("Итог");
        System.out.println("Максимальная длина очереди Q1: " + queue1.getMaxSize());
        System.out.println("Максимальная длина очереди Q2: " + queue2.getMaxSize());
        System.out.println("Максимальная длина очереди Q3: " + queue3.getMaxSize());
        System.out.println("Количество прерванных процессов типа 2: " + cpu.getInterruptedProcesses());
    }
}