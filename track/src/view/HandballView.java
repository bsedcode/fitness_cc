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

import controller.HandBallController;
import controller.MainMenuController;

public class HandballView {
	private String introImgPath = "res/Handball.jpg";
	private ImageIcon introImgIcon;
	private JFrame frame;
	private JPanel panel;
	private JLabel weightInstruc;
	private JButton calcBtn;
	private JTextField weightInput;
	private JLabel resultCalc;
	private JPanel helpPanelCalc;
	private JPanel helpPanelInstr;
	private JPanel fillPanel;
	private JTextField timeInput;
	private JLabel timeInstruc;
	private int calculatedCalories;
	
	public HandballView() {

		
		//Frame initiation
		frame = new JFrame("*Generic FitnessTrackerName* - Verbrannte Kalorien beim Handball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1366, 768);
		frame.setLocationRelativeTo(null);
	
		// main Panel gets filled into the Frame
		panel = new JPanel();
		panel = new BackGroundPanel(new ImageIcon(introImgPath).getImage());
		panel.setLayout(new BorderLayout());
		

		//Instruction for the user
		weightInstruc = new JLabel("Gewicht bei Trainingsbeginn (in Kilogramm): ");
		
		//Button to calculate
		calcBtn = new JButton("Berechne");
		calcBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int calcWeight = Integer.parseInt(weightInput.getText());
				int calcTime = Integer.parseInt(timeInput.getText());
				HandBallController handBallController=new HandBallController();
				calculatedCalories=handBallController.calculateHandBall(calcWeight, calcTime);
				resultCalc.setText("Verbrannte Kalorien: " + calculatedCalories);
				frame.repaint();
			}
		});
		
		//button for mainmenu
		JButton menuBtn = new JButton("Hauptmenu");
		menuBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainMenuController mainMenuController = new MainMenuController();
				frame.dispose();
			}
		});
		
		//Textfield for input weight
		weightInput = new JTextField(8);
		
		//Label that shows the calculated calories
		resultCalc = new JLabel ("Verbrannte Kalorien: " + calculatedCalories);
		
		//textfield for input time
		timeInput = new JTextField(8);
		
		//Label for user instructions
		timeInstruc = new JLabel("Dauer der Trainingseinheit (in Minuten): ");
		
		//Initiliaze Helppanel 
		helpPanelInstr = new JPanel();
		helpPanelInstr.setLayout(new FlowLayout());
		
		helpPanelInstr.add(weightInstruc);
		helpPanelInstr.add(weightInput);
		helpPanelInstr.add(timeInstruc);
		helpPanelInstr.add(timeInput);
		
		//filling helppanel for the Buttons and result
		helpPanelCalc = new JPanel();
		helpPanelCalc.setLayout(new FlowLayout());
		helpPanelCalc.add(menuBtn);
		helpPanelCalc.add(calcBtn);
		helpPanelCalc.add(resultCalc);
		
		//panel that gets filled into mainframe
		fillPanel = new JPanel();
		fillPanel.setLayout(new BorderLayout());
		fillPanel.add(helpPanelInstr, BorderLayout.NORTH);
		fillPanel.add(helpPanelCalc, BorderLayout.SOUTH);
		
		panel.add(fillPanel, BorderLayout.SOUTH);
		frame.add(panel);
		
		

		
		frame.setVisible(true);
	}
	
}


