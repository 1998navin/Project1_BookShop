package models;

public class BookInvoice {
	
	private String bID, bTitle;
	private int bQty;
	private float bPrice;
	private float bSubtotal, bTotal;
	
	public BookInvoice(String bID, String bTitle, int bQty, float bPrice, Float bSubtoal) {
	
	this.bID = bID;
	this.bTitle = bTitle;
	this.bQty = bQty;
	this.bPrice = bPrice;
	this.bSubtotal = bSubtoal;

		
	}
	
	public String getbID() {
		return bID;
	}
	
	public String getbTitle() {
		return bTitle;
	}
	
	public int getbQty() {
		return bQty;
	}
	
	public float getbPrice() {
		return bPrice;
	}
	
	public float getSubtotal() {
		return bSubtotal;
	}
	

}
