package com.ezen.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.restful.dto.Pizza;
import com.ezen.restful.mapper.PizzaMapper;

@Service
public class PizzaServiceImpl implements PizzaService{

	/*
	 	# Mapper Interface??
	 	
	 	 - 골격만 작성해 놓으면 Mybatis가 자동으로 해당 인터페이스의 구현체를 생성한다
	 	 - 알아서 귀찮은 JDBC 코드를 자동으로 생성한 후 
	 	   mybatis-spring:scan을 통해 spring-context에 등록된다  
	 	
	 */
	
	@Autowired
	PizzaMapper mapper;	
	
	@Override
	public Pizza getPizza(int pk) {
		mapper.updateView(pk);
		return mapper.get(pk);
	}
	
	@Override
	public List<Pizza> getList() {
		
		return mapper.getList();
	}
	
	@Override
	public Integer update(Pizza pizza) {
		
		return mapper.update(pizza);
	}
	
	@Override
	public Integer insert(Pizza pizza) {
		
		return mapper.insert(pizza);
	}


	
}
