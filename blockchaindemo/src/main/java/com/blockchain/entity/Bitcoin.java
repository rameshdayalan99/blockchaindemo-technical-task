package com.blockchain.entity;

import java.time.LocalDate;

public class Bitcoin {

	private String currency;
	private LocalDate currentDate;
	private LocalDate lastDate;
	private Long coinRate;

	public Bitcoin() {

	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

	public LocalDate getLastDate() {
		return lastDate;
	}

	public void setLastDate(LocalDate lastDate) {
		this.lastDate = lastDate;
	}

	public Long getCoinRate() {
		return coinRate;
	}

	public void setCoinRate(Long coinRate) {
		this.coinRate = coinRate;
	}

}
