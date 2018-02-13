package main.java;

public class Address {
	private String name;
	private String street;
	private String nr;
	private String plz;
	private String city;
	private String country;
	
	
	
	public Address(String name, String street, String nr, String plz, String city, String country) {
		super();
		this.name = name;
		this.street = street;
		this.nr = nr;
		this.plz = plz;
		this.city = city;
		this.country = country;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
