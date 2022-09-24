package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

import businessLogic.BLFacade;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;

public class Register extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField userNameField;
	private JTextField year;
	private JTextField day;




	//
	private JPanel panelPrincipal;

	// Box
	private JCheckBox Check_Remenber_Me;

	//Meses
	private JComboBox<String> month;
	private DefaultComboBoxModel<String> monthNames = new DefaultComboBoxModel<String>();
	private JTextField textField_3;

	//Etiquetas
	private JLabel lblDate, lblGender, lblCurrentAccount,lblYear ,lblMonth, lblDay, lblRegister, lblUsername, lblPassword, lblPassword_1;

	//Botones
	private JButton btnSingUp, btnBack;
	private JRadioButton rdbtnMale, rdbtnFemale, rdbtnOthers ;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField passwordField_1;
	//
	char[] password, password1;
	//Panel de errores
	JTextPane ErrorPanel;



	public Register() {
		JFrame registro = this;
		BLFacade facade = MainGUI.getBusinessLogic();
		getContentPane().setLayout(null);

		lblRegister = new JLabel("SING IN");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.BLACK);
		lblRegister.setFont(new Font("Rockwell", Font.BOLD, 34));
		lblRegister.setBackground(Color.WHITE);
		lblRegister.setBounds(10, 10, 516, 64);
		getContentPane().add(lblRegister);

		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		panelPrincipal.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelPrincipal.setBackground(SystemColor.menu);
		panelPrincipal.setBounds(10, 84, 516, 587);
		getContentPane().add(panelPrincipal);

		Check_Remenber_Me = new JCheckBox("Accept Permissions");
		Check_Remenber_Me.setFont(new Font("Rockwell", Font.PLAIN, 15));
		Check_Remenber_Me.setBounds(88, 529, 183, 21);
		panelPrincipal.add(Check_Remenber_Me);


		passwordField = new JPasswordField();
		password = passwordField.getPassword();
		passwordField.setBounds(88, 152, 294, 36);
		panelPrincipal.add(passwordField);

		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblPassword.setBounds(46, 132, 279, 21);
		panelPrincipal.add(lblPassword);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(88, 228, 294, 36);
		panelPrincipal.add(passwordField_1);

		lblPassword_1 = new JLabel("Password:");
		password1 = passwordField_1.getPassword();
		lblPassword_1.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblPassword_1.setBounds(46, 208, 279, 21);
		panelPrincipal.add(lblPassword_1);

		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblUsername.setBounds(46, 56, 294, 21);
		panelPrincipal.add(lblUsername);

		btnSingUp = new JButton("SING UP");
		btnSingUp.setEnabled(true);
		//if (Check_Remenber_Me.isSelected()) btnSingIn.setEnabled(true);

		userNameField = new JTextField();
		userNameField.setColumns(10);
		userNameField.setBounds(88, 76, 294, 36);
		panelPrincipal.add(userNameField);

		btnSingUp.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				ErrorPanel.setText("");
				String pass1= new String(passwordField.getPassword());
				String pass2=new String(passwordField_1.getPassword());
				
				Date date = newDate(Integer.parseInt(year.getText()),month.getSelectedIndex(),Integer.parseInt(day.getText()));
				Date actualDate = new Date();
				
				if (!pass1.equals(pass2)){
					ErrorPanel.setText("Error las contrase\u00F1as no coinciden");
					System.out.println("Las contrae�as no coinciden");
				}
				
				else if(date.compareTo(actualDate) > 0 || actualDate.getYear() - date.getYear() < 18) {
					ErrorPanel.setText("Fecha invalida(ve a jugar al pokemon)");
				}
				else if (!Check_Remenber_Me.isSelected()) {
					ErrorPanel.setText("Debes acceptar los terminos");
				}
				else {
				
				try {
					
						facade.registerUser(userNameField.getText(), new String(passwordField.getPassword()));
						registro.setVisible(false);
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						ErrorPanel.setText(e1.getMessage());
					}catch(Exception e1) {
						ErrorPanel.setText(e1.getMessage());
					}
				}


			}
		});
		btnSingUp.setFont(new Font("Rockwell", Font.PLAIN, 17));
		btnSingUp.setBounds(360, 520, 113, 36);
		panelPrincipal.add(btnSingUp);

		btnBack = new JButton("\u2190");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Microsoft YaHei", Font.BOLD, 34));
		btnBack.setBounds(10, 10, 69, 36);
		panelPrincipal.add(btnBack);

		lblYear = new JLabel("Year:");
		lblYear.setBounds(46, 310, 33, 16);
		panelPrincipal.add(lblYear);

		year = new JTextField();
		year.setText("xxxx");
		year.setColumns(10);
		year.setBounds(88, 306, 50, 26);
		panelPrincipal.add(year);

		lblMonth = new JLabel("Month:");
		lblMonth.setBounds(158, 310, 50, 16);
		panelPrincipal.add(lblMonth);

		month = new JComboBox<String>();
		month.setBounds(218, 305, 116, 27);
		panelPrincipal.add(month);

		month.setModel(monthNames);

		monthNames.addElement("January");
		monthNames.addElement("February");
		monthNames.addElement("March");
		monthNames.addElement("April");
		monthNames.addElement("May");
		monthNames.addElement("June");
		monthNames.addElement("July");
		monthNames.addElement("August");
		monthNames.addElement("September");
		monthNames.addElement("October");
		monthNames.addElement("November");
		monthNames.addElement("December");
		month.setSelectedIndex(0);

		lblDay = new JLabel("Day:");
		lblDay.setBounds(344, 310, 38, 16);
		panelPrincipal.add(lblDay);

		day = new JTextField();
		//day.setText();
		day.setColumns(10);
		day.setBounds(388, 306, 67, 26);
		panelPrincipal.add(day);

		lblDate = new JLabel("Born date:");
		lblDate.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblDate.setBounds(46, 274, 279, 21);
		panelPrincipal.add(lblDate);

		lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblGender.setBounds(46, 342, 279, 21);
		panelPrincipal.add(lblGender);

		rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMale.setSelected(true);
		rdbtnMale.setBounds(70, 369, 68, 23);
		panelPrincipal.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnFemale.setBounds(195, 369, 77, 23);
		panelPrincipal.add(rdbtnFemale);

		rdbtnOthers = new JRadioButton("Others");
		buttonGroup.add(rdbtnOthers);
		rdbtnOthers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnOthers.setBounds(344, 369, 77, 23);
		panelPrincipal.add(rdbtnOthers);

		lblCurrentAccount = new JLabel("Current account:");
		lblCurrentAccount.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblCurrentAccount.setBounds(46, 407, 294, 21);
		panelPrincipal.add(lblCurrentAccount);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(88, 438, 294, 36);
		panelPrincipal.add(textField_3);

		ErrorPanel = new JTextPane();
		ErrorPanel.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		ErrorPanel.setForeground(new Color(255, 0, 0));
		ErrorPanel.setBackground(SystemColor.menu);
		ErrorPanel.setBounds(292, 484, 214, 36);
		panelPrincipal.add(ErrorPanel);


		
		

		this.setSize(550, 710);
	}
	private Date newDate(int year,int month,int day) {

	     Calendar calendar = Calendar.getInstance();
	     calendar.setLenient(false); // To avoid use heuristics to parse inputs as dates
	     calendar.set(year, month, day,0,0,0);
	     calendar.set(Calendar.MILLISECOND, 0);

	     return calendar.getTime();
	}
}
