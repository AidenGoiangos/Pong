


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class Pong extends JFrame {
	public static Paddle p1 = new Paddle(10, 25);
	public static Paddle p2 = new Paddle(485, 25);
	//screen size variables.
	int gWidth = 500;
	int gHeight = 400;
	Dimension screenSize = new Dimension(gWidth, gHeight);
	
	Image dbImage;
	Graphics dbGraphics;
	
	
	//ball object
	static Ball b = new Ball(250, 200);
	
	
	//constructor for window
	public Pong() {
		this.setTitle("Pong!");
		this.setSize(screenSize);
		this.setResizable(false);
		this.setVisible(true);
		this.setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		Pong pg = new Pong();
		
		//create and start threads.
		Thread ball = new Thread(b);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		t2.start();
		t1.start();
		ball.start();
		
	}
	
	@Override
	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbGraphics = dbImage.getGraphics();
		draw(dbGraphics);
		g.drawImage(dbImage, 0, 0, this);
	}
	
	public void draw(Graphics g) {
		b.draw(g);
		p1.draw(g);
		p2.draw(g);
		
		repaint();
	}
	
	}
	

