package pl.sda.rafal.zientara.game.lesson4;

public class ExtendsThread {

    public static void main(String[] args) {
        Quest quest = new Quest();
        quest.start();
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
    }

    private static class Quest extends Thread {

        @Override
        public void run() {
//            super.run();
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName());
        }
    }
}
