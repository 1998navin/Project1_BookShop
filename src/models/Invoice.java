package models;

import java.sql.Date;

public class Invoice {
	
	private float Total;
	private float Pay;
	private float Balance;
	private Date date;
	private String Invoice_id;
	/**
	 * @param total
	 * @param pay
	 * @param balance
	 * @param date
	 * @param invoice_id
	 */
	public Invoice(float total, float pay, float balance, Date date, String invoice_id) {
		super();
		Total = total;
		Pay = pay;
		Balance = balance;
		this.date = date;
		Invoice_id = invoice_id;
	}
	/**
	 * @return the total
	 */
	public float getTotal() {
		return Total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(float total) {
		Total = total;
	}
	/**
	 * @return the pay
	 */
	public float getPay() {
		return Pay;
	}
	/**
	 * @param pay the pay to set
	 */
	public void setPay(float pay) {
		Pay = pay;
	}
	/**
	 * @return the balance
	 */
	public float getBalance() {
		return Balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(float balance) {
		Balance = balance;
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
	/**
	 * @return the invoice_id
	 */
	public String getInvoice_id() {
		return Invoice_id;
	}
	/**
	 * @param invoice_id the invoice_id to set
	 */
	public void setInvoice_id(String invoice_id) {
		Invoice_id = invoice_id;
	}
}
