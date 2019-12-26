package com.my.weather;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.weather.pojo.WeatherResponse;
import com.my.weather.service.WeatherService;

@SpringBootApplication
@RestController
public class WeatherforcaseApplication {
	
	@Autowired
	WeatherService weatherService;
	
	public static void main(String[] args) {
		SpringApplication.run(WeatherforcaseApplication.class, args);
	}
	
	@RequestMapping(value = "/getweather", method = RequestMethod.GET, produces = "application/json")
	public List<WeatherResponse> getWeather(){
		
		return weatherService.getWeather();
	}
	

}
