import javax.swing.*;

public class Home {
	public static void main(String[] args) {
		MyCanvas c = new MyCanvas();

		JFrame frame = new JFrame("Low Poly Art");
		frame.setSize(615,825);
		frame.setVisible(true);
		frame.setResizable(false);

		frame.add(c);
	}
}