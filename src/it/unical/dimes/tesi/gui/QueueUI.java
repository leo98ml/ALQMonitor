package it.unical.dimes.tesi.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import com.sun.jdi.ObjectReference;
import com.sun.jdi.VMDisconnectedException;
import com.sun.jdi.event.BreakpointEvent;
import com.sun.jdi.event.Event;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.request.BreakpointRequest;

import it.unical.dimes.tesi.debug.Breakpoint;
import it.unical.dimes.tesi.debug.DebugConnector;
import it.unical.dimes.tesi.debug.Variabile;
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

	private boolean paused = false;
	private Breakpoint breakToBeRem = null;
	private JPanel panel_6 = new JPanel();
	private JPanel panel_5 = new JPanel();
	private ObjectReference selectedAlq = null;
	private JComboBox<ObjectReference> comboBox = new JComboBox<ObjectReference>();

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame f) {
		DebugConnector dc = DebugConnector.getInstance();
		if (f == null) {
			frame = new JFrame();
			frame.setBounds(100, 100, 966, 522);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
		} else {
			frame = f;
		}
		updateComboBox(dc);
		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(204, 102, 102));

		JPanel panelLadder = new JPanel();
		panelLadder.setBackground(new Color(255, 160, 122));

		JPanel panelBottom = new JPanel();
		panelBottom.setBackground(new Color(60, 179, 113));

		JPanel panel_1_1 = new JPanel();

		JLabel labelBreakpoints = new JLabel("Breakpoints:");
		labelBreakpoints.setHorizontalAlignment(SwingConstants.CENTER);
		labelBreakpoints.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1_1.createSequentialGroup().addGap(110)
						.addComponent(labelBreakpoints, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE).addGap(88))
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE));
		gl_panel_1_1.setVerticalGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup().addComponent(labelBreakpoints)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(scrollPane_1)));

		updatePanelBP(dc, frame, scrollPane_1);
		panel_1_1.setLayout(gl_panel_1_1);

		JPanel panel_4 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelTop, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
						.addComponent(panelLadder, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
						.addComponent(panelBottom, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelTop, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
								.addComponent(
										panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout
										.createSequentialGroup()
										.addComponent(panelLadder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGap(7).addComponent(panelBottom, GroupLayout.PREFERRED_SIZE, 104,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 36,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
						.addContainerGap()));

		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.add(comboBox);

		JLabel labelComboCoda = new JLabel(" Selez. coda: ");
		labelComboCoda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_4.add(labelComboCoda, BorderLayout.WEST);

		JLabel labelBottom = new JLabel("BOTTOM");
		labelBottom.setHorizontalAlignment(SwingConstants.LEFT);
		labelBottom.setForeground(Color.WHITE);
		labelBottom.setFont(new Font("Tahoma", Font.BOLD, 17));
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

		JLabel labelLadder = new JLabel("LADDER");
		labelLadder.setHorizontalAlignment(SwingConstants.LEFT);
		labelLadder.setForeground(Color.WHITE);
		labelLadder.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_panel_3 = new GroupLayout(panelLadder);
		gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup().addContainerGap().addComponent(labelLadder,
										GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_3.createSequentialGroup().addGap(35)
										.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING))))
						.addContainerGap(285, Short.MAX_VALUE)));
		gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup().addContainerGap()
						.addComponent(labelLadder, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED).addContainerGap(25, Short.MAX_VALUE)));
		panelLadder.setLayout(gl_panel_3);
		JLabel labelTop = new JLabel("TOP");
		labelTop.setHorizontalAlignment(SwingConstants.LEFT);
		labelTop.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelTop.setForeground(Color.WHITE);

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

		JLabel labelVariabili = new JLabel("Variabili:");
		labelVariabili.setHorizontalAlignment(SwingConstants.CENTER);
		labelVariabili.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup().addGap(110)
						.addComponent(labelVariabili, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE).addGap(88))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE));
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
					btnPause.setEnabled(false);
					btnResume.setEnabled(true);
					updateComboBox(dc);
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
						.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addComponent(btnPause, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBreakpoints, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
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
		panelBottom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!paused) {
					dc.pause();
					paused = true;
					btnPause.setEnabled(false);
					btnResume.setEnabled(true);
					updateComboBox(dc);
					updatePanelVar(dc, f, scrollPane, comboBox);
					SwingUtilities.updateComponentTreeUI(frame);
				}
				JDialog d = new JDialog(frame, "Bottom Level", true);
				d.setLocationRelativeTo(frame);
				new BottomsUI(d);

			}
		});
		panelLadder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!paused) {
					dc.pause();
					paused = true;
					btnPause.setEnabled(false);
					btnResume.setEnabled(true);
					updateComboBox(dc);
					updatePanelVar(dc, f, scrollPane, comboBox);
					SwingUtilities.updateComponentTreeUI(frame);
				}
				JDialog d = new JDialog(frame, "Ladder Level", true);
				d.setLocationRelativeTo(frame);
				new RungsUI(d);

			}
		});
		panelTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!paused) {
					dc.pause();
					paused = true;
					btnPause.setEnabled(false);
					btnResume.setEnabled(true);
					updateComboBox(dc);
					updatePanelVar(dc, f, scrollPane, comboBox);
					SwingUtilities.updateComponentTreeUI(frame);
				}
				JDialog d = new JDialog(frame, "Top Level", true);
				d.setLocationRelativeTo(frame);
				new TopElementsUI(d);

			}
		});
		btnBreakpoints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!paused) {
					dc.pause();
					paused = true;
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
		for (Variabile v : dc.getVariabiliALQ((ObjectReference) comboBox.getSelectedItem())) {
			JLabel l = new JLabel(v.getNome() + ": " + v.getValore() + ";");
			l.setHorizontalAlignment(SwingConstants.CENTER);
			l.setFont(new Font("Tahoma", Font.PLAIN, 17));
			panel_5.add(l);
		}
		dc.resume();
	}
}
