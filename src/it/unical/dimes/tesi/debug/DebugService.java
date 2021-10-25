package it.unical.dimes.tesi.debug;

import java.util.HashMap;
import java.util.List;

public interface DebugService {
	
	//reperire informazioni
	List<Object> getVariabiliALQ();
	List<Object> getRungs();
	List<Object> getBuckets(Object o);
	List<Object> getTop();
	List<Object> getBottom();
	HashMap<String,String> getTopInfo();
	HashMap<String,String> getBottomInfo();
	HashMap<String,String> getLadderInfo();
	HashMap<String,String> getRungInfo(Object rung);
	HashMap<String,String> getBucketInfo(Object bucket);
	
	//comandi
	void pause();
	void resume();
	Breakpoint insertBreakpoint(String where);
	Breakpoint insertBreakpoint(String where, int afterNTimes);
	Breakpoint insertBreakpoint(String variable, String value);
	Breakpoint insertBreakpintOnUpGrowing();
	Breakpoint insertBreakpintOnSmartSpawning();
	Breakpoint insertBreakpintOnGrouping();
	void remove(Breakpoint b);
	
}
