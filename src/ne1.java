import java.util.*;
import java.io.*;
import java.net.*;
class ne1{
    public static void main(String[] args){
        DatagramSocket skt;
        try{
            InetAddress host = InetAddress.getByName("127.0.0.1");
            Scanner ip = new Scanner(System.in);
            int s_port = 3780;
            skt = new DatagramSocket();
            while(true){
                System.out.println("Client: ");
                String msg = ip.nextLine();
                byte[] b = msg.getBytes();
                DatagramPacket req = new DatagramPacket(b,b.length,host,s_port);
                skt.send(req);
                byte[] m = new byte[1024];
                DatagramPacket recv = new DatagramPacket(m,m.length);
                System.out.println("Server: "+new String(recv.getData()));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}