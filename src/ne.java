import java.io.*;
import java.net.*;
import java.util.Scanner;
class ne{
    public static void main(String[] args){
        DatagramSocket skt=null;
        Scanner ip = new Scanner(System.in);
        try{
            skt = new DatagramSocket(3780);
            System.out.println("Server is Ready");
            while(true){
                byte[] buffer = new byte[1024];
                DatagramPacket req = new DatagramPacket(buffer,buffer.length);
                skt.receive(req);
                String message = new String(req.getData());
                System.out.println("Client: "+message);
                System.out.println("Server: ");
                String reply = ip.nextLine();
                byte[] msg = reply.getBytes();
                DatagramPacket repl = new DatagramPacket(msg,msg.length,req.getAddress(),req.getPort());
                skt.send(repl);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}