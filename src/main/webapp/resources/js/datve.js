 $(document).ready(function () {
    	const container = document.querySelector('.container');
    	const gia = document.getElementById('gia');
    	const gheConTrong=document.querySelectorAll('.row .seat:not(.occupied)');
    	let soGheDaChon=0;
    	container.addEventListener('click',e =>{
    		if(e.target.classList.contains('seat')&&
    			!e.target.classList.contains('occupied')&& soGheDaChon<8){
					e.target.classList.toggle('selected');
				
    		}else{
				if(e.target.classList.contains('selected')){
					e.target.classList.toggle('selected');
				}else{
					alert("Chi Dược chọn tối đa 8 vé")
				}
			}
    		   update();
    		
    		
    	})
    	const update = () => {
	  	const gheDaChon = document.querySelectorAll('.row .selected');
		document.getElementById("tenGhe").innerHTML = ""
	  	const seatsIndex = [...gheDaChon].map(gheNgoi => [...gheConTrong].indexOf(gheNgoi));
		$.ajax({
			type: "Get",
			url: "/vitridatve?vitri="+seatsIndex+"",
		
			success: function(result) {
				for(let i=0 ; i<result.length ; i ++){
					
					$("#tenGhe").append(`${result[i].viTriHang}${result[i].viTriCot}	`);
				}
			},
			error: function(err) {
				console.log(err)
				alert(err);
			}
		});
	
	   soGheDaChon = gheDaChon.length;
	
	 gia.innerText = soGheDaChon;
	};
});