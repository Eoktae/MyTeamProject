<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX 사용하기</title>
</head>
<style>
	img{
		width: 100px;
	}
</style>
<body>

	<h3>Ajax Index</h3>
	
	<h5>static resource mapping</h5>
	
	<p>
		정적 자원들은 webapp/resources/ 에 보관하고 /resources/** uri로 접근하면 된다 (servlet-context의 내용을 참조)
	</p>
	
	<img src="https://static.hubzum.zumst.com/hubzum/2020/08/21/10/16af61affa8841f58caaedd241064824.jpg"/>
	<img src="/restful/resources/images/penguin.jpg"/>

	<hr>

	<button id="btn-xhttp">XHttp 요청보내기</button>
	<button id="btn-xhttp2">피자 리스트 요청</button>

	<hr>
	
	name : 
		<select id="select-pizza-name" name="name">
			<option value="null">db에서 가져온 피자이름들을 넣어주세요</option>
			<c:forEach items="${pizzas }" var="pizza">
				<option value="${pizza.id }">${pizza.name }</option>
			</c:forEach>		
		</select><br>
	price : 	<input id="input_pizza_price" type="text" placeholder="피자를 선택하면 값이 채워집니다"> <br>
	calrories : <input id="input_pizza_calories" type="text" placeholder="피자를 선택하면 값이 채워집니다"><br>
	pizza id : 	<input id="input_pizza_id" type="text" placeholder="피자를 선택하면 값이 채워집니다" readonly><br>
	<input id="input_pizza_name" type="hidden"/>
	<button id="btn-xhttp-put">xhttp put 해보기 (UPDATE)</button>
	</form>
	<hr>
	
	<div id="out2">아직 수정 전입니다.</div>
	
	<hr>
	
	name : <input id="post_pizza_name" type="text"/><br>
	price : 	<input id="post_pizza_price" type="text"> <br>
	calrories : <input id="post_pizza_calories" type="text" ><br>
	<button id="btn-xhttp-post">xhttp post 해보기 (UPDATE)</button>
	
	<div id="out"></div>
	<div id="out2"></div>
	<div id="out3"></div>
	<script src="/restful/resources/js/ajax.js"></script>
	<script src="/restful/resources/js/ajax2.js"></script>
	


</body>
</html>