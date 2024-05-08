package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.MainMenuController;

public class IntroView extends JFrame implements ActionListener {

	private JButton startAppBtn;
	private int scaledWidth, scaledHeight;
	private JPanel panelIntroPic;
	private JPanel panelBtnPruefen;
	private JLabel resImageHangman;
	private JTextField introText;
	private String imgPath;
	private ImageIcon imgIcon;
	private JLabel imgLabel;
	private JPanel mainPanel, topPanel, botPanel;

	public IntroView() {
		setTitle("*Generic Fitness Tracker* Welcome");
		setSize(1366, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		
		//initializing picture path
		imgPath = "res/img.jpg";
		imgIcon = new ImageIcon(imgPath);
		Image originalImage = imgIcon.getImage();
		imgLabel = new JLabel(imgIcon);
		imgLabel.setIcon(imgIcon);
		

		introText = new JTextField();
		startAppBtn = new JButton("Weiter");
		startAppBtn.addActionListener(this);
		
		//dimensions
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
//		topPanel = new JPanel();
//		topPanel.setLayout(new BorderLayout());
//		botPanel = new JPanel();
//		botPanel.setLayout(new BorderLayout());
		//topPanel.add(imgLabel, BorderLayout.NORTH);
		mainPanel.add(imgLabel);
		mainPanel.add(startAppBtn, BorderLayout.SOUTH);
		getContentPane().add(mainPanel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MainMenuController calcController = new MainMenuController();
		dispose();
	}

}
