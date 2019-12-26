package com.my.weather.pojo;

import java.util.List;

public class WeatherData {
	private City city;
	private List<Forecast> list;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Forecast> getList() {
		return list;
	}

	public void setList(List<Forecast> list) {
		this.list = list;
	}
	
	
}
