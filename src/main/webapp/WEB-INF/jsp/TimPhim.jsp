
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
        <title>Phim Sắp Chiếu</title>
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
						    <li class="nav-item"><a href="/showdangki" class="nav-link">${sessionScope.username}</a></li>
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
		 			<c:forEach items="${p}" var="p">
						
							<div class="col-3" style="font-weight: bold; cursor: pointer;margin-top: 15px">
								<div class="card" style="width: 100%;background-color: antiquewhite;">
									<a href="/kiemtrasuat?idPhim=${p.id}"><img class="card-img-top"
										src="${p.hinhAnh}"
										alt="Card image cap" style="height: 400px;"></a>
									<div class="card-body">
										<p class="card-text">${p.tenPhim}</p>
									</div>
								</div>
							</div>
							
						
						</c:forEach>
				</div>
			</div>


			<!-- Giới thiệu -->




		</div>
		<!-- Phần footer -->
		<div class="card-footer text-muted bg-dark">
			<img src="../resources/img/footer.png" style="width: 100%;" />
		</div>


	</div>
       
    </body>
</html>
