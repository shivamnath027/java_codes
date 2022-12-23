import java.util.Scanner;
class Mythread extends Thread{
    String str;
    Mythread(String x){
        str=x;
    }
    public void run(){
        try {
            while (true) {
                System.out.println("" + str);
                //System.out.println("------------------");
                Thread.sleep(1000);
            }
        }catch (Exception e){
            System.out.println("Caught");
        }
    }
}
class Nath extends Thread{
    String x;
    Nath(String i){
        x=i;
    }
    public void run(){
        try {
            while (true) {
                System.out.println("" + x);
                //System.out.println("-------------------------");
                Thread.sleep(1000);
            }
        }catch (Exception e){
            System.out.println("Exception caught");
        }
    }
}
class runu{
    public  static void main(String[] args) {
        Mythread t1 = new Mythread("Hello world\n");
        t1.start();
        Nath t2 = new Nath("Hello Nath");
        t2.start();
    }
}
