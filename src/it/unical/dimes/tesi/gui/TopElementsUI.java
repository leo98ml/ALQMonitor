package it.unical.dimes.tesi.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import it.unical.dimes.tesi.debug.DebugConnector;
import it.unical.dimes.tesi.debug.Variabile;

public class TopElementsUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TopElementsUI window = new TopElementsUI();
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
	public TopElementsUI() {
		initialize(null);
	}

	public TopElementsUI(JDialog d) {
		initialize(d);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JDialog d) {
		frame = new JFrame();
		frame.setBounds(100, 100, 763, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)));
		panel.setLayout(new BorderLayout(0, 0));

		JLabel labelInfoLivTop = new JLabel("Informazioni livello TOP");
		labelInfoLivTop.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelInfoLivTop.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(labelInfoLivTop, BorderLayout.NORTH);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 4, 0, 0));

		DebugConnector dc = DebugConnector.getInstance();
		List<Variabile> listaTimestampTop = dc.getTop(dc.getSelecteQueue());

		JLabel nElementiInTop = new JLabel("nElementiInTop: " + listaTimestampTop.size() + ";");
		nElementiInTop.setHorizontalAlignment(SwingConstants.CENTER);
		nElementiInTop.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_3.add(nElementiInTop);

		JPanel panel_2 = new JPanel();
		scrollPane.setColumnHeaderView(panel_2);

		JLabel labelElementiTop = new JLabel("Elementi in top:");
		labelElementiTop.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2.add(labelElementiTop);

		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);

		List<JPanel> listaTimestampPanel = new ArrayList<JPanel>();
		JPanel previousPanel = null;
		for (int i = 0; i < listaTimestampTop.size(); i++) {
			JPanel timestampPanel = new JPanel();
			timestampPanel.setBackground(Color.LIGHT_GRAY);
			if (previousPanel != null)
				previousPanel.setLayout(new BorderLayout(0, 0));
			previousPanel = timestampPanel;
			listaTimestampPanel.add(timestampPanel);
		}
		if (previousPanel != null)
			previousPanel.setLayout(new BorderLayout(0, 0));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		ParallelGroup pg = gl_panel_1.createParallelGroup(Alignment.LEADING);
		SequentialGroup sg = gl_panel_1.createSequentialGroup().addContainerGap();
		for (JPanel p : listaTimestampPanel) {
			pg.addComponent(p, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
		}
		Collections.reverse(listaTimestampPanel);
		for (JPanel p : listaTimestampPanel) {
			sg.addComponent(p, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED);
		}
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addGroup(pg).addGap(22)));
		sg.addContainerGap(55, Short.MAX_VALUE);
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(sg));
		panel_1.setLayout(gl_panel_1);
		int i = 0;
		for (Variabile v : listaTimestampTop) {
			JLabel l = new JLabel("" + v.getNome() + ": " + v.getValore() + ";");
			l.setHorizontalAlignment(SwingConstants.CENTER);
			l.setFont(new Font("Tahoma", Font.PLAIN, 17));
			listaTimestampPanel.get(i).add(l, BorderLayout.CENTER);
			i++;
		}
		frame.getContentPane().setLayout(groupLayout);
		if (d != null) {
			d.setSize(new Dimension(763, 451));
			d.setContentPane(frame.getContentPane());
			d.setVisible(true);
			d.pack();
		}
	}
}
