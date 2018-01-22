import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPHolePunchingServer {

    public static void main(String args[]) throws Exception {

    // Waiting for Connection of Client1 on Port 7070
    // ////////////////////////////////////////////////

    // open serverSocket on Port 7070
    DatagramSocket serverSocket1 = new DatagramSocket(7070);

    System.out.println("Waiting for Client 1 on Port "
            + serverSocket1.getLocalPort());

    // receive Data
    DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
    serverSocket1.receive(receivePacket);

    // Get IP-Address and Port of Client1
    InetAddress IPAddress1 = receivePacket.getAddress();
    int port1 = receivePacket.getPort();
    String msgInfoOfClient1 = IPAddress1 + "-" + port1 + "-";

    System.out.println("Client1: " + msgInfoOfClient1);

    // Waiting for Connection of Client2 on Port 7071
    // ////////////////////////////////////////////////

    // open serverSocket on Port 7071
    DatagramSocket serverSocket2 = new DatagramSocket(7071);

    System.out.println("Waiting for Client 2 on Port "
            + serverSocket2.getLocalPort());

    // receive Data
    receivePacket = new DatagramPacket(new byte[1024], 1024);
    serverSocket2.receive(receivePacket);

    // GetIP-Address and Port of Client1
    InetAddress IPAddress2 = receivePacket.getAddress();
    int port2 = receivePacket.getPort();
    String msgInfoOfClient2 = IPAddress2 + "-" + port2 + "-";

    System.out.println("Client2:" + msgInfoOfClient2);
 // Waiting for Connection of Client3 on Port 7072
    // ////////////////////////////////////////////////

    // open serverSocket on Port 7072
    DatagramSocket serverSocket3 = new DatagramSocket(7072);

    System.out.println("Waiting for Client 3 on Port "
            + serverSocket2.getLocalPort());

    // receive Data
    receivePacket = new DatagramPacket(new byte[1024], 1024);
    serverSocket3.receive(receivePacket);

    // GetIP-Address and Port of Client3
    InetAddress IPAddress3 = receivePacket.getAddress();
    int port3 = receivePacket.getPort();
    String msgInfoOfClient3 = IPAddress3 + "-" + port3 + "-";

    System.out.println("Client3:" + msgInfoOfClient3);
 // Waiting for Connection of Client4 on Port 7073
    // ////////////////////////////////////////////////

    // open serverSocket on Port 7073
    DatagramSocket serverSocket4 = new DatagramSocket(7073);

    System.out.println("Waiting for Client 4 on Port "
            + serverSocket4.getLocalPort());

    // receive Data
    receivePacket = new DatagramPacket(new byte[1024], 1024);
    serverSocket4.receive(receivePacket);

    // GetIP-Address and Port of Client4
    InetAddress IPAddress4 = receivePacket.getAddress();
    int port4 = receivePacket.getPort();
    String msgInfoOfClient4 = IPAddress4 + "-" + port4 + "-";

    System.out.println("Client4:" + msgInfoOfClient4);

    // Send the Information to the other Client
    // /////////////////////////////////////////////////

    // Send Information of Client2 to Client1,Client3,client4
    serverSocket1.send(new DatagramPacket(msgInfoOfClient2.getBytes(),
            msgInfoOfClient2.getBytes().length, IPAddress1, port1));
    serverSocket1.send(new DatagramPacket(msgInfoOfClient2.getBytes(),
            msgInfoOfClient2.getBytes().length, IPAddress3, port3));
    serverSocket1.send(new DatagramPacket(msgInfoOfClient2.getBytes(),
            msgInfoOfClient2.getBytes().length, IPAddress4, port4));

    // Send Infos of Client1 to Client2,Client3,client4
    serverSocket2.send(new DatagramPacket(msgInfoOfClient1.getBytes(),
            msgInfoOfClient1.getBytes().length, IPAddress2, port2));
    serverSocket2.send(new DatagramPacket(msgInfoOfClient1.getBytes(),
            msgInfoOfClient1.getBytes().length, IPAddress3, port3));
    serverSocket2.send(new DatagramPacket(msgInfoOfClient1.getBytes(),
            msgInfoOfClient1.getBytes().length, IPAddress4, port4));
 // Send Infos of Client3 to Client2,Client1,client4
    serverSocket3.send(new DatagramPacket(msgInfoOfClient3.getBytes(),
            msgInfoOfClient3.getBytes().length, IPAddress2, port2));
    serverSocket3.send(new DatagramPacket(msgInfoOfClient3.getBytes(),
            msgInfoOfClient3.getBytes().length, IPAddress1, port1));
    serverSocket3.send(new DatagramPacket(msgInfoOfClient3.getBytes(),
            msgInfoOfClient3.getBytes().length, IPAddress4, port4));
 // Send Infos of Client4 to Client2,Client3,client1
    serverSocket2.send(new DatagramPacket(msgInfoOfClient4.getBytes(),
            msgInfoOfClient4.getBytes().length, IPAddress2, port2));
    serverSocket2.send(new DatagramPacket(msgInfoOfClient4.getBytes(),
            msgInfoOfClient4.getBytes().length, IPAddress3, port3));
    serverSocket2.send(new DatagramPacket(msgInfoOfClient4.getBytes(),
            msgInfoOfClient4.getBytes().length, IPAddress1, port1));

    //close Sockets
    serverSocket1.close();
    serverSocket2.close();
    serverSocket3.close();
    serverSocket4.close();
}
}