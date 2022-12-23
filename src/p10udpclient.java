import java.util.Scanner;
import java.net.*;
import java.io.*;
public class p10udpclient
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        DatagramSocket skt;
        try
        {
            skt=new DatagramSocket();
            InetAddress host=InetAddress.getByName("127.0.0.1");
            int s_port=3780;
            while(true)
            {
                System.out.println("Client");
                String msg=in.nextLine();
                byte[] b = msg.getBytes();
                DatagramPacket request=new DatagramPacket(b,b.length,host,s_port);   //send
                skt.send(request);
                byte buffer[]=new byte[1024];
                DatagramPacket reply=new DatagramPacket(buffer,buffer.length);   //accept
                skt.receive(reply);
                System.out.println("Server:"+new String(reply.getData()));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
