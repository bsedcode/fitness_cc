package view;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CalculationView {

	String introImgPath = "res/fitnessTracker.jpg";
	ImageIcon introImgIcon;

	public CalculationView() {

		// Frame initiation
		JFrame frame = new JFrame("Kalorien Berechnung");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);

		// main Panel gets filled into the Frame
		JPanel panel = new JPanel();
		panel = new BackGroundPanel(new ImageIcon(introImgPath).getImage());
		panel.setLayout(new BorderLayout());

		// panels to get filled with button textfield dropdown
		JPanel calcPanel = new JPanel();
		JPanel txtPanel = new JPanel();

		// helppanel which gets filled by the calcPanel and textPanel
		JPanel helpPanel = new JPanel();
		helpPanel.setLayout(new BorderLayout());

		// Written Text in the program
		JLabel repDurPanel = new JLabel(
				"Gibt die Anzahl deiner Wiederholungen oder die Dauer deiner Trainigseinheit an: ");
		JLabel calcLbl = new JLabel("Wähle deine Sportart aus!");

		// Textfield variable needed for calculation
		JTextField inputCalc = new JTextField(5);

		// Dropdown Menu for sport disciplines
		String[] disciplTxt = { "Fahrrad fahren", "Schwimmen", "Fußball", "Handball", "Laufen", "Bettsport" };
		JComboBox<String> sportDiscipl = new JComboBox<String>(disciplTxt);

		// start the calculation button
		JButton startCalcBtn = new JButton("Berechne Kalorien");

		frame.add(panel);

		// filling the first support panel with dropdown menu and calc Button
		calcPanel.add(calcLbl);
		calcPanel.add(sportDiscipl);
		calcPanel.add(startCalcBtn);

		// filling 2nd support panel with Textfield and input text
		txtPanel.add(repDurPanel);
		txtPanel.add(inputCalc);

		// Filling the "main"
		helpPanel.add(calcPanel, BorderLayout.NORTH);
		helpPanel.add(txtPanel, BorderLayout.SOUTH);

		panel.add(helpPanel, BorderLayout.SOUTH);
		frame.setVisible(true);
	}
}
