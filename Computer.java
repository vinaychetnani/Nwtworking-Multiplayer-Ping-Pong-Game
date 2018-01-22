public class Computer {
	private double ballSpeed = 2.5;
	private double ballX = 600;
	private double ballY = 330;
	private double ballDiameter = 20;

	private double ballXSpeed = 1.5;
	private double ballYSpeed = 2;
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
	private int playerOneScore=0;
	private int playerTwoScore=0;
	private int playerThreeScore=0;
	private int playerFourScore=0;
	public String ball(
	double paddlec1X ,
	double paddlec2X ,
	double paddlec3Y ,
	double paddlec4Y ,
	double copy_ballX ,
	double copy_ballY ,
	double speed_ballX ,
	double speed_ballY ){
		String ball="";
//extract data of client 1
		paddleOneX=paddlec1X;
		paddleTwoX=paddlec2X;
		paddleThreeY=paddlec3Y ;
		paddleFourY=paddlec4Y ;
		ballX=copy_ballX ;
		ballY=copy_ballY;
		ballXSpeed=speed_ballX ;
		ballYSpeed=speed_ballY ;
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
			
		
		
		ball=ball+ballX+","+ballY+","+ballXSpeed+","+ballYSpeed+","+paddleOneX+","+paddleTwoX+","+paddleThreeY+","+paddleFourY;
		return ball;
	}
    public String paddle(
    		double paddlec ,
    		double copy_ballX ,
    		double copy_ballY ,
    		double speed_ballX ,
    		double speed_ballY,
    		int w){
    	if(w==1){
    		double crosX;
	    	if(speed_ballY<0){
	    		if((paddlec+50)<597){
	    			paddlec+=paddleSpeed;
	    		}
	    		if((paddlec+50)>597){
	    			paddlec-=paddleSpeed;
	    		}
	    	}
	    	if(speed_ballY>0){
	    		double anglet=Math.atan(speed_ballX/speed_ballY);
	    		double anglef;
	    		if(speed_ballX>=0){
	    			anglef=Math.atan((925-copy_ballX)/(655-copy_ballY));
	    			if(anglet<anglef){
	    				crosX=copy_ballX+(655-copy_ballY)*Math.tan(anglet);
	    				if((crosX-(paddlec+50))>0){
	    		    		paddlec+=paddleSpeed;
	    		    	}
	    		    	if((crosX-(paddlec+50))<0){
	    		    		paddlec-=paddleSpeed;
	    		    	}
	    			}
	    			if(anglet>anglef){
	    				crosX=925-((655-copy_ballY)-(925-copy_ballX)/Math.tan(anglet))*Math.tan(anglet);
	    				if((crosX-(paddlec+50))>0){
	    		    		paddlec+=paddleSpeed;
	    		    	}
	    		    	if((crosX-(paddlec+50))<0){
	    		    		paddlec-=paddleSpeed;
	    		    	}
	    			}
	    		}
	    		if(speed_ballX<0){
	    			anglef=Math.atan((copy_ballX-270)/(655-copy_ballY));
	    			anglet=-anglet;
	    			if(anglet<anglef){
	    				crosX=copy_ballX-(655-copy_ballY)*Math.tan(anglet);
	    				if((crosX-(paddlec+50))>0){
	    		    		paddlec+=paddleSpeed;
	    		    	}
	    		    	if((crosX-(paddlec+50))<0){
	    		    		paddlec-=paddleSpeed;
	    		    	}
	    			}
	    			if(anglet>anglef){
	    				crosX=270+((655-copy_ballY)-(copy_ballX-270)/Math.tan(anglet))*Math.tan(anglet);
	    				if((crosX-(paddlec+50))>0){
	    		    		paddlec+=paddleSpeed;
	    		    	}
	    		    	if((crosX-(paddlec+50))<0){
	    		    		paddlec-=paddleSpeed;
	    		    	}
	    			}
	    		}
	    		
	    	}
	    	if(paddlec<310){
	    		paddlec+=paddleSpeed;
	    	}
	    	if((paddlec+100)>885){
	    		paddlec-=paddleSpeed;
	    	}
	    }
    	
    	//--------------------------paddle2----------------------------------
    	if(w==2){
    		double crosX;
	    	if(speed_ballY>0){
	    		if((paddlec+50)<597){
	    			paddlec+=paddleSpeed;
	    		}
	    		if((paddlec+50)>597){
	    			paddlec-=paddleSpeed;
	    		}
	    	}
	    	if(speed_ballY<0){
	    		double anglet=Math.atan(speed_ballX/(-speed_ballY));
	    		double anglef;
	    		if(speed_ballX>=0){
	    			anglef=Math.atan((925-copy_ballX)/(copy_ballY));
	    			if(anglet<anglef){
	    				crosX=copy_ballX+(copy_ballY)*Math.tan(anglet);
	    				if((crosX-(paddlec+50))>0){
	    		    		paddlec+=paddleSpeed;
	    		    	}
	    		    	if((crosX-(paddlec+50))<0){
	    		    		paddlec-=paddleSpeed;
	    		    	}
	    			}
	    			if(anglet>anglef){
	    				crosX=925-((copy_ballY)-(925-copy_ballX)/Math.tan(anglet))*Math.tan(anglet);
	    				if((crosX-(paddlec+50))>0){
	    		    		paddlec+=paddleSpeed;
	    		    	}
	    		    	if((crosX-(paddlec+50))<0){
	    		    		paddlec-=paddleSpeed;
	    		    	}
	    			}
	    		}
	    		if(speed_ballX<0){
	    			anglef=Math.atan((copy_ballX-270)/(copy_ballY));
	    			anglet=-anglet;
	    			if(anglet<anglef){
	    				crosX=copy_ballX-(copy_ballY)*Math.tan(anglet);
	    				if((crosX-(paddlec+50))>0){
	    		    		paddlec+=paddleSpeed;
	    		    	}
	    		    	if((crosX-(paddlec+50))<0){
	    		    		paddlec-=paddleSpeed;
	    		    	}
	    			}
	    			if(anglet>anglef){
	    				crosX=270+((copy_ballY)-(copy_ballX-270)/Math.tan(anglet))*Math.tan(anglet);
	    				if((crosX-(paddlec+50))>0){
	    		    		paddlec+=paddleSpeed;
	    		    	}
	    		    	if((crosX-(paddlec+50))<0){
	    		    		paddlec-=paddleSpeed;
	    		    	}
	    			}
	    		}
	    		
	    	}
	    	if(paddlec<310){
	    		paddlec+=paddleSpeed;
	    	}
	    	if((paddlec+100)>885){
	    		paddlec-=paddleSpeed;
	    	}
    	}
    		//---------------------------paddle3------------------------------------
	    	if(w==3){
	    		double crosY;
		    	if(speed_ballX<0){
		    		if((paddlec+50)<327){
		    			paddlec+=paddleSpeed;
		    		}
		    		if((paddlec+50)>327){
		    			paddlec-=paddleSpeed;
		    		}
		    	}
		    	if(speed_ballX>0){
		    		double anglet=Math.atan(speed_ballY/(-speed_ballX));
		    		double anglef;
		    		if(speed_ballY<=0){
		    			anglef=Math.atan((copy_ballY)/(925-copy_ballX));
		    			if(anglet<anglef){
		    				crosY=copy_ballY-(925-copy_ballX)*Math.tan(anglet);
		    				if((crosY-(paddlec+50))>0){
		    		    		paddlec+=paddleSpeed;
		    		    	}
		    		    	if((crosY-(paddlec+50))<0){
		    		    		paddlec-=paddleSpeed;
		    		    	}
		    			}
		    			if(anglet<anglef){
		    				crosY=(925-copy_ballX-(copy_ballY)/Math.tan(anglet))*Math.tan(anglet);
		    				if((crosY-(paddlec+50))>0){
		    		    		paddlec+=paddleSpeed;
		    		    	}
		    		    	if((crosY-(paddlec+50))<0){
		    		    		paddlec-=paddleSpeed;
		    		    	}
		    			}
		    		}
		    		if(speed_ballY>0){
		    			anglef=Math.atan((655-copy_ballY)/(925-copy_ballX));
		    			anglet=-anglet;
		    			if(anglet<anglef){
		    				crosY=copy_ballY+(925-copy_ballX)*Math.tan(anglet);
		    				if((crosY-(paddlec+50))>0){
		    		    		paddlec+=paddleSpeed;
		    		    	}
		    		    	if((crosY-(paddlec+50))<0){
		    		    		paddlec-=paddleSpeed;
		    		    	}
		    			}
		    			if(anglet>anglef){
		    				crosY=655-((925-copy_ballX)-(655-copy_ballY)/Math.tan(anglet))*Math.tan(anglet);
		    				if((crosY-(paddlec+50))>0){
		    		    		paddlec+=paddleSpeed;
		    		    	}
		    		    	if((crosY-(paddlec+50))<0){
		    		    		paddlec-=paddleSpeed;
		    		    	}
		    			}
		    		}
		    		
		    	}
		    	if(paddlec<40){
		    		paddlec+=paddleSpeed;
		    	}
		    	if((paddlec+100)>615){
		    		paddlec-=paddleSpeed;
		    	}
	    	}
	     	if(w==4){
	    		double crosY;
		    	if(speed_ballX>0){
		    		if((paddlec+50)<327){
		    			paddlec+=paddleSpeed;
		    		}
		    		if((paddlec+50)>327){
		    			paddlec-=paddleSpeed;
		    		}
		    	}
		    	if(speed_ballX<0){
		    		double anglet=-Math.atan(speed_ballY/(-speed_ballX));
		    		double anglef;
		    		if(speed_ballY<=0){
		    			anglef=Math.atan((copy_ballY)/(copy_ballX-270));
		    			if(anglet<anglef){
		    				crosY=copy_ballY-(copy_ballX-270)*Math.tan(anglet);
		    				if((crosY-(paddlec+50))>0){
		    		    		paddlec+=paddleSpeed;
		    		    	}
		    		    	if((crosY-(paddlec+50))<0){
		    		    		paddlec-=paddleSpeed;
		    		    	}
		    			}
		    			if(anglet<anglef){
		    				crosY=(copy_ballX-270-(copy_ballY)/Math.tan(anglet))*Math.tan(anglet);
		    				if((crosY-(paddlec+50))>0){
		    		    		paddlec+=paddleSpeed;
		    		    	}
		    		    	if((crosY-(paddlec+50))<0){
		    		    		paddlec-=paddleSpeed;
		    		    	}
		    			}
		    		}
		    		if(speed_ballY>0){
		    			anglef=Math.atan((655-copy_ballY)/(copy_ballX-270));
		    			anglet=-anglet;
		    			if(anglet<anglef){
		    				crosY=copy_ballY+(copy_ballX-270)*Math.tan(anglet);
		    				if((crosY-(paddlec+50))>0){
		    		    		paddlec+=paddleSpeed;
		    		    	}
		    		    	if((crosY-(paddlec+50))<0){
		    		    		paddlec-=paddleSpeed;
		    		    	}
		    			}
		    			if(anglet>anglef){
		    				crosY=655-((copy_ballX-270)-(655-copy_ballY)/Math.tan(anglet))*Math.tan(anglet);
		    				if((crosY-(paddlec+50))>0){
		    		    		paddlec+=paddleSpeed;
		    		    	}
		    		    	if((crosY-(paddlec+50))<0){
		    		    		paddlec-=paddleSpeed;
		    		    	}
		    			}
		    		}
		    		
		    	}
		    	if(paddlec<40){
		    		paddlec+=paddleSpeed;
		    	}
		    	if((paddlec+100)>615){
		    		paddlec-=paddleSpeed;
		    	}
	    	}
    		
//    	if(w==2){
//    	if((copy_ballX-paddlec)>0){
//    		paddlec+=paddleSpeed;
//    	}
//    	if((copy_ballX-paddlec)<0){
//    		paddlec-=paddleSpeed;
//    	}
//	}
//    	if(w==3){
//	    	if((copy_ballY-paddlec)>0){
//	    		paddlec+=paddleSpeed;
//	    	}
//	    	if((copy_ballY-paddlec)<0){
//	    		paddlec-=paddleSpeed;
//	    	}
//	    }
//    	if(w==4){
//	    	if((copy_ballY-paddlec)>0){
//	    		paddlec+=paddleSpeed;
//	    	}
//	    	if((copy_ballY-paddlec)<0){
//	    		paddlec-=paddleSpeed;
//	    	}
//		}
    	 return (""+paddlec);
   }
	

    }