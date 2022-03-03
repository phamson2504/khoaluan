
let date = new Date();
let date1 = new Date();

	date.setMonth(date.getMonth()+1);
	

	
	var ngay1 = `${haha.getDate()+"/"+haha.getMonth()+"/"+haha.getFullYear()}`;
	console.log(ngay1);
  	for(var i =0 ; i<10 ; i++){
	var ngay = `${date.getDate()+"/"+date.getMonth()+"/"+date.getFullYear()}`;
	var test = `${date.getFullYear()+"/"+date.getMonth()+"/"+date.getDate()}`;
	  if(ngay==ngay1){
		$("#nava").append(`<li class="nav-item">
	    <a class="nav-link active"   href="/ngay?h=${test}" id="ngay">${ngay}</a>
	  </li>`);
		}else{
		$("#nava").append(`<li class="nav-item">
	    <a class="nav-link"  href="/ngay?h=${test}" id="ngay">${ngay}</a>
	  </li>`);
		}
	
   date.setDate(date.getDate()+1);
	}
	
		$.ajax({
				url: "/xuat",
                type: "get",
				success : function(data) {
				console.log(data)
				
				for(var i=0 ; i <data.length ; i++){
					
					if(i==0){
						$("#contain").append(`
						<div id='${data[i].ten}'>${data[i].ten}</div>		
					`)
					}
					else if(i>0&&data[i].ten!=data[i-1].ten){
						$("#contain").append(`
						<div id='${data[i].ten}'>${data[i].ten}</div>
							
						`)
					}else{
						document.getElementById(`${data[i].ten}`).append(` ${data[i].ten}`);
					}
					
				}
				
					
				},
				error : function(e) {
					 alert("errr"+e);
				},
				
			});
			var conceptName = $('#cars').find(":selected").text();
			alert(conceptName);
		$("#cars").on("change", function () {
			var a = this.value
			var conceptName = $('#cars').find(":selected").text();
			alert(conceptName);
		})
	

	
	