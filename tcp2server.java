import java.io.*;
import java.net.*;
import java.util.Scanner;

public class tcp2server {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(6060);
        Socket s = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String str,str1;
        while((str = br.readLine()) != null){
            if (!(str.equalsIgnoreCase("exit"))) {
				System.out.println(str);
			}
			else{
				break;
			}
            str1 = sc.nextLine();
            dos.writeBytes(str1+'\n');
        }
        ss.close();
        sc.close();
    }
}
