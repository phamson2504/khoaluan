 $(document).ready(function () {

	$('.rate input').change(
	  function() {
		var soSao = this.value;
		
		if($('#tenND').val() !=""){
			$.ajax({
					type: "Get",
					url: "/datve/kTraDG?idPhim="+idPhim+"",
					success: function(result) {
						 if(result==0){
							alert("không thể đánh giá");
							$('#star1').prop('checked', false);
							$('#star2').prop('checked', false);
							$('#star3').prop('checked', false);
							$('#star4').prop('checked', false);
							$('#star5').prop('checked', false);
						}else{
							$.ajax({
										type: "Get",
										url: "/datve/saveDGP?idPhim="+idPhim+"&soSao="+soSao+"",
										success: function(result) {
											 $("#danhgiaS").html("")
											 $("#danhgiaS").append(`${result.saoTB}/10 (${result.soLuong})`)
										},
										error: function(err) {
											console.log(err)
											alert(err);
										}
							});
							
						}
					},
					error: function(err) {
						console.log(err)
						alert(err);
					}
		});
		}else{
			alert("Đăng nhập để đánh giá phim");
			$('#star1').prop('checked', false);
			$('#star2').prop('checked', false);
			$('#star3').prop('checked', false);
			$('#star4').prop('checked', false);
			$('#star5').prop('checked', false);
		}
		
	
	  }
	)	
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
					url: "/datve/lichPhim?idPhim="+idPhim+"&ngay="+ngay+"",
					success: function(result) {
						window.location.href = "/datve/lichPhim?idPhim="+idPhim+"&ngay="+ngay+"";
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
		$.ajax({
			type: "Get",
			url: "/datve/lichPhimKvThayDoi?idPhim="+idPhim+"&ngay="+ngay+"&idKv="+idkv+"",
			success: function(result) {
				window.location.href = "/datve/lichPhimKvThayDoi?idPhim="+idPhim+"&ngay="+ngay+"&idKv="+idkv+"";
			},
			error: function(err) {
				console.log(err)
				alert(err);
			}
		});	
		
	})
	
	$('#tlSelect').on('change', function() {
		let tl = $('#tlSelect').find(":selected").val();
		document.getElementById("rap").innerHTML = "";
		let ngay = $('#datepicker').val();
		let idkv = $('#kvSelect').find(":selected").val();
		$.ajax({
				type: "Get",
				url: "/datve/lichPhimTlThayDoi?idPhim="+idPhim+"&idTl="+tl+"&ngay="+ngay+"&idKv="+idkv+"",
				success: function(result1) {
						window.location.href = "/datve/lichPhimTlThayDoi?idPhim="+idPhim+"&idTl="+tl+"&ngay="+ngay+"&idKv="+idkv+"";
				},
				error: function(err) {
					console.log(err)
					alert(err);
				}
		});
	});

})

