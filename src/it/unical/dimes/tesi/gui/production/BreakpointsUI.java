package it.unical.dimes.tesi.gui.production;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import com.sun.jdi.AbsentInformationException;

import it.unical.dimes.tesi.debug.Breakpoint;
import it.unical.dimes.tesi.debug.DebugConnector;

public class BreakpointsUI {

	private JFrame frame;
	private JTextField textFieldNVolte;
	private JTextField textFieldPuntoSpecifico;
	private JTextField textFieldPuntoSpecificoDopoNVolte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreakpointsUI window = new BreakpointsUI();
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
	public BreakpointsUI() {
		initialize(null);
	}
	
	public BreakpointsUI(JDialog d) {
		initialize(d);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JDialog d) {
		frame = new JFrame();
		frame.setBounds(100, 100, 763, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DebugConnector dc = DebugConnector.getInstance();
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
		btnNewButton.setBackground(new Color(139, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(btnNewButton, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		
		JPanel timestamp = new JPanel();
		timestamp.setBackground(Color.LIGHT_GRAY);
		
		JPanel timestamp_1 = new JPanel();
		timestamp_1.setBackground(Color.LIGHT_GRAY);
		
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
					.addComponent(timestamp_1_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(85, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Ad invocazione:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		timestamp_1_2.add(lblNewLabel_1_1_1_1, BorderLayout.NORTH);
		
		JComboBox<Breakpoint> comboInvocazione = new JComboBox<>();
		Breakpoint bSmartSpawning = new Breakpoint(251,"it.unical.dimes.elq.ALadderQueue","smart-spawning",-1);
		Breakpoint bSpawning = new Breakpoint(254,"it.unical.dimes.elq.ALadderQueue","spawning",-1);
		Breakpoint bUpgrowing = new Breakpoint(169,"it.unical.dimes.elq.ALadderQueue","upgrowing",-1);
		comboInvocazione.addItem(bSmartSpawning);
		comboInvocazione.addItem(bSpawning);
		comboInvocazione.addItem(bUpgrowing);
		comboInvocazione.setFont(new Font("Tahoma", Font.PLAIN, 14));
		timestamp_1_2.add(comboInvocazione, BorderLayout.CENTER);
		
		JRadioButton rdbtnInvocazione = new JRadioButton("");
		timestamp_1_2.add(rdbtnInvocazione, BorderLayout.WEST);
		
		timestamp_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Punto specifico dopo n volte");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		timestamp_1.add(lblNewLabel_1_1, BorderLayout.NORTH);
		
		textFieldPuntoSpecificoDopoNVolte = new JTextField();
		textFieldPuntoSpecificoDopoNVolte.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldPuntoSpecificoDopoNVolte.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPuntoSpecificoDopoNVolte.setText("nomeClasseCompleto:numeroRiga");
		timestamp_1.add(textFieldPuntoSpecificoDopoNVolte, BorderLayout.CENTER);
		
		textFieldNVolte = new JTextField();
		textFieldNVolte.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldNVolte.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNVolte.setText("1");
		timestamp_1.add(textFieldNVolte, BorderLayout.EAST);
		textFieldNVolte.setColumns(10);
		
		JRadioButton rdbtnDopoNVolte = new JRadioButton("");
		timestamp_1.add(rdbtnDopoNVolte, BorderLayout.WEST);
		timestamp.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Punto specifico");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		timestamp.add(lblNewLabel_1, BorderLayout.NORTH);
		
		textFieldPuntoSpecifico= new JTextField();
		textFieldPuntoSpecifico.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textFieldPuntoSpecifico.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPuntoSpecifico.setText("nomeClasseCompleto:numeroRiga");
		timestamp.add(textFieldPuntoSpecifico, BorderLayout.CENTER);
		
		JRadioButton rdbtnPuntoSpecifico = new JRadioButton("");
		timestamp.add(rdbtnPuntoSpecifico, BorderLayout.WEST);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnDopoNVolte.isSelected()) {
					Breakpoint b = new Breakpoint(Integer.parseInt(textFieldPuntoSpecificoDopoNVolte.getText().split(":")[1]), 
							textFieldPuntoSpecificoDopoNVolte.getText().split(":")[0], textFieldPuntoSpecificoDopoNVolte.getText()+
							" dopo : "+ textFieldNVolte.getText()+" volte", Integer.parseInt(textFieldNVolte.getText()));
					try {
						dc.insertBreakpoint(b);
					} catch (AbsentInformationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(rdbtnPuntoSpecifico.isSelected()) {
					Breakpoint b = new Breakpoint(Integer.parseInt(textFieldPuntoSpecifico.getText().split(":")[1]), 
							textFieldPuntoSpecifico.getText().split(":")[0], textFieldPuntoSpecifico.getText(), -1);
					try {
						dc.insertBreakpoint(b);
					} catch (AbsentInformationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(rdbtnInvocazione.isSelected()) {
					Breakpoint b = (Breakpoint)comboInvocazione.getSelectedItem();
					try {
						dc.insertBreakpoint(b);
					} catch (AbsentInformationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				d.dispose();
			}
		});
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
		if (d!=null) {
			d.setSize(new Dimension(763, 451));
			d.setContentPane(frame.getContentPane());
			d.setVisible(true);
			d.pack();
		}
	}
}
