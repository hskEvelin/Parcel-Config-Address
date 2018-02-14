package main.java;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class PriceTable {
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(foreign=true, canBeNull = false)
	private Zone zone;
	@DatabaseField(foreign=true, canBeNull = false)
	private Size size;
	@DatabaseField(canBeNull=false)
	private double price;
	
	public PriceTable(){}
	
	public PriceTable(Zone z, Size s, double p){
		zone = z;
		size = s;
		price = p;
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
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
