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

import it.unical.dimes.tesi.gui.utils.CommonsPopUp;

import javax.swing.SwingConstants;
import javax.swing.JMenu;

public class HomeUI {

	private JFrame frmAlqMonitor;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlqMonitor = new JFrame();
		frmAlqMonitor.setTitle("ALQ Monitor");
		frmAlqMonitor.setIconImage(Toolkit.getDefaultToolkit().getImage(HomeUI.class.getResource("/it/unical/dimes/tesi/gui/resources/unical.gif")));
		frmAlqMonitor.setBounds(100, 100, 899, 481);
		frmAlqMonitor.setResizable(true);
		frmAlqMonitor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_2 = new JPanel();
		
		JLabel lblNewLabel = new JLabel("Choose Parameters:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel label = new JLabel("");
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel = new JPanel();
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(178, 34, 34));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmAlqMonitor.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(155)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(156))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
		);
		
		JTextArea txtrInQuestaSchermata = new JTextArea();
		txtrInQuestaSchermata.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPane_1.setViewportView(txtrInQuestaSchermata);
		txtrInQuestaSchermata.setEditable(false);
		txtrInQuestaSchermata.setWrapStyleWord(true);
		txtrInQuestaSchermata.setLineWrap(true);
		txtrInQuestaSchermata.setText("In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.In questa schermata si possono impostare i vari parametri della Adaptive Ladder Queue e lanciare appunto un esecuzione.");
		txtrInQuestaSchermata.setCaretPosition(0);
		panel_1.setLayout(gl_panel_1);
		frmAlqMonitor.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frmAlqMonitor.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opzioni");
		menuBar.add(mnNewMenu);
		
		mnNewMenu.add(CommonsPopUp.credits(frmAlqMonitor));
	}
}
