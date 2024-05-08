package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.BikingController;
import controller.MainMenuController;

public class BikingView {

	String introImgPath = "res/Radfahren.jpg";
	ImageIcon introImgIcon;
	double resultBikingCalories;
	JTextField timeInput;
	JTextField distanceInput;

	public BikingView(int burnedCalories) {
		resultBikingCalories=burnedCalories;
		
		// Frame initiation
		JFrame frame = new JFrame("*Generic FitnessTrackerName* - Verbrannte Kalorien beim Radfahren");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1366, 768);
		frame.setLocationRelativeTo(null);

		// main Panel gets filled into the Frame
		JPanel panel = new JPanel();
		panel = new BackGroundPanel(new ImageIcon(introImgPath).getImage());
		panel.setLayout(new BorderLayout());
		
		// Textfield for input weight
		timeInput = new JTextField(8);
		// Label that shows the calculated calories
		JLabel resultCalc = new JLabel("Verbrannte Kalorien: " + resultBikingCalories);

		// Label for User instructions
		JLabel distanceInstruction = new JLabel("Gefahrene Strecke (in Kilometer): ");
		// Textfield for the distance Input. Input used to calculate Calories
		distanceInput = new JTextField(8);
		
		// Label for user Instructions 
		JLabel timeInstruction = new JLabel("Dauer der Trainingseinheit (in Minuten): ");
		// Button to calculate
		JButton calcBtn = new JButton("Berechne");
		calcBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int time = Integer.parseInt(timeInput.getText());
				int distance=Integer.parseInt(distanceInput.getText());
				BikingController bikingController = new BikingController(distance, time);
				frame.dispose();
				
			}
		});
		
		//Button to trace back to Mainmenu
		JButton menuBtn = new JButton("Hauptmenu");
		menuBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainMenuController mainMenuController = new MainMenuController();
				frame.dispose();
			}
		});


		// Initiliaze Helppanel where instructions and textfields are filled in 
		JPanel helpPanelInstructions = new JPanel(new FlowLayout());
		helpPanelInstructions.add(timeInstruction);
		helpPanelInstructions.add(timeInput);
		helpPanelInstructions.add(distanceInstruction);
		helpPanelInstructions.add(distanceInput);
		helpPanelInstructions.add(calcBtn);
		helpPanelInstructions.add(resultCalc);
		
		//initialize Helppanel where button and result is filled in 
		JPanel helpPanelCalculate= new JPanel(new FlowLayout());
		helpPanelCalculate.add(menuBtn);
		helpPanelCalculate.add(calcBtn);
		helpPanelCalculate.add(resultCalc);
		
		//initialize and filling of the fillpanel wich gets implemented in the final panel
		JPanel fillPanel = new JPanel(new BorderLayout());
		fillPanel.add(helpPanelInstructions, BorderLayout.NORTH);
		fillPanel.add(helpPanelCalculate, BorderLayout.SOUTH);
		
		//filling the fillpanel into the mainpanel
		panel.add(fillPanel, BorderLayout.SOUTH);


		frame.add(panel);

		frame.setVisible(true);
	}

}
