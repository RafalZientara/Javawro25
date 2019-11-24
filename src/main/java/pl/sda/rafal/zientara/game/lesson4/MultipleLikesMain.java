package pl.sda.rafal.zientara.game.lesson4;

import java.util.concurrent.atomic.AtomicInteger;

public class MultipleLikesMain {

    public static void main(String[] args) {
        AtomicInteger likes = new AtomicInteger(0);
        for (int i = 0; i < 10000; i++) {
            Liker liker = new Liker(likes);
            Thread thread = new Thread(liker);
            thread.start();
        }

        System.out.println("MAAAAAAAAIN " + likes);

    }

    private static class Liker implements Runnable {

        private final AtomicInteger integer;

        public Liker(AtomicInteger integer) {
            this.integer = integer;
        }

        @Override
        public void run() {
            synchronized (integer) {
                int currentLikes = integer.get();
                currentLikes++;
                integer.set(currentLikes);
                System.out.println(integer);
            }
        }
    }
}
