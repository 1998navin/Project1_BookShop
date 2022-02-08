package models;

import java.util.Date;

public class Stock {
	
	
	public int id;
	public float quantity;
	public float unit_price;
	public Date date;
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the quantity
	 */
	public float getQuantity() {
		return quantity;
	}


	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}


	/**
	 * @return the unit_price
	 */
	public float getUnit_price() {
		return unit_price;
	}


	/**
	 * @param unit_price the unit_price to set
	 */
	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}


	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}


	public Stock(int id, float quantity, float unit_price, Date date) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.date = date;
	}


}
