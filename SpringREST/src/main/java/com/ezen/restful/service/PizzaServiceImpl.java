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
	 	
	 	 - ��ݸ� �ۼ��� ������ Mybatis�� �ڵ����� �ش� �������̽��� ����ü�� �����Ѵ�
	 	 - �˾Ƽ� ������ JDBC �ڵ带 �ڵ����� ������ �� 
	 	   mybatis-spring:scan�� ���� spring-context�� ��ϵȴ�  
	 	
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
