import java.awt.*;

public class Droplet {
	int x;
	int y;
	
	public Droplet(int startX, int startY) {
		this.x = startX;
		this.y = startY;
	}
	
	public void move() {
		y += 30; 
		
        if (y > 700) {
            y = 20;
        }
	}
	
	public void drawDroplet(Graphics g) {	
		g.setColor(new Color(217, 217, 217));
		g.fillOval(x, y, 4, 17);
	}
}