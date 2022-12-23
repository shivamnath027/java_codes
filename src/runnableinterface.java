class runnableinterface1 implements Runnable{
    public void run(){
        try {
            while (true) {
                System.out.println("Hello");
                Thread.sleep(1000);
            }
        }catch (Exception e){
            System.out.println("Excetion caught");
        }
    }
}
class runnableinterface{
    public static void main(String[] args){
        runnableinterface1 obj = new runnableinterface1();
        Thread t1 = new Thread(obj);
        t1.start();
    }
}