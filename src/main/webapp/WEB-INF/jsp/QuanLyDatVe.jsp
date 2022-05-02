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
       
        <link href="<c:url value="/resources/css/admin.css"/>" rel="stylesheet" type="text/css">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    	 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
      <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
  
     <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
        <title>Quản lý người dùng</title>
    </head>
    <script type="text/javascript">
    </script>
    <body>
   		<div class="dash">
        <div class="dash-nav dash-nav-dark">
            <header>
                <a href="#!" class="menu-toggle">
                    <i class="fas fa-bars"></i>
                </a>
                <a href="/" class="easion-logo"><i class="fa fa-home"></i> <span>Trang Chủ</span></a>
            </header>
            <nav class="dash-nav-list">
                <a href="/admin/thongke" class="dash-nav-item">
                    <i class="fa fa-desktop" aria-hidden="true"></i> Thống Kê </a>
                <a href="/admin/nguoidung" class="dash-nav-item"><i class="fa fa-user" aria-hidden="true"></i> Người Dùng </a>
                <a href="/admin/phim" class="dash-nav-item"> <i class="fa fa-film" aria-hidden="true"></i> Phim </a>
                <a href="/admin/KhuVucs" class="dash-nav-item"> <i class="fa fa-th-list" aria-hidden="true"></i> Quản lý Rạp </a>
                <a href="/admin/theLoais" class="dash-nav-item"> <i class="fa fa-th-list" aria-hidden="true"></i> Thể Loại </a>
               <a class="dash-nav-item" href="/logout"><i class="fa fa-outdent" aria-hidden="true"></i>Logout</a>
    				
				
                
            </nav>
        </div>
        <div class="dash-app">
            <main class="dash-content">
                <div class="container-fluid">
                
                    <h1 class="dash-title">Quản lý Người Dùng</h1>
 					   <!-- Trigger the modal with a button -->

                   <table >
                <thead>
                  <tr>
                 	 <th scope="col">id</th>
                    <th scope="col">Rạp Phim</th>
                    <th scope="col">Phim</th>
                    <th scope="col">Tên Phòng</th>
                    <th scope="col">Ngày Đặt Vé</th>
                    <th scope="col">Ngày Chiếu</th>
                    <th scope="col">Giờ Chiếu</th>
                    <th scope="col">Ghế</th>
                    <th scope="col">Giá Vé</th>
                    <th style="text-align: center;">Hành Động</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${ls}" var="ls">
                
                  <tr>
                  	<td>${ls.id}</td>
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
                   	 <td>
			           <a class="btn btn-danger" href="/admin/huyVe?idNd=${idNd}&idHD=${ls.id}" style="margin-left: 50px">hủy vé</a>		
					</td>
                  </tr>
                  
                </c:forEach>
                  
                </tbody>
              </table>
					
                </div>
            </main>
        </div>
    </div>
   
    </body>
</html>
