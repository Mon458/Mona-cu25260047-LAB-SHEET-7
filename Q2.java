class MyTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Mona");
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        MyTask obj = new MyTask();
        Thread t = new Thread(obj);
        t.start();
    }
}
