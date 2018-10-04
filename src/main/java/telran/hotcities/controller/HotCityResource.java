package telran.hotcities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.hotcities.model.HottestCity;
import telran.hotcities.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
public class HotCityResource {
	
	@Autowired
	WeatherService service;
	
	@GetMapping("{cities}")
	public HottestCity getHottestCity(@PathVariable String [] cities) throws Exception 
	{
		return service.getHottestCity(cities);
	}

}
