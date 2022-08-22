package com.ezen.restful;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.restful.dto.Pizza;

import lombok.extern.log4j.Log4j;


@RestController
public class RestSampleController {
	
	@GetMapping(value = "/test1", produces = "text/plain; charset=EUC-KR")
	public String test1(){
		return "Hello, RESTFUL!!";
	}
	
	//jackson-databind : 자바 객체를 JSON타입 또는 XML타입으로 알아서 변환해주는 라이브러리
	
	@GetMapping(value="/pizza", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Pizza getPizza() {
		Pizza pizza = new Pizza();
		
		pizza.setId(13);
		pizza.setName("페페로니");
		pizza.setCalories(333.123);
		pizza.setPrice(8000);
		
		return pizza;
	}
	
	@GetMapping(value="/pizza2", produces = MediaType.APPLICATION_XML_VALUE)
	public Pizza getPizza2() {
		Pizza pizza = new Pizza();
		
		pizza.setId(13);
		pizza.setName("페페로니");
		pizza.setCalories(333.123);
		pizza.setPrice(8000);
		
		return pizza;
	}
	
	@GetMapping(value="/pizzas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Pizza> getPizzas(){
		List<Pizza> pizzas = new ArrayList<>();
		
		pizzas.add(new Pizza(1001,"파인애플 피자",12000, 1560.8));
		pizzas.add(new Pizza(1002,"민트초코 피자",13000, 1660.8));
		pizzas.add(new Pizza(1003,"페퍼민트 피자",13300, 1760.8));
		pizzas.add(new Pizza(1004,"보약 피자",14000, 1860.8));
		
		return pizzas;
	}
	
	@GetMapping(value = "/pizza_map", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String,Pizza>getPizzaMap(){
		
		Map<String, Pizza> pizzaMap = new HashMap<>();
		
		pizzaMap.put("menu1",new Pizza(1001,"하리보 피자",12000, 1560.8));
		pizzaMap.put("menu2",new Pizza(1002,"페로로로쉐 피자",12000, 1560.8));
		pizzaMap.put("menu3",new Pizza(1003,"계피맛 피자",12000, 1560.8));
		
		return pizzaMap;
	}
	
	
	
}





