
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
    
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
        <link href="<c:url value="/resources/css/datve.css"/>" rel="stylesheet" type="text/css">
      
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js">
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    	 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
      <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
     <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
    	<script type="text/javascript" src="<c:url value="/resources/js/datve.js"/>"></script>
        <title>Admin</title>
    </head>
    <style>

    
    </style>

    <body>
   		<!-- navbar -->
    <div class="col-md-12 navbar bg-dark">
        <a href="index.html" class="logo navbar-brand text-white offset-md-2">Sơn Hảo Phim</a>
        <ul class="nav">
            <li class="nav-item"><a href="/home" class="nav-link">Trang chủ</a></li>
            <li class="nav-item"><a href="/home" class="nav-link">Đăng Xuất</a></li>


        </ul>
    </div>

    <!-- Chia layout -->
    <div class="container-fluid mt-3">
        <div class="row">

            <!-- Hình ảnh phim -->
            <div class="col-3" style="font-weight: bold;">
                <div class="card" style="width: 100%; background-color: antiquewhite;">
                    <img class="card-img-top" src="/resources/img/avanger.jpg" alt="Card image cap" style="height: 500px;">
                    <div class="card-body">
                        <p class="card-text">Lootte Gò Vấp - AVANGER</p>
                        <p class="card-text">Ngày Chiếu:...</p>
                        <p class="card-text">Giờ Chiếu:...</p>
                    </div>
                </div>
            </div>
			
            <!-- Đặt vé -->
            <div class="col-5">
                <h3 class="text-center" style="background-color: green; color: aliceblue; height: 40px; width: 97%;">Màn
                    Hình</h3>

                <div class="m-3">
					<div class="container">
                    <!-- Hàng A -->
                    <div class="m-2 text-center">
                    	<c:forEach items="${h}" var="h">
									<c:choose>
									    <c:when test="${h.viTriCot==0}">
									   	 <c:choose>
									         <c:when test = "${h.viTriHang=='A'}">
									         <div class="row">
									         		 
					        						<div class="seat" >${ h.viTriHang}${ h.viTriCot}</div>
											    
									         </c:when>
									         
									         <c:otherwise>
									            </div>
											    <div class="row">
											    	
											    	<div class="seat" >${ h.viTriHang}${ h.viTriCot}</div>
											   
									         </c:otherwise>
									      </c:choose>
							
									    </c:when>    
									    <c:otherwise>
									  			<div class="seat" >${ h.viTriHang}${ h.viTriCot}</div>
									  			
									    </c:otherwise>
								</c:choose> 
						
						</c:forEach>
                    	
                      
                    	

                    </div>
                    
				

                    <div class="row mt-5 text-center">

                        <div class="col-4">
                        	<div class="row">
                        		 <div class="seat occupied "> </div><p> Đã có người đặt</p>
                        	</div>
                           

                        </div>
                        <div class="col-4">
                            <div class="row">
                        		 <div class="seat " > </div><p> Ghế còn trống</p>
                        	</div>

                        </div>

                    </div>
				</div>

                </div>

            </div>
 			</div>

            <!-- Hóa đơn -->
            <div class="col-4">
                <div class="card" style="width: 100%; background-color: antiquewhite;">
                    <img class="card-img-top" src="/resources/img/avanger.jpg" alt="Card image cap">
                    <div class="card-body">
                        <p class="card-text" style="font-weight: bold;">AVANGER</p>
                        <p class="card-text">Rạp: Lotte Gò Vấp</p>
                        <p class="card-text">Suất Chiếu: 15h | Thứ 7, ngày 26 tháng 2 năm 2022</p>
                        <div class="row" style="margin-left:0.5px">
                       		 Ghế:<p class="card-text" id="tenGhe"> </p>
                        </div>
                        
                       
                       Tổng Tiền: <p class="card-text"  id="gia"> 0 </p>(vnd)

                        <div class="text-center mt-5">
                            <button type="button" class="btn btn-danger m-3"
                                style="width: 150px; height: 50px; font-weight: bold;">Quay Lại</button>
                            <button type="button" class="btn btn-warning"
                                style="width: 150px; height: 50px; font-weight: bold;">Thanh Toán</button>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

   
    </body>
</html>
