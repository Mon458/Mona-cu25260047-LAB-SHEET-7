class MyThread extends Thread {
    public void run() {
        System.out.println(getName() + " is running");
    }
}

public class Q8 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("High Priority");
        t2.setName("Low Priority");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);

        System.out.println("T1 Priority: " + t1.getPriority());
        System.out.println("T2 Priority: " + t2.getPriority());

        t1.start();
        t2.start();
    }
}
