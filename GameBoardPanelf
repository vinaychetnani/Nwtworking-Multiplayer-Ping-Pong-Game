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
    public int i=0;
    public int ClientID;
    public int clients=4;
    public boolean flag=false;
    public int count=0;
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
    private double paddlec1X ;
    private double paddlec2X ;
    private double paddlec3Y ;
    private double paddlec4Y ;
    private double copy_ballX ;
    private double copy_ballY ;
    private double speed_ballX ;
    private double speed_ballY ;

    private int playerOneScore;
    private int playerTwoScore;
    private int playerThreeScore;
    private int playerFourScore;
    public String[] ClientsAwailable={"awailable","awailable","awailable","awailable"};
    public String[][] A=new String[4][4];
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
        
        for(int u=0;u<4;u++){
            for(int m=0;m<4;m++){
                A[u][m]="close";
            }
        }
        switch(ClientID){
        case 1:
            break;
        case 2:
            paddleOneX = 1200 - paddleOneX - paddleOneLength;
            paddleOneY = 660 - paddleOneY - paddleWidth;

            paddleTwoX = 1200 - paddleTwoX - paddleTwoLength;
            paddleTwoY = 660 - paddleTwoY - paddleWidth;

            paddleThreeX = 1200 - paddleThreeX - paddleWidth;
            paddleThreeY = 660 - paddleThreeY - paddleThreeLength;

            paddleFourX = 1200 - paddleFourX - paddleWidth;
            paddleFourY = 660 - paddleFourY - paddleFourLength;
            break;
        case 3:
            paddleOneX = 270 + 660 - paddleOneY - paddleWidth;
            paddleOneY = paddleOneX - 270;

            paddleTwoX =  270 + 660 - paddleTwoY - paddleWidth;
            paddleTwoY = paddleTwoX - 270;

            paddleThreeX = 270 + 660 - paddleThreeY - paddleThreeLength;
            paddleThreeY = paddleThreeX - 270;

            paddleFourX = 270 + 660 - paddleFourY - paddleFourLength;
            paddleFourY = paddleFourX - 270;
            break;
        case 4:
            paddleOneX = paddleOneY + 270;
            paddleOneY = 1200 - paddleOneX - paddleOneLength - 270;

            paddleTwoX = paddleTwoY + 270;
            paddleTwoY = 1200 - paddleTwoX - paddleTwoLength - 270;

            paddleThreeX = paddleThreeY + 270;
            paddleThreeY = 1200 - paddleThreeX - paddleWidth - 270;

            paddleFourX = paddleFourY + 270;
            paddleFourY =  1200 - paddleFourX - paddleWidth - 270;
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
        case 1: 
            paddlec1X =paddleOneX;
            paddlec2X =paddleTwoX;
            paddlec3Y =paddleThreeY;
            paddlec4Y =paddleFourY;
            copy_ballX=ballX;
            copy_ballY=ballY ;
            speed_ballX =ballXSpeed;
            speed_ballY =ballYSpeed;
            sendData = ("Client1"+","+paddleOneX +","+paddleTwoX+","+ballX +","+ ballY+","+paddleThreeY+","+paddleFourY+","+ballXSpeed+","+ballYSpeed).getBytes();
        break;
        case 2:  sendData = ("Client2"+","+paddleTwoX ).getBytes();
        break;
        case 3:  sendData = ("Client3"+","+paddleThreeX).getBytes();
        break;
        case 4:  sendData = ("Client4"+","+paddleFourX).getBytes();
        break;
        }
        //------------------------Compuret Player------------------------------------------------------------
        for(int j=0;j<4;j++){
            if(ClientsAwailable[j]=="unawailable"){
                if(j==0){
                    for(int k=1;(j+k)<4;k++){
                        if(ClientsAwailable[k+j]=="awailable"){
                            if(ClientID==(k+j+1)){
                                multiplayer.Computer c1=new Computer();
                                String ball=c1.ball(paddlec1X, paddlec2X, paddlec3Y, paddlec4Y, copy_ballX, copy_ballY, speed_ballX, speed_ballY);
                                String[] balldata=ball.split(",");
                                ballX = Float.valueOf(balldata[0]);
                                ballY= Float.valueOf(balldata[1]);
                                copy_ballX=ballX;
                                copy_ballY=ballY;
                                speed_ballX= Float.valueOf(balldata[2]);
                                speed_ballY= Float.valueOf(balldata[3]);
                                paddlec2X= Float.valueOf(balldata[5]);
                                paddlec3Y= Float.valueOf(balldata[6]);
                                paddlec4Y= Float.valueOf(balldata[7]);
                                byte[] sendData1 = "Hello".getBytes();
                                //----------------------update paddle location-------------------------------------
                                String paddle=c1.paddle(paddlec1X, copy_ballX, copy_ballY, speed_ballX, speed_ballY,1);
                                String[] paddledata=paddle.split(",");
                                paddlec1X =Float.valueOf(paddledata[0]);
                                if(ClientID == 2){
                                    paddleOneX = 1200 - paddlec1X - paddleOneLength;
                                    ballX = 1200 - ballX - ballDiameter;
                                    ballY = 660 - ballY - ballDiameter;
                                    paddlec2X = 1200 - paddleTwoX - paddleTwoLength;
                                    paddlec3Y = 660 - paddleThreeY - paddleThreeLength;
                                    paddlec4Y = 660 - paddleFourY - paddleFourLength;
                                }
                                if(ClientID == 3){
                                    paddleOneY = paddlec1X - 270;
                                    ballX = 660 - ballY - ballDiameter + 270;
                                    ballY = ballX - 270;
                                    paddlec2X = paddleTwoY + 270;
                                    paddlec3Y = 1200 - 270 - paddleThreeX - paddleThreeLength;
                                    paddlec4Y = 1200 - 270 - paddleFourX - paddleFourLength;
                                }
                                if(ClientID == 4){
                                    paddleOneY = 1200 - 270 - paddlec1X - paddleOneLength;
                                    ballX = ballY + 270;
                                    ballY = 1200 - 270 - ballX - ballDiameter;
                                    paddlec2X = 660 - paddleTwoY - paddleTwoLength + 270;
                                    paddlec3Y = paddleThreeX - 270;
                                    paddlec4Y = paddleFourX - 270;
                                }
                                
                                sendData1 = ("Client1"+","+paddlec1X +","+paddlec2X+","+copy_ballX +","+ copy_ballY+","+paddlec3Y+","+paddlec4Y+","+speed_ballX+","+speed_ballY).getBytes();
                                sendPacket = new DatagramPacket(sendData1, sendData1.length, ip02, port02);
                                clientSocket.send(sendPacket);
                                sendPacket = new DatagramPacket(sendData1, sendData1.length, ip04, port04);
                                clientSocket.send(sendPacket);
                                sendPacket = new DatagramPacket(sendData1, sendData1.length, ip03, port03);
                                clientSocket.send(sendPacket);
                            }
                            k=5;
                        }
                    }
                }
                if(j!=0){
                    for(int y=1;y<4;y++){
                        if(y!=(j+1)){
                            if(ClientsAwailable[y-1]=="awailable"){
                                if(ClientID==(y)){
                                    byte[] sendData1 = "Hello".getBytes();
                                    switch (j+1){
                                    case 2:
                                        multiplayer.Computer c2=new Computer();
                                        String paddle2=c2.paddle(paddlec2X, copy_ballX, copy_ballY, speed_ballX, speed_ballY,2);
                                        String[] paddle2data=paddle2.split(",");
                                        paddlec2X =Float.valueOf(paddle2data[0]);
                                        double sendPaddle2=1200-paddlec2X - paddleTwoLength;
                                        sendData1 = ("Client2"+","+sendPaddle2).getBytes();
                                        switch(ClientID){
                                            case 1:    paddleTwoX =paddlec2X;
                                            break;
                                            case 3:    paddleTwoY = 1200 - 270 - sendPaddle2 - paddleTwoLength;
                                            break;
                                            case 4:    paddleTwoY =sendPaddle2 - 270;
                                            break;
                                        }
                                    break;
                                    case 3:
                                        multiplayer.Computer c3=new Computer();
                                        String paddle3=c3.paddle(paddlec3Y, copy_ballX, copy_ballY, speed_ballX, speed_ballY,3);
                                        String[] paddle3data=paddle3.split(",");
                                        paddlec3Y =Float.valueOf(paddle3data[0]);
                                        double sendPaddle3=1200 - 270 - paddlec3Y - paddleThreeLength;
                                        sendData1 = ("Client3"+","+sendPaddle3).getBytes();
                                        switch(ClientID){
                                        case 1:    paddleThreeY = paddlec3Y;
                                        break;
                                        case 2:    paddleThreeY = sendPaddle3 - 270;
                                        break;
                                        case 4:    paddleThreeX = 1200 - sendPaddle3- paddleThreeLength;
                                        break;
                                        }
                                    break;
                                    case 4:
                                        multiplayer.Computer c4=new Computer();
                                        String paddle4=c4.paddle(paddlec4Y, copy_ballX, copy_ballY, speed_ballX, speed_ballY,4);
                                        String[] paddle4data=paddle4.split(",");
                                        paddlec4Y =Float.valueOf(paddle4data[0]);
                                        double sendPaddle4=270 +paddlec4Y;
                                        sendData1 = ("Client4"+","+sendPaddle4).getBytes();
                                        switch(ClientID){
                                        case 1:    paddleFourY = paddlec4Y;
                                        break;
                                        case 2:    paddleFourY = 1200 - 270 - sendPaddle4- paddleFourLength;
                                        break;
                                        case 3:    paddleFourX = 1200 - sendPaddle4 - paddleFourLength;
                                        break;
                                        }
                                    break;
                                    }
                                    sendPacket = new DatagramPacket(sendData1, sendData1.length, ip02, port02);
                                    clientSocket.send(sendPacket);
                                    sendPacket = new DatagramPacket(sendData1, sendData1.length, ip04, port04);
                                    clientSocket.send(sendPacket);
                                    sendPacket = new DatagramPacket(sendData1, sendData1.length, ip03, port03);
                                    clientSocket.send(sendPacket);
                                }
                                y=5;
                            }
                        }
                    }

                }
            }
        }
        sendPacket = new DatagramPacket(sendData, sendData.length, ip02, port02);
        clientSocket.send(sendPacket);
        sendPacket = new DatagramPacket(sendData, sendData.length, ip04, port04);
        clientSocket.send(sendPacket);
        sendPacket = new DatagramPacket(sendData, sendData.length, ip03, port03);
        clientSocket.send(sendPacket);
        // receive Message from other client
        String[] isopen={"close","close","close","close"};
        int temp=0;
        isopen[ClientID-1]="open";
        for(int indx = 0; indx < (clients-1); indx++){
            try {if(temp==1)
                System.out.println("intry"+indx);
                receivePacket.setData(new byte[1024]);
                clientSocket.receive(receivePacket);
                String rec1=new String(receivePacket.getData());
                String[] pad=rec1.split(",");
                switch(pad[0]){
                case "Client1":isopen[0]="open";
                break;
                case "Client2":isopen[1]="open";
                break;
                case "Client3":isopen[2]="open";
                break;
                case "Client4":isopen[3]="open";
                break;

                }
                if(ClientID == 1){
                    switch(pad[0]){
                    case "Client2":
                        paddleTwoX = 1200 - Float.valueOf(pad[1]) - paddleTwoLength;
                        break;
                    case "Client3":
                        paddleThreeY = 1200 - 270 - Float.valueOf(pad[1]) - paddleThreeLength;
                        break;
                    case "Client4":
                        paddleFourY = Float.valueOf(pad[1]) - 270;
                    }
                }

                if(ClientID == 2)
                    switch(pad[0]){
                    case "Client1":
                        paddleOneX = 1200 - Float.valueOf(pad[1]) - paddleOneLength;
                        ballX = 1200 - Float.valueOf(pad[3]) - ballDiameter;
                        ballY= 660 - Float.valueOf(pad[4]) - ballDiameter;
                        paddlec1X =Float.valueOf(pad[1]);
                        paddlec2X =Float.valueOf(pad[2]);
                        paddlec3Y =Float.valueOf(pad[5]);
                        paddlec4Y =Float.valueOf(pad[6]);
                        copy_ballX=Float.valueOf(pad[3]) ;
                        copy_ballY=Float.valueOf(pad[4]) ;
                        speed_ballX =Float.valueOf(pad[7]) ;;
                        speed_ballY =Float.valueOf(pad[8]) ;;
                        break;
                    case "Client3":
                        paddleThreeY = Float.valueOf(pad[1]) - 270;
                        break;
                    case "Client4":
                        paddleFourY = 1200 - 270 - Float.valueOf(pad[1]) - paddleFourLength;
                    }

                if(ClientID == 3)
                    switch(pad[0]){
                    case "Client1":
                        paddleOneY = Float.valueOf(pad[1]) - 270;
                        ballX = 1200 - 270 - Float.valueOf(pad[4]) - ballDiameter;
                        ballY = Float.valueOf(pad[3]) - 270;
                        paddlec1X =Float.valueOf(pad[1]);
                        paddlec2X =Float.valueOf(pad[2]);
                        paddlec3Y =Float.valueOf(pad[5]);
                        paddlec4Y =Float.valueOf(pad[6]);
                        copy_ballX=Float.valueOf(pad[3]) ;
                        copy_ballY=Float.valueOf(pad[4]) ;
                        speed_ballX =Float.valueOf(pad[7]) ;;
                        speed_ballY =Float.valueOf(pad[8]) ;;
                        break;
                    case "Client2":  
                        paddleTwoY = 1200 - 270 - Float.valueOf(pad[1]) - paddleTwoLength;
                        break;
                    case "Client4":
                        paddleFourX = 1200 - Float.valueOf(pad[1]) - paddleFourLength;
                    }

                if(ClientID == 4)
                    switch(pad[0]){
                    case "Client1":
                        paddleOneY = 1200 - 270 - Float.valueOf(pad[1]) - paddleOneLength;
                        ballX = Float.valueOf(pad[4]) + 270;
                        ballY = 1200 - 270 - Float.valueOf(pad[3]) - ballDiameter;
                        paddlec1X =Float.valueOf(pad[1]);
                        paddlec2X =Float.valueOf(pad[2]);
                        paddlec3Y =Float.valueOf(pad[5]);
                        paddlec4Y =Float.valueOf(pad[6]);
                        copy_ballX=Float.valueOf(pad[3]) ;
                        copy_ballY=Float.valueOf(pad[4]) ;
                        speed_ballX =Float.valueOf(pad[7]) ;;
                        speed_ballY =Float.valueOf(pad[8]) ;;
                        break;
                    case "Client2":
                        paddleTwoY = Float.valueOf(pad[1]) - 270;
                        break;
                    case "Client3":
                        paddleThreeX = 1200 - Float.valueOf(pad[1]) - paddleThreeLength;
                    }

            } catch (Exception e){
                flag=true;
                temp=1;
                System.out.println("SERVER TIMED OUT"+count);
                for(int j=0;j<4;j++){
                    System.out.println(""+isopen[j]);
                }
            }
            if(temp==1)
            System.out.println(""+indx);
        }
        if(flag==true){
            flag=false;
                for(int m=0;m<4;m++){
                    if(isopen[m]=="open"){
                        if(count<4){
                         A[count][m]="open";
                        }
                    }
                }
                count=count+1;
        }
        if(count>4){
            clients=clients-1;
            boolean temp1=false;
            for(int u=0;u<4;u++){
                temp1=false;
                for(int m=0;m<4;m++){
                    if(A[m][u]=="open"){
                        temp1=true;
                    }
                }
                if(!temp1){
                    ClientsAwailable[u]="unawailable";
                }      
            }
            for(int u=0;u<4;u++){
                for(int m=0;m<4;m++){
                    A[m][u]="close";
                }
            }                
            System.out.println("clients:1"+ClientsAwailable[0]+"2"+ClientsAwailable[1]+"3"+ClientsAwailable[2]+"4"+ClientsAwailable[3]);
            count=0;
        }
        //--------------------------one client have left the game-----------------------------------
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
            g.fillRect((int)paddleThreeX, 635, (int)paddleThreeLength, (int)paddleWidth);
            g.fillRect((int)paddleFourX, 5,  (int)paddleFourLength,(int)paddleWidth);
            break;
        case 4:  
            g.fillRect((int)paddleOneX, (int)paddleOneY, (int)paddleWidth, (int)paddleOneLength);
            g.fillRect((int)paddleTwoX, (int)paddleTwoY, (int)paddleWidth,(int)paddleTwoLength);
            g.fillRect((int)paddleThreeX, 5, (int)paddleThreeLength, (int)paddleWidth);
            g.fillRect((int)paddleFourX, 635,  (int)paddleFourLength,(int)paddleWidth);
            break;
        }

        g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        g.drawString("Client"+ClientID, 100, 300);
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