import java.io.*;
import java.net.*;
import java.util.*;

public class tcp2client {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost",6060);
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        String str;
        while(!(str = sc.nextLine()).equals("exit")){
            dos.writeBytes(str+"\n");
            System.out.println(br.readLine());
        }
        s.close();
        sc.close();
        br.close();
    }
}
