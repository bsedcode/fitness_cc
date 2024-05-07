package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BikingView {
	
	String introImgPath = "res/FussballHintergrund.jpg";
	ImageIcon introImgIcon;
	
	public BikingView() {
		
		//Frame initiation
		JFrame frame = new JFrame("*Generic FitnessTrackerName* - Verbrannte Kalorien beim Radfahren");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1366, 768);
	
		// main Panel gets filled into the Frame
		JPanel panel = new JPanel();
		panel = new BackGroundPanel(new ImageIcon(introImgPath).getImage());
		panel.setLayout(new BorderLayout());
		

		//Instruction for the user
		JLabel weightInstruc = new JLabel("Gewicht bei Trainingsbeginn: ");
		
		//Button to calculate
		JButton calcBtn = new JButton("Berechne");
		
		//Textfield for input weight
		JTextField weightInput = new JTextField(8);
		
		//Label that shows the calculated calories
		JLabel resultCalc = new JLabel ("result");
		
		//Initiliaze Helppanel 
		JPanel helpPanel = new JPanel();
		helpPanel.setLayout(new FlowLayout());
		
		helpPanel.add(weightInstruc);
		helpPanel.add(weightInput);
		helpPanel.add(calcBtn);
		helpPanel.add(resultCalc);
		
		panel.add(helpPanel, BorderLayout.SOUTH);
		frame.add(panel);
		
		

		
		frame.setVisible(true);
	}
	
}


