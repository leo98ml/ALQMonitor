package it.unical.dimes.tesi.gui.production;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import com.sun.jdi.ObjectReference;

import it.unical.dimes.tesi.debug.DebugConnector;

public class RungUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RungUI window = new RungUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private ObjectReference rung;

	/**
	 * Create the application.
	 */
	public RungUI() {
		initialize(null);
	}

	public RungUI(JDialog d, ObjectReference rung) {
		this.rung = rung;
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
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(scrollPane,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)));

		JPanel panel_2 = new JPanel();
		scrollPane.setColumnHeaderView(panel_2);

		JLabel labelBuckets = new JLabel("Buckets:");
		labelBuckets.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2.add(labelBuckets);

		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);

		List<ObjectReference> listaBucket = dc.getBuckets(this.rung);
		List<JPanel> listaBucketsPanel = new ArrayList<JPanel>();
		JPanel previousPanel = null;
		for (ObjectReference v : listaBucket) {
			JPanel bucketPanel = new JPanel();
			bucketPanel.setBackground(Color.LIGHT_GRAY);
			if (previousPanel != null)
				previousPanel.setLayout(new BorderLayout(0, 0));
			previousPanel = bucketPanel;
			listaBucketsPanel.add(bucketPanel);
			bucketPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					JDialog d = new JDialog(frame, "Bucket", true);
					d.setLocationRelativeTo(frame);
					new BucketUI(d, v);

				}
			});
		}

		scrollPane.setViewportView(panel_1);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		ParallelGroup pg = gl_panel_1.createParallelGroup(Alignment.LEADING);
		SequentialGroup sg = gl_panel_1.createSequentialGroup().addContainerGap();
		for (JPanel p : listaBucketsPanel) {
			pg.addComponent(p, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
		}
		Collections.reverse(listaBucketsPanel);
		for (JPanel p : listaBucketsPanel) {
			sg.addComponent(p, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED);
		}
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addGroup(pg).addGap(22)));
		sg.addContainerGap(55, Short.MAX_VALUE);
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(sg));
		panel_1.setLayout(gl_panel_1);

		for (int i=0;i<listaBucket.size();++i) {
			JLabel rung = new JLabel("Bucket " + i);
			rung.setHorizontalAlignment(SwingConstants.CENTER);
			rung.setFont(new Font("Tahoma", Font.BOLD, 17));
			listaBucketsPanel.get(i).add(rung);
		}

		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
		if (d != null) {
			d.setSize(new Dimension(763, 451));
			d.setContentPane(frame.getContentPane());
			d.setVisible(true);
			d.pack();
		}
	}

}
