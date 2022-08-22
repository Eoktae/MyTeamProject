package com.ezen.restful.mapper;

import java.util.List;

import com.ezen.restful.dto.Pizza;

public interface PizzaMapper {
	
	Pizza get(int pk);
	
	Integer updateView(int pk);
	
	List <Pizza> getList();
	
	List <Pizza> getAll();
	
	Integer update(Pizza pizza);
	
	Integer insert(Pizza pizza);


	
		
}
