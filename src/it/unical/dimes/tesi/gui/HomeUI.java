package it.unical.dimes.tesi.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import it.unical.dimes.tesi.debug.DebugConnector;
import it.unical.dimes.tesi.gui.utils.CommonsPopUp;

import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class HomeUI {

	private JFrame frmAlqMonitor;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeUI window = new HomeUI();
					window.frmAlqMonitor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeUI() {
		initialize(null);
	}

	public HomeUI(JFrame f) {
		initialize(f);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame f) {
		
		frmAlqMonitor = f==null?new JFrame():f;
		frmAlqMonitor.getContentPane().removeAll();
		frmAlqMonitor.setTitle("ALQ Monitor");
		frmAlqMonitor.setIconImage(Toolkit.getDefaultToolkit().getImage(HomeUI.class.getResource("/it/unical/dimes/tesi/gui/resources/unical.gif")));
		if (f==null) frmAlqMonitor.setBounds(100, 100, 966, 522);
		frmAlqMonitor.setResizable(true);
		frmAlqMonitor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmAlqMonitor.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opzioni");
		menuBar.add(mnNewMenu);
		
		mnNewMenu.add(CommonsPopUp.credits(frmAlqMonitor));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(60);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] ipAndPort = textField.getText().split(":");
				try {
					DebugConnector.createInstance(ipAndPort[1],ipAndPort[0]);
				} catch (Exception e1) {
					System.err.println("Invalid port or ip");
					return;
				}
				frmAlqMonitor.getContentPane().removeAll();
				new QueueUI(frmAlqMonitor);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(178, 34, 34));
		
		JLabel lblNewLabel = new JLabel("Inserisci indirizzo debugger:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(frmAlqMonitor.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(172)
					.addComponent(textField)
					.addGap(167))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(308)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
					.addGap(301))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(390)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(408))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(151)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap(183, Short.MAX_VALUE))
		);
		frmAlqMonitor.getContentPane().setLayout(groupLayout);
	}
}
