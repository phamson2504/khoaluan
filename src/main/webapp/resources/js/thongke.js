 $(document).ready(function() {
	$( "#tk" ).on( "click", function() {
		 var nam =$( "#nam" ).val();
		 $.ajax({
			type : 'GET',
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
			url : '/admin/theoNam?nam='+nam+'',
			success : function(result) {
				google.charts.load('current', {
					'packages' : [ 'corechart' ]
				});
				google.charts.setOnLoadCallback(function() {
					drawPieChart(result);
				
				});
			}
		});
		$.ajax({
			type : 'GET',
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
			url : '/admin/sltheoNam?nam='+nam+'',
			success : function(result) {
				google.charts.load('current', {
					'packages' : [ 'corechart' ]
				});
				google.charts.setOnLoadCallback(function() {
			
					drawbarChart(result);
				});
			}
		});
		$.ajax({
			type : 'GET',
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
			url : '/admin/phimTheoNam?nam='+nam+'',
			success : function(result) {
				google.charts.load('current', {
					'packages' : [ 'corechart' ]
				});
				google.charts.setOnLoadCallback(function() {
			
					drawPieChartPhim(result);
				});
			}
		});
		$.ajax({
			type : 'GET',
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
			url : '/admin/slPhimtheoNam?nam='+nam+'',
			success : function(result) {
				google.charts.load('current', {
					'packages' : [ 'corechart' ]
				});
				google.charts.setOnLoadCallback(function() {
			
					drawbarChartPhim(result);
				});
			}
		});
	});
	
 	$('#thongke').on('change', function() {
		let thongke = $('#thongke').find(":selected").val();
		if(thongke==1){
			$('#thaotac').html("")
			$('#thaotac').append(`
				
				<label for="formGroupExampleInput" class="col-sm-2 col-form-label">Ngày bắt đầu</label>
				<div class="col-sm-2" style="margin-left:-100px">
					<input id="datepicker" path="ngayChieu" class="form-control"  type="text" />
				</div>
				<label for="formGroupExampleInput" class="col-sm-2 col-form-label">Ngày kết thúc</label>
				<div class="col-sm-2" style="margin-left:-100px">
					<input id="datepicker2" path="ngayChieu" class="form-control"  type="text" />
				</div>
				<div class="col-sm-2"  style="margin-left:50px">
					<a id="tk" type="submit" class="btn btn-primary">Thống kê</a>
				</div>
				
				`)
				$( "#tk" ).on( "click", function() {
				   var ngay1 = $( "#datepicker" ).val();
				   var ngay2 = $( "#datepicker2" ).val();
				   $.ajax({
						type : 'GET',
						headers : {
							Accept : "application/json; charset=utf-8",
							"Content-Type" : "application/json; charset=utf-8"
						},
						url : '/admin/theoNgay?ngay1='+ngay1+'&&ngay2='+ngay2+'',
						success : function(result) {
							google.charts.load('current', {
								'packages' : [ 'corechart' ]
							});
							google.charts.setOnLoadCallback(function() {
								drawPieChart(result);
							
							});
						}
					});
					$.ajax({
						type : 'GET',
						headers : {
							Accept : "application/json; charset=utf-8",
							"Content-Type" : "application/json; charset=utf-8"
						},
						url : '/admin/sltheoNgay?ngay1='+ngay1+'&&ngay2='+ngay2+'',
						success : function(result) {
							google.charts.load('current', {
								'packages' : [ 'corechart' ]
							});
							google.charts.setOnLoadCallback(function() {
						
								drawbarChart(result);
							});
						}
					});
					$.ajax({
						type : 'GET',
						headers : {
							Accept : "application/json; charset=utf-8",
							"Content-Type" : "application/json; charset=utf-8"
						},
						url : '/admin/phimtheoNgay?ngay1='+ngay1+'&&ngay2='+ngay2+'',
						success : function(result) {
							google.charts.load('current', {
								'packages' : [ 'corechart' ]
							});
							google.charts.setOnLoadCallback(function() {
						
								drawPieChartPhim(result);
							});
						}
					});
					$.ajax({
						type : 'GET',
						headers : {
							Accept : "application/json; charset=utf-8",
							"Content-Type" : "application/json; charset=utf-8"
						},
						url : '/admin/slphimtheoNgay?ngay1='+ngay1+'&&ngay2='+ngay2+'',
						success : function(result) {
							google.charts.load('current', {
								'packages' : [ 'corechart' ]
							});
							google.charts.setOnLoadCallback(function() {
						
								drawbarChartPhim(result);
							});
						}
					});
				   
				});
			$(function() {
		 		$("#datepicker").datepicker({ 
		 			uiLibrary: 'bootstrap4',
		 			format: 'dd/mm/yyyy',
					autoclose: true,         
					todayHighlight: true 
				}).datepicker();
				$("#datepicker2").datepicker({ 
		 			uiLibrary: 'bootstrap4',
		 			format: 'dd/mm/yyyy',
					autoclose: true,         
					todayHighlight: true 
				}).datepicker();
		 		});
			}
			else if(thongke==2){
				$('#thaotac').html("")
				$('#thaotac').append(`
					
					<label for="formGroupExampleInput" class="col-sm-2 col-form-label">Tháng</label>
					<div class="col-sm-2" style="margin-left:-170px">
						<input id="thang" class="form-control"  type="text" />
					</div>
					<label for="formGroupExampleInput" class="col-sm-2 col-form-label">Năm</label>
					<div class="col-sm-2" style="margin-left:-170px">
						<input id="nam" class="form-control"  type="text" />
					</div>
					<div class="col-sm-2"  style="margin-left:50px">
						<a id="tk" type="submit" class="btn btn-primary">Thống kê</a>
					</div>
					
					`)
				$( "#tk" ).on( "click", function() {
				  var nam = $( "#nam" ).val()
				  var thang =$( "#thang" ).val()
				  $.ajax({
						type : 'GET',
						headers : {
							Accept : "application/json; charset=utf-8",
							"Content-Type" : "application/json; charset=utf-8"
						},
						url : '/admin/theothang?thang='+thang+'&&nam='+nam+'',
						success : function(result) {
							google.charts.load('current', {
								'packages' : [ 'corechart' ]
							});
							google.charts.setOnLoadCallback(function() {
								drawPieChart(result);
							
							});
						}
					});
					$.ajax({
						type : 'GET',
						headers : {
							Accept : "application/json; charset=utf-8",
							"Content-Type" : "application/json; charset=utf-8"
						},
						url : '/admin/sltheothang?thang='+thang+'&&nam='+nam+'',
						success : function(result) {
							google.charts.load('current', {
								'packages' : [ 'corechart' ]
							});
							google.charts.setOnLoadCallback(function() {
						
								drawbarChart(result);
							});
						}
					});
					$.ajax({
						type : 'GET',
						headers : {
							Accept : "application/json; charset=utf-8",
							"Content-Type" : "application/json; charset=utf-8"
						},
						url : '/admin/phimtheoThang?thang='+thang+'&&nam='+nam+'',
						success : function(result) {
							google.charts.load('current', {
								'packages' : [ 'corechart' ]
							});
							google.charts.setOnLoadCallback(function() {
						
								drawPieChartPhim(result);
							});
						}
					});
					$.ajax({
						type : 'GET',
						headers : {
							Accept : "application/json; charset=utf-8",
							"Content-Type" : "application/json; charset=utf-8"
						},
						url : '/admin/slphimtheothang?thang='+thang+'&&nam='+nam+'',
						success : function(result) {
							google.charts.load('current', {
								'packages' : [ 'corechart' ]
							});
							google.charts.setOnLoadCallback(function() {
						
								drawbarChartPhim(result);
							});
						}
					});
				});
			}else{
				$('#thaotac').html("")
				$('#thaotac').append(`
					<label for="formGroupExampleInput" class="col-sm-2 col-form-label">Năm</label>
					<div class="col-sm-2" style="margin-left:-170px">
						<input id="nam" class="form-control"  type="text" />
					</div>
					<div class="col-sm-2"  style="margin-left:50px">
						<a id="tk" type="submit" class="btn btn-primary">Thống kê</a>
					</div>
				`);
				 $( "#tk" ).on( "click", function() {
				  var nam =$( "#nam" ).val();
					$.ajax({
						type : 'GET',
						headers : {
							Accept : "application/json; charset=utf-8",
							"Content-Type" : "application/json; charset=utf-8"
						},
						url : '/admin/theoNam?nam='+nam+'',
						success : function(result) {
							google.charts.load('current', {
								'packages' : [ 'corechart' ]
							});
							google.charts.setOnLoadCallback(function() {
								drawPieChart(result);
							
							});
						}
					});
					$.ajax({
						type : 'GET',
						headers : {
							Accept : "application/json; charset=utf-8",
							"Content-Type" : "application/json; charset=utf-8"
						},
						url : '/admin/sltheoNam?nam='+nam+'',
						success : function(result) {
							google.charts.load('current', {
								'packages' : [ 'corechart' ]
							});
							google.charts.setOnLoadCallback(function() {
						
								drawbarChart(result);
							});
						}
					});
					$.ajax({
						type : 'GET',
						headers : {
							Accept : "application/json; charset=utf-8",
							"Content-Type" : "application/json; charset=utf-8"
						},
						url : '/admin/phimTheoNam?nam='+nam+'',
						success : function(result) {
							google.charts.load('current', {
								'packages' : [ 'corechart' ]
							});
							google.charts.setOnLoadCallback(function() {
						
								drawPieChartPhim(result);
							});
						}
					});
					$.ajax({
						type : 'GET',
						headers : {
							Accept : "application/json; charset=utf-8",
							"Content-Type" : "application/json; charset=utf-8"
						},
						url : '/admin/slPhimtheoNam?nam='+nam+'',
						success : function(result) {
							google.charts.load('current', {
								'packages' : [ 'corechart' ]
							});
							google.charts.setOnLoadCallback(function() {
						
								drawbarChartPhim(result);
							});
						}
					});
				});
				
			}
		
	});
	

		function drawPieChart(result) {

			var data = new google.visualization.DataTable();
			data.addColumn('string', 'Name');
			data.addColumn('number', 'Quantity');
			var dataArray = [];
			$.each(result, function(i, obj) {
				dataArray.push([ obj.string, obj.gia]);
			});

			data.addRows(dataArray);

			var piechart_options = {
				title : 'Thống kê doanh số',
				width : 500,
				height : 300
			};
			var piechart = new google.visualization.PieChart(document
					.getElementById('piechart_div'));
			piechart.draw(data, piechart_options);
		}
		function drawPieChartPhim(result) {

			var data = new google.visualization.DataTable();
			data.addColumn('string', 'Name');
			data.addColumn('number', 'Quantity');
			var dataArray = [];
			$.each(result, function(i, obj) {
				dataArray.push([ obj.string, obj.gia]);
			});

			data.addRows(dataArray);

			var piechart_options = {
				title : 'Thống kê doanh số',
				width : 500,
				height : 300
			};
			var piechart = new google.visualization.PieChart(document
					.getElementById('piechartphim_div'));
			piechart.draw(data, piechart_options);
		}
		function drawbarChart(result) {

			var data = new google.visualization.DataTable();
			data.addColumn('string', 'Name');
			data.addColumn('number', 'số vé');
			var dataArray = [];
			$.each(result, function(i, obj) {
				dataArray.push([ obj.string, obj.soLuong]);
			});

			data.addRows(dataArray);

			var barchart_options = {
				title : 'thống kê số lượng',
				width : 500,
				height : 300,
				legend : 'none'
			};
			var barchart = new google.visualization.BarChart(document
					.getElementById('barchart_div'));
			barchart.draw(data, barchart_options);
		}
		function drawbarChartPhim(result) {

			var data = new google.visualization.DataTable();
			data.addColumn('string', 'Name');
			data.addColumn('number', 'số vé');
			var dataArray = [];
			$.each(result, function(i, obj) {
				dataArray.push([ obj.string, obj.soLuong]);
			});

			data.addRows(dataArray);

			var barchart_options = {
				title : 'thống kê số lượng',
				width : 500,
				height : 300,
				legend : 'none'
			};
			var barchart = new google.visualization.BarChart(document
					.getElementById('barchartphim_div'));
			barchart.draw(data, barchart_options);
		}

});