package it.unical.dimes.tesi.debug;

import java.util.List;

import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.ObjectReference;

public interface DebugService {
	
	//reperire informazioni
	public List<Variabile> getVariabiliALQ(ObjectReference alq);
	public List<ObjectReference> getRungs(ObjectReference alq);
	public List<ObjectReference> getBuckets(ObjectReference rung);
	public List<Variabile> getTop(ObjectReference alq);
	public List<Variabile> getBottom(ObjectReference alq);
	
	//comandi
	void pause();
	void resume();
	void remove(Breakpoint b);
	List<Variabile> getBucketElements(ObjectReference buck);
	void insertBreakpoint(Breakpoint p) throws AbsentInformationException;
	
}
