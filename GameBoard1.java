import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
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
public class GameBoardPanel extends JPanel implements ActionListener, KeyListener{
    public int ClientID;
	public DatagramSocket clientSocket ;
	public DatagramPacket receivePacket;
	public int port02 = 0;
	public InetAddress ip02 = null;
	public int port03 = 0;
	public InetAddress ip03 = null;
	public int port04 = 0;
	public InetAddress ip04 = null;
	public byte[] sendData = "Hello".getBytes();
	public DatagramPacket sendPacket;
	private double ballSpeed = 2.5;
	private double ballX = 600;
	private double ballY = 330;
	private double ballDiameter = 20;
	private double ballXSpeed = 1.5;
	private double ballYSpeed = 2;
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	private double paddleWidth = 20;
	private double paddleOneX = 550;
	private double paddleOneY = 635;
	private double paddleOneLength = 100;
	private double paddleTwoX = 550;
	private double paddleTwoY = 5;
	private double paddleTwoLength = 100;
	private double paddleThreeX = 905;
	private double paddleThreeY = 280;
	private double paddleThreeLength = 100;
	private double paddleFourX = 275;
	private double paddleFourY = 280;
	private double paddleFourLength = 100;
	private double paddleSpeed = 2;
	private int playerOneScore;
	private int playerTwoScore;
	private int playerThreeScore;
	private int playerFourScore;
    
