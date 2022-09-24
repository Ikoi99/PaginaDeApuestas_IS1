package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;

import businessLogic.BLFacade;
import exceptions.EventAlreadyExist;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CreateEventGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel date;
	private JTextField questionT;
	private JLabel description;
	private JTextField descriptionT;
	private JLabel minBet;
	private JTextField minBetI;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateEventGUI frame = new CreateEventGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreateEventGUI() {
		JFrame createEvento = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 335);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BLFacade facade =  MainGUI.getBusinessLogic();
		
		date = new JLabel("Event Date");
		date.setBounds(347, 22, 98, 14);
		contentPane.add(date);
		
		JLabel question = new JLabel("Add a question for the event");
		question.setBounds(10, 133, 302, 14);
		contentPane.add(question);
		
		questionT = new JTextField();
		questionT.setBounds(10, 158, 302, 26);
		contentPane.add(questionT);
		questionT.setColumns(10);
		
		description = new JLabel("Describe the event");
		description.setBounds(10, 22, 154, 14);
		contentPane.add(description);
		
		descriptionT = new JTextField();
		descriptionT.setBounds(10, 47, 302, 75);
		contentPane.add(descriptionT);
		descriptionT.setColumns(10);
		
		minBet = new JLabel("Minimum Bet");
		minBet.setBounds(10, 195, 82, 20);
		contentPane.add(minBet);
		
		minBetI = new JTextField();
		minBetI.setBounds(109, 196, 67, 20);
		contentPane.add(minBetI);
		minBetI.setColumns(10);
		
		JLabel ERROR = new JLabel("");
		ERROR.setEnabled(false);
		ERROR.setForeground(Color.RED);
		ERROR.setBounds(144, 234, 302, 14);
		contentPane.add(ERROR);
		
		JCalendar jCalendar1 = new JCalendar();
		jCalendar1.setBounds(347, 47, 225, 150);
		contentPane.add(jCalendar1);
		
		JButton create = new JButton("Create");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(descriptionT.getText().equals("")){
					ERROR.setText("Please set an event description");
					ERROR.setEnabled(true);
					/*
				}else if(questionT.getText().equals("") && minBetI.getText().equals("") != false){
					ERROR.setText("Please set a question");
					ERROR.setEnabled(true);
				}else if(questionT.getText().equals("") != false && minBetI.getText().equals("")){
					ERROR.setText("Please set a minimum amount for the question");
					ERROR.setEnabled(true);
					*/
				}else if(Float.parseFloat(minBetI.getText()) == 0) {
					ERROR.setText("The minimum bet has to be number");
					ERROR.setEnabled(true);
				}else if(Float.parseFloat(minBetI.getText()) == 0) {
					ERROR.setText("The minimum bet has to be higher that 0");
					ERROR.setEnabled(true);
				}

				if(questionT.getText().equals("") != false && minBetI.getText().equals("") != false) {
					try {
						facade.createEvent(descriptionT.getText(),jCalendar1.getDate(), questionT.getText(), Float.parseFloat(minBetI.getText()));
					} catch (NumberFormatException | EventAlreadyExist | EventFinished | QuestionAlreadyExist e1) {
						e1.printStackTrace();
					}
				}else {
					try {
						facade.createEvent(descriptionT.getText(),jCalendar1.getDate());
					} catch (EventAlreadyExist e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		create.setBounds(231, 259, 126, 36);
		contentPane.add(create);
		
		
		
		btnBack = new JButton("\u2190");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame a = new MainGUI();
				createEvento.setVisible(false);;
			}
		});
		btnBack.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		btnBack.setBounds(10, 249, 69, 36);
		contentPane.add(btnBack);

	}
	
}