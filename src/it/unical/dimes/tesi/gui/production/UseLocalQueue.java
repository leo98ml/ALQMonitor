package it.unical.dimes.tesi.gui.production;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.apache.commons.math3.distribution.UniformIntegerDistribution;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import dataset.Action;
import dataset.Get;
import dataset.Put;
import it.unical.dimes.elq.ALadderQueue;
import it.unical.dimes.elq.AtomicEvent;
import it.unical.dimes.elq.Event;
import random.Camel;
import random.Exponential;
import random.Pareto;
import random.RandomVariable;
import random.SpecBimodal;
import random.SpecChange;

public class UseLocalQueue {

	private JFrame frame;
	private JTextField sleepTime;
	private JTextField scrap;
	private JTextField totExecution;
	private JTextField textValuesToBeInsert;
	private JTextField textNumValoriRandom;
	private JTextField textNumValoriRem;
	private JTextField tztSizeInit;
	private JTextField textHowManyTimesInsert;
	private JTextField boundConcurrentEvent;

	// var alq
	// coda su cui fare le varie operazioni
	private ALadderQueue ladder = null;
	private boolean ladderLock = true;
	private int qsize;
	private int accesses = 1_000_000;
	private int TOT = 50;
	private int SCRAP = 10;
	private long SLEEP = 500;
	private double meanincr = 0.0;
	private int distributions;
	private int c = 100;
	private boolean grouping = false, smartSpawning = false, upGrowing = false;
	private long ultimoValoreEstratto = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UseLocalQueue window = new UseLocalQueue();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public UseLocalQueue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1042, 516);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);

		JLabel lblNewLabel = new JLabel("OPERAZIONI SU CODA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));

		JLabel lblLastRemoveddouble = new JLabel("last rem (double):");
		lblLastRemoveddouble.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastRemoveddouble.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblLastRemovedlong = new JLabel("last rem (long):");
		lblLastRemovedlong.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastRemovedlong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(lblLastRemovedlong, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
						.addGap(11).addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblLastRemoveddouble, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
						.addGap(224)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(5)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel)
						.addComponent(lblLastRemoveddouble, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLastRemovedlong, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.LIGHT_GRAY);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.LIGHT_GRAY);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.LIGHT_GRAY);

		JPanel panel_7_1 = new JPanel();
		panel_7_1.setBackground(Color.LIGHT_GRAY);
		panel_7_1.setLayout(
				new FormLayout(new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, },
						new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 946,
												Short.MAX_VALUE)
										.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 946,
												Short.MAX_VALUE)
										.addComponent(panel_2_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 954,
												Short.MAX_VALUE))
								.addGap(26))
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE).addGap(26))
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE).addGap(25))
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE).addGap(25))
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(panel_7_1, GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE).addGap(25)))));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_7_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(199, Short.MAX_VALUE)));

		JButton btnKill = new JButton("KILL");
		btnKill.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnKill.setBackground(Color.GRAY);
		panel_7_1.add(btnKill, "2, 2");
		panel_7.setLayout(new FormLayout(new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnReset.setBackground(Color.GRAY);
		panel_7.add(btnReset, "2, 2");
		panel_6.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, }));

		JButton btnInitialize = new JButton("INITIALIZE");
		btnInitialize.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnInitialize.setBackground(Color.GRAY);
		panel_6.add(btnInitialize, "2, 2");

		JLabel lblNewLabel_2_1_1 = new JLabel("Distribuzione:");
		panel_6.add(lblNewLabel_2_1_1, "2, 4, right, default");

		JComboBox<String> comboDistrInitialize = new JComboBox<>();
		comboDistrInitialize.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Esponenziale(1)", "Esponenziale(1/3000)", "Pareto(1,1)", "Pareto(1,1.5)",
						"Pareto(1,700)", "Change", "Camel(0,1000,2,0.001,0.999)", "Bimodal" }));
		panel_6.add(comboDistrInitialize, "4, 4, 2, 1, fill, default");

		JLabel lblNewLabel_3_1_1 = new JLabel("Taglia Coda:");
		panel_6.add(lblNewLabel_3_1_1, "14, 4, right, default");

		tztSizeInit = new JTextField();
		tztSizeInit.setColumns(10);
		panel_6.add(tztSizeInit, "16, 4, 9, 1, fill, default");
		panel_5.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JButton btnRemove = new JButton("REMOVE");
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRemove.setBackground(Color.GRAY);
		panel_5.add(btnRemove, "2, 2");

		JLabel lblNewLabel_3_2 = new JLabel("Numero Valori:");
		panel_5.add(lblNewLabel_3_2, "6, 2, right, default");

		textNumValoriRem = new JTextField();
		panel_5.add(textNumValoriRem, "8, 2, fill, default");
		textNumValoriRem.setColumns(10);
		panel_3.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, }));

		JButton btnRandom = new JButton("RANDOM");
		btnRandom.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRandom.setBackground(Color.GRAY);
		panel_3.add(btnRandom, "2, 2");

		JLabel lblNewLabel_1_1_2_1 = new JLabel("bound concurrent event:");
		panel_3.add(lblNewLabel_1_1_2_1, "16, 2, right, default");

		boundConcurrentEvent = new JTextField();
		boundConcurrentEvent.setText("200");
		boundConcurrentEvent.setColumns(10);
		panel_3.add(boundConcurrentEvent, "18, 2, fill, default");

		JLabel lblNewLabel_2 = new JLabel("Distribuzione:");
		panel_3.add(lblNewLabel_2, "2, 4, right, default");

		JComboBox<String> comboDistribuzioneRandom = new JComboBox<>();
		comboDistribuzioneRandom.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Esponenziale(1)", "Esponenziale(1/3000)", "Pareto(1,1)", "Pareto(1,1.5)",
						"Pareto(1,700)", "Change", "Camel(0,1000,2,0.001,0.999)", "Bimodal" }));
		panel_3.add(comboDistribuzioneRandom, "4, 4, 4, 1, fill, default");

		JLabel lblNewLabel_3 = new JLabel("Numero Valori:");
		panel_3.add(lblNewLabel_3, "16, 4, right, default");

		textNumValoriRandom = new JTextField();
		panel_3.add(textNumValoriRandom, "18, 4, fill, default");
		textNumValoriRandom.setColumns(10);
		panel_2_1.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("126px"),
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("500px"), FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.DEFAULT_COLSPEC, },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("29px"), FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("19px"), }));

		JButton btnInsert = new JButton("INSERT");
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnInsert.setBackground(Color.GRAY);
		panel_2_1.add(btnInsert, "2, 2, fill, top");

		JRadioButton rdbtnAsLong = new JRadioButton("as long");
		panel_2_1.add(rdbtnAsLong, "4, 2, left, center");

		JLabel lblNewLabel_1 = new JLabel("Values (separed by space):");
		panel_2_1.add(lblNewLabel_1, "2, 4, right, center");

		textValuesToBeInsert = new JTextField();
		panel_2_1.add(textValuesToBeInsert, "4, 4, fill, top");
		textValuesToBeInsert.setColumns(10);

		JLabel lblNewLabel_1_1_2 = new JLabel("how many times");
		panel_2_1.add(lblNewLabel_1_1_2, "6, 4, right, default");

		textHowManyTimesInsert = new JTextField();
		textHowManyTimesInsert.setText("1");
		textHowManyTimesInsert.setColumns(10);
		panel_2_1.add(textHowManyTimesInsert, "8, 4, fill, default");
		panel_2.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC,
						FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("default:grow"),
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, }));

		JButton btnNewButton = new JButton("NEW");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2.add(btnNewButton, "2, 2");

		JRadioButton rdbtnGrouping = new JRadioButton("grouping");
		rdbtnGrouping.setSelected(true);
		panel_2.add(rdbtnGrouping, "4, 2");

		JRadioButton rdbtnSmartSpawning = new JRadioButton("smart spawning");
		rdbtnSmartSpawning.setSelected(true);
		panel_2.add(rdbtnSmartSpawning, "8, 2");

		JRadioButton rdbtnUpGrowing = new JRadioButton("up growing");
		rdbtnUpGrowing.setSelected(true);
		panel_2.add(rdbtnUpGrowing, "12, 2");

		JLabel sleepTimeLabel = new JLabel("Sleep time:");
		panel_2.add(sleepTimeLabel, "2, 4, right, default");

		sleepTime = new JTextField("0");
		panel_2.add(sleepTime, "4, 4, fill, default");
		sleepTime.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Scrap:");
		panel_2.add(lblNewLabel_1_1, "6, 4, right, default");

		scrap = new JTextField("10");
		scrap.setColumns(10);
		panel_2.add(scrap, "8, 4, fill, default");

		JLabel lblNewLabel_1_1_1 = new JLabel("Tot:");
		panel_2.add(lblNewLabel_1_1_1, "10, 4, right, default");

		totExecution = new JTextField("50");
		totExecution.setColumns(10);
		panel_2.add(totExecution, "12, 4, fill, default");
		panel_1.setLayout(gl_panel_1);

		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getLadder() == null)
					;// System.out.println("Prima devi creare una coda col comando new!!!");
				else {
					int howManyTimes = Integer.parseInt(textHowManyTimesInsert.getText());
					String[] values = textValuesToBeInsert.getText().split(" ");
					for (int i = 0; i < values.length; i++) {
						long valore;
						if (rdbtnAsLong.isSelected())
							valore = Long.parseLong(values[i]);
						else
							valore = Double.doubleToLongBits(Double.parseDouble(values[i]));
						if (valore >= ultimoValoreEstratto) {
							if (ladderLock) {
								ladderLock = false;
								for (int j = 0; j < howManyTimes; j++) {
									getLadder().enqueue(new AtomicEvent(valore));
								}
								ladderLock = true;
							}
						}
					}
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (ladderLock) {
					ladderLock = false;
					grouping = rdbtnGrouping.isSelected();
					upGrowing = rdbtnUpGrowing.isSelected();
					smartSpawning = rdbtnSmartSpawning.isSelected();
					SLEEP = Integer.parseInt(sleepTime.getText());
					SCRAP = Integer.parseInt(scrap.getText());
					TOT = Integer.parseInt(totExecution.getText());
					setLadder(new ALadderQueue(grouping, upGrowing, smartSpawning));
					ladderLock = true;
				}
			}
		});
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getLadder() == null)
					;// System.out.println("Prima devi creare una coda col comando new!!!");
				else {
					int boundMax = Integer.parseInt(boundConcurrentEvent.getText());
					int numVal = Integer.parseInt(textNumValoriRandom.getText());
					int distribution = comboDistribuzioneRandom.getSelectedIndex();
					LinkedList<AtomicEvent> l = generateRandom(numVal, distribution + 1, boundMax);
					if (ladderLock) {
						ladderLock = false;
						for (AtomicEvent evt : l) {
							getLadder().enqueue(evt);
						}
						ladderLock = true;
					}
				}
			}
		});

		btnInitialize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getLadder() == null)
					;// System.out.println("Prima devi creare una coda col comando new!!!");
				else {
					if (ladderLock) {
						ladderLock = false;
						qsize = Integer.parseInt(tztSizeInit.getText());
						distributions = comboDistrInitialize.getSelectedIndex();
						LinkedList<Action> list = generate_random();
						for (int i = 0; i < SCRAP; i++) {
							System.gc();
							try {
								Thread.sleep(SLEEP);
							} catch (InterruptedException ex) {
								ex.printStackTrace();
							}
							fullTestALQ(list, getLadder());
						}
						ladderLock = true;
					}
				}
			}
		});

		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ladderLock) {
					ladderLock = false;
					setLadder(new ALadderQueue(grouping, upGrowing, smartSpawning));
					meanincr = 0;
					ladderLock = true;
				}
			}
		});
		btnKill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnRemove.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt(textNumValoriRem.getText());
				if (getLadder() == null)
					;
