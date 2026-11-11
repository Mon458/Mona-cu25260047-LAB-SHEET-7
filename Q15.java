public class Q15 {
    static Object Lock1 = new Object();
    static Object Lock2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (Lock1) {
                System.out.println("Thread 1: Lock1 acquired");

                synchronized (Lock2) {
                    System.out.println("Thread 1: Lock2 acquired");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (Lock1) {
                System.out.println("Thread 2: Lock1 acquired");

                synchronized (Lock2) {
                    System.out.println("Thread 2: Lock2 acquired");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
