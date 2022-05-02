
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
        <title>Đặt Vé</title>
    </head>
    <script type="text/javascript">
    	var idSuat = ${s.id}
    </script>

    <body>
   		<!-- navbar -->
    <div class="col-md-12 navbar bg-dark">
        <a href="/" class="logo navbar-brand text-white offset-md-2">Sơn Hảo Phim</a>
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

    <!-- Chia layout -->
    <div class="container-fluid mt-3">
        <div class="row">

            <!-- Hình ảnh phim -->
            <div class="col-3" style="font-weight: bold;">
                <div class="card" style="width: 100%; background-color: antiquewhite;">
                    <img class="card-img-top" src="${anh}" alt="Card image cap" style="height: 500px;">
                    <div class="card-body">
                        <p class="card-text">${s.tenRap} - ${s.tenPhim}</p>
                        <p class="card-text">Ngày Chiếu: ${s.ngayChieu}</p>
                        <p class="card-text">Giờ Chiếu:${s.gioBatDau}</p>
                        
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
                    <c:choose>
					    <c:when test="${hetTG==true}">
					   		<h1>Suất đã hết thời gian có thể đặt</h1>
					    </c:when>    
					    <c:otherwise>
							<c:forEach items="${h}" var="h">
									<c:choose>
									    <c:when test="${h.viTriCot==0}">
									   	 <c:choose>
									         <c:when test = "${h.viTriHang=='A'}">
									         <div class="row">
									         		 <c:choose>
													    <c:when test="${h.daDat==true}">
													    	<div class="seat">${ h.viTriHang}${ h.viTriCot}</div>
													    </c:when>    
													    <c:otherwise>
													    	<div class="seat occupied" >${ h.viTriHang}${ h.viTriCot}</div>
													    </c:otherwise>
													</c:choose>
					        						
											    
									         </c:when>
									         
									         <c:otherwise>
									            </div>
											    <div class="row">
											    	
											    	<c:choose>
													    <c:when test="${h.daDat==true}">
													    	<div class="seat" >${ h.viTriHang}${ h.viTriCot}</div>
													    </c:when>    
													    <c:otherwise>
													    	<div class="seat occupied" >${ h.viTriHang}${ h.viTriCot}</div>
													    </c:otherwise>
													</c:choose>
											   
									         </c:otherwise>
									      </c:choose>
							
									    </c:when>    
									    <c:otherwise>
									  			<c:choose>
													    <c:when test="${h.daDat==true}">
													    	<div class="seat" >${ h.viTriHang}${ h.viTriCot}</div>
													    </c:when>    
													    <c:otherwise>
													    	<div class="seat occupied" >${ h.viTriHang}${ h.viTriCot}</div>
													    </c:otherwise>
													</c:choose>
									  			
									    </c:otherwise>
								</c:choose> 
						
						</c:forEach>
                    	 </div>
                    	 <div class="row mt-5 text-center">

                        <div class="col-6">
                        	<div class="row">
                        		 <div class="seat occupied "> </div><p> Đã có người đặt</p>
                        	</div>
                           

                        </div>
                        <div class="col-6">
                            <div class="row">
                        		 <div class="trong" > </div><p> Ghế còn trống</p>
                        	</div>

                        </div>

                    </div>
					    </c:otherwise>
					     
					</c:choose>
                    	
                     
                    	

                
                    
				

                    
				</div>

                </div>

            </div>
 			</div>

            <!-- Hóa đơn -->
            <div class="col-4">
                <div class="card" style="width: 100%; background-color: antiquewhite;">
                    <img class="card-img-top" src="${anh}" alt="Card image cap" style="height: 500px;">
                    <div class="card-body">
                        <p class="card-text" style="font-weight: bold;">${s.tenPhim}</p>
                        <p class="card-text">Rạp: ${s.tenRap}</p>
                        <p class="card-text">Suất Chiếu: ${s.gioBatDau} | ${s.ngayChieu}</p>
                        <div class="row" style="margin-left:0.5px">
                       		 Ghế:<p class="card-text" id="tenGhe">0</p>
                        </div>
                        <input type="hidden" id="gia1Suat" value="${s.giaVe}">
                       
                       Tổng Tiền: <p class="card-text"  id="gia" > 0 </p>(vnd)

                        <div class="text-center mt-5">
                            <a type="button" id="btnThanhToan" class="btn btn-warning" href="/chonve/ShowFormThanhToan"
                                style="width: 150px; height: 50px; font-weight: bold;">Thanh Toán</a>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

   
    </body>
</html>
