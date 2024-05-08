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

import controller.SwimmController;

public class SwimView {
	String introImgPath = "res/schwimmenHintergrund.jpg";
	ImageIcon introImgIcon;
	JFrame frame;
	JPanel panel;
	JLabel weightInstruc;
	JButton calcBtn;
	JTextField weightInput;
	JLabel resultCalc;
	JPanel helpPanel;
	
	public SwimView() {
		
		//Frame initiation
		frame = new JFrame("*Generic FitnessTrackerName* - Verbrannte Kalorien beim Schwimmen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1366, 768);
		frame.setLocationRelativeTo(null);
	
		// main Panel gets filled into the Frame
		panel = new JPanel();
		panel = new BackGroundPanel(new ImageIcon(introImgPath).getImage());
		panel.setLayout(new BorderLayout());
		

		//Instruction for the user
		weightInstruc = new JLabel("Gewicht bei Trainingsbeginn: ");
		
		//Button to calculate
		calcBtn = new JButton("Berechne");
		calcBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwimmController swimmController = new SwimmController();
				
			}
		});
		
		//Textfield for input weight
		weightInput = new JTextField(8);
		
		//Label that shows the calculated calories
		resultCalc = new JLabel ("result");
		
		//Initiliaze Helppanel 
		helpPanel = new JPanel();
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


