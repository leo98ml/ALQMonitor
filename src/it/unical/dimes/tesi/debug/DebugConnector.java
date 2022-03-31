package it.unical.dimes.tesi.debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ArrayReference;
import com.sun.jdi.BooleanValue;
import com.sun.jdi.Bootstrap;
import com.sun.jdi.ByteValue;
import com.sun.jdi.CharValue;
import com.sun.jdi.ClassType;
import com.sun.jdi.DoubleValue;
import com.sun.jdi.Field;
import com.sun.jdi.FloatValue;
import com.sun.jdi.IntegerValue;
import com.sun.jdi.Location;
import com.sun.jdi.LongValue;
import com.sun.jdi.ObjectReference;
import com.sun.jdi.PrimitiveValue;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.ShortValue;
import com.sun.jdi.StringReference;
import com.sun.jdi.Value;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.VirtualMachineManager;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.request.BreakpointRequest;

import it.unical.dimes.elq.ALadderQueue;

public class DebugConnector implements DebugService {

	private HashSet<Breakpoint> breakpoints;
	private VirtualMachine remoteJVM = null;
	private List<ObjectReference> alqs = null;
	private ObjectReference selecteQueue = null;
	private static DebugConnector dc = null;
	private HashMap<Breakpoint, BreakpointRequest> breakpointRequests = null;
	
	private DebugConnector() {
	};

	private DebugConnector(String port, String ip) throws Exception {
		this.remoteJVM = connectToVM(port, ip);
		breakpoints = new HashSet<Breakpoint>();
		breakpointRequests = new HashMap<Breakpoint, BreakpointRequest>();
		getAlqs();
	}

	public VirtualMachine getRemoteJVM() {
		return remoteJVM;
	}

	public List<ObjectReference> getALQS() {
		getAlqs();
		return this.alqs;
	}

	public static DebugConnector getInstance() {
		if (dc==null) throw new RuntimeException("Prima va creata l'istanza");
		return dc;
	}

	public static DebugConnector createInstance(String port, String ip) throws Exception {
		dc = new DebugConnector(port, ip);
		return dc;
	}

	public static void disconnect() {
		dc.remoteJVM.dispose();
		dc = null;
	}

