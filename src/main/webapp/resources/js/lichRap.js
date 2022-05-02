 $(document).ready(function () {
	let a = $("#datepicker").val()
	$('#datepicker').datepicker({
		uiLibrary: 'bootstrap4',
		format: 'dd/mm/yyyy',
						      		
	}).on("change", function (e) {
			if(a!=$("#datepicker").val()){
				a=$("#datepicker").val();
				ngay =$("#datepicker").val();
			
				$.ajax({
					type: "Get",
					url: "/datve/ngayLichRap?ngay="+ngay+"",
					success: function(result) {
						window.location.href = "/datve/ngayLichRap?ngay="+ngay+"";
					},
					error: function(err) {
						console.log(err)
						alert(err);
					}
				});
				
			}
	});
	$('#tlSelect').on('change', function() {
		let idRap = $('#rapSelect').find(":selected").val();
		document.getElementById("phim").innerHTML = "";
		let idTl = $('#tlSelect').find(":selected").val();
		let idkv = $('#kvSelect').find(":selected").val();
		let ngay = $('#datepicker').val();
		$.ajax({
			type: "Get",
			url: "/datve/tlLichRap?ngay="+ngay+"&idRap="+idRap+"&idTl="+idTl+"&idKv="+idkv+"",
			success: function(result1) {
					window.location.href = "/datve/tlLichRap?ngay="+ngay+"&idRap="+idRap+"&idTl="+idTl+"&idKv="+idkv+"";			
								
			},
			error: function(err) {
					console.log(err)
					alert(err);
			}
	});
		
	})
	$('#rapSelect').on('change', function() {
		
		let ngay = $('#datepicker').val();
		let idkv = $('#kvSelect').find(":selected").val();
		let idRap = $('#rapSelect').find(":selected").val();
				$.ajax({
					type: "Get",
					url: "/datve/rapLichRap?ngay="+ngay+"&idRap="+idRap+"&idKv="+idkv+"",
					success: function(result) {
						window.location.href = "/datve/rapLichRap?ngay="+ngay+"&idRap="+idRap+"&idKv="+idkv+"";
					},
					error: function(err) {
						console.log(err)
						alert(err);
					}
				});
		
		
	})
	$('#kvSelect').on('change', function() {
	
		let idkv = $('#kvSelect').find(":selected").val();
		let ngay = $('#datepicker').val();
		
		funcionKv(idkv,ngay);
		
		
	})
	function funcionKv(idkv,ngay){
		$.ajax({
			type: "Get",
			url: "/datve/kvLichRap?ngay="+ngay+"&idKv="+idkv+"",
			success: function(result) {
				window.location.href = "/datve/kvLichRap?ngay="+ngay+"&idKv="+idkv+"";
			},
			error: function(err) {
				console.log(err)
				alert(err);
			}
		});
	}
})