import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;
public class guiserver {
    public static DefaultListModel<String> lstmodel = new DefaultListModel<>();
    public static void creategui() throws IOException{
        ServerSocket ss = new ServerSocket(6060);
        Socket s = ss.accept();
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        JFrame frame = new JFrame("server");
        frame.setSize(300, 400);
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
        
        JList<String> lstview = new JList<>(lstmodel);
        JScrollPane sclpane = new JScrollPane(lstview);
        JPanel inppanel = new JPanel();
        inppanel.setLayout(new BoxLayout(inppanel,BoxLayout.X_AXIS));
        JTextField msgbox = new JTextField();
        JButton btn = new JButton("send");
        btn.addActionListener(e->{
            String text = msgbox.getText();
            try {
                dos.writeBytes(text+"\n");
                lstmodel.addElement("YOU:"+text+"\n");
            } catch (IOException e1) {
                 e1.printStackTrace();
            }
            msgbox.setText("");
        });
        inppanel.add(msgbox);
        inppanel.add(btn);
        inppanel.setMaximumSize(new Dimension(Integer.MAX_VALUE,40));
        mainpanel.add(sclpane);
        mainpanel.add(inppanel);
        frame.add(mainpanel);
        frame.setVisible(true);
        Thread receiveThread = new Thread(() -> {
            try {
                String receivedMessage;
                while ((receivedMessage = br.readLine()) != null) {
                    lstmodel.addElement("CLIENT: " + receivedMessage);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        receiveThread.start();
    }
    public static void main(String[] args) throws IOException{
        creategui();
    }
}
