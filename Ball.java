

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Ball implements Runnable {

	//global variables
	int x, y, xDirection, yDirection;
	
	
	
	

	
	Rectangle ball;

	
	public Ball(int x, int y){
		
		this.x = x;
		this.y = y;
		
		//Set ball moving randomly
		Random r = new Random();
		int rXDir = r.nextInt(1);
		if (rXDir == 0)
			rXDir--;
		setXDirection(rXDir);
		
		int rYDir = r.nextInt(1);
		if (rYDir == 0)
			rYDir--;
		setYDirection(rYDir);
		
		//create "ball"
		ball = new Rectangle(this.x, this.y, 15, 15);
	}
	
	public void setXDirection(int xDir){
		xDirection = xDir;
	}
	public void setYDirection(int yDir){
		yDirection = yDir;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(ball.x, ball.y, ball.width, ball.height);
	}
	
	
	public void move() {
		
		ball.x += xDirection;
		ball.y += yDirection;
		//bounce the ball when it hits the edge of the screen
		if (ball.x <= 0) {
			setXDirection(+1);
			
			
	}
		if (ball.x >= 485) {
			setXDirection(-1);
			
		}
		
		if (ball.y <= 15) {
			setYDirection(+1);
		}
		
		if (ball.y >= 385) {
			setYDirection(-1);
		}
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				move();
				Thread.sleep(8);
			}
		}catch(Exception e) { System.err.println(e.getMessage()); }

	}

}