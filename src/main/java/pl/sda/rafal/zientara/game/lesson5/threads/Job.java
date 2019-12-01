package pl.sda.rafal.zientara.game.lesson5.threads;

import java.util.Random;

public class Job implements Runnable {
    private JobListener heniek;

    public Job(JobListener listener) {
        this.heniek = listener;
    }

    @Override
    public void run() {
        try {
            doJob();
            heniek.onJobComplete();
        }catch (Exception e) {
            heniek.onError(e);
        }
    }

    private void doJob() {
        Thread thread = Thread.currentThread();
        System.out.println("Robie " + thread.getName());
        int seconds = new Random().nextInt(10) + 1;
        try {
            System.out.println("Nie moge.");
            System.out.println("Mam spanko przez " + seconds
                    + " " + thread.getName());
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Koniec " + thread.getName());
    }

    public interface JobListener {
        void onJobComplete();
        void onError(Exception e);
    }

}
