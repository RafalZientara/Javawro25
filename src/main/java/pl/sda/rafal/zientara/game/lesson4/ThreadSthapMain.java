package pl.sda.rafal.zientara.game.lesson4;

import pl.sda.rafal.zientara.game.lesson1.psr.players.ScannerPlayer;

import java.util.Scanner;

public class ThreadSthapMain {

    public static void main(String[] args) {
        Runnable story = new NeverEndingStory();
        Thread thread = new Thread(story);
        thread.start();

        Scanner scanner = new Scanner(System.in);
        String next;
        do {
            System.out.println("Napisz exit aby przerwac");
            next = scanner.next();

            try {
                next.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!"exit".equals(next));
        System.out.println("Giń!");
        thread.interrupt();
        System.out.println("X_x");
    }

    private static class NeverEndingStory implements Runnable {

        @Override
        public void run() {
            int count = 0;
            while (!Thread.currentThread().isInterrupted()) {
                count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
