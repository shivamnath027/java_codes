import java.net.*;
import java.io.*;
import java.util.Scanner;
public class tcpclient {
    public static void main(String[] args) {
        Socket s;
        Scanner input= new Scanner(System.in);
        while(true) {
            try {
                s=new Socket("127.0.0.1",3000);
                OutputStream ostream = s.getOutputStream();
                System.out.println("enter filename");
                String fname= input.nextLine();
                PrintWriter pwrite = new PrintWriter(ostream, true);
                pwrite.println(fname);
                InputStream istream= s.getInputStream();
                Scanner cRead= new Scanner (new InputStreamReader(istream));
                while(cRead.hasNext())
                    System.out.println(cRead.nextLine());
                pwrite.close();
                s.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}