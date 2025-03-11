import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class GameCardView extends GameCard {
	public GameCardView(String strName, ImageIcon icnImage, String strRelease, String strDeveloper, String strPublisher, String strGenre) {
		super(strName, icnImage, strRelease, strDeveloper, strPublisher, strGenre);
		
		// CHANGE PANEL SIZE
		this.setPreferredSize(new Dimension(446, 645));
		
		// CHANGE COMPONENTS SIZE
		lblName.setText("<html><span style=\"font-size: 20px; font-family: 'Trebuchet MS';\">" + strName + "</span></html>");
		lblName.setBounds(20,45,406,60);
		
		Image imgGame = icnImage.getImage().getScaledInstance(406, 264, Image.SCALE_SMOOTH);
		lblPicture.setIcon(new ImageIcon(imgGame));
		lblPicture.setBounds(20, 100, 406, 264);
			
		lblReleasePublisher.setText("<html><span style=\"font-size: 16px; font-family: 'Trebuchet MS';\"><u> Release:</u><br>" + strRelease + "<br><br><u>Publisher/s:</u><br>" + strPublisher + "</span></html>");
		lblReleasePublisher.setBounds(20,375,198,200);
		
		lblDeveloperGenre.setText("<html><span style=\"font-size: 16px; font-family: 'Trebuchet MS';\"><u> Developer:</u><br>" + strDeveloper + "<br><br><u>Genre/s:</u><br>" + strGenre + "</span></html>");
		lblDeveloperGenre.setBounds(228,375,203,200);

		URL urlDesign = GameCardView.class.getResource("/slash6.png");
		Image imgDesign = new ImageIcon(urlDesign).getImage().getScaledInstance(260, 30, Image.SCALE_SMOOTH);
		ImageIcon icnDesign = new ImageIcon(imgDesign);
		
		lblDesign1.setIcon(icnDesign);
		lblDesign1.setBounds(10, 20, 260, 30);
		
		lblDesign2.setIcon(icnDesign);
		lblDesign2.setBounds(176, 593, 260, 30);
		
		// ADD TO PANEL
		this.add(lblDesign1);
	    this.add(lblDesign2);
		this.add(lblName);
        this.add(lblPicture);
        this.add(lblReleasePublisher);
        this.add(lblDeveloperGenre);
	}
}