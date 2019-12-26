package com.my.weather.old;
                 
public class Forecast
{
    private Time[] time;

    public Time[] getTime ()
    {
        return time;
    }

    public void setTime (Time[] time)
    {
        this.time = time;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [time = "+time+"]";
    }
}
	