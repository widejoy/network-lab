import java.io.*;
import java.net.*;
import java.util.Scanner;

public class udp2client {
    public static void main(String[] args) throws IOException{
        DatagramSocket ds = new DatagramSocket();
		DatagramSocket ds1 = new DatagramSocket(6000);
        Scanner sc = new Scanner(System.in);
        byte buffer[] = new byte[6000];
        byte buffer1[] = new byte[6000];
        InetAddress ip = InetAddress.getByName("localhost");
        while(true){
                String str = sc.nextLine();
                buffer = str.getBytes();
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length, ip, 9000);
                ds.send(dp);
                System.out.println(str+"\n");
                buffer = new byte[6000];
                DatagramPacket dp1 = new DatagramPacket(buffer1, buffer1.length);
                ds1.receive(dp1);
                String str1 = new String(dp1.getData(),0,dp.getLength());
                System.out.println(str1 +"\n");
                if (str.equalsIgnoreCase("exit"))
                    break;
                buffer = new byte[6000];
        }
    }
}
