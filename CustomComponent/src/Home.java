import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class Home {
	static Color clrRed = new Color(249, 159, 157);
	static Color clrBlue = new Color(190, 227, 253);
	static Color clrYellow = new Color(255,245,194);
	
	public static void main(String[] args) {
		
		// DECLARATIONS
		JFrame frame = new JFrame("Game Card Library");
		
		JPanel pnlTitleContainer = new JPanel();
		JPanel pnlTitle = new JPanel();
		JPanel pnlMainContainer = new JPanel();
		JPanel pnlHome = new JPanel();
		
		JLabel lblTitle = new JLabel("<html><span style=\"font-size: 18px; font-family: 'Trebuchet MS';\"><b> GAME CARD LIBRARY</b></span></html>");
		
		JButton btnHome = new JButton();
		
		JScrollPane scrHome = new JScrollPane(pnlHome);
		scrHome.getVerticalScrollBar().setUnitIncrement(16);
		
		// FRAME SETTINGS
		frame.setSize(1115, 800);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		
		// PANEL SETTINGS
		pnlTitleContainer.setBackground(clrRed);
		pnlTitleContainer.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		pnlTitleContainer.setLayout(new BorderLayout());
		pnlTitleContainer.add(pnlTitle, BorderLayout.CENTER);
		pnlTitleContainer.add(btnHome, BorderLayout.EAST);
		
		pnlTitle.setBackground(clrRed);
		pnlTitle.add(lblTitle);
		
		CardLayout lmCard = new CardLayout();
		pnlMainContainer.setLayout(lmCard);
		
		pnlHome.setBackground(clrBlue);
		pnlHome.setLayout(new WrapLayout(FlowLayout.CENTER, 15, 15));
		pnlMainContainer.add(scrHome, "home");
		
		// HOME BUTTON SETTINGS
		URL urlHome = Home.class.getResource("/home1.png");
		Image imgHome = new ImageIcon(urlHome).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon icnHome = new ImageIcon(imgHome);
		
		btnHome.setIcon(icnHome);
		btnHome.setBackground(clrYellow);
		btnHome.setSize(30, 30);
		btnHome.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lmCard.show(pnlMainContainer, "home");
			}
		});
		
		btnHome.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent evt) {
		    	btnHome.setBackground(new Color(227, 217, 161));
		    }

		    public void mouseExited(MouseEvent evt) {
		    	btnHome.setBackground(clrYellow);
		    }
		});
		
		// CREATE CONTENTS
		String[][] strGames = {
			{"", "STARDEW VALLEY", "stardew.png", "2016", "ConcernedApe", "ConcernedApe", "Farm life sim, role-playing"},
			{"", "PORTAL", "portal.png", "2007", "Valve", "Valve", "Puzzle-platformer"},
			{"", "LIFE IS STRANGE", "lis.jpg", "2015", "Don't Nod Entertainment", "Square Enix", "Adventure"},
			{"", "GRAND THEFT AUTO V", "gtav.jpg", "2013", "Rockstar North", "Rockstar Games", "Action-adventure"},
			{"", "ELDEN RING", "elden.jpg", "2022", "FromSoftware", "Bandai Namco, FromSoftware", "Action role-playing"},
			{"", "VALORANT", "valorant.png", "2020", "Riot Games", "Riot Games", "Hero shooter, tactical shooter"},
			{"", "FIREWATCH", "firewatch.jpg", "2016", "Campo Santo", "Panic; Campo Santo", "Adventure"},
			{"", "MINECRAFT", "minecraft.png", "2011", "Mojang Studios", "Mojang Studios; Xbox Game Studios", "Sandbox, survival"},
			{"", "CELESTE", "celeste.jpg", "2018", "Maddy Makes Games", "Maddy Makes Games", "Platform"},
			{"", "PRINCE OF PERSIA", "pop.png", "2008", "Ubisoft Montreal", "Ubisoft", "Action-adventure, platform"},
			{"", "POKEMON FIRE RED", "pokemon.png", "2004", "Game Freak", "Nintendo", "Role-playing"},
			{"", "FORTNITE", "fortnite.jpg", "2017", "Epic Games", "Epic Games", "Survival, battle royale, sandbox"}
		};
		
		int indexCounter = 0;
		
		for(String[] game : strGames) {
			
			game[0] = "" + indexCounter;
			
			// Create panel container for each game card
			JPanel pnlGame = new JPanel();
			pnlGame.setBackground(clrBlue);
			pnlGame.setLayout(new WrapLayout(FlowLayout.CENTER, 15, 40));
			pnlMainContainer.add(pnlGame, game[0]);	
			
			// Create buttons for each game panel
			ArrowButton btnBack = new ArrowButton("&lt;", clrYellow);
			ArrowButton btnNext = new ArrowButton("&gt;", clrYellow);
			
			if(indexCounter == 0) {
                btnBack.hide();
            }

            if(indexCounter == strGames.length - 1) {
                btnNext.hide();
            }
			
			// Get game image location 
			URL urlGame = Home.class.getResource("/" + game[2]);
			ImageIcon icnGame = new ImageIcon(urlGame);
			
			// Create game cards for the home panel
			GameCard pnlGameCardHome = new GameCard(game[1], icnGame, game[3], game[4], game[5], game[6]);
			pnlHome.add(pnlGameCardHome);
			
			// Create a game card for the game panel
			GameCardView pnlGameCardView = new GameCardView(game[1], icnGame, game[3], game[4], game[5], game[6]);
			pnlGame.add(btnBack);
			pnlGame.add(pnlGameCardView);
			pnlGame.add(btnNext);
			
			// Add game card function
			pnlGameCardHome.addMouseListener(new MouseAdapter() {
	            public void mouseEntered(MouseEvent e) {
	                pnlGameCardHome.hover();
	            }

	            public void mouseExited(MouseEvent e) {
	                pnlGameCardHome.unhover();
	            }

				public void mouseClicked(MouseEvent e) {
					lmCard.show(pnlMainContainer, game[0]);
				}
	        });
			
			// Add arrow button function
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lmCard.previous(pnlMainContainer);
				}
			});
			
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		            lmCard.next(pnlMainContainer);
				}
			});
			
			indexCounter++;
		}
		
		// ADD TO FRAME
		frame.add(pnlTitleContainer, BorderLayout.NORTH);
		frame.add(pnlMainContainer, BorderLayout.CENTER);
		frame.revalidate();
	}
}