
<%-- 
    Document   : person-form
    Created on : Jun 23, 2021, 9:39:44 AM
    Author     : Admin
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  		<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
    	 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
      <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	  
 	 <script src="https://kit.fontawesome.com/a076d05399.js"></script>
     <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
        <title>Trang Chủ</title>
    </head>
    <body>
     <div style="background-color: rgba(235, 179, 212, 0.3); min-width: 100%; height: 100%; ">
		<div class="container-fluid">

			<div class="row">
				<div class="col-md-12 navbar bg-dark">
                    <a  class="logo navbar-brand text-white offset-md-2" href="/">Sơn Hảo Phim</a>
                    <nav class="navbar navbar-light bg-dark">
                    <form class="form-inline" action="/timPhim" method="get">
	                    <input class="form-control mr-sm-2" name="tenPhim" type="search" placeholder="Nhập tên phim..."
	                        aria-label="Tìm tên phim">
	                    <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Tìm kiếm</button>
	                </form>
                    </nav>
                    <ul class="nav">
                
                        <c:choose>
						    <c:when test="${sessionScope.username==null}">
						        <li class="nav-item"><a href="/login" class="nav-link">Đăng Nhập</a></li>

                        		<li class="nav-item"><a href="/showdangki" class="nav-link">Đăng Ký</a></li>
						    </c:when>    
						    <c:otherwise>
						    <li class="nav-item"><a href="/thongtinNd" class="nav-link">${sessionScope.username}</a></li>
						    <li class="nav-item"><a href="/lichSuDatVe" class="nav-link">Lịch Sử Đặt Vé</a></li>
						    <c:choose>
							    <c:when test="${sessionScope.role==2}">
							     	<li class="nav-item"><a href="/admin/phim" class="nav-link">Quản Lý</a></li>
							    </c:when>    
							</c:choose>
						    	
						        <li class="nav-item"><a href="/logout" class="nav-link">Đăng Xuất</a></li>
						       
						    </c:otherwise>
						</c:choose>
						
                        
                        
                        

                    </ul>
                </div>
				
				<!-- slider banner	 -->

				<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel"
					style="min-height: 450px;">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<div class="info">
								<!-- Chèn nooik dung slide 1 -->

							</div>
						</div>
						<div class="carousel-item">
							<div class="info">
								<!-- Chèn nooik dung slide 1 -->

							</div>
						</div>
						<div class="carousel-item">
							<div class="info">
								<!-- Chèn nooik dung slide 1 -->

							</div>
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>

				</div>
			</div>




			<!-- Danh Sách Phim -->
			<div class="m-3">
				<div class="row">
					<div><a href="/"><h2 style="color: blue; font-weight: bold;">Phim Đang Chiếu</h2></a></div>
					<div><a href="/phimsapchieu"><h2 style="color: blue; font-weight: bold;margin-left: 60px">Phim Sắp chiếu</h2></a></div>
					<div><a href="/datve/lichrap"><h2 style="color: blue; font-weight: bold;margin-left: 60px">Phim Theo Rap</h2></a></div>
				</div>
				
				<div class="row">
		 			<c:forEach items="${pdc}" var="pdc">
						
							<div class="col-3" style="font-weight: bold; cursor: pointer;margin-top: 15px">
								<div class="card" style="width: 100%;background-color: antiquewhite;">
									<a href="/kiemtrasuat?idPhim=${pdc.id}"><img class="card-img-top"
										src="${pdc.hinhAnh}"
										alt="Card image cap" style="height: 400px;"></a>
									<div class="card-body">
										<p class="card-text">${pdc.tenPhim}</p>
									</div>
								</div>
							</div>
							
						
						</c:forEach>
				</div>
			</div>


			<!-- Giới thiệu -->
			<div class="mt-5">
				<h3 style="color: blue; font-weight: bold;">Sơn Hảo Phim</h3>
				<p>Sơn Hảo Phim là một trong những công ty tư nhân đầu tiên về điện ảnh được thành lập từ năm 2003, đã
					khẳng định thương hiệu là 1 trong 10 địa điểm vui chơi giải trí được yêu thích nhất. Ngoài hệ thống
					rạp chiếu phim hiện đại, thu hút hàng triệu lượt người đến xem, Galaxy Cinema còn hấp dẫn khán giả
					bởi không khí thân thiện cũng như chất lượng dịch vụ hàng đầu.
					</br></br> Đến website galaxycine.vn, khách hàng sẽ dễ dàng tham khảo các phim hay nhất, phim mới
					nhất
					đang chiếu hoặc sắp chiếu luôn được cập nhật thường xuyên. Lịch chiếu tại tất cả hệ thống rạp chiếu
					phim của Galaxy Cinema cũng được cập nhật đầy đủ hàng ngày hàng giờ trên trang chủ.
					<br> Từ vũ trụ điện ảnh Marvel, người hâm mộ sẽ có cuộc tái ngộ với Người Nhện qua Spider-Man: No
					Way Home hoặc Doctor Strange 2. Ngoài ra 007: No Time To Die, Turning Red, Minions: The Rise Of
					Gru..., là những tác phẩm hứa hẹn sẽ gây bùng nổ phòng vé trong thời gian tới.
					</br></br>Giờ đây đặt vé tại Galaxy Cinema càng thêm dễ dàng chỉ với vài thao tác vô cùng đơn giản.
					Để
					mua vé, hãy vào tab Mua vé. Quý khách có thể chọn Mua vé theo phim, theo rạp, hoặc theo ngày. Sau
					đó, tiến hành mua vé theo các bước hướng dẫn. Chỉ trong vài phút, quý khách sẽ nhận được tin nhắn và
					email phản hồi Đặt vé thành công của Galaxy Cinema. Quý khách có thể dùng tin nhắn lấy vé tại quầy
					vé của Galaxy Cinema hoặc quét mã QR để một bước vào rạp mà không cần tốn thêm bất kỳ công đoạn nào
					nữa. Nếu bạn đã chọn được phim hay để xem, hãy đặt vé cực nhanh bằng box Mua Vé Nhanh ngay từ Trang
					Chủ. Chỉ cần một phút, tin nhắn và email phản hồi của Galaxy Cinema sẽ gửi ngay vào điện thoại và
					hộp mail của bạn.
					</br></br>Nếu chưa quyết định sẽ xem phim mới nào, hãy tham khảo các bộ phim hay trong mục Phim Đang
					Chiếu
					cũng như Phim Sắp Chiếu tại rạp chiếu phim bằng cách vào mục Bình Luận Phim ở Góc Điện Ảnh để đọc
					những bài bình luận chân thật nhất, tham khảo và cân nhắc. Sau đó, chỉ việc đặt vé bằng box Mua Vé
					Nhanh ngay ở đầu trang để chọn được suất chiếu và chỗ ngồi vừa ý
					</br></br> Galaxy Cinema luôn có những chương trình khuyến mãi, ưu đãi, quà tặng vô cùng hấp dẫn như
					giảm
					giá vé, tặng vé xem phim miễn phí, tặng Combo, tặng quà phim… dành cho các khách hàng.
					</br></br> Trang web galaxycine.vn còn có mục Góc Điện Ảnh - nơi lưu trữ dữ liệu về phim, diễn viên
					và
					đạo diễn, những bài viết chuyên sâu về điện ảnh, hỗ trợ người yêu phim dễ dàng hơn trong việc lựa
					chọn phim và bổ sung thêm kiến thức về điện ảnh cho bản thân. Ngoài ra, vào mỗi tháng, Galaxy Cinema
					cũng giới thiệu các phim sắp chiếu hot nhất trong mục Phim Hay Tháng .
					</br></br> Hiện nay, Galaxy Cinema đang ngày càng phát triển hơn nữa với các chương trình đặc sắc,
					các
					khuyến mãi hấp dẫn, đem đến cho khán giả những bộ phim bom tấn của thế giới và Việt Nam nhanh chóng
					và sớm nhất.
				</p>

			</div>




		</div>
		<!-- Phần footer -->
		<div class="card-footer text-muted bg-dark">
			<img src="../resources/img/footer.png" style="width: 100%;" />
		</div>


	</div>
       
    </body>
</html>
