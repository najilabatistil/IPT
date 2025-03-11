import java.awt.*;
import java.net.URL;
import java.util.Random;
import javax.swing.*;

public class Animation extends JPanel {
	int x = 0;
	int y = 0;
	int moveX = 2;
	int moveY = 3;
	
	String direction = "down-right";
	String newDirection;
	String currentColor = "cyan.png";
	
	URL urlDVD = Home.class.getResource("/" + currentColor);
	ImageIcon icnDVD = new ImageIcon(urlDVD);
	Image imgDVD = icnDVD.getImage();
	
	public Animation() {
		Timer t = new Timer(1000/120, e -> animate());
		t.start();
	}
	
	public void animate() {
		moveLogo();
		bounceLogo();
		repaint();
	}
	
	public void moveLogo() {
		switch(direction) {
			case "down-right":
				x += moveX;
				y += moveY;
				break;
			case "down-left":
				x -= moveX;
				y += moveY;
				break;
			case "up-right":
				x += moveX;
				y -= moveY;
				break;
			case "up-left":
				x -= moveX;
				y -= moveY;
				break;
		}
	}

	public void bounceLogo() {
		int panelWidth = this.getSize().width;
		int panelHeight = this.getSize().height;
		int imageWidth = imgDVD.getWidth(null);
		int imageHeight = imgDVD.getHeight(null);
		
		// Bounces the logo from the top or bottom edges
		if (y <= 0 || y >= panelHeight - imageHeight) {
			getOppositeDirection(true);
			changeColor();	
		}
		
		// Bounces the logo from the right or left edges
		if (x <= 0 || x >= panelWidth - imageWidth) {
			getOppositeDirection(false);
			changeColor();

		}
	}

	public void getOppositeDirection(boolean hitYEdge) {
		// Changes dir1 when top or bottom edge is hit and changes dir2 when left or right edge is hit
		switch(direction) {
			case "down-right":
	            direction = hitYEdge ? "up-right" : "down-left";
	            break;
			case "down-left":
				direction = hitYEdge ? "up-left" : "down-right";
				break;
	        case "up-right":
	        	direction = hitYEdge ? "down-right" : "up-left";
	        	break;
	        case "up-left":
	        	direction = hitYEdge ? "down-left" : "up-right";
	        	break;
		}
	}
	
	public void changeColor() {
		String[] colors = {"red.png", "orange.png", "yellow.png", "green.png", "blue.png", "cyan.png", "violet.png"};
		Random rand = new Random();

		currentColor = colors[rand.nextInt(7)];
		
		urlDVD = Home.class.getResource("/" + currentColor);
		icnDVD = new ImageIcon(urlDVD);
		imgDVD = icnDVD.getImage();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.BLACK);
		g.drawImage(imgDVD, x, y, this);
	}
}