	public void setAlqs(List<ObjectReference> alqs) {
		this.alqs = alqs;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.asList(ALadderQueue.class.getDeclaredClasses()));
	}

	private void getAlqs() {
		this.alqs = new LinkedList<ObjectReference>();
		for (ReferenceType tr : this.remoteJVM.allClasses()) {
			if (tr.classObject().reflectedType().signature().contains("ALadderQueue")) {
				this.alqs = tr.instances(Integer.MAX_VALUE);
				break;
			}
		}
	}

	private AttachingConnector getConnector() {
		VirtualMachineManager vmManager = Bootstrap.virtualMachineManager();
		for (AttachingConnector connector : vmManager.attachingConnectors()) {
			if ("com.sun.jdi.SocketAttach".equals(connector.name())) {
				return (AttachingConnector) connector;
			}
		}
		throw new IllegalStateException();
	}

	private VirtualMachine connectToVM(String port, String ip) throws Exception {
		AttachingConnector c = (AttachingConnector) getConnector();
		Map<String, Connector.Argument> arguments = c.defaultArguments();
		arguments.get("port").setValue(port);
		arguments.get("hostname").setValue(ip);
		return c.attach(arguments);
	}

	@Override
	public List<Variabile> getVariabiliALQ(ObjectReference alq) {
		List<Variabile> ret = new ArrayList<Variabile>();
		if (alq != null)
			for (Field f : ((ClassType) alq.referenceType()).allFields()) {
				Variabile v = new Variabile();
				v.setNome(f.name());
				v.setTipo(f.typeName());
				v.setValore(getJavaValueString(alq.getValue(f)));
				ret.add(v);
			}
		return ret;
	}

	private String getJavaValueString(Value jdiValue) {
		if (jdiValue instanceof StringReference) {
			return ((StringReference) jdiValue).value() + "";
		}
		if (jdiValue instanceof PrimitiveValue) {
			PrimitiveValue primitiveValue = (PrimitiveValue) jdiValue;
			if (primitiveValue instanceof BooleanValue) {
				return primitiveValue.booleanValue() + "";
			}
			if (primitiveValue instanceof ShortValue) {
				return primitiveValue.shortValue() + "";
			}
			if (primitiveValue instanceof ByteValue) {
				return primitiveValue.byteValue() + "";
			}
			if (primitiveValue instanceof CharValue) {
				return primitiveValue.charValue() + "";
			}
			if (primitiveValue instanceof DoubleValue) {
				return primitiveValue.doubleValue() + "";
			}
			if (primitiveValue instanceof FloatValue) {
				return primitiveValue.floatValue() + "";
			}
			if (primitiveValue instanceof IntegerValue) {
				return primitiveValue.intValue() + "";
			}
			if (primitiveValue instanceof LongValue) {
				return primitiveValue.longValue() + "";
			}
		} else if (jdiValue instanceof ObjectReference) {
			String typename = ((ObjectReference) jdiValue).referenceType().name();
			if (typename.equals(Boolean.class.getName()) || typename.equals(Short.class.getName())
					|| typename.equals(Byte.class.getName()) || typename.equals(Character.class.getName())
					|| typename.equals(Double.class.getName()) || typename.equals(Float.class.getName())
					|| typename.equals(Integer.class.getName()) || typename.equals(Long.class.getName())) {
				Field f = ((ObjectReference) jdiValue).referenceType().fieldByName("value");
				Value result = ((ObjectReference) jdiValue).getValue(f);
				return getJavaValueString(result);
			}
		}
		return "obj";
	}

	@Override
	public List<ObjectReference> getRungs(ObjectReference alq) {
		List<ObjectReference> ret = new ArrayList<ObjectReference>();
		ObjectReference rungsDeck = null;
		for (Field f : ((ClassType) alq.referenceType()).allFields()) {
			if (f.name().equals("rungs")) {
				rungsDeck = (ObjectReference) alq.getValue(f);
				break;
			}
		}
		ArrayReference elementsArray = null;
		for (Field f : ((ClassType) rungsDeck.referenceType()).allFields()) {
			if (f.name().equals("elements")) {
				elementsArray = (ArrayReference) rungsDeck.getValue(f);
				break;
			}
		}
		for (int i = 0; i < elementsArray.length(); i++) {
			if (elementsArray.getValue(i) != null) {
				ret.add((ObjectReference) elementsArray.getValue(i));
			}
		}
		return ret;
	}

	@Override
	public List<ObjectReference> getBuckets(ObjectReference rung) {
		List<ObjectReference> ret = new ArrayList<ObjectReference>();
		ArrayReference bucketsArray = null;
		for (Field f : ((ClassType) rung.referenceType()).allFields()) {
			if (f.name().equals("bucket")) {
				bucketsArray = (ArrayReference) rung.getValue(f);
				break;
			}
		}
		for (int i = 0; i < bucketsArray.length(); i++) {
			if (bucketsArray.getValue(i) != null) {
				ret.add((ObjectReference) bucketsArray.getValue(i));
			}
		}
		return ret;
	}

	@Override
	public List<Variabile> getBucketElements(ObjectReference buck) {
		return buck == null ? new LinkedList<Variabile>() : fromLinkedEventListToList(buck);
	}

	@Override
	public List<Variabile> getTop(ObjectReference alq) {
		ObjectReference topEventList = null;
		for (Field f : ((ClassType) alq.referenceType()).allFields()) {
			if (f.name().equals("top")) {
				topEventList = (ObjectReference) alq.getValue(f);
				break;
			}
		}
		return topEventList == null ? new LinkedList<Variabile>() : fromLinkedEventListToList(topEventList);
	}

	private List<Variabile> fromLinkedEventListToList(ObjectReference topEventList) {
		List<Variabile> ret = new ArrayList<Variabile>();
		ObjectReference head = null;
		for (Field f : ((ClassType) topEventList.referenceType()).allFields()) {
			if (f.name().equals("head")) {
				head = (ObjectReference) topEventList.getValue(f);
				break;
			}
		}
		if (head != null)
			fromLinkedEventListToList(head, ret);
		return ret;
	}

	private void fromLinkedEventListToList(ObjectReference head, List<Variabile> ret) {
		ObjectReference next = head;
		while (next != null) {
			head = next;
			next = null;
			for (Field f : ((ClassType) head.referenceType()).allFields()) {
				if (f.name().equals("next")) {
					next = (ObjectReference) head.getValue(f);
				}
				if (f.name().equals("info")) {
					ObjectReference event = (ObjectReference) head.getValue(f);
					LongValue ts = null;
					int ifComposite = 0;
					for (Field f1 : ((ClassType) event.referenceType()).allFields()) {
						if (f1.name().equals("timestamp")) {
							ts = (LongValue) event.getValue(f1);
						}
						if (f1.name().equals("list")) {
							ifComposite = fromLinkedEventListToList((ObjectReference) event.getValue(f1)).size();
						}
					}
					Variabile v = new Variabile();
					v.setNome("timestamp");
					v.setValore(ts.value()+((ifComposite==0)?"":"[x"+ifComposite+"]"));
//					v.setValore(Double.longBitsToDouble(ts.value())+((ifComposite==0)?"":"[x"+ifComposite+"]"));
					v.setTipo("long");
					ret.add(v);
				}
			}
		}
	}

	@Override
	public List<Variabile> getBottom(ObjectReference alq) {
		ObjectReference bottomEventList = null;
		for (Field f : ((ClassType) alq.referenceType()).allFields()) {
			if (f.name().equals("bottom")) {
				bottomEventList = (ObjectReference) alq.getValue(f);
				break;
			}
		}
		return bottomEventList == null ? new LinkedList<Variabile>() : fromLinkedEventListToList(bottomEventList);
	}

	@Override
	public void pause() {
		if (this.remoteJVM != null) {
			this.remoteJVM.suspend();
		} else {
			throw new RuntimeException("No jvm");
		}
	}

	@Override
	public void resume() {
		if (this.remoteJVM != null) {
			this.remoteJVM.resume();
		}
	}

	@Override
	public void insertBreakpoint(Breakpoint b) throws AbsentInformationException {
		dc.getBreakpoints().remove(b);
		dc.getBreakpoints().add(b);
		if (dc.breakpointRequests.get(b) == null) {
			ClassType classType = null;
			for (ReferenceType r : remoteJVM.allClasses()) {
				if (r.classObject().reflectedType().name().equals(b.getFile())) {
					classType = (ClassType) r;
					break;
				}
			}
			Location location = classType.locationsOfLine(b.getLine()).get(0);
			BreakpointRequest br = this.remoteJVM.eventRequestManager().createBreakpointRequest(location);
			br.enable();
			dc.breakpointRequests.put(b, br);
		}
	}

	@Override
	public void remove(Breakpoint b) {
		dc.getBreakpoints().remove(b);
		try {
			this.remoteJVM.eventRequestManager().deleteEventRequest((dc.breakpointRequests.get(b)));
			dc.breakpointRequests.remove(b);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}
	}

	public ObjectReference getSelecteQueue() {
		List<ObjectReference> lor = new ArrayList<ObjectReference>();
		for (ReferenceType tr : this.remoteJVM.allClasses()) {
			if (tr.classObject().reflectedType().signature().contains("ALadderQueue")) {
				lor = tr.instances(Integer.MAX_VALUE);
				break;
			}
		}
		for (ObjectReference or : lor) {
			if (or.equals(selecteQueue)) {
				return or;
			}
		}
		return null;
	}

	public void setSelecteQueue(ObjectReference selecteQueue) {
		this.selecteQueue = selecteQueue;
	}

	public HashSet<Breakpoint> getBreakpoints() {
		return breakpoints;
	}

	public Breakpoint getBreakpoint(BreakpointRequest be) {
		for (Entry<Breakpoint, BreakpointRequest> e : breakpointRequests.entrySet()) {
			if (e.getValue().equals(be)) {
				return e.getKey();
			}
		}
		return null;
	}

}
