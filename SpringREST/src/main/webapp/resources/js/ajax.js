
const btn1 = document.getElementById('btn-xhttp');
const btn2 = document.getElementById('btn-xhttp-put');

const out = document.getElementById('out');
const out2 = document.getElementById('out2');

const select1 = document.getElementById('select-pizza-name');

const input_pizza_name = document.getElementById('input_pizza_name');
const input_pizza_price = document.getElementById('input_pizza_price');
const input_pizza_calories = document.getElementById('input_pizza_calories');
const input_pizza_id = document.getElementById('input_pizza_id');

const xhttp2 = new XMLHttpRequest();

xhttp2.addEventListener('readystatechange', (e)=> {
	const readyState = e.target.readyState;
	
	if(readyState == 4){
		const responseText = e.target.responseText;
		const pizza = JSON.parse(responseText);
		
		input_pizza_calories.value 	= pizza.calories;
		input_pizza_price.value 	= pizza.price;
		input_pizza_id.value 		= pizza.id;
		input_pizza_name.value 		= pizza.name;
	}
	
});

select1.addEventListener('change',(e)=>{
	xhttp2.open('GET', '/restful/sample/pizza/' + e.target.value);
	xhttp2.send();
});

//AJAX

//1. Ajax를 위한 xhttp 인스턴스 생성

const xhttp = new XMLHttpRequest();

//2. xhttp에 이벤트 설정

xhttp.addEventListener('readystatechange', (e)=>{
    // console.log('readystate event : ',e);

    const readystate = e.target.readyState;
    const responseText = e.target.responseText;

    if(readystate == 1){
        console.log('서버로 비동기 요청을 보냈다.');
    }else if(readystate == 2){
        console.log('서버가 내 요청을 받았다');
    }else if(readystate== 3){
        console.log('서버가 내요청에 대한 처리르 시작했다.');
    }else if(readystate == 4){
        console.log('서버의 처리가 끝나고 내 요청에 대한 응답이 도착했다.');
        console.log('응답은 responseText에 들어있다.',responseText)

        //5. Json 문자열 -> Javascript Object로 변환

        const pizza = JSON.parse(responseText);
 
        console.log('pizza name: ' , pizza.name);
        console.log('pizza calories: ' , pizza.calories);

        //6. 받아온 데이터 활용

         const pizzaDiv = document.createElement('div');

         pizzaDiv.innerText=`${pizza.name}/${pizza.calories}/${pizza.price}`;
         out.appendChild(pizzaDiv);

    }else{
        console.log('?? :' ,readystate,',' ,responseText);
    }
});

/* xhttp2.addEventListener('readystatechange', (e)=>{
    // console.log('readystate event : ',e);

    const readystate = e.target.readyState;
    const responseText = e.target.responseText;

    if(readystate == 1){
        console.log('서버로 비동기 요청을 보냈다.');
    }else if(readystate == 2){
        console.log('서버가 내 요청을 받았다');
    }else if(readystate== 3){
        console.log('서버가 내요청에 대한 처리르 시작했다.');
    }else if(readystate == 4){
        console.log('서버의 처리가 끝나고 내 요청에 대한 응답이 도착했다.');
        console.log('응답은 responseText에 들어있다.',responseText)

        //5. Json 문자열 -> Javascript Object로 변환

        const pizzaList = JSON.parse(responseText);
 

        //6. 받아온 데이터 활용

        const pizzaDiv2 = document.createElement('div');
        price.value = (JSON.stringify(pizzaList[0].price));
        calories.value = (JSON.stringify(pizzaList[0].calories));
        id.value = (JSON.stringify(pizzaList[0].id));
         for(var i = 0 ; i < pizzaList.length; ++i){
            pizzaDiv2.innerText=`${pizzaList[i].name}/${pizzaList[i].calories}/${pizzaList[i].price}`;

            out.appendChild(pizzaDiv2);
         }

         for(var i = 0 ; i < pizzaList.length; ++i){
            const option = document.createElement('option');

            option.innerText = JSON.stringify(pizzaList[i].name);

            pizzaOption.append(option);
         }

         pizzaOption.onchange = function(){

            price.value = (JSON.stringify(pizzaList[pizzaOption.selectedIndex].price));
            calories.value = (JSON.stringify(pizzaList[pizzaOption.selectedIndex].calories));
            id.value = (JSON.stringify(pizzaList[pizzaOption.selectedIndex].id));
         }; 


}});*/

btn1.addEventListener('click',(e)=>{
    //3.원하는 타이밍에 새로운 xhttp 연결을 생성
    xhttp.open('GET', '/restful/sample/pizza/2');

    //4.원하는 타이밍에 요청을 전송
    xhttp.send();

});

const xhttp3 = new XMLHttpRequest();

xhttp3.addEventListener('readystatechange',(e)=>{
	const readyState = e.target.readyState;
	
	if(readyState == 4 ){
		const responseText = e.target.responseText;
		
		if(responseText == 1){
			out2.innerText = 'SUCCESS';
			out2.style.color = 'green';
		} else{
			out2.innerText = responseText;
			out2.style.color = 'red';
		}
	}
});

btn2.addEventListener('click',(e)=>{
	// console.log('pizza id', input_pizza_id.value);
	// console.log('pizza name', input_pizza_name.value);
	// console.log('pizza price', input_pizza_price.value);
	// console.log('pizza calories', input_pizza_calories.value);
    
    const pizza = {
    	id : input_pizza_id.value,
    	name : input_pizza_name.value,
    	price : input_pizza_price.value,
    	calories : input_pizza_calories.value
    };
    
    // GET 방식은 주소 뒤에 ?name=value&... 로 실어 보내면 되지만
    // 그 외의 방식은 send(paylodad) 메서드에 데이터를 실어 보낸다 
    xhttp3.open('PUT', '/restful/sample/pizza');
    
    // xhr 요청 헤더 설정 (JSON 형식으로 보낸다고 서버에 알려야 한다)
    xhttp3.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    
    // Javascript Object -> JSON (stringify)
    console.log('JSON string : ' , JSON.stringify(pizza));
    xhttp3.send(JSON.stringify(pizza));
	

});

