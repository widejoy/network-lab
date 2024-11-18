import java.util.*;
import java.net.*;
import java.io.*;

public class udpserver {
    public static void main(String args[]) throws IOException {
		DatagramSocket ds = new DatagramSocket(9000);
		byte buff[] = new byte[6000];
        while(true){
            DatagramPacket dp = new DatagramPacket(buff, buff.length);
            ds.receive(dp);
            String str = new String(dp.getData(), 0, dp.getLength());
            System.out.println("client: " + str);
            if (str.equalsIgnoreCase("exit")) {
				break;
			}
			
			buff = new byte[60000];
        }
		ds.close();
	}
}