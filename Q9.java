class MyThread extends Thread {
    public void run() {
        System.out.println(getName() +
                " Priority: " + getPriority());
    }
}

public class Q9 {
    public static void main(String[] args) {
        MyThread[] t = new MyThread[5];

        int p = 1;

        for (int i = 0; i < 5; i++) {
            t[i] = new MyThread();
            t[i].setName("Thread " + (i + 1));
            t[i].setPriority(p);
            p += 2;
        }

        for (int i = 0; i < 5; i++) {
            t[i].start();
        }
    }
}
