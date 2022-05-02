
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
        <title>Lịch Sử Đặt Vé</title>
    </head>
    <body style="background-image: url(/resources/img/showtime-bg.jpg); width: 100%;">


    <!-- Menu -->
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


    <div class="container-fluid">



        <div style="text-align: center;">
            <h1 style="color: greenyellow; font-size: 40px; margin-top: 50px;">Lịch Sử Đặt Vé</h1>

           

        </div>

        <!-- Table -->
        <div style="margin-top: 50px;">
            <table class="table table-striped table-dark">
                <thead>
                  <tr>
                    <th scope="col">Rạp Phim</th>
                    <th scope="col">Phim</th>
                    <th scope="col">Tên Phòng</th>
                    <th scope="col">Ngày Đặt Vé</th>
                    <th scope="col">Ngày Chiếu</th>
                    <th scope="col">Giờ Chiếu</th>
                    <th scope="col">Ghế</th>
                    <th scope="col">Giá Vé</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${ls}" var="ls">
                
                  <tr>
                    <th scope="row">${ls.tenRap}</th>       
                    <td>${ls.tenPhim}</td>
                    <td>${ls.tenPhong}</td>
                    <td>${ls.ngayDatVe}</td>
                    <td>${ls.ngayChieu}</td>
                    <td>${ls.gioChieu}</td>
                    <td>
                    <c:forEach items="${g}" var="g">
                    	<c:choose>
							<c:when test="${ls.id==g.id}">
								 ${g.viTriHang}${g.viTriCot}	
							</c:when>  
						</c:choose>
                    </c:forEach>
                    </td> 
                    <td>${ls.giaVe}</td>
                  </tr>
                  
                </c:forEach>
                  
                </tbody>
              </table>
        </div>



        <div style="text-align: center; " class="mt-5">
            <a href="/" type="button" class="btn btn-success" style="font-size: 20px; border-radius: 10px;">Về Trang
                Chủ</a>
        </div>



    </div>
</body>
</html>
