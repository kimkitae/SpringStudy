package Datebase;

public class DTO {
	
	int num;
	String device;
	String model;
	
	public DTO(int num, String device, String model) {
		// TODO Auto-generated constructor stub
	super();
		this.num = num;
	this.device = device;
	this.model = model;
	
	}
	
	public DTO() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	

}
