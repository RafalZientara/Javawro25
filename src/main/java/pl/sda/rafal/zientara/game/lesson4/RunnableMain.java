package pl.sda.rafal.zientara.game.lesson4;

public class RunnableMain {
    public static void main(String[] args) {
        Quest quest = new Quest();
        Thread thread = new Thread(quest);
        thread.start();

        Thread cthread = Thread.currentThread();
        System.out.println(cthread.getName());
    }

    private static class Quest implements Runnable {

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName());
        }
    }
}
