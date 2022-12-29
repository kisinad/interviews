package io.denis.kisina.threads_and_locks;

class RunnableThreadExample implements Runnable {

    private int count = 0;

    public void run() {
        System.out.println("RunnableThread starting.");

        try {
            while (count < 5) {
                Thread.sleep(500);
                count++;
            }
        }catch (InterruptedException exc) {
            System.out.println("RunnableThread interrupted.");
            throw new IllegalArgumentException();
        }
        System.out.println("RunnableThread terminating.");
    }

    public static void main(String[] args) {
        RunnableThreadExample threadExample = new RunnableThreadExample();
        Thread thread = new Thread(threadExample);
        thread.start();

        while (threadExample.count != 5){
            try {
                Thread.sleep(250);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
                throw new IllegalArgumentException();
            }
        }
    }
}
