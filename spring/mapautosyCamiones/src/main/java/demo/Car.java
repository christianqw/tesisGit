package demo;

import java.util.HashMap;

public class Car {

	private HashMap <String, String> att;
	private Integer miles;
	private String color;



	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getAtt(String clave) {
		return att.get(clave);
	}
	public void setAtt(String clave, String value) {
		this.att.put(clave, value);
	}

	public Integer getMiles() {
		return miles;
	}
	public void setMiles(Integer miles) {
		this.miles = miles;
	}

}
