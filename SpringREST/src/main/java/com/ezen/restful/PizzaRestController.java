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
	
	
	// GET 방식으로 피자의 ID와 함께 요청을 보내면 해당 피자의 정보를 JSON 형식으로 반환
	@GetMapping(value= "/sample/pizza/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Pizza getPizza(@PathVariable Integer id) {
		
		// 피자의 조회수(calories를 임시 조회수로 사용)가 있다, 
		// 조회 할 때마다 1씩 증가해야 한다
		
		return service.getPizza(id);
	}
	
	// @RestController에서는 @RequestBody를 적어주지 않으면 파라미터가 자동 바인딩 되지 않는다
	// POST 방식으로 파라미터의 피자 데이터와 함께 요청 보내면 해당 피자를 DB에 추가
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
		// ResponseEntity : 상황에 따라 원한는 응답을 만들 수 있다. (상태 코드 활용)		
		//ResponseEntity<Pizza> response = null;
		
		// ResponseEntity.ok() : Http 상태코드 200의 응답을 만든다.
		// response = ResponseEntity.ok(null);
		
		// ResponseEntity.notFound() : Http 상태코드 404의 응답을 만든다.
		// response = ResponseEntity.notFound().build();
		
		// 자유롭게 응답만들기
//		response = ResponseEntity.status(HttpStatus.OK)
//				.contentType(MediaType.APPLICATION_JSON)
//				.body(service.getPizza(8));
//		
//		return response;
	}
	// PUT방식으로 파라미터의 피자 데이터를 함께 요청을 보내면 해당 피자의 정보를 받아서 수정..
	@PutMapping(value= "/sample/pizza", produces = MediaType.TEXT_PLAIN_VALUE)
	public String updatePizza(@RequestBody Pizza pizza) {
		
		try {
		return service.update(pizza).toString();
		} catch(Exception e) {
			return "0 : " + e;
		}
	}
	

	// DELETE 방식으로 피자의 ID와 함께 요청을 보내면 해당 피자를 DB에서 삭제
	@DeleteMapping(value= "/sample/pizza/{id}")
	public Integer deletePizza() {
		
		return 4;
	}
}
