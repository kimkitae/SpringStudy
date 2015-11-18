package spring;

import java.sql.Timestamp;
import java.util.Date;

public class Member {

	private int num;
	private String service;
	private String name;
	private float result;
	private Timestamp time;

	public Member(String service, String name, Float result, Timestamp time) {
		this.service = service;
		this.name = name;
		this.result = result;
		this.time = time;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getResult() {
		return result;
	}

	public void setResult(float result) {
		this.result = result;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}
