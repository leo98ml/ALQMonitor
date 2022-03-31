package it.unical.dimes.tesi.gui.improvements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import com.sun.jdi.ClassType;
import com.sun.jdi.Field;
import com.sun.jdi.LongValue;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.VMDisconnectedException;
import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.Event;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.request.BreakpointRequest;

import it.unical.dimes.tesi.debug.Breakpoint;
import it.unical.dimes.tesi.debug.DebugConnector;
import it.unical.dimes.tesi.debug.Variabile;
import it.unical.dimes.tesi.gui.TopElementsUI;
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
					QueueUI window = new QueueUI(null);
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
	public QueueUI(JFrame frame) {
		initialize(frame);
	}

	private boolean asDouble = true;
	private boolean paused = false;
	private Breakpoint breakToBeRem = null;
	private JPanel panel_6 = new JPanel();
	private JPanel panel_5 = new JPanel();
	private ObjectReference selectedAlq = null;
	private JComboBox<ObjectReference> comboBox = new JComboBox<ObjectReference>();
	private JPanel panelTop = new JPanel();
	private JPanel panelBottom = new JPanel();
	private JPanel panelLadder = new JPanel();
	private JPanel panelShowBucket = new JPanel();

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize(JFrame f) {
		DebugConnector dc = DebugConnector.getInstance();
		if (f == null) {
			frame = new JFrame();
			frame.setBounds(100, 100, 1200, 522);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
		} else {
			frame = f;
		}
		updateComboBox(dc);
		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_1_1 = new JPanel();

		JLabel labelBreakpoints = new JLabel("Breakpoints:");
		labelBreakpoints.setHorizontalAlignment(SwingConstants.CENTER);
		labelBreakpoints.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1_1.createSequentialGroup().addGap(110)
						.addComponent(labelBreakpoints, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE).addGap(88))
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE));
		gl_panel_1_1.setVerticalGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup().addComponent(labelBreakpoints)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(scrollPane_1)));

		updatePanelBP(dc, frame, scrollPane_1);
		panel_1_1.setLayout(gl_panel_1_1);

		updatePanelBucketSelected(null);

		JPanel panel_4 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
						.addComponent(panelLadder, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
						.addComponent(panelBottom, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelShowBucket, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelTop, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(panelLadder, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGap(7).addComponent(panelBottom, GroupLayout.PREFERRED_SIZE, 104,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 36,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(panelShowBucket, GroupLayout.DEFAULT_SIZE, 100,
														100)))
						.addContainerGap()));

		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.add(comboBox);

		JLabel labelComboCoda = new JLabel(" Selez. coda: ");
		labelComboCoda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_4.add(labelComboCoda, BorderLayout.WEST);

		JLabel labelVariabili = new JLabel("Variabili:");
		labelVariabili.setHorizontalAlignment(SwingConstants.CENTER);
		labelVariabili.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(110)
						.addComponent(labelVariabili, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE).addGap(88))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addComponent(labelVariabili)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)));

		updatePanelVar(dc, f, scrollPane, comboBox);

		panel_1.setLayout(gl_panel_1);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DebugConnector.disconnect();
				new HomeUI(frame);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.setBackground(new Color(70, 130, 180));

		JButton btnBreakpoints = new JButton("BREAKPOINT");
		btnBreakpoints.setForeground(Color.WHITE);
		btnBreakpoints.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBreakpoints.setBackground(Color.GRAY);

		JButton btnPause = new JButton("PAUSE");
		btnPause.setForeground(Color.WHITE);
		btnPause.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnPause.setBackground(new Color(178, 34, 34));
		JButton btnResume = new JButton("RESUME");
		btnPause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!paused) {
					dc.pause();
					paused = true;
					updateComboBox(dc);
					constructTop();
					constructBottom();
					constructLadder();
					btnPause.setEnabled(false);
					btnResume.setEnabled(true);
					updatePanelVar(dc, f, scrollPane, comboBox);
					SwingUtilities.updateComponentTreeUI(frame);
				}
			}
		});

		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (breakToBeRem != null) {
					dc.remove(breakToBeRem);
					breakToBeRem = null;
				}
				paused = false;
				btnResume.setEnabled(false);
				btnPause.setEnabled(true);
				for (Breakpoint bp : dc.getBreakpoints()) {
					bp.setActive(false);
				}
				updateComboBox(dc);
				updatePanelBP(dc, frame, scrollPane_1);
				updatePanelVar(dc, f, scrollPane, comboBox);
				constructTop();
				constructBottom();
				constructLadder();
				SwingUtilities.updateComponentTreeUI(frame);
				dc.resume();
			}
		});
		btnResume.setEnabled(false);
		btnResume.setForeground(Color.WHITE);
		btnResume.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnResume.setBackground(new Color(60, 179, 113));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
						.addComponent(btnPause, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBreakpoints, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
						.addComponent(btnResume, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBreakpoints, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnResume, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
								.addComponent(btnPause, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
						.addContainerGap()));
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Opzioni");
		menuBar.add(mnNewMenu);
		constructTop();
		constructBottom();
		constructLadder();

		btnBreakpoints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!paused) {
					dc.pause();
					paused = true;
					constructTop();
					constructBottom();
					constructLadder();
					btnPause.setEnabled(false);
					btnResume.setEnabled(true);
					SwingUtilities.updateComponentTreeUI(frame);
				}
				JDialog d = new JDialog(frame, "Inserisci breakpoint", true);
				d.setLocationRelativeTo(frame);
				new BreakpointsUI(d);
			}
		});
		Thread t = new Thread(() -> {
			try {
				EventSet eventSet = null;
				while ((eventSet = dc.getRemoteJVM().eventQueue().remove()) != null) {
					for (Event event : eventSet) {
						if (event instanceof BreakpointEvent) {
							BreakpointRequest be = (BreakpointRequest) event.request();
							paused = true;
							btnPause.setEnabled(false);
							btnResume.setEnabled(true);
							Breakpoint b = dc.getBreakpoint(be);
							b.setActive(true);
							boolean resume = false;
							if (b.getANTimes() == 0) {
								b.setActive(true);
								breakToBeRem = b;
							} else {
								if (b.getANTimes() > 0) {
									b.setActive(false);
									b.setANTimes(b.getANTimes() - 1);
									b.setDescr(
											b.getFile() + ":" + b.getLine() + " dopo : " + b.getANTimes() + " volte");
									dc.insertBreakpoint(b);
									paused = false;
									btnPause.setEnabled(true);
									btnResume.setEnabled(false);
									resume = true;
								}
							}
							updatePanelBP(dc, frame, scrollPane_1);
							constructTop();
							constructBottom();
							constructLadder();
							SwingUtilities.updateComponentTreeUI(frame);
							if (resume)
								dc.resume();
						}
					}
				}
			} catch (VMDisconnectedException e) {
				System.out.println("Virtual Machine is disconnected.");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
			}
		});
		t.start();
		mnNewMenu.add(CommonsPopUp.credits(frame));
		JCheckBox timestamp = new JCheckBox("ts as Long");
		menuBar.add(timestamp);
		timestamp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				asDouble = !asDouble;
				constructTop();
				constructBottom();
				constructLadder();
				SwingUtilities.updateComponentTreeUI(frame);
			}
		});
	}

	private void updatePanelBucketSelected(ObjectReference bucket) {
		panelShowBucket.removeAll();

		JLabel labelShownBucket = new JLabel("Bucket selcted:");
		labelShownBucket.setHorizontalAlignment(SwingConstants.CENTER);
		labelShownBucket.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JScrollPane scrollPaneBucket = new JScrollPane();
		GroupLayout gl_panelShowBucket = new GroupLayout(panelShowBucket);
		gl_panelShowBucket.setHorizontalGroup(gl_panelShowBucket.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelShowBucket.createSequentialGroup().addGap(110)
						.addComponent(labelShownBucket, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE).addGap(88))
				.addComponent(scrollPaneBucket, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE));
		gl_panelShowBucket.setVerticalGroup(gl_panelShowBucket.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowBucket.createSequentialGroup().addComponent(labelShownBucket)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(scrollPaneBucket)));
		panelShowBucket.setLayout(gl_panelShowBucket);
		if ((paused) && bucket != null) {
			JPanel panelTimestamp = new JPanel();
			scrollPaneBucket.setViewportView(panelTimestamp);
			List<Variabile> listaTimestampBucketSelected = DebugConnector.getInstance().getBucketElements(bucket);
			List<JPanel> listaTimestampPanel = new ArrayList<JPanel>();
			JPanel previousPanel = null;
			for (int i = 0; i < listaTimestampBucketSelected.size(); i++) {
				JPanel timestampPanel = new JPanel();
				timestampPanel.setBackground(Color.LIGHT_GRAY);
				if (previousPanel != null)
					previousPanel.setLayout(new BorderLayout(0, 0));
				previousPanel = timestampPanel;
				listaTimestampPanel.add(timestampPanel);
			}
			if (previousPanel != null)
				previousPanel.setLayout(new BorderLayout(0, 0));
			GroupLayout gl_panel_1 = new GroupLayout(panelTimestamp);
			ParallelGroup pg = gl_panel_1.createParallelGroup(Alignment.LEADING);
			SequentialGroup sg = gl_panel_1.createSequentialGroup().addContainerGap();
			for (JPanel p : listaTimestampPanel) {
				pg.addComponent(p, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE);
			}
			for (JPanel p : listaTimestampPanel) {
				sg.addComponent(p, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED);
			}
			gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(sg));
			sg.addContainerGap(55, Short.MAX_VALUE);
			gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addGroup(pg).addGap(22)));
			int i = 0;
			for (Variabile v : listaTimestampBucketSelected) {
				if (asDouble) {
					if (!v.getValore().contains("[")) {
						v.setValore("" + Double.longBitsToDouble(Long.parseLong(v.getValore())));
					} else {
						String[] splitted = v.getValore().split("[");
						v.setValore("" + Double.longBitsToDouble(Long.parseLong(splitted[0])) + "[" + splitted[1]);
					}
				}
				JLabel l = new JLabel("ts: " + v.getValore() + ";");
				l.setHorizontalAlignment(SwingConstants.CENTER);
				l.setFont(new Font("Tahoma", Font.PLAIN, 14));
				listaTimestampPanel.get(i).add(l, BorderLayout.CENTER);
				i++;
			}
			panelTimestamp.setLayout(gl_panel_1);
		}
	}

	private void updateComboBox(DebugConnector dc) {
		comboBox.removeAllItems();
		comboBox.setEditable(true);
		for (ObjectReference coda : dc.getALQS()) {
			comboBox.addItem(coda);
		}
		if (dc.getALQS() != null && !dc.getALQS().isEmpty()) {
			comboBox.setSelectedItem(dc.getALQS().get(0));
			if (selectedAlq != null && dc.getALQS().contains(selectedAlq)) {
				comboBox.setSelectedItem(selectedAlq);
			}
			dc.setSelecteQueue((ObjectReference) comboBox.getSelectedItem());
			this.selectedAlq = (ObjectReference) comboBox.getSelectedItem();
		}
	}

	private void updatePanelBP(DebugConnector dc, JFrame frame2, JScrollPane scrollPane_1) {
		panel_6.removeAll();
		scrollPane_1.setViewportView(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));

		for (Breakpoint bp : dc.getBreakpoints()) {
			JPanel panel_7 = new JPanel();
			panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			panel_6.add(panel_7);
			panel_7.setLayout(new BorderLayout(0, 0));

			JButton btnX = new JButton("x");
			btnX.setForeground(Color.WHITE);
			btnX.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnX.setBackground(new Color(139, 0, 0));
			panel_7.add(btnX, BorderLayout.EAST);
			btnX.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dc.remove(bp);
					updatePanelBP(dc, frame2, scrollPane_1);
					SwingUtilities.updateComponentTreeUI(frame);
				}
			});
			JTextPane txtpnCiao_3 = new JTextPane();
			txtpnCiao_3.setText(bp.getDescr());
			txtpnCiao_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
			txtpnCiao_3.setEditable(false);
			txtpnCiao_3.setBackground(bp.isActive() ? new Color(100, 0, 0) : new Color(255, 255, 255));
			panel_7.add(txtpnCiao_3, BorderLayout.CENTER);
		}
	}

	private void updatePanelVar(DebugConnector dc, JFrame frame2, JScrollPane scrollPane_1,
			JComboBox<ObjectReference> comboBox) {
		panel_5.removeAll();
		scrollPane_1.setViewportView(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		dc.pause();
		if (dc.getSelecteQueue()!=null) {
			for (Variabile v : dc.getVariabiliALQ((ObjectReference) comboBox.getSelectedItem())) {
				JLabel l = new JLabel(v.getNome() + ": " + v.getValore() + ";");
				l.setHorizontalAlignment(SwingConstants.CENTER);
				l.setFont(new Font("Tahoma", Font.PLAIN, 17));
				panel_5.add(l);
			}
		}
		dc.resume();
	}

	private void constructTop() {
		panelTop.removeAll();
		panelTop.setBackground(new Color(204, 102, 102));
		JLabel labelTop = new JLabel("TOP");
		labelTop.setHorizontalAlignment(SwingConstants.LEFT);
		labelTop.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelTop.setForeground(Color.WHITE);
		labelTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (paused) {
					JDialog d = new JDialog(frame, "Top Level", true);
					d.setLocationRelativeTo(frame);
					new TopElementsUI(d);
				}
			}
		});
		DebugConnector dc = DebugConnector.getInstance();
		if (!paused || dc.getSelecteQueue() == null) {
			GroupLayout gl_panel_2 = new GroupLayout(panelTop);
			gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(labelTop)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING))
							.addContainerGap(266, Short.MAX_VALUE)));
			gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(labelTop)
							.addContainerGap(73, Short.MAX_VALUE))
					.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup().addGap(19)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			panelTop.setLayout(gl_panel_2);
		} else {
			List<Variabile> listaTimestampTop = dc.getTop(dc.getSelecteQueue());
			JLabel size = new JLabel("Size: " + listaTimestampTop.size());
			size.setHorizontalAlignment(SwingConstants.LEFT);
			size.setForeground(Color.WHITE);
			size.setFont(new Font("Tahoma", Font.BOLD, 14));
			Variabile topStart = null;
			for (Variabile var : dc.getVariabiliALQ(dc.getSelecteQueue())) {
				if (var.getNome().equals("topStart"))
					topStart = var;
			}
			JLabel maxTS = new JLabel(
					"topStart:" + (asDouble ? Double.longBitsToDouble(Long.parseLong(topStart.getValore()))
							: topStart.getValore()));
			maxTS.setHorizontalAlignment(SwingConstants.LEFT);
			maxTS.setForeground(Color.WHITE);
			maxTS.setFont(new Font("Tahoma", Font.BOLD, 14));

			JScrollPane pannelloTimestamp = new JScrollPane();
			pannelloTimestamp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			GroupLayout gl_panel_2 = new GroupLayout(panelTop);
			gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(labelTop)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
									.addComponent(size, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addComponent(maxTS, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
							.addGap(21).addComponent(pannelloTimestamp, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
							.addContainerGap()));
			gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_2
					.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
									.addComponent(pannelloTimestamp, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
							.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(labelTop))
							.addGroup(gl_panel_2.createSequentialGroup().addGap(19)
									.addComponent(size, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(maxTS, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap()));

			JPanel pannelloTimestampDaScrollare = new JPanel();
			pannelloTimestamp.setViewportView(pannelloTimestampDaScrollare);

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
			GroupLayout gl_panel_1 = new GroupLayout(pannelloTimestampDaScrollare);
			ParallelGroup pg = gl_panel_1.createParallelGroup(Alignment.LEADING);
			SequentialGroup sg = gl_panel_1.createSequentialGroup().addContainerGap();
			for (JPanel p : listaTimestampPanel) {
				pg.addComponent(p, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE);
			}
			for (JPanel p : listaTimestampPanel) {
				sg.addComponent(p, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED);
			}
			gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(sg));
			sg.addContainerGap(55, Short.MAX_VALUE);
			gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addGroup(pg).addGap(22)));
			pannelloTimestampDaScrollare.setLayout(gl_panel_1);
			int i = 0;
			for (Variabile v : listaTimestampTop) {
				if (asDouble) {
					if (!v.getValore().contains("[")) {
						v.setValore("" + Double.longBitsToDouble(Long.parseLong(v.getValore())));
					} else {
						String[] splitted = v.getValore().split("[");
						v.setValore("" + Double.longBitsToDouble(Long.parseLong(splitted[0])) + "[" + splitted[1]);
					}
				}
				JLabel l = new JLabel("ts: " + v.getValore() + ";");
				l.setHorizontalAlignment(SwingConstants.CENTER);
				l.setFont(new Font("Tahoma", Font.PLAIN, 14));
				listaTimestampPanel.get(i).add(l, BorderLayout.CENTER);
				i++;
			}
			pannelloTimestampDaScrollare.setLayout(gl_panel_1);
			panelTop.setLayout(gl_panel_2);
		}
	}

	private void constructBottom() {
		panelBottom.removeAll();
		panelBottom.setBackground(new Color(60, 179, 113));

		JLabel labelBottom = new JLabel("BOTTOM");
		labelBottom.setHorizontalAlignment(SwingConstants.LEFT);
		labelBottom.setForeground(Color.WHITE);
		labelBottom.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelBottom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (paused) {
					JDialog d = new JDialog(frame, "Bottom Level", true);
					d.setLocationRelativeTo(frame);
					new BottomsUI(d);
				}
			}
		});
		DebugConnector dc = DebugConnector.getInstance();
		if (!paused || dc.getSelecteQueue() == null) {
			GroupLayout gl_panel_2_1 = new GroupLayout(panelBottom);
			gl_panel_2_1.setHorizontalGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2_1.createSequentialGroup().addContainerGap()
							.addComponent(labelBottom, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(432, Short.MAX_VALUE)));
			gl_panel_2_1.setVerticalGroup(gl_panel_2_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2_1.createSequentialGroup().addContainerGap()
							.addComponent(labelBottom, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(73, Short.MAX_VALUE)));
			panelBottom.setLayout(gl_panel_2_1);
		} else {
			List<Variabile> listaTimestampBottom = dc.getBottom(dc.getSelecteQueue());
			JLabel size = new JLabel("Size: " + listaTimestampBottom.size());
			size.setHorizontalAlignment(SwingConstants.LEFT);
			size.setForeground(Color.WHITE);
			size.setFont(new Font("Tahoma", Font.BOLD, 14));

			JScrollPane pannelloTimestamp = new JScrollPane();
			pannelloTimestamp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			GroupLayout gl_panel_2 = new GroupLayout(panelBottom);
			gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(labelBottom)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false).addComponent(size,
									GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
							.addGap(21).addComponent(pannelloTimestamp, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
							.addContainerGap()));
			gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_2
					.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
									.addComponent(pannelloTimestamp, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
							.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(labelBottom))
							.addGroup(gl_panel_2.createSequentialGroup().addGap(19)
									.addComponent(size, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap()));

			JPanel pannelloTimestampDaScrollare = new JPanel();
			pannelloTimestamp.setViewportView(pannelloTimestampDaScrollare);

			List<JPanel> listaTimestampPanel = new ArrayList<JPanel>();
			JPanel previousPanel = null;
			for (int i = 0; i < listaTimestampBottom.size(); i++) {
				JPanel timestampPanel = new JPanel();
				timestampPanel.setBackground(Color.LIGHT_GRAY);
				if (previousPanel != null)
					previousPanel.setLayout(new BorderLayout(0, 0));
				previousPanel = timestampPanel;
				listaTimestampPanel.add(timestampPanel);
			}
			if (previousPanel != null)
				previousPanel.setLayout(new BorderLayout(0, 0));
			GroupLayout gl_panel_1 = new GroupLayout(pannelloTimestampDaScrollare);
			ParallelGroup pg = gl_panel_1.createParallelGroup(Alignment.LEADING);
			SequentialGroup sg = gl_panel_1.createSequentialGroup().addContainerGap();
			for (JPanel p : listaTimestampPanel) {
				pg.addComponent(p, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE);
			}
			for (JPanel p : listaTimestampPanel) {
				sg.addComponent(p, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED);
			}
			gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(sg));
			sg.addContainerGap(55, Short.MAX_VALUE);
			gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addGroup(pg).addGap(22)));
			pannelloTimestampDaScrollare.setLayout(gl_panel_1);
			int i = 0;
			for (Variabile v : listaTimestampBottom) {
				if (asDouble) {
					if (!v.getValore().contains("[")) {
						v.setValore("" + Double.longBitsToDouble(Long.parseLong(v.getValore())));
					} else {
						String[] splitted = v.getValore().split("[");
						v.setValore("" + Double.longBitsToDouble(Long.parseLong(splitted[0])) + "[" + splitted[1]);
					}
				}
				JLabel l = new JLabel("ts: " + v.getValore() + ";");
				l.setHorizontalAlignment(SwingConstants.CENTER);
				l.setFont(new Font("Tahoma", Font.PLAIN, 14));
				listaTimestampPanel.get(i).add(l, BorderLayout.CENTER);
				i++;
			}
			pannelloTimestampDaScrollare.setLayout(gl_panel_1);
			panelBottom.setLayout(gl_panel_2);
		}
	}

	private void constructLadder() {
		panelLadder.removeAll();
		updatePanelBucketSelected(null);
		panelLadder.setBackground(new Color(255, 160, 122));
		DebugConnector dc = DebugConnector.getInstance();
		JLabel labelLadder = new JLabel("LADDER");
		labelLadder.setHorizontalAlignment(SwingConstants.LEFT);
		labelLadder.setForeground(Color.WHITE);
		labelLadder.setFont(new Font("Tahoma", Font.BOLD, 17));
		if (!paused || dc.getSelecteQueue() == null) {
			GroupLayout gl_panel_3 = new GroupLayout(panelLadder);
			gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_3.createSequentialGroup().addContainerGap().addComponent(
											labelLadder, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_3.createSequentialGroup().addGap(35)
											.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING))))
							.addContainerGap(285, Short.MAX_VALUE)));
			gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_3.createSequentialGroup().addContainerGap()
							.addComponent(labelLadder, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED).addContainerGap(25, Short.MAX_VALUE)));
			panelLadder.setLayout(gl_panel_3);
		} else {
			labelLadder.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (paused) {
						JDialog d = new JDialog(frame, "Ladder Level", true);
						d.setLocationRelativeTo(frame);
						new RungsUI(d);
					}
				}
			});
			List<ObjectReference> listaRungs = dc.getRungs(dc.getSelecteQueue());
			JLabel nRungs = new JLabel("NRungs: " + listaRungs.size());
			nRungs.setHorizontalAlignment(SwingConstants.LEFT);
			nRungs.setForeground(Color.WHITE);
			nRungs.setFont(new Font("Tahoma", Font.BOLD, 14));

			JScrollPane scrollPane_2_1_1 = new JScrollPane();
			scrollPane_2_1_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollPane_2_1_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			GroupLayout gl_panel_3 = new GroupLayout(panelLadder);
			gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_3
					.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_3.createSequentialGroup().addContainerGap().addComponent(labelLadder,
									GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_3.createSequentialGroup().addGap(35)
									.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false).addComponent(
											nRungs, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))))
					.addGap(79).addComponent(scrollPane_2_1_1, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
					.addContainerGap()));
			gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_3
					.createSequentialGroup().addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
							.addComponent(scrollPane_2_1_1, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
							.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(labelLadder, GroupLayout.PREFERRED_SIZE, 21,
											GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(nRungs, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap()));

			JPanel rungContainer = new JPanel();
			scrollPane_2_1_1.setViewportView(rungContainer);

			if (listaRungs.size() > 0) {
				GroupLayout groupingLayoutRungContainer = new GroupLayout(rungContainer);

				ParallelGroup pgGroupingLayoutRungContainer = groupingLayoutRungContainer
						.createParallelGroup(Alignment.LEADING);
				SequentialGroup sgGroupingLayoutRungContainer = groupingLayoutRungContainer.createSequentialGroup()
						.addContainerGap();
				int i = 0;
				for (ObjectReference rung : listaRungs) {
					JPanel primoRung = new JPanel();
					primoRung.setLayout(new BorderLayout(0, 0));

					JPanel nomeRung = new JPanel();
					nomeRung.setBackground(Color.LIGHT_GRAY);
					primoRung.add(nomeRung, BorderLayout.NORTH);

					JLabel labelRung = new JLabel("Rung " + i);

					labelRung.setFont(new Font("Tahoma", Font.PLAIN, 13));
					nomeRung.add(labelRung);

					JPanel baseRung = new JPanel();
					baseRung.setBackground(Color.LIGHT_GRAY);
					primoRung.add(baseRung, BorderLayout.SOUTH);
					baseRung.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					Double d = Double.valueOf(0);
					Long l = Long.valueOf(0);
					Long bucketWidth = Long.valueOf(1);
					for (Field f1 : ((ClassType) rung.referenceType()).allFields()) {
						if (f1.name().equals("rStart")) {
							l = ((LongValue) rung.getValue(f1)).longValue();
							d = Double.longBitsToDouble(l);
						}
						if (f1.name().equals("bucketWidth")) {
							bucketWidth = ((LongValue) rung.getValue(f1)).longValue();
						}
					}
					JLabel rungStart = new JLabel("RungStart: " + (asDouble ? d + "" : l + ""));
					rungStart.setFont(new Font("Tahoma", Font.PLAIN, 13));
					baseRung.add(rungStart);
					i++;
					List<ObjectReference> listaBucket = dc.getBuckets(rung);
					JLabel numBuckets = new JLabel("NumBuckets: " + listaBucket.size());
					numBuckets.setFont(new Font("Tahoma", Font.PLAIN, 13));
					baseRung.add(numBuckets);

					JScrollPane scrollPaneBuckets = new JScrollPane();
					scrollPaneBuckets.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
					primoRung.add(scrollPaneBuckets, BorderLayout.CENTER);

					JPanel bucketsContainer = new JPanel();
					bucketsContainer.setBackground(Color.LIGHT_GRAY);
					scrollPaneBuckets.setViewportView(bucketsContainer);
					if (listaBucket.size() > 0) {
						int j = 0;
						GroupLayout groupingLayoutBucketsContainer = new GroupLayout(bucketsContainer);
						SequentialGroup sqGroupingLayoutBucketsContainer = groupingLayoutBucketsContainer
								.createSequentialGroup().addGap(5);
						ParallelGroup pgGroupingLayoutBucketsContainer = groupingLayoutBucketsContainer
								.createParallelGroup(Alignment.LEADING);
						for (ObjectReference bucket : listaBucket) {
							JPanel panelBucket = new JPanel();
							panelBucket.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									updatePanelBucketSelected(bucket);
								}
							});
							JLabel labelBucket = new JLabel("Bucket " + j);
							labelBucket.setFont(new Font("Tahoma", Font.PLAIN, 13));
							Double dTS = Double.longBitsToDouble(bucketWidth * j + l);
							JLabel labelTS = new JLabel(
									"ts: " + (asDouble ? Double.toString(dTS) : bucketWidth * j + l));
							labelTS.setFont(new Font("Tahoma", Font.PLAIN, 9));
							JLabel labelSize = new JLabel("size: " + dc.getBucketElements(bucket).size());
							labelSize.setFont(new Font("Tahoma", Font.PLAIN, 13));
							GroupLayout groupLayoutPanelBucket = new GroupLayout(panelBucket);
							groupLayoutPanelBucket
									.setHorizontalGroup(groupLayoutPanelBucket.createParallelGroup(Alignment.TRAILING)
											.addGap(0, 71, Short.MAX_VALUE)
											.addGroup(groupLayoutPanelBucket.createSequentialGroup().addGap(2)
													.addComponent(labelBucket, GroupLayout.PREFERRED_SIZE, 120,
															Short.MAX_VALUE)
													.addGap(9))
											.addGroup(groupLayoutPanelBucket.createSequentialGroup().addGap(1)
													.addComponent(labelTS, GroupLayout.PREFERRED_SIZE, 120,
															Short.MAX_VALUE)
													.addContainerGap())
											.addGroup(groupLayoutPanelBucket
													.createSequentialGroup().addComponent(labelSize,
															GroupLayout.PREFERRED_SIZE, 120, Short.MAX_VALUE)
													.addGap(11)));
							groupLayoutPanelBucket.setVerticalGroup(groupLayoutPanelBucket
									.createParallelGroup(Alignment.LEADING).addGap(0, 66, Short.MAX_VALUE)
									.addGroup(groupLayoutPanelBucket
											.createSequentialGroup().addGap(1).addComponent(labelBucket)
											.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelTS)
											.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelSize,
													GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
											.addContainerGap(11, Short.MAX_VALUE)));
							panelBucket.setLayout(groupLayoutPanelBucket);

							sqGroupingLayoutBucketsContainer
									.addPreferredGap(ComponentPlacement.RELATED).addComponent(panelBucket,
											GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED);
							pgGroupingLayoutBucketsContainer.addComponent(panelBucket, GroupLayout.DEFAULT_SIZE, 66,
									Short.MAX_VALUE);
							j++;
						}
						groupingLayoutBucketsContainer.setHorizontalGroup(
								groupingLayoutBucketsContainer.createParallelGroup(Alignment.LEADING).addGroup(
										sqGroupingLayoutBucketsContainer.addContainerGap(73, Short.MAX_VALUE)));
						groupingLayoutBucketsContainer
								.setVerticalGroup(groupingLayoutBucketsContainer.createParallelGroup(Alignment.LEADING)
										.addGroup(groupingLayoutBucketsContainer.createSequentialGroup().addGap(5)
												.addGroup(pgGroupingLayoutBucketsContainer).addContainerGap()));
						bucketsContainer.setLayout(groupingLayoutBucketsContainer);
					}
					pgGroupingLayoutRungContainer.addGroup(groupingLayoutRungContainer.createSequentialGroup()
							.addGap(10).addComponent(primoRung, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
							.addGap(10));
					sgGroupingLayoutRungContainer.addPreferredGap(ComponentPlacement.RELATED).addComponent(primoRung,
							GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE);
				}
				groupingLayoutRungContainer.setHorizontalGroup(pgGroupingLayoutRungContainer);
				groupingLayoutRungContainer.setVerticalGroup(groupingLayoutRungContainer
						.createParallelGroup(Alignment.LEADING).addGroup(sgGroupingLayoutRungContainer.addGap(40)));
				rungContainer.setLayout(groupingLayoutRungContainer);
				panelLadder.setLayout(gl_panel_3);

			}
		}
	}

}
