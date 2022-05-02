 $(document).ready(function () {
	const container = document.querySelector('.container');
    const gia = document.getElementById('gia');
    const ghes=document.querySelectorAll('.row .seat');
    const giave1suat =  $('#gia1Suat').val();
    let soGheDaChon=0;
	const populateUI = () => {
		const idSuat1 = localStorage.getItem('idSuat');
		if(idSuat1!=idSuat){
			localStorage.setItem('gheNgoi', "");
		  	localStorage.setItem('idSuat', "");
		  	localStorage.setItem('gia', '');
		  	localStorage.setItem('tenGhe','');
		}else{
			const gheChons = JSON.parse(localStorage.getItem('gheNgoi'));
			  const gia = document.getElementById('gia');
			  const tenGhe = document.getElementById('tenGhe');
			  soGheDaChon=gheChons.length
			  if (gheChons !== null && gheChons.length > 0) {
			    ghes.forEach((ghe, index) => {
			      if (gheChons.indexOf(index) > -1) {
			        ghe.classList.add('selected');
			      }
			    });
			  }
			  const gia1 = localStorage.getItem('gia');
			  gia.innerText = gia1 ;
			  const tenGhe1 = localStorage.getItem('tenGhe');
			  tenGhe.innerText = tenGhe1;
			  
		}
	  
	};
	populateUI();
	$(document).on("click","#btnThanhToan",function(e){
	 	const gia = $('#gia').text().trim();
		if( gia==0){
	    	alert('Vui Lòng Chọn ghế trước khi thanh toán.');
	    	return false;
	    }
	    else{
	    	const gheChons = JSON.parse(localStorage.getItem('gheNgoi'));
	    	$.ajax({
				type: "Get",
				url: "/chonve/vitridatve?vitri="+gheChons+"&&idSuat="+idSuat+"",
			
				success: function(result) {
					for(let i=0 ; i<result.length ; i ++){	
					}
					
				},
				error: function(err) {
					console.log(err)
					alert(err);
				}
			});
			return true;
			
	    }
	    
	    
	});
    container.addEventListener('click',e =>{
    		if(e.target.classList.contains('seat')&&
    			!e.target.classList.contains('occupied')){
					if((soGheDaChon+1)<=8){
						e.target.classList.toggle('selected');
					}else{
						if(e.target.classList.contains('selected')){
							e.target.classList.toggle('selected');
							
						}else{
							alert("Chi Dược chọn tối đa "+(soGheDaChon)+" vé")
						}
					}
					
				
    		}
    		  
    		 update();
    		
    })
    const update = () => {
		
	  	const gheDaChon = document.querySelectorAll('.row .selected');
		document.getElementById("tenGhe").innerHTML = ""
	  	const seatsIndex = [...gheDaChon].map(gheNgoi => [...ghes].indexOf(gheNgoi));
		$.ajax({
			type: "Get",
			url: "/chonve/vitridatve?vitri="+seatsIndex+"&&idSuat="+idSuat+"",
		
			success: function(result) {
				for(let i=0 ; i<result.length ; i ++){
					$("#tenGhe").append(`${result[i].viTriHang}${result[i].viTriCot}	`);
				}
				 const tenGhe = $('#tenGhe').text();
				 localStorage.setItem('tenGhe',"");
				 localStorage.setItem('tenGhe',tenGhe);
				
			},
			error: function(err) {
				console.log(err)
				alert(err);
			}
		});
	   soGheDaChon = gheDaChon.length;
	
	 gia.innerText = soGheDaChon*giave1suat;
	 const gia1 = $('#gia').text();
	 	localStorage.setItem('gheNgoi', JSON.stringify(seatsIndex));
	  	localStorage.setItem('idSuat', idSuat);
	  	localStorage.setItem('gia', gia1);
	};
	
	
});