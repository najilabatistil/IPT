import javax.swing.JFrame;

public class Home {
	public static void main(String[] args) {
		JFrame frmHome = new JFrame("Rain Animation");
		
		frmHome.setSize(865, 688);
        frmHome.setVisible(true);
        frmHome.setResizable(false);
		
		Animation anmRain = new Animation();
		
		frmHome.add(anmRain);
	}
}