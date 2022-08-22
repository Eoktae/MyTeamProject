<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX ����ϱ�</title>
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
		���� �ڿ����� webapp/resources/ �� �����ϰ� /resources/** uri�� �����ϸ� �ȴ� (servlet-context�� ������ ����)
	</p>
	
	<img src="https://static.hubzum.zumst.com/hubzum/2020/08/21/10/16af61affa8841f58caaedd241064824.jpg"/>
	<img src="/restful/resources/images/penguin.jpg"/>

	<hr>

	<button id="btn-xhttp">XHttp ��û������</button>
	<button id="btn-xhttp2">���� ����Ʈ ��û</button>

	<hr>
	
	name : 
		<select id="select-pizza-name" name="name">
			<option value="null">db���� ������ �����̸����� �־��ּ���</option>
			<c:forEach items="${pizzas }" var="pizza">
				<option value="${pizza.id }">${pizza.name }</option>
			</c:forEach>		
		</select><br>
	price : 	<input id="input_pizza_price" type="text" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�"> <br>
	calrories : <input id="input_pizza_calories" type="text" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�"><br>
	pizza id : 	<input id="input_pizza_id" type="text" placeholder="���ڸ� �����ϸ� ���� ä�����ϴ�" readonly><br>
	<input id="input_pizza_name" type="hidden"/>
	<button id="btn-xhttp-put">xhttp put �غ��� (UPDATE)</button>
	</form>
	<hr>
	
	<div id="out2">���� ���� ���Դϴ�.</div>
	
	<hr>
	
	name : <input id="post_pizza_name" type="text"/><br>
	price : 	<input id="post_pizza_price" type="text"> <br>
	calrories : <input id="post_pizza_calories" type="text" ><br>
	<button id="btn-xhttp-post">xhttp post �غ��� (UPDATE)</button>
	
	<div id="out"></div>
	<div id="out2"></div>
	<div id="out3"></div>
	<script src="/restful/resources/js/ajax.js"></script>
	<script src="/restful/resources/js/ajax2.js"></script>
	


</body>
</html>