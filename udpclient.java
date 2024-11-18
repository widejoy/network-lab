import java.util.*;
import java.net.*;
import java.io.*;

public class udpclient {
	public static void main(String args[])
	throws IOException {
		Scanner sc=new Scanner(System.in);
		DatagramSocket ds = new DatagramSocket();
		InetAddress ip = InetAddress.getByName("localhost");
		byte buff [];
		
		while(true) {
			String str = sc.nextLine();
			buff = str.getBytes();
			DatagramPacket dp = new DatagramPacket(buff, buff.length, ip, 9000);
			ds.send(dp);
			
			if (str.equalsIgnoreCase("exit"))
				break;
		}
		
		ds.close();
		sc.close();
	}
}