import java.awt.*;  
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JPanel;
import javax.swing.Timer;
public class PingPong{
	
	public static void main(String[] args)throws Exception{  
//---------------------server------------------------------------------------------------
		int ClientID=1;
		InetAddress ip3=null;
		int port3=0;
		InetAddress ip4=null;
		int port4=0;
		DatagramSocket clientSocket1 = new DatagramSocket();
        int localPort = clientSocket1.getLocalPort();
        // prepare Data
        byte[] sendData1 = "Hello".getBytes();
        
        
        // send Data to Server with fix IP (X.X.X.X)
        // Client1 uses port 7070, Client2 uses port 7070
        DatagramPacket sendPacket1 = new DatagramPacket(sendData1,
                sendData1.length, InetAddress.getByName("192.168.0.108"), 7069+ClientID);
        clientSocket1.send(sendPacket1);
        // receive Data ==> Format:"<IP of other Client>-<Port of other Client>"
      //---------------------------------------------------get client 2--------------------------
        DatagramPacket receivePacket1 = new DatagramPacket(new byte[1024], 1024);
        clientSocket1.receive(receivePacket1);
        // Convert Response to IP and Port
        String response1 = new String(receivePacket1.getData());
        String[] splitResponse1 = response1.split("-");
        InetAddress ip2 = InetAddress.getByName(splitResponse1[0].substring(1));
        int port2 = Integer.parseInt(splitResponse1[1]);
        // output converted Data for check
        System.out.println("IP: " + ip2 + " PORT: " + port2);
        //---------------------------------------------------get client 3--------------------------
        try{
	        receivePacket1.setData(new byte[1024]);
	        clientSocket1.receive(receivePacket1);
	        String response2 = new String(receivePacket1.getData());
	        String[] splitResponse2 = response2.split("-");
	        ip3 = InetAddress.getByName(splitResponse2[0].substring(1));
		
	        port3 = Integer.parseInt(splitResponse2[1]);
	
	        // output converted Data for check
	        System.out.println("IP: " + ip3 + " PORT: " + port3);
        } catch (Exception e) {
            System.out.println("SERVER TIMED OUT");
      }
      //---------------------------------------------------get client 4--------------------------
        try{
		        receivePacket1.setData(new byte[1024]);
		        clientSocket1.receive(receivePacket1);
		        String response3 = new String(receivePacket1.getData());
		        String[] splitResponse3 = response3.split("-");
		        ip4 = InetAddress.getByName(splitResponse3[0].substring(1));
		
		        port4 = Integer.parseInt(splitResponse3[1]);
		
		        // output converted Data for check
		        System.out.println("IP: " + ip4 + " PORT: " + port4);
		        // close socket and open new socket with SAME localport
		} catch (Exception e) {
		        System.out.println("SERVER TIMED OUT");
		}
        
        clientSocket1.close();
        clientSocket1 = new DatagramSocket(localPort);
        // set Timeout for receiving Data
        
        clientSocket1.setSoTimeout(1000);
//--------------------------------------------------------------------------------------
		JFrame f=new JFrame("Ping Pong");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameBoardPanel gameBoardPanel= new GameBoardPanel(ClientID,ip2,port2,ip3,port3,ip4,port4,clientSocket1,receivePacket1);
		f.add(gameBoardPanel, BorderLayout.CENTER);
		f.setSize(1200, 700);    
		f.setVisible(true);
	}  
}