package com.my.weather;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.my.weather.service.WeatherService;

@Configuration
public class AppConfig {
	@Bean
	public WeatherService weatherServie() {
		return new WeatherService();
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
	    Proxy proxy = new Proxy(Type.HTTP, new InetSocketAddress("cloudpxgot1.srv.volvo.com", 8080));
	    requestFactory.setProxy(proxy);
	    return new RestTemplate(requestFactory);
	}
}
