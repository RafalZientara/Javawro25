package pl.sda.rafal.zientara.game.lesson4;

public class TwinThreadsMain {
    public static void main(String[] args) {
        Twin twin1 = new Twin();
        Twin twin2 = new Twin();
        Thread thread1 = new Thread(twin1);
        Thread thread2 = new Thread(twin2);
        thread1.start();
        thread2.start();
    }

    private static class Twin implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " " + (i + 1));
            }
        }
    }
}
