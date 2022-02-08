package models;

public class Book {

	private String bID, bTitle, bAuthor, bPublisher;
	private int bQty;
	private float bPrice;
	
	public Book(String bID, String bTitle,int bQty, float bPrice, String bAuthor, String bPublisher) {
	
	this.bID = bID;
	this.bTitle = bTitle;
	this.bQty = bQty;
	this.bPrice = bPrice;
	this.bAuthor = bAuthor;
	this.bPublisher = bPublisher;
		
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
	
	public String getbAuthor() {
		return bAuthor;
	}
	
	public String getbPublisher() {
		return bPublisher;
	}

}

