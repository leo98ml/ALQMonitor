package it.unical.dimes.tesi.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.LayoutStyle.ComponentPlacement;

import it.unical.dimes.tesi.gui.utils.CommonsPopUp;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JComboBox;

public class QueueUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueueUI window = new QueueUI();
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
	public QueueUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 966, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);

		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 102, 102));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 160, 122));

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(60, 179, 113));

		JPanel panel_1_1 = new JPanel();

		JLabel lblNewLabel_1 = new JLabel("Breakpoints:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1
				.setHorizontalGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING).addGap(0, 393, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel_1_1.createSequentialGroup().addGap(110)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE).addGap(88))
						.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 393,
								GroupLayout.PREFERRED_SIZE));
		gl_panel_1_1
				.setVerticalGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING).addGap(0, 168, Short.MAX_VALUE)
						.addGroup(gl_panel_1_1.createSequentialGroup().addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)));
		panel_1_1.setLayout(gl_panel_1_1);
		
		JPanel panel_4 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
						.addComponent(panel_2_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
						.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(7)
							.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		
		JLabel lblNewLabel_3 = new JLabel("Code:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addGap(44)
					.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(comboBox, 0, 275, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addContainerGap(10, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		JLabel lblNewLabel_2_2 = new JLabel("BOTTOM");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
		gl_panel_2_1.setHorizontalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(432, Short.MAX_VALUE))
		);
		gl_panel_2_1.setVerticalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(73, Short.MAX_VALUE))
		);
		panel_2_1.setLayout(gl_panel_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("LADDER");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("N. rungs:");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Avg N. Buckets x Rung:");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Avg N. Items x Buck.:");
		lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("N. Items:");
		lblNewLabel_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("N. Empty rungs:");
		lblNewLabel_2_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1 = new JLabel("N. Empty");
		lblNewLabel_2_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1_1_1_1_1_1)
								.addComponent(lblNewLabel_2_1_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(285, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1_1_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("TOP");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("NTop:");
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("MinTS:");
		lblNewLabel_2_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblNewLabel_2_1_1_1_1_2 = new JLabel("MaxTS:");
		lblNewLabel_2_1_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_1_1_2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_1_1_2, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(266, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2)
					.addContainerGap(73, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_2_1_1_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(lblNewLabel_2_1_1_1_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(lblNewLabel_2_1_1_1_1_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);

		JLabel lblNewLabel = new JLabel("Variabili:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup().addGap(110)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE).addGap(88))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 393,
								GroupLayout.PREFERRED_SIZE));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)));
		panel_1.setLayout(gl_panel_1);

		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.setBackground(new Color(70, 130, 180));

		JButton btnReset = new JButton("BREAKPOINT");
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnReset.setBackground(Color.GRAY);

		JButton btnEnqueue = new JButton("PAUSE");
		btnEnqueue.setForeground(Color.WHITE);
		btnEnqueue.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEnqueue.setBackground(new Color(178, 34, 34));

		JButton btnDequeue = new JButton("RESUME");
		btnDequeue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDequeue.setForeground(Color.WHITE);
		btnDequeue.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDequeue.setBackground(new Color(60, 179, 113));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(btnEnqueue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(btnDequeue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnDequeue, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
								.addComponent(btnEnqueue, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
						.addContainerGap()));
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Opzioni");
		menuBar.add(mnNewMenu);
		
		mnNewMenu.add(CommonsPopUp.credits(frame));
	}
}