//					System.out.println("Prima devi creare una coda col comando new!!!");
				else if (ladderLock) {
					ladderLock = false;
					if (getLadder().size() >= n) {

						for (int i = 0; i < n; i++) {
							ultimoValoreEstratto = getLadder().dequeue().getTimeStamp();
//							System.out.println(Double.longBitsToDouble(ultimoValoreEstratto));
						}
						lblLastRemoveddouble
								.setText("last rem (double):" + Double.longBitsToDouble(ultimoValoreEstratto));
						lblLastRemovedlong.setText("last rem (long):" + ultimoValoreEstratto);
						SwingUtilities.updateComponentTreeUI(frame);
						
					}
					ladderLock = true;
				}
			}
		});
	}

	public ALadderQueue getLadder() {
		return ladder;
	}

	public void setLadder(ALadderQueue a) {
		ladder = a;
	}

	private LinkedList<AtomicEvent> generateRandom(int queueSize, int distribution, int meanContemp) {
		LinkedList<AtomicEvent> list = new LinkedList<>();
		PriorityQueue<Long> putList = new PriorityQueue<>();
		final double factor = 1.0;
		RandomVariable r = null;
		switch (distribution) {
		case 1:
			r = new Exponential(1.0);
			break;
		case 2:
			r = new Exponential(1.0 / 3000.0);
			break;
		case 3:
			r = new Pareto(1, 1);
			break;
		case 4:
			r = new Pareto(1, 1.5);
			break;
		case 5:
			r = new Pareto(1, 700);
			break;
		case 6:
			r = new SpecChange();
			break;
		case 7:
			r = new Camel(0, 1000, 2, 0.001, 0.999);
			break;
		case 8:
			r = new SpecBimodal();
			break;
		}
		UniformIntegerDistribution ud = new UniformIntegerDistribution(0, 2 * meanContemp - 1);
		int bound;
		double ts = Double.longBitsToDouble(ultimoValoreEstratto);
		int j = 0;
		int incrCount = 0;
		double meanIncr = 0;
		while (j < queueSize) {
			bound = ud.sample();
			double sd = factor * r.sample();
			double d = sd - meanIncr;
			meanIncr = meanIncr + d / (incrCount + 1);
			incrCount++;
			for (int i = 0; i < bound && j < queueSize; i++, j++) {
				long lRepr = Double.doubleToLongBits(ts + sd);
				list.add(new AtomicEvent(lRepr));
				putList.add(lRepr);
			}
			ts += meanIncr;
		}
		return list;
	}

	private long fullTestALQ(LinkedList<Action> list, ALadderQueue ladder) {
		ListIterator<Action> li = list.listIterator();

		Action x = null;
		boolean si = false;
		Event e = null;
		for (int j = 0; j < qsize; j++) {
			x = li.next();
			ladder.enqueue(new AtomicEvent(x.getTs()));
		}
		x = li.next();
		if (!(x instanceof Get))
			throw new RuntimeException();

		e = ladder.dequeue();

		System.gc();
		try {
			Thread.sleep(SLEEP);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		long time = System.nanoTime();
		while (li.hasNext()) {
			x = li.next();

			if (x instanceof Put) {
				ladder.enqueue(new AtomicEvent(x.getTs()));
			} else if (x instanceof Get) {
				e = ladder.dequeue();
				if (e.getTimeStamp() != x.getTs()) {
					si = true;
					break;
				}
			}
		}

		if (si) {
			throw new RuntimeException("");
		}

		time = System.nanoTime() - time;

		return time;
	}

	private LinkedList<Action> generate_random() {
		LinkedList<Action> list = new LinkedList<>();
		PriorityQueue<Long> putList = new PriorityQueue<>();

		final double factor = 1.0;
		RandomVariable r = null;

		switch (distributions) {
		case 1:
			r = new Exponential(1.0);
			break;
		case 2:
			r = new Exponential(1.0 / 3000.0);
			break;
		case 3:
			r = new Pareto(1, 1);
			break;
		case 4:
			r = new Pareto(1, 1.5);
			break;
		case 5:
			r = new Pareto(1, 700);
			break;
		case 6:
			r = new SpecChange();
			break;
		case 7:
			r = new Camel(0, 1000, 2, 0.001, 0.999);
			break;
		case 8:
			r = new SpecBimodal();
			break;
		}

		UniformIntegerDistribution ud = new UniformIntegerDistribution(0, 2 * c - 1);
		int bound;

		double ts = 0;

		int j = 0;
		int incrCount = 0;
		while (j < qsize) {
			bound = ud.sample();
			double sd = factor * r.sample();
			double d = sd - meanincr;
			meanincr = meanincr + d / (incrCount + 1);
			incrCount++;
			for (int i = 0; i < bound && j < qsize; i++, j++) {
				long lRepr = Double.doubleToLongBits(ts + sd);
				System.out.println(lRepr);
				list.add(new Put(lRepr));
				putList.add(lRepr);

			}
			ts += meanincr;
		}

		// TEST CH
		for (int jj = 0; jj < accesses; jj++) {
			ts = Double.longBitsToDouble(putList.remove());
			list.add(new Get(Double.doubleToLongBits(ts)));

			double s = (factor * r.sample());
			long lRepr = Double.doubleToLongBits(ts + s);
			list.add(new Put(lRepr));
			putList.add(lRepr);

		}

		return list;
	}
}
