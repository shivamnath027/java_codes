import java.util.Scanner;
import java.net.*;
import java.io.*;
public class tcpserver {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=null;    //serversocket
        Socket s=null;    //client socket
        try {
            ss=new ServerSocket(3000);  //Creates a server socket(ss), bound to the specified port
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        while(true) {
            try {
                System.out.println("SERVER READY!!..");
                s = ss.accept();                        //accept() : returns The new Socket :: The accept() method of ServerSocket class is used to accept the incoming request to the socket.
                System.out.println("CLIENT CONNECTED..");
                InputStream istream = s.getInputStream();
                Scanner fread= new Scanner(new InputStreamReader(istream));
                String fileName= fread.nextLine();
                System.out.println("reading contents of "+fileName);
                Scanner contentRead= new Scanner(new FileReader(fileName));
                OutputStream ostream= s.getOutputStream();
                PrintWriter pwrite = new PrintWriter(ostream,true);      //character into bytes
                //String str;
                while(contentRead.hasNext())
                    pwrite.println(contentRead.nextLine());
                pwrite.close();
                s.close();
            }
            catch(FileNotFoundException e1) {
                System.out.println("file not found");
                OutputStream ostream = s.getOutputStream();
                PrintWriter pwrite = new PrintWriter(ostream, true);
                pwrite.close();
            }
            catch(Exception e)
            {}
        }
    }
}