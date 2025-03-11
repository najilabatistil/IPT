import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class GameCard extends JPanel {
	JLabel lblName;
    JLabel lblPicture;
    JLabel lblReleasePublisher;
    JLabel lblDeveloperGenre;
    JLabel lblDesign1;
    JLabel lblDesign2;
    
	public GameCard(String strName, ImageIcon icnImage, String strRelease, String strDeveloper, String strPublisher, String strGenre) {
		
		// PANEL SETTINGS
		this.setPreferredSize(new Dimension(250, 370));
		this.setBackground(new Color(255,245,194));
		this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		this.setLayout(null);
		
		// PANEL COMPONENTS
		lblName = new JLabel("<html><span style=\"font-size: 12px; font-family: 'Trebuchet MS';\">" + strName + "</span></html>");
		lblName.setBounds(10,40,230,40);
		
		lblPicture = new JLabel();
		Image imgGame = icnImage.getImage().getScaledInstance(230, 140, Image.SCALE_SMOOTH);
		lblPicture.setIcon(new ImageIcon(imgGame));
		lblPicture.setBounds(10, 80, 230, 140);
		lblPicture.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		lblReleasePublisher = new JLabel("<html><span style=\"font-size: 9px; font-family: 'Trebuchet MS';\"><u> Release:</u><br>" + strRelease + "<br><br><u>Publisher/s:</u><br>" + strPublisher + "</span></html>");
		lblReleasePublisher.setBounds(10,215,115,120);
		
		lblDeveloperGenre = new JLabel("<html><span style=\"font-size: 9px; font-family: 'Trebuchet MS';\"><u> Developer:</u><br>" + strDeveloper + "<br><br><u>Genre/s:</u><br>" + strGenre + "</span></html>");
		lblDeveloperGenre.setBounds(130,215,115,120);
		
		URL urlDesign = GameCard.class.getResource("/slash6.png");
		Image imgDesign = new ImageIcon(urlDesign).getImage().getScaledInstance(150, 20, Image.SCALE_SMOOTH);
		ImageIcon icnDesign = new ImageIcon(imgDesign);
		
		lblDesign1 = new JLabel();
		lblDesign1.setIcon(icnDesign);
		lblDesign1.setBounds(5, 15, 150, 20);
		
		lblDesign2 = new JLabel();
		lblDesign2.setIcon(icnDesign);
		lblDesign2.setBounds(95, 335, 150, 20);

		// ADD TO PANEL
	    this.add(lblDesign1);
	    this.add(lblDesign2);
		this.add(lblName);
        this.add(lblPicture);
        this.add(lblReleasePublisher);
        this.add(lblDeveloperGenre);
	}
	
	public void hover() {
		lblName.setBounds(12, 38, 230, 40);
        lblPicture.setBounds(12, 78, 230, 140);
        lblReleasePublisher.setBounds(12,213,115,120);
        lblDeveloperGenre.setBounds(132,213,115,120);
        lblDesign1.setBounds(7, 13, 150, 20);
        lblDesign2.setBounds(97, 333, 150, 20);
	}
	
	public void unhover() {
		lblName.setBounds(10, 40, 230, 40);
        lblPicture.setBounds(10, 80, 230, 140);
        lblReleasePublisher.setBounds(10,215,115,120);
        lblDeveloperGenre.setBounds(130,215,115,120);
        lblDesign1.setBounds(5, 15, 150, 20);
        lblDesign2.setBounds(95, 335, 150, 20);
	}
}