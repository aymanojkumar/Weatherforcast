package com.my.weather.old;
                 
public class Time
{
    private Symbol symbol;

    private Precipitation precipitation;

    private Temperature temperature;

    private Humidity humidity;

    private String from;

    private String to;

    private WindDirection windDirection;

    private Pressure pressure;

    private Clouds clouds;

    private WindSpeed windSpeed;

    private Feels_like feels_like;

    public Symbol getSymbol ()
    {
        return symbol;
    }

    public void setSymbol (Symbol symbol)
    {
        this.symbol = symbol;
    }

    public Precipitation getPrecipitation ()
    {
        return precipitation;
    }

    public void setPrecipitation (Precipitation precipitation)
    {
        this.precipitation = precipitation;
    }

    public Temperature getTemperature ()
    {
        return temperature;
    }

    public void setTemperature (Temperature temperature)
    {
        this.temperature = temperature;
    }

    public Humidity getHumidity ()
    {
        return humidity;
    }

    public void setHumidity (Humidity humidity)
    {
        this.humidity = humidity;
    }

    public String getFrom ()
    {
        return from;
    }

    public void setFrom (String from)
    {
        this.from = from;
    }

    public String getTo ()
    {
        return to;
    }

    public void setTo (String to)
    {
        this.to = to;
    }

    public WindDirection getWindDirection ()
    {
        return windDirection;
    }

    public void setWindDirection (WindDirection windDirection)
    {
        this.windDirection = windDirection;
    }

    public Pressure getPressure ()
    {
        return pressure;
    }

    public void setPressure (Pressure pressure)
    {
        this.pressure = pressure;
    }

    public Clouds getClouds ()
    {
        return clouds;
    }

    public void setClouds (Clouds clouds)
    {
        this.clouds = clouds;
    }

    public WindSpeed getWindSpeed ()
    {
        return windSpeed;
    }

    public void setWindSpeed (WindSpeed windSpeed)
    {
        this.windSpeed = windSpeed;
    }

    public Feels_like getFeels_like ()
    {
        return feels_like;
    }

    public void setFeels_like (Feels_like feels_like)
    {
        this.feels_like = feels_like;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [symbol = "+symbol+", precipitation = "+precipitation+", temperature = "+temperature+", humidity = "+humidity+", from = "+from+", to = "+to+", windDirection = "+windDirection+", pressure = "+pressure+", clouds = "+clouds+", windSpeed = "+windSpeed+", feels_like = "+feels_like+"]";
    }
}