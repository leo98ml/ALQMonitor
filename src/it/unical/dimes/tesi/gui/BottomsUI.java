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

public class BottomsUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BottomsUI window = new BottomsUI();
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
	public BottomsUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 763, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
		);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Informazioni livello BOTTOM:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1_1_3_1);
		
		JLabel lblNewLabel_1_1_3_1_1 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1_1_3_1_1);
		
		JLabel lblNewLabel_1_1_3_2 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1_1_3_2);
		
		JLabel lblNewLabel_1_1_3_1_3 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1_1_3_1_3);
		
		JLabel lblNewLabel_1_1_3_1_1_1 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1_1_3_1_1_1);
		
		JLabel lblNewLabel_1_1_3_1_2_1 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1_1_3_1_2_1);
		
		JLabel lblNewLabel_1_1_3_1_1_2 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1_1_3_1_1_2);
		
		JLabel lblNewLabel_1_1_3_2_1 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1_1_3_2_1);
		
		JLabel lblNewLabel_1_1_3_1_2_1_1 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1_1_3_1_2_1_1);
		
		JLabel lblNewLabel_1_1_3_1_2 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_3.add(lblNewLabel_1_1_3_1_2);
		
		JPanel panel_2 = new JPanel();
		scrollPane.setColumnHeaderView(panel_2);
		
		JLabel lblNewLabel = new JLabel("Elementi in bottom:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		
		JPanel timestamp_2 = new JPanel();
		timestamp_2.setBackground(Color.LIGHT_GRAY);
		
		JPanel timestamp = new JPanel();
		timestamp.setBackground(Color.LIGHT_GRAY);
		
		JPanel timestamp_1 = new JPanel();
		timestamp_1.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(timestamp_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(timestamp_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(timestamp, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(22))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(timestamp, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(timestamp_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(timestamp_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		timestamp_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Timestamp: 102101202");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		timestamp_2.add(lblNewLabel_1_1_2, BorderLayout.CENTER);
		timestamp_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Timestamp: 102101202");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		timestamp_1.add(lblNewLabel_1_1_1, BorderLayout.CENTER);
		timestamp.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Timestamp: 102101202");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		timestamp.add(lblNewLabel_1_1, BorderLayout.CENTER);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
	}

}
