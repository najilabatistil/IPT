import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class Animation extends JPanel {	
	int cloud1X = 0;
	int cloud2X = 0;
	String cloud1Direction = "right";
	String cloud2Direction = "left";
	
	int lightningCounter;
	boolean showLightning = false;
	
	Droplet[] droplets = new Droplet[22];
	
	int[][] dropletsXY = {
		{74, 103},
		{253, 60},
		{167, 187},
		{328, 211},
		{234, 288},
		{105, 346},
		{195, 433},
		{380, 394},
		{290, 483},
		{130, 555},
		{346, 570},
		{588, 68},
		{728, 118},
		{626, 196},
		{485, 159},
		{778, 233},
		{566, 303},
		{692, 325},
		{668, 433},
		{516, 468},
		{758, 531},
		{604, 563}
	};
	
    public Animation() {
    	createDroplet();
    	
    	Timer t = new Timer(1000/60, e -> animate());
		t.start();
    }
    
    public void animate() {
    	moveDroplet();
    	moveClouds();
    	flashLightning();
    	repaint();
    }
    
    public void createDroplet() {
    	for (int i = 0; i <= droplets.length - 1; i++) {
    		droplets[i] = new Droplet(dropletsXY[i][0], dropletsXY[i][1]);
    	}
    }
    
    public void moveDroplet() {	
    	for (Droplet droplet : droplets) {
            droplet.move();
        }
    }
    
    public void moveClouds() {
    	if (cloud1Direction == "right") {
    		cloud1X += 2;
    	} else {
    		cloud1X -=2;
    	}
    	
    	if (cloud2Direction == "left") {
    		cloud2X -= 2;
    	} else {
    		cloud2X += 2;
    	}
    	
    	bounceClouds();
    }
    
    public void bounceClouds() {
    	if (cloud1X >= 20) {
    		cloud1Direction = "left";
        } else if (cloud1X <= -20) {
        	cloud1Direction = "right";
        }
        
        if (cloud2X >= 20) {
        	cloud2Direction = "left";
        } else if (cloud2X <= -20) {
        	cloud2Direction = "right";
        }
    }
    
    public void flashLightning() {
    	lightningCounter++;
    	
    	if ((lightningCounter % 150) == 0) {
    		showLightning = true;
    	} else if ((lightningCounter % 153) == 0) {
    		showLightning = false;
    	}
    }
    
    public void drawBackground(Graphics g, String fileName, int bgX, int bgY) {
        URL url = getClass().getResource("/" + fileName);
        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage();
        g.drawImage(img, bgX, bgY, this);
    }
    
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		setBackground(new Color(164, 184, 192));
		
		drawBackground(g, "bg.png", 21, 421);
		drawBackground(g, "cloudbackL.png", cloud2X, -5);
		
		if (showLightning) {
			setBackground(new Color(174, 196, 205));
			drawBackground(g, "lightning1.png", 260, -21);
			drawBackground(g, "lightning2.png", 655, 76);
		}
		
		drawBackground(g, "cloudfrontL.png", cloud1X, -5);
		
		for (Droplet droplet : droplets) {
            droplet.drawDroplet(g);
        }
		
		drawBackground(g, "window.png", 0, 0);
	}
}