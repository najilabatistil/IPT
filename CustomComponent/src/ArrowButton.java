import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ArrowButton extends JButton {
	boolean isVisible = true;
	
	public ArrowButton (String strArrow, Color clr) {
		this.setText("<html><span style=\"font-size: 20px; font-family: 'Trebuchet MS';\">" + strArrow + "</span></html>");
		this.setPreferredSize(new Dimension(45,45));
		this.setBackground(clr);
		this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		this.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {	
		    	if(isVisible) {
		    		ArrowButton.this.setText("<html><span style=\"font-size: 26px; font-family: 'Trebuchet MS';\">" + strArrow + "</span></html>");
		    	}
		    }

		    public void mouseExited(MouseEvent evt) {
		    	if(isVisible) {
		    		ArrowButton.this.setText("<html><span style=\"font-size: 20px; font-family: 'Trebuchet MS';\">" + strArrow + "</span></html>");
		    	}
		    }
		});
	}
	
	public void hide() {
		this.setText("<html> </html>");
		this.setBackground(new Color(190, 227, 253));
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setEnabled(false);
		isVisible = false;
	}
}