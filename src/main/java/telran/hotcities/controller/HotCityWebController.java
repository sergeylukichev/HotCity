package telran.hotcities.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import telran.hotcities.clientmodel.WeatherForm;
import telran.hotcities.model.HottestCity;
import telran.hotcities.service.WeatherService;

@Controller
public class HotCityWebController {
	
	@Autowired
	WeatherService service;
	
	@GetMapping("/weather")
	public String getWeatherForm(Model model) {
		model.addAttribute("weatherForm", new WeatherForm());
		return "index";
	}
	
	@PostMapping("/getWeather")
	public String getHottestCity(Model model, WeatherForm form) throws Exception {
		HottestCity hottestCity = service.getHottestCity(form.getCities().split(","));
		model.addAttribute("city", hottestCity.getName());
		model.addAttribute("temp", hottestCity.getTemp());		
		return "city";
	}

}
