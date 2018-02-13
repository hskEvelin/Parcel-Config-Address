package main.java;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Country {
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(foreign = true, canBeNull = false)
	private Zone zone;
	@DatabaseField(canBeNull = false)
	private String country;
	
	public Country(){}
	
	public Country(Zone z, String c){
		zone = z;
		country = c;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
