import java.util.Scanner;
import java.net.*;
//import java.io.*;
public class p10udpserver
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        DatagramSocket skt=null;
        try
        {
            skt = new DatagramSocket(3780);
            System.out.println("Server is ready");
            while(true)
            {
                byte[] buffer=new byte[1024];
                DatagramPacket req= new DatagramPacket(buffer,buffer.length);   //constructs a datagram packet for recieveing packets of length (buffer.length)
                skt.receive(req);
                String msg=new String(req.getData());
                System.out.println("Client:" +msg);
                System.out.println("Server");
                String m=in.nextLine();
                byte[] sendmsg = m.getBytes();
                DatagramPacket reply=new DatagramPacket(sendmsg,sendmsg.length,req.getAddress(),req.getPort());
                skt.send(reply);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}