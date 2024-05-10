package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.HandBallController;
import controller.MainMenuController;
import controller.WalkingController;

public class WalkingView {
	private String introImgPath = "res/Walking.jpg";
	private JFrame frame;
	private JPanel panel;
	private JLabel weightInstr;
	private JButton calcBtn;
	private JTextField weightInput;
	private JLabel resultCalc;
	private JPanel helpPanelTop;
	private JPanel helpPanelBot;
	private JButton menuBtn;
	private JPanel fillPanel; // weight distance time
	private JLabel distanceInstr;
	private JTextField distanceInput;
	private JLabel timeInstr;
	private JTextField timeInput;
	private JComboBox<String> walkingIntensitiesCombo;
	private JButton exitBtn;
	private int burnedCalories;

	public WalkingView() {
		burnedCalories = 0;
		// Frame initiation
		frame = new JFrame("*Generic FitnessTrackerName* - Verbrannte Kalorien beim Laufen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1366, 768);
		frame.setLocationRelativeTo(null);

		// main Panel gets filled into the Frame
		panel = new JPanel();
		panel = new BackGroundPanel(new ImageIcon(introImgPath).getImage());
		panel.setLayout(new BorderLayout());

		// Instruction for the user weight & Textfield for input weight
		weightInstr = new JLabel("     Gewicht bei Trainingsbeginn: ");
		weightInput = new JTextField(8);

		// instruction for the user duration & Textfield for input Duration
		timeInstr = new JLabel("     Dauer des Trainings (in min)");
		timeInput = new JTextField(8);

		// instruction for the user distance & Textfield for input Distance
		distanceInstr = new JLabel("     Gelaufene Strecke");
		distanceInput = new JTextField(8);

		// Dropdown Menu for waling intensities 
		String[] walkingIntensitiesTxt = { "Laufen", "Walking", "Joggen", "Rennen" };
		walkingIntensitiesCombo = new JComboBox<String>(walkingIntensitiesTxt);

		// Button to calculate
		calcBtn = new JButton("Berechne");
		calcBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int calcDistance=Integer.parseInt(distanceInput.getText());;
				int calcWeight=Integer.parseInt(weightInput.getText());;
				int calcTime=Integer.parseInt(timeInput.getText());;
				int calcCalories;
				String calcString=(String) walkingIntensitiesCombo.getSelectedItem();;
				
				WalkingController walkingController=new WalkingController();
				calcCalories=walkingController.calculateWalking(calcWeight,calcDistance,calcTime, calcString);
				resultCalc.setText("Verbrannte Kalorien: " + calcCalories + "                              ");
				frame.repaint();
			}
		});

		// Button to trace back to main menu
		menuBtn = new JButton("Hauptmenü");
		menuBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainMenuController mainMenuController = new MainMenuController();
				frame.dispose();

			}
		});

		//Button to exit the app
		exitBtn = new JButton("Beenden");
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		
		// Label that shows the calculated calories
		resultCalc = new JLabel("Verbrannte Kalorien: " + burnedCalories + "                              ");

		// Initiliaze Helppanel to fill the top row
		helpPanelTop = new JPanel();
		helpPanelTop.setLayout(new FlowLayout());

		helpPanelTop.add(weightInstr);
		helpPanelTop.add(weightInput);
		helpPanelTop.add(timeInstr);
		helpPanelTop.add(timeInput);
		helpPanelTop.add(distanceInstr);
		helpPanelTop.add(distanceInput);

		// initialize Helppanel to fill the bottom row
		helpPanelBot = new JPanel();
		helpPanelBot.setLayout(new FlowLayout());
		helpPanelBot.add(walkingIntensitiesCombo);
		helpPanelBot.add(calcBtn);
		helpPanelBot.add(resultCalc);
		helpPanelBot.add(menuBtn);
		helpPanelBot.add(exitBtn);

		fillPanel = new JPanel();
		fillPanel.setLayout(new BorderLayout());
		fillPanel.add(helpPanelTop, BorderLayout.NORTH);
		fillPanel.add(helpPanelBot, BorderLayout.SOUTH);

		panel.add(fillPanel, BorderLayout.SOUTH);
		frame.add(panel);

		frame.setVisible(true);
	}

}
