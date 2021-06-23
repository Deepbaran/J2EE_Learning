package com.deepbarankar.cnp.model;

import java.math.BigDecimal;

public class Coupon {
	private int id;
	private String code;
	private BigDecimal discount;
	private String expDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return "<h2>Coupon Data</h2> Coupon id: " + id + "<br>Code: " + code + "<br>Discount: " + discount + "<br>Expiry Date: " + expDate;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
}
