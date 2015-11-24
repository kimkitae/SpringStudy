package spring;

import java.sql.Timestamp;

public class voltvalues {
	
	int num;
	String service;
	String device;
	String tc;
	int round;
	String logcat;
	String dump;
	String average;
	
	public voltvalues(String service, String device, String tc, int round, String logcat, String dump, String average) {
		this.service = service;
		this.device = device;
		this.tc = tc;
		this.round = round;
		this.logcat = logcat;
		this.dump = dump;
		this.average = average;

	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public String getLogcat() {
		return logcat;
	}
	public void setLogcat(String logcat) {
		this.logcat = logcat;
	}
	public String getDump() {
		return dump;
	}
	public void setDump(String dump) {
		this.dump = dump;
	}
	public String getAverage() {
		return average;
	}
	public void setAverage(String average) {
		this.average = average;
	}
	

}