	public GameBoardPanel(int ID,InetAddress ip2,int port2,InetAddress ip3,int port3,InetAddress ip4,int port4,DatagramSocket clientSocket1,DatagramPacket receivePacket1){
		clientSocket = clientSocket1;
		receivePacket = receivePacket1;
		port02 = port2;
		ip02 = ip2;
		port03 = port3;
		ip03 = ip3;
		port04 = port4;
		ip04 = ip4;
		ClientID=ID;
		switch(ClientID){
		case 1:
			break;
		case 2:
			 paddleOneX = 550;
			 paddleOneY = 5;
	
			 paddleTwoX = 550;
			 paddleTwoY = 635;
			 paddleThreeX = 275;
			 paddleThreeY = 280;
			
			 paddleFourX = 905;
			 paddleFourY = 280;
			 break;
		case 3:
			 paddleOneX = 275;
			 paddleOneY = 280;
	
			 paddleTwoX =  905;
			 paddleTwoY = 280;
			 paddleThreeX =550;
			 paddleThreeY = 635;
			
			 paddleFourX = 550;
			 paddleFourY = 5;
			 break;
		case 4:
			 paddleOneX = 905;
			 paddleOneY = 280;
	
			 paddleTwoX = 275;
			 paddleTwoY = 280;
			 paddleThreeX = 550;
			 paddleThreeY = 5;
			
			 paddleFourX = 550;
			 paddleFourY =  635;
			 break;
		
		}
		setFocusable(true);
		addKeyListener(this);
		Timer timer = new Timer(2, this);
		timer.start();
		
	}
	public void actionPerformed(ActionEvent e) {
		try {
			step();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	//call this method from a Timer to move the ball!
	public void step() throws Exception{
		
		
		if(ClientID==1){
		//If the ball strikes paddle one
		if(ballY + ballDiameter > paddleOneY && ballX + ballDiameter > paddleOneX && ballX < paddleOneX + paddleOneLength)
			ballYSpeed *= -1;
		else{
			//If the ball strikes the corners towards player 1
			if(ballY + ballDiameter > 619)
				if(ballX + ballDiameter / 2 > 890 || ballX + ballDiameter / 2 < 309)
					ballYSpeed *= -1;
			//If the ball is missed by paddle one
			if(ballY > 653){
				ballX = 600;
				ballY = 330;
				double d;
				do
					d = Math.random();
				while(Math.abs(Math.cos(2*Math.PI*d))<0.02 || Math.abs(Math.sin(2*Math.PI*d))<0.02);
				ballXSpeed = ballSpeed * Math.cos(2 * Math.PI * d);
				ballYSpeed = ballSpeed * Math.sin(2 * Math.PI * d);
				playerOneScore++;;
			}
		}
		//If the ball collides with paddle one from the side
		if(ballY + ballDiameter / 2 > paddleOneY)
			if(ballX + ballDiameter >= paddleOneX && ballX <= paddleOneX + paddleOneLength){
				ballX = 600;
				ballY = 330;
				double d;
				do
					d = Math.random();
				while(Math.abs(Math.cos(2*Math.PI*d))<0.02||Math.abs(Math.sin(2*Math.PI*d))<0.02);
				ballXSpeed = ballSpeed * Math.cos(2 * Math.PI * d);
				ballYSpeed = ballSpeed * Math.sin(2 * Math.PI * d);
				playerOneScore++;
			}
		//If the ball strikes paddle two
		if(ballY < paddleTwoY + paddleWidth && ballX + ballDiameter > paddleTwoX && ballX < paddleTwoX + paddleTwoLength)
			ballYSpeed *= -1;
		else{
			//If the ball strikes the corners towards player 2
			if(ballY < 40)
				if(ballX + ballDiameter / 2 > 890 || ballX + ballDiameter / 2 < 309)
					ballYSpeed *= -1;
			//If the ball is missed by paddle two
			if(ballY + ballDiameter < 2){
				ballX = 600;
				ballY = 330;
				double d;
				do
					d = Math.random();
				while(Math.abs(Math.cos(2*Math.PI*d))<0.02 || Math.abs(Math.sin(2*Math.PI*d))<0.02);
				ballXSpeed = ballSpeed * Math.cos(2 * Math.PI * d);
				ballYSpeed = ballSpeed * Math.sin(2 * Math.PI * d);
				playerTwoScore++;
			}
		}
		//If the ball collides with paddle two from the side
		if(ballY + ballDiameter / 2 < paddleTwoY + paddleWidth)
			if(ballX + ballDiameter >= paddleTwoX && ballX <= paddleTwoX + paddleTwoLength){
				ballX = 600;
				ballY = 330;
				double d;
				do
					d = Math.random();
				while(Math.abs(Math.cos(2*Math.PI*d))<0.02||Math.abs(Math.sin(2*Math.PI*d))<0.02);
				ballXSpeed = ballSpeed * Math.cos(2 * Math.PI * d);
				ballYSpeed = ballSpeed * Math.sin(2 * Math.PI * d);
				playerTwoScore++;
			}
		//If the ball strikes paddle three
		if(ballX + ballDiameter > paddleThreeX && ballY + ballDiameter > paddleThreeY && ballY < paddleThreeY + paddleThreeLength)
			ballXSpeed *= -1;
		else{
			//If the ball strikes the corners towards player 3
			if(ballX + ballDiameter > 889)
				if(ballY + ballDiameter / 2 > 620 || ballY + ballDiameter / 2 < 39)
					ballXSpeed *= -1;
			//If the ball is missed by paddle three
			if(ballX > 923){
				ballX = 600;
				ballY = 330;
				double d;
				do
					d = Math.random();
				while(Math.abs(Math.cos(2*Math.PI*d))<0.02 || Math.abs(Math.sin(2*Math.PI*d))<0.02);
				ballXSpeed = ballSpeed * Math.cos(2 * Math.PI * d);
				ballYSpeed = ballSpeed * Math.sin(2 * Math.PI * d);
				playerThreeScore++;;
			}
		}
		//If the ball collides with paddle three from the side
		if(ballX + ballDiameter / 2 > paddleThreeX)
			if(ballY + ballDiameter >= paddleThreeY && ballY <= paddleThreeY + paddleThreeLength){
				ballX = 600;
				ballY = 330;
				double d;
				do
					d = Math.random();
				while(Math.abs(Math.cos(2*Math.PI*d))<0.02||Math.abs(Math.sin(2*Math.PI*d))<0.02);
				ballXSpeed = ballSpeed * Math.cos(2 * Math.PI * d);
				ballYSpeed = ballSpeed * Math.sin(2 * Math.PI * d);
				playerThreeScore++;
			}
		//If the ball strikes paddle four
		if(ballX < paddleFourX + paddleWidth && ballY + ballDiameter > paddleFourY && ballY < paddleFourY + paddleFourLength)
			ballXSpeed *= -1;
		else{
			//If the ball strikes the corners towards player 4
			if(ballX < 310)
				if(ballY + ballDiameter / 2 > 620 || ballY + ballDiameter / 2 < 39)
					ballXSpeed *= -1;
			//If the ball is missed by paddle four
			if(ballX + ballDiameter < 272){
				ballX = 600;
				ballY = 330;
				double d;
				do
					d = Math.random();
				while(Math.abs(Math.cos(2*Math.PI*d))<0.02 || Math.abs(Math.sin(2*Math.PI*d))<0.02);
				ballXSpeed = ballSpeed * Math.cos(2 * Math.PI * d);
				ballYSpeed = ballSpeed * Math.sin(2 * Math.PI * d);
				playerFourScore++;;
			}
		}
		//If the ball collides with paddle four from the side
		if(ballX + ballDiameter / 2 < paddleFourX + paddleWidth)
			if(ballY + ballDiameter >= paddleFourY && ballY <= paddleFourY + paddleFourLength){
				ballX = 600;
				ballY = 330;
				double d;
				do
					d = Math.random();
				while(Math.abs(Math.cos(2*Math.PI*d))<0.02||Math.abs(Math.sin(2*Math.PI*d))<0.02);
				ballXSpeed = ballSpeed * Math.cos(2 * Math.PI * d);
				ballYSpeed = ballSpeed * Math.sin(2 * Math.PI * d);
				playerFourScore++;
			}
		ballY += ballYSpeed;
		ballX += ballXSpeed;
		}
		switch(ClientID){
		case 1:
			if (leftPressed) 
				if (paddleOneX-paddleSpeed > 310) 
					paddleOneX -= paddleSpeed;
			if (rightPressed) 
				if (paddleOneX + paddleSpeed + paddleOneLength < 890)
					paddleOneX += paddleSpeed;
			break;
		case 2:  
			if (leftPressed) 
				if (paddleTwoX-paddleSpeed > 310) 
					paddleTwoX -= paddleSpeed;
			if (rightPressed) 
				if (paddleTwoX + paddleSpeed + paddleOneLength < 890)
					paddleTwoX += paddleSpeed;
		break;
		case 3:  
			if (leftPressed) 
				if (paddleThreeX-paddleSpeed > 310) 
					paddleThreeX -= paddleSpeed;
			if (rightPressed) 
				if (paddleThreeX + paddleSpeed + paddleOneLength < 890)
					paddleThreeX += paddleSpeed;
		break;
		case 4:  
			if (leftPressed) 
				if (paddleFourX-paddleSpeed > 310) 
					paddleFourX -= paddleSpeed;
			if (rightPressed) 
				if (paddleFourX + paddleSpeed + paddleOneLength < 890)
					paddleFourX += paddleSpeed;
		break;
	}
		//---------------------------------------------------------------------------------
		switch(ClientID){
		case 1:  sendData = ("Client1"+","+paddleOneX +","+ paddleOneY+","+ballX +","+ ballY).getBytes();
		break;
		case 2:  sendData = ("Client2"+","+paddleTwoX +","+ paddleTwoY).getBytes();
		break;
		case 3:  sendData = ("Client3"+","+paddleThreeX +","+ paddleThreeY).getBytes();
		break;
		case 4:  sendData = ("Client4"+","+paddleFourX +","+ paddleFourY).getBytes();
		break;
	}
	sendPacket = new DatagramPacket(sendData, sendData.length, ip02, port02);
	clientSocket.send(sendPacket);
	sendPacket = new DatagramPacket(sendData, sendData.length, ip04, port04);
	clientSocket.send(sendPacket);
	sendPacket = new DatagramPacket(sendData, sendData.length, ip03, port03);
	clientSocket.send(sendPacket);
	// receive Message from other client
	try {
		receivePacket.setData(new byte[1024]);
		clientSocket.receive(receivePacket);
		System.out.println("REC: "
				+ new String(receivePacket.getData()));
		String rec1=new String(receivePacket.getData());
		String[] pad=rec1.split(",");
		if(ClientID==1){
			switch(pad[0]){
			case "Client2":  paddleTwoX = 1200-Float.valueOf(pad[1]); paddleTwoY = 5;
			break;
			case "Client3":  paddleThreeY = 925-Float.valueOf(pad[1]); paddleThreeX = 905;
			break;
			case "Client4":  paddleFourY = Float.valueOf(pad[1])-270;paddleFourX = 275;
			break;
			}
			
		}
		if(ClientID==2){
			switch(pad[0]){
				case "Client1":  paddleOneX = 1200-Float.valueOf(pad[1]);paddleOneY = 5;ballX=1200-Float.valueOf(pad[3]);ballY=655-Float.valueOf(pad[4]);
				break;
				case "Client3":  paddleThreeY = Float.valueOf(pad[1])-270;paddleThreeX = 275;
				break;
				case "Client4":  paddleFourY = 925-Float.valueOf(pad[1]); paddleFourX = 905;
				break;
			}
//			paddleTwoX=1200-paddleTwoX;paddleTwoY=635;
		}
		if(ClientID==3){
			switch(pad[0]){
				case "Client2":  paddleTwoY= 925-Float.valueOf(pad[1]); paddleTwoX = 905;
				break;
				case "Client1":  paddleOneY =Float.valueOf(pad[1])-270;paddleOneX = 275;ballX=1200-Float.valueOf(pad[3]);ballY=Float.valueOf(pad[4]);
				break;
				case "Client4":  paddleFourX = 1200-Float.valueOf(pad[1]);paddleFourY = 5;
				break;
			}
//			paddleThreeX=925-paddleThreeY;paddleThreeY=635;
		}
		if(ClientID==4){
			switch(pad[0]){
				case "Client2":  paddleTwoY = Float.valueOf(pad[1])-270;paddleTwoX = 275;
				break;
				case "Client3":  paddleThreeX =  1200-Float.valueOf(pad[1]);paddleThreeY = 5;
				break;
				case "Client1":  paddleFourY = 925-Float.valueOf(pad[1]); paddleFourX = 905;ballX=Float.valueOf(pad[3]);ballY=655-Float.valueOf(pad[4]);
				break;
			}
//			paddleFourX=270+paddleFourY;paddleFourY=635;
		}
		
	} catch (Exception e) {
		System.out.println("SERVER TIMED OUT");
	}
	//-----------------------------------------------------to client 3--------------------------------------
	// receive Message from other client
	try {
		receivePacket.setData(new byte[1024]);
		clientSocket.receive(receivePacket);
		System.out.println("REC: "
				+ new String(receivePacket.getData()));
		String rec1=new String(receivePacket.getData());
		String[] pad=rec1.split(",");
		if(ClientID==1){
			switch(pad[0]){
			case "Client2":  paddleTwoX = 1200-Float.valueOf(pad[1]); paddleTwoY = 5;
			break;
			case "Client3":  paddleThreeY = 925-Float.valueOf(pad[1]); paddleThreeX = 905;
			break;
			case "Client4":  paddleFourY = Float.valueOf(pad[1])-270;paddleFourX = 275;
			break;
			}
			
		}
		if(ClientID==2){
			switch(pad[0]){
				case "Client1":  paddleOneX = 1200-Float.valueOf(pad[1]);paddleOneY = 5;ballX=1200-Float.valueOf(pad[3]);ballY=655-Float.valueOf(pad[4]);
				break;
				case "Client3":  paddleThreeY = Float.valueOf(pad[1])-270;paddleThreeX = 275;
				break;
				case "Client4":  paddleFourY = 925-Float.valueOf(pad[1]); paddleFourX = 905;
				break;
			}
		//	paddleTwoX=1200-paddleTwoX;paddleTwoY=635;
		}
		if(ClientID==3){
			switch(pad[0]){
				case "Client2":  paddleTwoY= 925-Float.valueOf(pad[1]); paddleTwoX = 905;
				break;
				case "Client1":  paddleOneY =Float.valueOf(pad[1])-270;paddleOneX = 275;ballX=1200-Float.valueOf(pad[3]);ballY=Float.valueOf(pad[4]);
				break;
				case "Client4":  paddleFourX = 1200-Float.valueOf(pad[1]);paddleFourY = 5;
				break;
			}
	//		paddleThreeX=925-paddleThreeY;paddleThreeY=635;
		}
		if(ClientID==4){
			switch(pad[0]){
				case "Client2":  paddleTwoY = Float.valueOf(pad[1])-270;paddleTwoX = 275;
				break;
				case "Client3":  paddleThreeX =  1200-Float.valueOf(pad[1]);paddleThreeY = 5;
				break;
				case "Client1":  paddleFourY = 925-Float.valueOf(pad[1]); paddleFourX = 905;ballX=Float.valueOf(pad[3]);ballY=655-Float.valueOf(pad[4]);
				break;
			}
		//	paddleFourX=270+paddleFourY;paddleFourY=635;
		}
	} catch (Exception e) {
		System.out.println("SERVER TIMED OUT");
	}
	//------------------------------------------------------to client 4------------------------------------------------------------
	// receive Message from other client
	try {
		receivePacket.setData(new byte[1024]);
		clientSocket.receive(receivePacket);
		System.out.println("REC: "
				+ new String(receivePacket.getData()));
		String rec1=new String(receivePacket.getData());
		String[] pad=rec1.split(",");
		if(ClientID==1){
			switch(pad[0]){
			case "Client2":  paddleTwoX = 1200-Float.valueOf(pad[1]); paddleTwoY = 5;
			break;
			case "Client3":  paddleThreeY = 925-Float.valueOf(pad[1]); paddleThreeX = 905;
			break;
			case "Client4":  paddleFourY = Float.valueOf(pad[1])-270;paddleFourX = 275;
			break;
			}
			
		}
		if(ClientID==2){
			switch(pad[0]){
				case "Client1":  paddleOneX = 1200-Float.valueOf(pad[1]);paddleOneY = 5;ballX=1200-Float.valueOf(pad[3]);ballY=655-Float.valueOf(pad[4]);
				break;
				case "Client3":  paddleThreeY = Float.valueOf(pad[1])-270;paddleThreeX = 275;
				break;
				case "Client4":  paddleFourY = 925-Float.valueOf(pad[1]); paddleFourX = 905;
				break;
			}
			paddleTwoX=1200-paddleTwoX;paddleTwoY=635;
		}
		if(ClientID==3){
			switch(pad[0]){
				case "Client2":  paddleTwoY= 925-Float.valueOf(pad[1]); paddleTwoX = 905;
				break;
				case "Client1":  paddleOneY =Float.valueOf(pad[1])-270;paddleOneX = 275;ballX=1200-Float.valueOf(pad[3]);ballY=Float.valueOf(pad[4]);
				break;
				case "Client4":  paddleFourX = 1200-Float.valueOf(pad[1]);paddleFourY = 5;
				break;
			}
			paddleThreeX=925-paddleThreeY;paddleThreeY=635;
		}
		if(ClientID==4){
			switch(pad[0]){
				case "Client2":  paddleTwoY = Float.valueOf(pad[1])-270;paddleTwoX = 275;
				break;
				case "Client3":  paddleThreeX =  1200-Float.valueOf(pad[1]);paddleThreeY = 5;
				break;
				case "Client1":  paddleFourY = 925-Float.valueOf(pad[1]); paddleFourX = 905;ballX=Float.valueOf(pad[3]);ballY=655-Float.valueOf(pad[4]);
				break;
			}
			paddleFourX=270+paddleFourY;paddleFourY=635;
		}
	} catch (Exception e) {
		System.out.println("SERVER TIMED OUT");
	}
	//------------------------------------------------------------------------------------------------------------------------
		repaint();
	}
	//paint the ball
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Color c;
		g2.setStroke(new BasicStroke(5));
		g.setColor(Color.BLACK);
		g.drawRect(272, 2, 655, 655);
		g2.setStroke(new BasicStroke(1));
		c = new Color(200, 220, 255);
		g.setColor(c);
		g.fillRect(275, 5, 650, 650);
		g.setColor(Color.BLACK);
		g.drawLine(310, 40, 310, 619);
		g.drawLine(310, 40, 889, 40);
		g.drawLine(889, 40, 889, 619);
		g.drawLine(310, 619, 889, 619);
		g2.setStroke(new BasicStroke(3));
		g.drawRect(271, 1, 38, 38);
		g.drawRect(890, 1, 38, 38);
		g.drawRect(271, 620, 38, 38);
		g.drawRect(890, 620, 38, 38);
		g.setColor(Color.RED);
		g.fillRect(274, 4, 35, 35);
		g.fillRect(891, 4, 35, 35);
		g.fillRect(274, 621, 35, 35);
		g.fillRect(891, 621, 35, 35);
		c = new Color(255, 36, 48);
		g.setColor(c);
		g.fillOval((int)ballX, (int)ballY, (int)ballDiameter, (int)ballDiameter);
		c = new Color(144, 144, 0);
		g.setColor(c);
		switch(ClientID){
		case 1:
			g.fillRect((int)paddleOneX, (int)paddleOneY, (int)paddleOneLength, (int)paddleWidth);
			g.fillRect((int)paddleTwoX, (int)paddleTwoY, (int)paddleTwoLength, (int)paddleWidth);
			g.fillRect((int)paddleThreeX, (int)paddleThreeY, (int)paddleWidth, (int)paddleThreeLength);
			g.fillRect((int)paddleFourX, (int)paddleFourY, (int)paddleWidth, (int)paddleFourLength);
			break;
		case 2:  
			g.fillRect((int)paddleOneX, (int)paddleOneY, (int)paddleOneLength, (int)paddleWidth);
			g.fillRect((int)paddleTwoX, (int)paddleTwoY, (int)paddleTwoLength, (int)paddleWidth);
			g.fillRect((int)paddleThreeX, (int)paddleThreeY, (int)paddleWidth, (int)paddleThreeLength);
			g.fillRect((int)paddleFourX, (int)paddleFourY, (int)paddleWidth, (int)paddleFourLength);
		break;
		case 3:  
			g.fillRect((int)paddleOneX, (int)paddleOneY, (int)paddleWidth, (int)paddleOneLength);
			g.fillRect((int)paddleTwoX, (int)paddleTwoY, (int)paddleWidth,(int)paddleTwoLength);
			g.fillRect((int)paddleThreeX, (int)paddleThreeY, (int)paddleThreeLength, (int)paddleWidth);
			g.fillRect((int)paddleFourX, (int)paddleFourY,  (int)paddleFourLength,(int)paddleWidth);
		break;
		case 4:  
			g.fillRect((int)paddleOneX, (int)paddleOneY, (int)paddleWidth, (int)paddleOneLength);
			g.fillRect((int)paddleTwoX, (int)paddleTwoY, (int)paddleWidth,(int)paddleTwoLength);
			g.fillRect((int)paddleThreeX, (int)paddleThreeY, (int)paddleThreeLength, (int)paddleWidth);
			g.fillRect((int)paddleFourX, (int)paddleFourY,  (int)paddleFourLength,(int)paddleWidth);
		break;
	}
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		g.drawString("Balls missed", 1000, 230);
		g.drawString("Player South : " + String.valueOf(playerOneScore), 1000, 300);
		g.drawString("Player North : " + String.valueOf(playerTwoScore), 1000, 350);
		g.drawString("Player East : " + String.valueOf(playerThreeScore), 1000, 400);
		g.drawString("Player West : " + String.valueOf(playerFourScore), 1000, 450);
	}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftPressed = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightPressed = true;
		}
	}
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftPressed = false;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightPressed = false;
		}
	}
}