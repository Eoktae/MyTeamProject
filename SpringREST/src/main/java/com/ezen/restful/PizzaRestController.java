package com.ezen.restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ezen.restful.dto.Pizza;
import com.ezen.restful.service.PizzaService;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
public class PizzaRestController {
	
	@Autowired
	PizzaService service;
	
	@GetMapping(value= "/pizza/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Pizza> listPizza() {
		
		return service.getList();
	}
	
	
	// GET ������� ������ ID�� �Բ� ��û�� ������ �ش� ������ ������ JSON �������� ��ȯ
	@GetMapping(value= "/sample/pizza/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Pizza getPizza(@PathVariable Integer id) {
		
		// ������ ��ȸ��(calories�� �ӽ� ��ȸ���� ���)�� �ִ�, 
		// ��ȸ �� ������ 1�� �����ؾ� �Ѵ�
		
		return service.getPizza(id);
	}
	
	// @RestController������ @RequestBody�� �������� ������ �Ķ���Ͱ� �ڵ� ���ε� ���� �ʴ´�
	// POST ������� �Ķ������ ���� �����Ϳ� �Բ� ��û ������ �ش� ���ڸ� DB�� �߰�
	@PostMapping(value = "/sample/pizza", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<Pizza> insertPizza(@RequestBody Pizza pizza) {
		
		if(pizza.getName() == null || pizza.getName().trim().equals("") || 
				pizza.getCalories() == null||
				pizza.getPrice() == null ) {
			return ResponseEntity.badRequest().build();
		}
		
		try {
			service.insert(pizza);
			
			return ResponseEntity.ok().build();
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.build();
		}
		// ResponseEntity : ��Ȳ�� ���� ���Ѵ� ������ ���� �� �ִ�. (���� �ڵ� Ȱ��)		
		//ResponseEntity<Pizza> response = null;
		
		// ResponseEntity.ok() : Http �����ڵ� 200�� ������ �����.
		// response = ResponseEntity.ok(null);
		
		// ResponseEntity.notFound() : Http �����ڵ� 404�� ������ �����.
		// response = ResponseEntity.notFound().build();
		
		// �����Ӱ� ���丸���
//		response = ResponseEntity.status(HttpStatus.OK)
//				.contentType(MediaType.APPLICATION_JSON)
//				.body(service.getPizza(8));
//		
//		return response;
	}
	// PUT������� �Ķ������ ���� �����͸� �Բ� ��û�� ������ �ش� ������ ������ �޾Ƽ� ����..
	@PutMapping(value= "/sample/pizza", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updatePizza(@RequestBody Pizza pizza) {
		
		try {
		return service.update(pizza).toString();
		} catch(Exception e) {
			return "0 : " + e;
		}
	}
	

	// DELETE ������� ������ ID�� �Բ� ��û�� ������ �ش� ���ڸ� DB���� ����
	@DeleteMapping(value= "/sample/pizza/{id}")
	public Integer deletePizza() {
		
		return 4;
	}
}
