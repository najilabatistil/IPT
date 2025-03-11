import javax.swing.JFrame;

public class Home {
	public static void main(String[] args) {
		JFrame frmHome = new JFrame("DVD Screensaver");
		
		frmHome.setSize(1100, 700);
		frmHome.setVisible(true);
		
		Animation anmDVD = new Animation();
		
		frmHome.add(anmDVD);
		frmHome.revalidate();
	}
}
