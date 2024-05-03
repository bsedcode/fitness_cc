package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TestViewIntro extends JFrame{
	
	JLabel gameTitleLbl;
	JPanel backgroundPanel, buttonPanel;
	JButton newGameBtn, loadGameBtn, closeGameBtn;
	String introImgPath = "res/img.jpg";
	ImageIcon introImgIcon;
	Font gameFont;
	
	
	public TestViewIntro() {
		
		setTitle("Fitness Tracker Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// create background Panel
		backgroundPanel = new BackRoundPanel(new ImageIcon(introImgPath).getImage());
		backgroundPanel.setLayout(new BorderLayout());
		
		// create JLabel for the Game Title
		gameFont = new Font("Old English Text MT", Font.BOLD, 64);
		gameTitleLbl = new JLabel("Fitness Tracker Demo", SwingConstants.CENTER);
		gameTitleLbl.setFont(gameFont);
		gameTitleLbl.setForeground(new Color(245, 245, 220));
		
		// button panel for better Alignment
		buttonPanel = new JPanel(new FlowLayout());
		newGameBtn = new JButton("Neues Profil");
		
		newGameBtn.setFont(gameFont);
		loadGameBtn = new JButton("Profil laden");
		
		loadGameBtn.setFont(gameFont);
		closeGameBtn = new JButton("Beenden");
		closeGameBtn.setFont(gameFont);
		
		buttonPanel.add(newGameBtn);
		buttonPanel.add(loadGameBtn);
		buttonPanel.add(closeGameBtn);
		
		// fill the background with contents
		backgroundPanel.add(gameTitleLbl, BorderLayout.NORTH);
		backgroundPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		getContentPane().add(backgroundPanel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
	


}

