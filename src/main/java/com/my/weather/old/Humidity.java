package com.my.weather.old;
               
public class Humidity
{
    private String unit;

    private String value;

    public String getUnit ()
    {
        return unit;
    }

    public void setUnit (String unit)
    {
        this.unit = unit;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [unit = "+unit+", value = "+value+"]";
    }
}
			
			

