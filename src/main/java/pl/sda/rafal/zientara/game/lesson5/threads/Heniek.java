package pl.sda.rafal.zientara.game.lesson5.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Heniek implements Job.JobListener {
    private AtomicInteger counter = new AtomicInteger();
    private int threadsCount;

    public static void main(String[] args) {
        Heniek heniek = new Heniek();
        heniek.startThreads(100);
    }

    public void startThreads(int threadsCount) {
        this.threadsCount = threadsCount;
        counter.set(0);
        for (int i = 0; i < threadsCount; i++) {
            Runnable job = new Job(this);
            Thread thread = new Thread(job);
            thread.start();
        }
    }

    @Override
    public void onJobComplete() {
        counter.addAndGet(1);
        int finishedThreads = counter.get();
        System.out.println(finishedThreads + "/" + threadsCount);
        if (threadsCount == finishedThreads) {
            System.out.println("Wszystkie watki zakonczyly prace!");
        }
    }


}
