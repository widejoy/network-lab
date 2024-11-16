import java.io.File;
import java.io.IOException;
import java.util.*;
public class arp {
    public static void main(String[] args) throws IOException{
            Scanner scanner = new Scanner(new File("arp.text"));
            Scanner sc = new Scanner(System.in);
            String mac,ip,input;
            int c;
            System.out.println("ENTER 1 FOR IP AND ENTER 2 FOR MAC:");
            c = sc.nextInt();
            sc.nextLine();
            System.out.println("ENTER YOUR INPUT:");
            input = sc.nextLine();
            if(c==1){
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    String[] parts = line.split("\\s+");
                    ip = parts[0];
                    mac = parts[1];
                    if(ip.equals(input)){
                        System.out.println("MAC: "+mac);
                        break;
                    }
                }   
            }
            else if(c==2){
                while(scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    String[] parts = line.split("\\s+");
                    ip = parts[0];
                    mac = parts[1];
                    if(mac.equals(input)){
                        System.out.println("IP: "+ip);
                        break;
                    }
                }  
            }
            scanner.close();
            sc.close();
    }
}
