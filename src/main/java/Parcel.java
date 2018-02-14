package main.java;

public class Parcel {
	private Address recipient;
	private Address sender;
	private Parcelsize size;
	private double price;
	
	public Address getSender() {
		return sender;
	}
	public void setSender(Address sender) {
		this.sender = sender;
	}
	public Address getRecipient() {
		return recipient;
	}
	public void setRecipient(Address recipient) {
		this.recipient = recipient;
	}
	public Parcelsize getSize() {
		return size;
	}
	public void setSize(Parcelsize size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
