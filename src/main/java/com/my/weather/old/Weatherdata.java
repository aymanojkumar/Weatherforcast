package com.my.weather.old;

public class Weatherdata {
	private String meta;

	private Location location;

	private Forecast forecast;

	private String credit;

	private Sun sun;

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Forecast getForecast() {
		return forecast;
	}

	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public Sun getSun() {
		return sun;
	}

	public void setSun(Sun sun) {
		this.sun = sun;
	}

	@Override
	public String toString() {
		return "ClassPojo [meta = " + meta + ", location = " + location + ", forecast = " + forecast + ", credit = "
				+ credit + ", sun = " + sun + "]";
	}
}