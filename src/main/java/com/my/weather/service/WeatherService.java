package com.my.weather.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.weather.pojo.Forecast;
import com.my.weather.pojo.Weather;
import com.my.weather.pojo.WeatherData;
import com.my.weather.pojo.WeatherResponse;

public class WeatherService {
	private static final String baseUrl = "http://api.openweathermap.org/data/2.5/forecast?q=London,us&mode=json&appid=d2929e9483efc82c82c32ee7e02d563e";
	
	@Autowired
	private RestTemplate restTemplate;
	/*
	 * static { System.setProperty("java.net.useSystemProxies", "true");
	 * System.setProperty("https.proxyHost", "");
	 * System.setProperty("https.proxyPort", "8080");
	 * System.setProperty("http.proxyHost", "cloudpxgot1.srv.volvo.com");
	 * System.setProperty("http.proxyPort", "8080"); }
	 */
	public List<WeatherResponse> getWeather() {
		try {
			HttpHost proxy = new HttpHost("cloudpxgot1.srv.volvo.com", 8080);
			DefaultHttpClient httpClient = new DefaultHttpClient();
			httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
			HttpGet getRequest = new HttpGet(baseUrl);
			HttpResponse response = httpClient.execute(getRequest);
			// verify the valid error code first
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new RuntimeException("Failed with HTTP error code : " + statusCode);
			}

			HttpEntity e = response.getEntity();
			String responseText = EntityUtils.toString(e);

			
			
			//System.out.println("responseText -\n" + responseText);
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
			WeatherData obj = mapper.readValue(responseText, WeatherData.class);

			
	        
	        
	   
	        List<WeatherResponse> weatherResponseList = new ArrayList<WeatherResponse>();

			obj.getList().stream()
					.filter(l -> isDateBetween(new Date(l.getDt() * 1000)))
					.forEach(l -> {
						WeatherResponse w = new WeatherResponse();
						w.setDate(new Date(l.getDt() * 1000));
						w.setMessage(getStatistic(l));
						w.setMaxTrempreture(kelvinToCelcius(l.getMain().getTemp_max()));
						w.setMinTemprature(kelvinToCelcius(l.getMain().getTemp_min()));

						weatherResponseList.add(w);
					});
	        
	      
			System.out.println(obj.getCity().getName());
			System.out.println(obj.getList().size());
			System.out.println(obj.getList().get(0).getMain().getTemp_max());
			System.out.println(obj.getList().get(0).getWeather().get(0).getDescription());
			
			
		    String result = restTemplate.getForObject(baseUrl, String.class);
		     
		    System.out.println(result);
			
			return weatherResponseList;
		} catch (Exception e) {
			e.printStackTrace();
		}

		throw new RuntimeException("Something went wrong");
	}
	
	private static boolean isDateBetween(Date d){
		Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.DATE, 1);
        Date tomorrowMidNight = c.getTime();
        c.add(Calendar.DATE, 3); 
        Date fourthDayMidnight = c.getTime();
		return d.after(tomorrowMidNight) && d.before(fourthDayMidnight);
	}
	
	private static String getStatistic(Forecast forcast) {
		if(kelvinToCelcius(forcast.getMain().getTemp_max()) > 40d) {
			return " sunscreen lotion";
		}else if(checkRainPosibilitiesForDay(forcast.getWeather())) {
			return "Crry umbrella ";
		} 
		return "Not raining nor too hot";
	}
	private static boolean checkRainPosibilitiesForDay(List<Weather> todayWeather) {
		return todayWeather.stream().filter(w -> w.getMain().toLowerCase().contains("rain") || w.getDescription().toLowerCase().contains("rain")).findAny().isPresent();
	}
	private static Double kelvinToCelcius(Double kelvin) {
		DecimalFormat df = new DecimalFormat("##.##");
		return Double.valueOf(df.format(kelvin - 273.15));
	}
	
	
}
