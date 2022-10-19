
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Paddle implements Runnable{
	
	private int x, yDirection;
	private int y = 0;
	Rectangle paddle;
	
	public Paddle(int X, int Y){
		this.x = X;
		this.y = Y;
		
		paddle = new Rectangle(x, y, 10, 50);
		}
		
	public void keyPressed(KeyEvent e) {
		
	
		if(e.getKeyCode() == e.VK_UP) y+=15;	
		if(e.getKeyCode() == e.VK_DOWN)y-=15;
		if(e.getKeyCode() == e.VK_W)y+=15;
		if(e.getKeyCode() == e.VK_S)y-=15;
		
		if(y > 300) y = 300;
		if (y < 100) y = 100;
			
	}
	
	
	

	public void move() {
	 	this.y += yDirection;
	}



	public void draw(Graphics g) {
			g.setColor(Color.CYAN);
			g.fillRect(this.x, this.y, paddle.width, paddle.height);
			
		}

		
	
	public void setYDirection(int yDir) {
		yDirection = yDir;
		}
	public int getYDirection() {
		return yDirection;
		}


	@Override
	public void run() {
		try {
			while(true) {
				move();
				Thread.sleep(7);
			}
		} catch(Exception e) { System.err.println(e.getMessage()); }
	}


	

}
