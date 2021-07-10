package com.higradius;

import java.sql.Date;

public class Invc {
	private String customerName;
	private String cutomerNumber;
	private String invoiceID;
	private Long openAmount;
	private Date dueDate;
	private Date clearDate;
	private String note;
	private String bracket;
	public Invc(String customerName, String cutomerNumber, String invoiceID, Long openAmount, Date dueDate,
			Date clearDate, String note, String bracket) {
		this.customerName = customerName;
		this.cutomerNumber = cutomerNumber;
		this.invoiceID = invoiceID;
		this.openAmount = openAmount;
		this.dueDate = dueDate;
		this.clearDate = clearDate;
		this.note = note;
		this.bracket = bracket;
	}

	public Invc() {
		
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCutomerNumber() {
		return cutomerNumber;
	}

	public void setCutomerNumber(String cutomerNumber) {
		this.cutomerNumber = cutomerNumber;
	}

	public String getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}

	public Long getOpenAmount() {
		return openAmount;
	}

	public void setOpenAmount(Long openAmount) {
		this.openAmount = openAmount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getClearDate() {
		return clearDate;
	}

	public void setClearDate(Date clearDate) {
		this.clearDate = clearDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getBracket() {
		return bracket;
	}

	public void setBracket(String bracket) {
		this.bracket = bracket;
	}
}
