	let data1 = ["a1","a2","a3"];
	let a;
	
		$.ajax({
				url: "/api/hang",
                type: "get",
				success : function(data) {
					for(var i = 0; i<data.length ;i++){
						for(var j = 0; j<data[i].cot ;j++){
							
							$("p").append(`<input type="checkbox" id="${data[i].hang}${j}" value="${data[i].hang}${j}" > ${data[i].hang}${j}` );
							
						}
						
							
						$("p").append("</br>");
					}
				for(var k = 0 ; k < data1.length ; k ++){
					let test = document.getElementById(data1[k]).disabled = true;
					console.log(test)
				}
					
				},
				error : function(e) {
					 alert("errr"+e);
				},
				
			});
			
