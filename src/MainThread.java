import java.util.Random;
class SquareThread implements Runnable {
    int x;
    SquareThread(int x) {
        this.x = x;
    }
    public void run() {
        System.out.println("Square Thread and Square is: "+ x * x);
    }
}
class CubeThread implements Runnable {
    int x;
    CubeThread(int x) {
        this.x = x;
    }
    public void run() {
        System.out.println("Cube Thread and Cube is: "+ x * x * x);
    }
}
class RandomThread implements Runnable {
    Random r;
    Thread t2, t3;
    public void run() {
        int num;
        r = new Random();
        try {
            while (true) {
                num = r.nextInt(100);
                System.out.println("Random Thread and Number is: "+ num);
                t2 = new Thread(new SquareThread(num));
                t2.start();
                t3 = new Thread(new CubeThread(num));
                t3.start();
                Thread.sleep(1000);
                System.out.println("--------------------------------------");
            }
        } catch (Exception ex) {
            System.out.println("Exception Caught");
        }
    }
}
public class MainThread {
    public static void main(String[] args) {
        RandomThread thread_obj = new RandomThread();
        Thread t1 = new Thread(thread_obj);
        t1.start();
    }
}