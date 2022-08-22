
const btn = document.getElementById('btn-xhttp-post');
const out3 = document.getElementById('out3');
const xhttp4 = new XMLHttpRequest();


btn.addEventListener('click',(e)=>{
    
    const postPizza = {
    	name : post_pizza_name.value,
    	price : post_pizza_price.value,
    	calories : post_pizza_calories.value
    	}
   
    

    xhttp4.open('POST', '/restful/sample/pizza');
    xhttp4.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    console.log('JSON string : ' , JSON.stringify(postPizza));
    xhttp4.send(JSON.stringify(postPizza));
    
     });
	
	xhttp4.addEventListener('readystatechange',(e)=>{
	const readyState = e.target.readyState;
	console.dir(e.target);
	if(readyState == 4 ){
		// e.target.status에 컨트롤러에서 만들어 보낸 http 상태 코드가 들어 있다.
		const httpStatus = e.target.status;
		
		console.log('xhr4 http status : ', httpStatus);
				
		if(httpStatus == 200){
			//console.log('200 ok arrived');
			out3.style.color = 'green';
			out3.innerText = '200 ok!';
		} else if(httpStatus == 500){
			// console.log('500 internal server error arrived');
			out3.style.color = 'red';
			out3.innerText = '500 internal server error! ';
			
		} else if(httpStatus == 400){
			//console.log('400 bad request arrived');
			out3.style.color = 'orange';
			out3.innerText = 'null value detected!';
			
		}
	}
});

