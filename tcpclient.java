import java.io.*;
 import java.net.Socket;
import java.util.Scanner;

public class tcpclient {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost",6060);
        DataOutputStream dos = new DataOutputStream (s.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String str;
        while(!(str = sc.nextLine()).equals("exit")){
            dos.writeBytes(str+'\n');
        }
        dos.close();
        s.close();
        sc.close();
    }
}
