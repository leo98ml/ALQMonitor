package it.unical.dimes.tesi.gui.backupPlan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import it.unical.dimes.tesi.gui.utils.CommonsPopUp;

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
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(110)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(88))
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1))
		);
		
		JPanel panel_6 = new JPanel();
		scrollPane_1.setViewportView(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_6.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JButton btnX = new JButton("x");
		btnX.setForeground(Color.WHITE);
		btnX.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnX.setBackground(new Color(139, 0, 0));
		panel_7.add(btnX, BorderLayout.EAST);
		
		JTextArea txtrCiao = new JTextArea();
		txtrCiao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtrCiao.setText("ciao");
		txtrCiao.setRows(1);
		txtrCiao.setEditable(false);
		panel_7.add(txtrCiao, BorderLayout.CENTER);
		
		JPanel panel_7_2 = new JPanel();
		panel_7_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_6.add(panel_7_2);
		panel_7_2.setLayout(new BorderLayout(0, 0));
		
		JButton btnX_2 = new JButton("x");
		btnX_2.setForeground(Color.WHITE);
		btnX_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnX_2.setBackground(new Color(139, 0, 0));
		panel_7_2.add(btnX_2, BorderLayout.EAST);
		
		JTextArea txtrCiao_1 = new JTextArea();
		txtrCiao_1.setLineWrap(true);
		txtrCiao_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtrCiao_1.setText("ciao");
		txtrCiao_1.setRows(1);
		txtrCiao_1.setEditable(false);
		panel_7_2.add(txtrCiao_1, BorderLayout.CENTER);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_6.add(panel_7_1);
		panel_7_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnX_1 = new JButton("x");
		btnX_1.setForeground(Color.WHITE);
		btnX_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnX_1.setBackground(new Color(139, 0, 0));
		panel_7_1.add(btnX_1, BorderLayout.EAST);
		
		JTextArea txtrCiao_2 = new JTextArea();
		txtrCiao_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtrCiao_2.setText("ciao");
		txtrCiao_2.setRows(1);
		txtrCiao_2.setEditable(false);
		panel_7_1.add(txtrCiao_2, BorderLayout.CENTER);
		
		JPanel panel_7_3 = new JPanel();
		panel_7_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_6.add(panel_7_3);
		panel_7_3.setLayout(new BorderLayout(0, 0));
		
		JButton btnX_1_1 = new JButton("x");
		btnX_1_1.setForeground(Color.WHITE);
		btnX_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnX_1_1.setBackground(new Color(139, 0, 0));
		panel_7_3.add(btnX_1_1, BorderLayout.EAST);
		
		JTextArea txtrCiao_2_1 = new JTextArea();
		txtrCiao_2_1.setText("ciao");
		txtrCiao_2_1.setRows(1);
		txtrCiao_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtrCiao_2_1.setEditable(false);
		panel_7_3.add(txtrCiao_2_1, BorderLayout.CENTER);
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
						.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(7)
							.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.add(comboBox);
		
		JLabel lblNewLabel_3_1 = new JLabel(" Selez. coda: ");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_4.add(lblNewLabel_3_1, BorderLayout.WEST);
		
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
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(110)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(88))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
		);
		
		JPanel panel_5 = new JPanel();
		scrollPane.setViewportView(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_5.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_5.add(lblNewLabel_1_1_3_1);
		
		JLabel lblNewLabel_1_1_3_1_1 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_5.add(lblNewLabel_1_1_3_1_1);
		
		JLabel lblNewLabel_1_1_3_2 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_5.add(lblNewLabel_1_1_3_2);
		
		JLabel lblNewLabel_1_1_3_1_3 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_5.add(lblNewLabel_1_1_3_1_3);
		
		JLabel lblNewLabel_1_1_3_1_1_1 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_5.add(lblNewLabel_1_1_3_1_1_1);
		
		JLabel lblNewLabel_1_1_3_1_2_1 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_5.add(lblNewLabel_1_1_3_1_2_1);
		
		JLabel lblNewLabel_1_1_3_1_1_2 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_5.add(lblNewLabel_1_1_3_1_1_2);
		
		JLabel lblNewLabel_1_1_3_2_1 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_5.add(lblNewLabel_1_1_3_2_1);
		
		JLabel lblNewLabel_1_1_3_1_2_1_1 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_5.add(lblNewLabel_1_1_3_1_2_1_1);
		
		JLabel lblNewLabel_1_1_3_1_2 = new JLabel("Variabile: valore;");
		lblNewLabel_1_1_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_5.add(lblNewLabel_1_1_3_1_2);
		panel_1.setLayout(gl_panel_1);

		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.setBackground(new Color(70, 130, 180));

		JButton btnReset = new JButton("BREAKPOINT");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BreakpointsUI.main(null);
			}
		});
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
