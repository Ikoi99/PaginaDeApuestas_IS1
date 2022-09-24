package gui;

/**
 * @author Software Engineering teachers
 */

import javax.swing.*;

import domain.Event;
import domain.User;
import businessLogic.BLFacade;
import domain.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	
	private static final long serialVersionUID = 1L;

	private MainGUI main = this;
	private User user = null;

	private JPanel jContentPane = null;
	private JButton jButtonCreateQuery = null;
	private JButton jButtonQueryQueries = null;
	private JButton btnCreateEvent = null;
	private JButton jButtonCreateForecast =null;

	private static BLFacade appFacadeInterface;

	public static BLFacade getBusinessLogic() {
		return appFacadeInterface;
	}

	public static void setBussinessLogic(BLFacade afi) {
		appFacadeInterface = afi;
	}

	protected JLabel jLabelSelectOption;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JPanel panel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnRegister;
	private JButton btnLogin;

	/**
	 * This is the default constructor
	 */
	public MainGUI() {
		super();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					// if (ConfigXML.getInstance().isBusinessLogicLocal()) facade.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(
							"Error: " + e1.toString() + " , probably problems with Business Logic or Database");
				}
				System.exit(1);
			}
		});

		initialize();
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		// this.setSize(271, 295);
		this.setSize(495, 290);
		this.setContentPane(getJContentPane());
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("MainTitle"));
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getLblNewLabel());
			jContentPane.add(getBoton3());
			jContentPane.add(getBoton2());
			jContentPane.add(getBoton4());
			jContentPane.add(getPanel());
			jContentPane.add(getBtnRegister());
			jContentPane.add(getBtnLogin());

			btnCreateEvent = new JButton();
			btnCreateEvent.setText(ResourceBundle.getBundle("Etiquetas").getString("MainGUI.btnCreateEvent.text")); //$NON-NLS-1$ //$NON-NLS-2$
			btnCreateEvent.setBounds(280, 64, 191, 63);
			jContentPane.add(btnCreateEvent);
			btnCreateEvent.setVisible(false);
			btnCreateEvent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (user != null && user.isAdmin()) {
						CreateEventGUI a = new CreateEventGUI();
						a.setVisible(true);
					}
				}
			});
			btnCreateEvent.setText(ResourceBundle.getBundle("Etiquetas").getString("MainGUI.btnCreateEvent.text")); //$NON-NLS-1$ //$NON-NLS-2$
			btnCreateEvent.setBounds(255, 64, 216, 38);
			jContentPane.add(btnCreateEvent);
		}
		return jContentPane;
	}

	/**
	 * This method initializes boton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBoton2() {
		if (jButtonCreateQuery == null) {
			jButtonCreateQuery = new JButton();
			jButtonCreateQuery.setBounds(10, 64, 235, 38);
			jButtonCreateQuery.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
			jButtonCreateQuery.setVisible(false);
			jButtonCreateQuery.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (user != null && user.isAdmin()) {
						//jButtonCreateQuery.setVisible(true);
						JFrame a = new CreateQuestionGUI(new Vector<Event>());
						a.setVisible(true);
					}
				}
			});
		}
		return jButtonCreateQuery;
	}

	/**
	 * This method initializes boton2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBoton3() {
		if (jButtonQueryQueries == null) {
			jButtonQueryQueries = new JButton();
			jButtonQueryQueries.setBounds(10, 113, 235, 38);
			jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
			jButtonQueryQueries.setVisible(false);
			jButtonQueryQueries.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (user != null) {
						//jButtonQueryQueries.setVisible(true);
						JFrame a = new FindQuestionsGUI();
						a.setVisible(true);
					}
				}
			});
		}
		return jButtonQueryQueries;
	}
	private JButton getBoton4() {
		if (jButtonCreateForecast == null) {
			jButtonCreateForecast = new JButton();
			jButtonCreateForecast.setBounds(255, 113, 214, 38);
			jButtonCreateForecast.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
			jButtonCreateForecast.setVisible(false);
			jButtonCreateForecast.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JFrame a = new CreateForecastGUI(new Vector<Event>());

					a.setVisible(true);
				}
			});
		}
		return jButtonCreateForecast;
	}
	

	private JLabel getLblNewLabel() {
		if (jLabelSelectOption == null) {
			jLabelSelectOption = new JLabel(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
			jLabelSelectOption.setBounds(122, 0, 220, 63);
			jLabelSelectOption.setFont(new Font("Tahoma", Font.BOLD, 13));
			jLabelSelectOption.setForeground(Color.BLACK);
			jLabelSelectOption.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabelSelectOption;
	}

	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("English", true);
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Locale.setDefault(new Locale("en"));
					System.out.println("Locale: " + Locale.getDefault());
					redibujar();
				}
			});
			buttonGroup.add(rdbtnNewRadioButton);
		}
		return rdbtnNewRadioButton;
	}

	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("Euskara");
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Locale.setDefault(new Locale("eus"));
					System.out.println("Locale: " + Locale.getDefault());
					redibujar();
				}
			});
			buttonGroup.add(rdbtnNewRadioButton_1);
		}
		return rdbtnNewRadioButton_1;
	}

	private JRadioButton getRdbtnNewRadioButton_2() {
		if (rdbtnNewRadioButton_2 == null) {
			rdbtnNewRadioButton_2 = new JRadioButton("Castellano");
			rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Locale.setDefault(new Locale("es"));
					System.out.println("Locale: " + Locale.getDefault());
					redibujar();
				}
			});
			buttonGroup.add(rdbtnNewRadioButton_2);
		}
		return rdbtnNewRadioButton_2;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(0, 189, 481, 63);
			panel.add(getRdbtnNewRadioButton_1());
			panel.add(getRdbtnNewRadioButton_2());
			panel.add(getRdbtnNewRadioButton());
		}
		return panel;
	}

	private void redibujar() {
		jLabelSelectOption.setText(ResourceBundle.getBundle("Etiquetas").getString("SelectOption"));
		jButtonQueryQueries.setText(ResourceBundle.getBundle("Etiquetas").getString("QueryQueries"));
		jButtonCreateQuery.setText(ResourceBundle.getBundle("Etiquetas").getString("CreateQuery"));
		this.setTitle(ResourceBundle.getBundle("Etiquetas").getString("MainTitle"));
	}

	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MainGUI.btnNewButton.text")); //$NON-NLS-1$ //$NON-NLS-2$
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame a = new Register();
					a.setVisible(true);
				}
			});
			btnRegister.setBounds(40, 22, 85, 21);
		}
		return btnRegister;
	}

	private JButton getBtnLogin() {
		MainGUI gui = this;
		if (btnLogin == null) {
			btnLogin = new JButton(ResourceBundle.getBundle("Etiquetas").getString("MainGUI.btnNewButton_1.text")); //$NON-NLS-1$ //$NON-NLS-2$
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame a = new Login(main);
					a.setVisible(true);
				}
			});
			btnLogin.setBounds(340, 22, 85, 21);
		}
		return btnLogin;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void setVisible() {
		if (user != null && user.isAdmin()) {
			jButtonCreateQuery.setVisible(true);
			btnCreateEvent.setVisible(true);
			jButtonQueryQueries.setVisible(true);
			jButtonCreateForecast.setVisible(true);
		} else if (user != null) {
			jButtonQueryQueries.setVisible(true);
		}
		btnLogin.setVisible(false);
		btnRegister.setVisible(false);
	}
	
} // @jve:decl-index=0:visual-constraint="0,0"
