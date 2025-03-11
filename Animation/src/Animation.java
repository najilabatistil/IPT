import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class Animation extends JPanel {
	int balloonY = 135;
	int[] cloudsX = {-159, 694, 132, 407};
	boolean movingUp = true;
	
	public Animation() {
		Timer t = new Timer(1000/60, e -> animate());
		t.start();
	}
	
	public void animate() {
		moveClouds();
		moveBalloon();
		repaint();
	}
	
	public void moveClouds() {
		// Animate the clouds
		for (int i = 0; i < cloudsX.length; i++) {
			cloudsX[i] -= 3;			
			// Reset the clouds to the right side of the frame
            if (cloudsX[i] < -273) {
                cloudsX[i] = getWidth();
            }
        }
	}
	
	public void moveBalloon() {
		// Animate the balloon
		if (movingUp) {
			balloonY -= 1;
		} else {
			balloonY += 1;
		}
		floatBalloon();
	}
	
	public void floatBalloon() {
		// Make the balloon 'float'
		if (balloonY <= 120) {
			movingUp = false;
		} else if (balloonY >= 150) {
			movingUp = true;
		}
	}
	
	public void drawImage(Graphics g, String fileName, int x, int y) {
        URL url = getClass().getResource("/" + fileName);
        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage();
        g.drawImage(img, x, y, this);
    }
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(167, 213, 245));
		
		drawImage(g, "cloud4.png", cloudsX[0], 28); 
		drawImage(g, "cloud1.png", cloudsX[1], 244);
		drawImage(g, "cloud2.png", cloudsX[2], 423); 
		drawImage(g, "cloud3.png", cloudsX[3], 602);
		
		int balloonX = (getWidth() - 420) / 2;
		drawImage(g, "hotairb.png", balloonX, balloonY);
	}
}
