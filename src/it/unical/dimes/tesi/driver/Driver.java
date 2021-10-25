package it.unical.dimes.tesi.driver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;

import org.apache.commons.math3.distribution.UniformIntegerDistribution;

import dataset.Action;
import dataset.Get;
import dataset.Put;
import it.unical.dimes.elq.ALadderQueue;
import it.unical.dimes.elq.AtomicEvent;
import it.unical.dimes.elq.Event;
import it.unical.dimes.elq.FQ;
import it.unical.dimes.elq.GroupingPriorityQueue;
import random.Camel;
import random.Exponential;
import random.Pareto;
import random.RandomVariable;
import random.SpecBimodal;
import random.SpecChange;

public class Driver {
	// coda su cui fare le varie operazioni
	static ALadderQueue ladder = null;

	static int qsize;
	static int accesses = 1_000_000;
	static int TOT = 50;
	static int SCRAP = 10;
	static long SLEEP = 500;
	static double meanincr = 0.0;
	static int distributions;
	static int c = 100;
	static int totacc = 2_000_000;
	static boolean grouping = false, smartSpawning = false, upGrowing = false;

	public static void main(String[] args) {

		loop: while (true) {
			try {
				String[] comando = leggiComando();
				switch (comando[0]) {
				case "insert":// insert-value-value...
					if (ladder == null)
						System.out.println("Prima devi creare una coda col comando new!!!");
					else
						for (int i = 1; i < comando.length; i++) {
							ladder.enqueue(new AtomicEvent(Long.parseLong(comando[i])));
						}
					break;
				case "random":// random-nIns-distribution
					if (ladder == null)
						System.out.println("Prima devi creare una coda col comando new!!!");
					else {
						int nIns = Integer.parseInt(comando[1]);
						distributions = Integer.parseInt(comando[2]);
						LinkedList<AtomicEvent> l = generateRandom(nIns);
						ListIterator<AtomicEvent> li = l.listIterator();
						for (int j = 0; j < nIns; j++) {
							ladder.enqueue(li.next());
						}
					}
					break;
				case "test":// test-qsize-distribution-resetBefore-initializeBefore
					if (ladder == null)
						System.out.println("Prima devi creare una coda col comando new!!!");
					else {
						qsize = Integer.parseInt(comando[1]);
						distributions = Integer.parseInt(comando[2]);
						boolean resetBefore = Integer.parseInt(comando[3]) == 1;
						boolean initializeBefore = Integer.parseInt(comando[4]) == 1;
						if (resetBefore) {
							ladder = new ALadderQueue(grouping, upGrowing, smartSpawning);
							meanincr = 0;
						}
						if (initializeBefore) {
							initialize();
						}
						executeTest();
					}
					break;
				case "remove":// remove-n
					int n = Integer.parseInt(comando[1]);
					if (ladder == null)
						System.out.println("Prima devi creare una coda col comando new!!!");
					else if (ladder.size() <= n)
						for (int i = 0; i < n; i++) {
							System.out.println(Double.longBitsToDouble(ladder.dequeue().getTimeStamp()));
						}
					else
						System.out.println("Operazione non valida in quanto la coda non contiene " + n
								+ " elementi, ma: " + ladder.size());
					break;
				case "new":// new-g-u-s-garbageCollectorSleepTime-scrap-tot
					grouping = comando[1].equals("1");
					upGrowing = comando[2].equals("1");
					smartSpawning = comando[3].equals("1");
					SLEEP = Integer.parseInt(comando[4]);
					SCRAP = Integer.parseInt(comando[5]);
					TOT = Integer.parseInt(comando[6]);
					ladder = new ALadderQueue(grouping, upGrowing, smartSpawning);
					break;

				case "initialize":// initialize-qsize-distribution
					// EVENT LIST CREATION
					if (ladder == null)
						System.out.println("Prima devi creare una coda col comando new!!!");
					else {
						qsize = Integer.parseInt(comando[1]);
						distributions = Integer.parseInt(comando[2]);
						initialize();
					}
					break;
				case "reset":// reset
					ladder = new ALadderQueue(grouping, upGrowing, smartSpawning);
					meanincr = 0;
					break;
				case "kill":// kill
					break loop;
				}
			} catch (Exception e) {
				System.out.println("C'è stata la seguente eccezione, prova a ricontrollare il comando inserito: ");
				e.printStackTrace();
			}

		}

	}

