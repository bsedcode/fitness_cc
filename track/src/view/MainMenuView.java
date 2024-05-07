package view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import controller.MainMenuController;

public class MainMenuView {

	String introImgPath = "res/fitnessTracker.jpg";
	ImageIcon introImgIcon;
	JComboBox<String> sportDiscipl;
	JPanel panel;
	JFrame frame;
	JLabel calcLbl;
	JPanel calcPanel;
	JButton startCalcBtn;


	public MainMenuView() {

		// Frame initiation
		frame = new JFrame("Kalorien Berechnung");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);

		// main Panel gets filled into the Frame
		panel = new JPanel();
		panel = new BackGroundPanel(new ImageIcon(introImgPath).getImage());
		panel.setLayout(new BorderLayout());

		// panels to get filled with button textfield dropdown
		calcPanel = new JPanel();

		// helppanel which gets filled by the calcPanel and textPanel
		JPanel helpPanel = new JPanel();
		helpPanel.setLayout(new BorderLayout());

		// Written Text in the program
		calcLbl = new JLabel("Wähle deine Sportart aus!");

		// Dropdown Menu for sport disciplines
		String[] disciplTxt = { "Fahrrad fahren", "Schwimmen", "Fußball", "Handball", "Laufen"};
		sportDiscipl = new JComboBox<String>(disciplTxt);

		// start the calculation button
		startCalcBtn = new JButton("Weiter");
		startCalcBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String disciplineTxt = (String) sportDiscipl.getSelectedItem();

				if (disciplineTxt.equals("Schwimmen")) {
					SwimView swimView = new SwimView();
					frame.dispose();
				}
				else if(disciplineTxt.equals("Fahrrad fahren")) {
					BikingView bikingView = new BikingView();
					frame.dispose();
				}
				else if(disciplineTxt.equals("Handball")) {
					HandballView handBallView = new HandballView();
					frame.dispose();
				}
				else if(disciplineTxt.equals("Fußball")) {
					SoccerView soccerView = new SoccerView();
					frame.dispose();
				}
				else if(disciplineTxt.equals("Laufen")) {
					WalkingView bikingView = new WalkingView();
					frame.dispose();
				}
				
			}
		});

		frame.add(panel);

		// filling the first support panel with dropdown menu and calc Button
		calcPanel.add(calcLbl);
		calcPanel.add(sportDiscipl);
		calcPanel.add(startCalcBtn);

		// Filling the "main" Panel
		panel.add(calcPanel, BorderLayout.SOUTH);
		panel.add(helpPanel, BorderLayout.NORTH);

		frame.setVisible(true);
	}
}
