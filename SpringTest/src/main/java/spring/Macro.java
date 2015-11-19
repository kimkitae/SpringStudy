package spring;

import java.sql.Timestamp;
import java.util.Date;

public class Macro {

	private int num;
	private String stats;
	private String result;
	private Timestamp time;

	public Macro(String stats, String result,  Timestamp date) {
		this.stats = stats;
		this.result = result;
		this.time = date;

	}
	
	public Macro(String stats, String result) {
		this.stats = stats;
		this.result = result;

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStats() {
		return stats;
	}

	public void setStats(String stats) {
		this.stats = stats;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}


}
