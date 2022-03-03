 $(document).ready(function () {
	let a = $("#datepicker").val()
	$('#datepicker').datepicker({
		uiLibrary: 'bootstrap4',
		format: 'dd/mm/yyyy',
						      		
	}).on("change", function (e) {
			if(a!=$("#datepicker").val()){
				a=$("#datepicker").val();
				ngay =$("#datepicker").val();
				document.getElementById("tlSelect").innerHTML = "";
				document.getElementById("kvSelect").innerHTML = "";
				document.getElementById("rap").innerHTML = "";
				$.ajax({
					type: "Get",
					url: "/datve/lichPhimKV?idPhim="+idPhim+"&ngay="+ngay+"",
					success: function(result) {
						for(let i=0 ; i<result.length ; i ++){
							$("#kvSelect").append(`<option value='${result[i].id}'>${result[i].tenKhuVuc}</option>`);
						
						}
						
						let idkv = $('#kvSelect').find(":selected").val();
						if(idkv!=null){
							myFunctionKv(ngay,idkv)
						}
						
						
					},
					error: function(err) {
						console.log(err)
						alert(err);
					}
				});
				
				
			}
      });
    $('#kvSelect').on('change', function() {
	
		let idkv = $('#kvSelect').find(":selected").val();
		
		document.getElementById("rap").innerHTML = "";
		document.getElementById("tlSelect").innerHTML = "";
		let ngay = $('#datepicker').val();
		myFunctionKv(ngay,idkv)	
		
	})
	function myFunctionKv(ngay,idkv) {
			$.ajax({
			type: "Get",
			url: "/datve/lichPhimTlThayDoi?idPhim="+idPhim+"&ngay="+ngay+"&idKv="+idkv+"",
			success: function(result) {
				for(let i=0 ; i<result.length ; i ++){
					$("#tlSelect").append(`<option value='${result[i].id}'>${result[i].ten}</option>`);
				
				}
				let tl = $('#tlSelect').find(":selected").val();
				$.ajax({
						type: "Get",
						url: "/datve/lichPhimRapThayDoi?idPhim="+idPhim+"&idTl="+tl+""+"&ngay="+ngay+"&idKv="+idkv+"",
					
						success: function(result1) {
							for(let i=0 ; i<result1.length ; i ++){
								$("#rap").append(`<div class="card-header" >
                                  ${result1[i].tenRap}
                                </div>
                                <div class="card-body">
                                  <h5 class="card-title"></h5>
                                 
                                  <div class="row" style="margin-left: 10px;" id='suatchieu${result1[i].id}' >
                           
                                    
                                    
                                  </div>
                               

                                  
                                </div>`);
							
							}
							$.ajax({
								type: "Get",
								url: "/datve/lichPhimSuatThayDoi?idPhim="+idPhim+"&idTl="+tl+"&ngay="+ngay+"&idKv="+idkv+"",
								
								success: function(result2) {
									for(let i=0 ; i<result1.length ; i ++){
										for(let j=0 ; j<result2.length ; j ++){
										
											if(result1[i].id == result2[j].idRap){
												$(`#suatchieu${result1[i].id}`).append(`<a href="/datve/suat?id=${result2[j].id}" class="btn btn-warning" style="margin-left: 10px; width: 70px; margin: 4px;">${result2[j].gioBatDau}</a>`)
											}
										
										}
									
									}
								},
								error: function(err) {
									console.log(err)
									alert(err);
								}
							});
						},
						error: function(err) {
							console.log(err)
							alert(err);
						}
					});
			},
			error: function(err) {
				console.log(err)
				alert(err);
			}
		});
	}
	
	$('#tlSelect').on('change', function() {
		let tl = $('#tlSelect').find(":selected").val();
		document.getElementById("rap").innerHTML = "";
		let ngay = $('#datepicker').val();
		let idkv = $('#kvSelect').find(":selected").val();
		
		myFunction(tl, ngay,idkv);
	});
	function myFunction(tl, ngay,idkv) {
	   $.ajax({
				type: "Get",
				url: "/datve/lichPhimRapThayDoi?idPhim="+idPhim+"&idTl="+tl+"&ngay="+ngay+"&idKv="+idkv+"",
					
				success: function(result1) {
							for(let i=0 ; i<result1.length ; i ++){
								$("#rap").append(`<div class="card-header" >
                                  ${result1[i].tenRap}
                                </div>
                                <div class="card-body">
                                  <h5 class="card-title"></h5>
                                 
                                  <div class="row" style="margin-left: 10px;" id='suatchieu${result1[i].id}' >
                           
                                    
                                    
                                  </div>
                               

                                  
                                </div>`);
							
							}
							$.ajax({
								type: "Get",
								url: "/datve/lichPhimSuatThayDoi?idPhim="+idPhim+"&idTl="+tl+"&ngay="+ngay+"&idKv="+idkv+"",
								
								success: function(result2) {
									for(let i=0 ; i<result1.length ; i ++){
										for(let j=0 ; j<result2.length ; j ++){
										
											if(result1[i].id == result2[j].idRap){
												$(`#suatchieu${result1[i].id}`).append(`<a href="/datve/suat?id=${result2[j].id}" class="btn btn-warning" style="margin-left: 10px; width: 70px; margin: 4px;">${result2[j].gioBatDau}</a>`)
											}
										
										}
									
									}
								},
								error: function(err) {
									console.log(err)
									alert(err);
								}
							});
						},
						error: function(err) {
							console.log(err)
							alert(err);
						}
					});
	}

})

