class MyThread extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Mona");
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}