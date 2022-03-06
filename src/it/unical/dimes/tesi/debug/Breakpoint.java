package it.unical.dimes.tesi.debug;


public class Breakpoint {
	private boolean active=false;
	private int line;
	private String file;
	private String descr;
	private int aNTimes;
	public Breakpoint(int line,String file,String descr, int aNTimes) {
		this.line=line;
		this.file=file;
		this.descr=descr;
		this.aNTimes=aNTimes;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active=active;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public int getANTimes() {
		return aNTimes;
	}
	public void setANTimes(int aNTimes) {
		this.aNTimes = aNTimes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + line;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Breakpoint other = (Breakpoint) obj;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (line != other.line)
			return false;
		return true;
	}
	public String toString() {
		return this.descr;
	}
	
}
