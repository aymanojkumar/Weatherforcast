package com.my.weather.pojo;

import java.util.Date;

public class WeatherResponse {
	private Date date;
	private Double minTemprature;
	private Double maxTrempreture;
	private String message;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getMinTemprature() {
		return minTemprature;
	}
	public void setMinTemprature(Double minTemprature) {
		this.minTemprature = minTemprature;
	}
	public Double getMaxTrempreture() {
		return maxTrempreture;
	}
	public void setMaxTrempreture(Double maxTrempreture) {
		this.maxTrempreture = maxTrempreture;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "WeatherResponse [date=" + date + ", minTemprature=" + minTemprature + ", maxTrempreture="
				+ maxTrempreture + ", message=" + message + "]";
	}
	
	
}
