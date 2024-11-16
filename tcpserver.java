import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class tcpserver {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6060);
        Socket s = ss.accept();
        BufferedReader br = new BufferedReader (new InputStreamReader(s.getInputStream()));
        String str;
		while((str = br.readLine()) != null){
			if (!(str.equalsIgnoreCase("exit"))) {
				System.out.println(str);
			}
			else{
				break;
			}
		}
		br.close();
		s.close();
		ss.close();
    }
}
