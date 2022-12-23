class Test{
        synchronized static void display(){
        for (int i = 1; i <= 5; i++)
            System.out.println("" + i);
    }
}
class A extends Thread{
    Test t2;
    A(Test i){
        t2=i;
    }
    public void run(){
     //   synchronized (t2) {
            t2.display();
       // }
    }
}
class B extends Thread{
    Test t1;
    B(Test i){
        t1 = i;
    }
    public void run(){
      //  synchronized (t1) {
            t1.display();
       // }
    }
}
public class Synchroniz {
    public static void main(String[] args){
        Test t1 = new Test();
        A p1 = new A(t1);
        B p2 = new B(t1);
        p1.start();
        p2.start();
    }
}
