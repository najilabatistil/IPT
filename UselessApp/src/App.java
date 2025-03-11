import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class App {
	static int s = 500;
	static int x = 43;
	static int y = 44;
	
	public static void main(String[] args) {
		// DECLARATIONS
		
		JFrame frame = new JFrame("Useless Image Manipulator");
		
		JPanel pnlMain = new JPanel();
		JPanel pnlBottom = new JPanel();
		
		URL imageURL = App.class.getResource("/cat.png");
	    ImageIcon pic = new ImageIcon(imageURL);
	    JLabel lblPic = new JLabel(pic);
	    lblPic.setBounds(x,y,s,s);
		
	    JButton btnMinus = new JButton("-");
	    JButton btnPlus = new JButton("+");
	    JButton btnLeft = new JButton("←");
	    JButton btnRight = new JButton("→");  
	    JButton btnUp = new JButton("↑");
	    JButton btnDown = new JButton("↓");
		
		// FRAME SETTINGS
		
		frame.setVisible(true);
		frame.setSize(600,700);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		
		// PANEL SETTINGS
		
		pnlMain.setLayout(new BorderLayout());
		pnlMain.setBackground(new Color(219,219,219));
		pnlBottom.setLayout(new FlowLayout());
		
		// BUTTON SETTINGS
		
		Dimension btnSize = new Dimension(65,65);
		Font btnFont = new Font (Font.SANS_SERIF, Font.PLAIN, 16);
		
		btnMinus.setPreferredSize(btnSize);
		btnMinus.setFont(btnFont);
		
		btnPlus.setPreferredSize(btnSize);
		btnPlus.setFont(btnFont);
		
		btnLeft.setPreferredSize(btnSize);
		btnLeft.setFont(btnFont);
		
		btnRight.setPreferredSize(btnSize);
		btnRight.setFont(btnFont);
		
		btnUp.setPreferredSize(btnSize);
		btnUp.setFont(btnFont);
		
		btnDown.setPreferredSize(btnSize);
		btnDown.setFont(btnFont);
		
		// BUTTON FUNCTIONS
		
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s > 200) {
					s -= 10;
					lblPic.setBounds(x,y,s,s);
				} else {
					JOptionPane.showMessageDialog(frame, "Minimum size reached.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (s < 500) {
				    if (x <= 585 - s && y <= 585 - s) {
				        s += 5;
				        lblPic.setBounds(x, y, s, s);
				    } else {
				        JOptionPane.showMessageDialog(frame, "Out of Bounds.", "Error", JOptionPane.ERROR_MESSAGE);
				    }
				} else {
				    JOptionPane.showMessageDialog(frame, "Maximum size reached.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (x > 0) {
					x -= 10;
					lblPic.setBounds(x,y,s,s);
				}
			}
		});
		
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (x <= 585 - s) {
					x += 10;
					lblPic.setBounds(x,y,s,s);
				}
			}
		});
		
		
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y >= 0) {
					y -= 10;
					lblPic.setBounds(x,y,s,s);
				}
			}
		});
		
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (y <= 585 - s) {
					y += 10;
					lblPic.setBounds(x,y,s,s);
				}
			}
		});
		
		// ADD TO PANELS
		
		pnlMain.add(lblPic, BorderLayout.CENTER);
		pnlBottom.add(btnMinus);
		pnlBottom.add(btnLeft);
		pnlBottom.add(btnUp);
		pnlBottom.add(btnDown);
		pnlBottom.add(btnRight);
		pnlBottom.add(btnPlus);
		
		// ADD TO FRAME
		
		frame.add(pnlMain, BorderLayout.CENTER);
		frame.add(pnlBottom, BorderLayout.SOUTH);
		frame.revalidate();
	}
}