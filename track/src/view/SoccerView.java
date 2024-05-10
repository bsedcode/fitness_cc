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

import controller.MainMenuController;
import controller.SoccerController;

public class SoccerView {
	
	private String introImgPath = "res/FussballHintergrund.jpg";
	private ImageIcon introImgIcon;
	private int resultBikingCalories;
	private JTextField timeInput;
	private JTextField weightInput;
	private JFrame frame;
	private JPanel panel;
	private JLabel weightInstruc;
	private JLabel timeInstruc;
	private JButton calcBtn;
	private JButton menuBtn;
	private JLabel resultCalc;
	private JPanel helpPanelInstr;
	private JPanel helpPanelBtn;
	private JPanel fillPanel;		
	
	public SoccerView(int burnedCalories) {
		resultBikingCalories=burnedCalories;
		
		//Frame initiation
		frame = new JFrame("*Generic FitnessTrackerName* - Verbrannte Kalorien Fußball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1366, 768);
		frame.setLocationRelativeTo(null);
	
		// main Panel gets filled into the Frame
		panel = new JPanel();
		panel = new BackGroundPanel(new ImageIcon(introImgPath).getImage());
		panel.setLayout(new BorderLayout());
		

		//Instruction for the user weight
		weightInstruc = new JLabel("Gewicht bei Trainingsbeginn (in Kilogramm): ");
		
		//Instruction for the user Time
		timeInstruc = new JLabel("Dauer des Trainings (in Minuten): ");
		
		//Button to calculate
		calcBtn = new JButton("Berechne");
		calcBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int time = Integer.parseInt(timeInput.getText());
				int weight=Integer.parseInt(weightInput.getText());
				SoccerController soccerController=new SoccerController(time,weight);
				frame.dispose();
			}
		});
		
		
		//Button to trace back to Mainmenu
		menuBtn = new JButton("Hauptmenu");
		menuBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainMenuController mainMenuController = new MainMenuController();
				frame.dispose();
			}
		});
		
		//Textfield for input weight
		weightInput = new JTextField(8);
		
		//texfield for input time
		timeInput = new JTextField(8);
		
		//Label that shows the calculated calories
		resultCalc = new JLabel ("Verbrannte Kalorien: " + resultBikingCalories);
		
		//Initiliaze Helppanel Filled with the Instructions and Textfields
		helpPanelInstr = new JPanel(new FlowLayout());		
		helpPanelInstr.add(weightInstruc);
		helpPanelInstr.add(weightInput);
		helpPanelInstr.add(timeInstruc);
		helpPanelInstr.add(timeInput);

		
		//initializing Helppanel filled with Buttons
		helpPanelBtn = new JPanel(new FlowLayout());
		helpPanelBtn.add(menuBtn);
		helpPanelBtn.add(calcBtn);
		helpPanelBtn.add(resultCalc);
		
		//initialize fillpanel getting filled with both helppanels and gets filled into the main panel
		fillPanel = new JPanel(new BorderLayout());
		fillPanel.add(helpPanelInstr, BorderLayout.NORTH);
		fillPanel.add(helpPanelBtn, BorderLayout.SOUTH);
		
		panel.add(fillPanel, BorderLayout.SOUTH);
		frame.add(panel);
		
		

		
		frame.setVisible(true);
	}
	
}