	private static String[] leggiComando() {
		System.out.println("\nLista comandi accettati:\r\n" + "[comando]-[parametro_1]-[parametro_2]-...\r\n"
				+ "* new-g-u-s-garbageCollectorSleepTime-scrap-tot:\r\n" + "    g,u,s accettano valori 0 o 1;\r\n"
				+ "    il tempo di sleep di GC va espresso in ms;\r\n"
				+ "    scrap indica i giri scartati in caso di inizializzazione;\r\n"
				+ "    tot indica il numero di ripetizioni totali\r\n" + "    scrap < tot\r\n"
				+ "* insert-value-[value]...\r\n" + "    inserisce gli n valori parametro nella coda\r\n"
				+ "* random-numeroInsertDesiderato-distribuzione (\r\n" + "    1:Esponenziale(1);\r\n"
				+ "    2:Esponenziale(1/3000);\r\n" + "    3:Pareto(1,1);\r\n" + "    4:Pareto(1,1.5);\r\n"
				+ "    5:Pareto(1,700);\r\n" + "    6:Change;\r\n" + "    7:Camel(0,1000,2,0.001,0.999);\r\n"
				+ "    8:Bimodal();\r\n" + ")\r\n" + "    esegue l'insert di n elementi \r\n"
				+ "    generati con la distribuzione desiderata\r\n"
				+ "* test-tagliaCoda-distribuzione-resettaPrima-inizializzaPrima\r\n"
				+ "    esegue un test con la distribuzione desiderata e con il numero\r\n"
				+ "    di elementi desiderato, stampando a video il classic hold\r\n" + "* remove-numeroElementi\r\n"
				+ "    rimuove numeroElemnti elementi dalla coda\r\n" + "* initialize\r\n"
				+ "    inizializza la coda facendo scrap giri di inserimenti\r\n"
				+ "    e rimozioni per assicurarsi che la struttura sia in uno stato\r\n" + "    intermedio\r\n"
				+ "* reset\r\n" + "    reinizializza la struttura con i parametri inseriti al momento\r\n"
				+ "    della new\r\n" + "* kill\r\n" + "    termina il programma\r\n" + "\r\n"
				+ "Per prima cosa prova a creare una coda con la new, \r\n"
				+ "poi potrai eseguire le varie operazioni \r\n" + "con i comandi a tua disposizione");
		System.out.println("Inserisci il comando desiderato:");
		String ret = null;
		BufferedReader sc = null;
		try {
			sc = new BufferedReader(new InputStreamReader(System.in));
			ret = sc.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret.split("-");
	}

	private static void initialize() {
		LinkedList<Action> list = generate_random();
		for (int i = 0; i < SCRAP; i++) {
			System.gc();
			try {
				Thread.sleep(SLEEP);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			fullTestALQ(list, ladder);
		}

	}

	private static void testALQ(LinkedList<Action> list, boolean grouping, boolean upgrowing, boolean smartspawn) {
		long min = Long.MAX_VALUE;
		long sit = 0, c = 0;
		double m2 = 0, d = 0, m = 0;
		for (int i = 0; i < TOT; i++) {
			System.gc();
			try {
				Thread.sleep(SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ALadderQueue ladder = new ALadderQueue(grouping, upgrowing, smartspawn);
			if (i < SCRAP)
				c = fullTestALQ(list, ladder);
			else {

				c = fullTestALQ(list, ladder);
				sit = sit + c;
				d = c - m;
				m = m + d / (i - (SCRAP - 1));
				m2 = m2 + d * (c - m);
			}
			if (c < min)
				min = c;
		}
		sit = sit / (TOT - SCRAP);
		double value = m / totacc;
		System.out.print(" " + value);

	}

	public static long fullTestALQ(LinkedList<Action> list, ALadderQueue ladder) {
		ListIterator<Action> li = list.listIterator();

		Action x = null;
		boolean si = false;
		int i = 0;
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

			i++;

		}

		if (si) {
			throw new RuntimeException("");
		}

		time = System.nanoTime() - time;

		return time;
	}

	private static LinkedList<Action> generate_random() {
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

	public static LinkedList<AtomicEvent> generateRandom(int n) {
		LinkedList<AtomicEvent> list = new LinkedList<>();
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
		int j = 0;
		while (j < n) {
			long lRepr = Double.doubleToLongBits(r.sample());
			j++;
			list.add(new AtomicEvent(lRepr));
		}
		return list;
	}

	public static void executeTest() {

		// EVENT LIST CREATION
		LinkedList<Action> list = generate_random();

		testALQ(list, grouping, upGrowing, smartSpawning);

	}

}
