package pl.sda.rafal.zientara.game.lesson4;

public class TenThreadsMain {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Twin twin1 = new Twin();
            Thread thread1 = new Thread(twin1);
            System.out.println(thread1);
            thread1.start();
        }
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
