import javax.swing.JFrame;

public class Home {
	public static void main(String[] args) {
		JFrame frmHome = new JFrame("Hot Air Balloon Animation");
		
		frmHome.setSize(850, 815);
		frmHome.setVisible(true);
		
		Animation anm = new Animation();
		
		frmHome.add(anm);
	}
}
