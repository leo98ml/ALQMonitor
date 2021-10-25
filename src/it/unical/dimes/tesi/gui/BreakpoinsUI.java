package it.unical.dimes.tesi.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class BreakpoinsUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreakpoinsUI window = new BreakpoinsUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BreakpoinsUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 763, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
		);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setColumnHeaderView(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Aggiungi un breakpoint!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(139, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(btnNewButton, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		
		JPanel timestamp = new JPanel();
		timestamp.setBackground(Color.LIGHT_GRAY);
		
		JPanel timestamp_1 = new JPanel();
		timestamp_1.setBackground(Color.LIGHT_GRAY);
		
		JPanel timestamp_1_1 = new JPanel();
		timestamp_1_1.setBackground(Color.LIGHT_GRAY);
		timestamp_1_1.setLayout(new BorderLayout(0, 0));
		
		JPanel timestamp_1_2 = new JPanel();
		timestamp_1_2.setBackground(Color.LIGHT_GRAY);
		timestamp_1_2.setLayout(new BorderLayout(0, 0));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(timestamp, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
								.addComponent(timestamp_1, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE))
							.addGap(22))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(timestamp_1_1, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
							.addGap(22))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(timestamp_1_2, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
							.addGap(22))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(timestamp, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(timestamp_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(timestamp_1_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(timestamp_1_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(85, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ad invocazione:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		timestamp_1_2.add(lblNewLabel_1_1_1_1, BorderLayout.NORTH);
		
		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		timestamp_1_2.add(comboBox_1_2, BorderLayout.CENTER);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		timestamp_1_2.add(rdbtnNewRadioButton, BorderLayout.WEST);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quando var assume valore:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		timestamp_1_1.add(lblNewLabel_1_1_1, BorderLayout.NORTH);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		timestamp_1_1.add(comboBox_1_1, BorderLayout.CENTER);
		
		textField_1 = new JTextField();
		textField_1.setText("1");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_1.setColumns(10);
		timestamp_1_1.add(textField_1, BorderLayout.EAST);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		timestamp_1_1.add(rdbtnNewRadioButton_1, BorderLayout.WEST);
		timestamp_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Punto specifico dopo n volte");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		timestamp_1.add(lblNewLabel_1_1, BorderLayout.NORTH);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		timestamp_1.add(comboBox_1, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("1");
		timestamp_1.add(textField, BorderLayout.EAST);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("");
		timestamp_1.add(rdbtnNewRadioButton_2, BorderLayout.WEST);
		timestamp.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Punto specifico");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		timestamp.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		timestamp.add(comboBox, BorderLayout.CENTER);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("");
		timestamp.add(rdbtnNewRadioButton_3, BorderLayout.WEST);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
	}
}
