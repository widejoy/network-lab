import java.io.*;
import java.net.*;
import java.util.*;
public class udp2server {
    public static void main(String[] args) throws IOException{
        DatagramSocket ds = new DatagramSocket(9000);
		DatagramSocket ds1 = new DatagramSocket();

        byte buffer[] = new byte[6000];
        Scanner sc = new Scanner(System.in);
        InetAddress ip = InetAddress.getByName("localhost");
        while(true){
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            ds.receive(dp);
            String string = new String(dp.getData(),0,dp.getLength());
            if(string.equals("exit")){
                break;
            }
            System.out.println(string+"\n");
            String str = sc.nextLine();
            buffer = str.getBytes();
            DatagramPacket dp1 = new DatagramPacket(buffer, buffer.length,ip,6000);
            ds1.send(dp1);
            System.out.println(str+"\n");
            buffer = new byte[6000];
        }
    }
}
