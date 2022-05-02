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
        <title>Suất chiếu</title>
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
                
                    <h1 class="dash-title">Suất chiếu của phim</h1>
 					   <!-- Trigger the modal with a button -->
                    <table >
						  <tr>
						    <th>Id Suất Chiếu</th>
						    <th>Giờ Bắt Đầu</th>
						    <th>Ngày Chiếu</th>
						    <th>Giá Vé</th>
							<th>Tên Rạp</th>
							<th>Id Phòng</th>
							<th>Tên Phim</th>
							<th>Thể Loại</th>
						    <th>Hành Động</th>
						  </tr>
						  <c:forEach items="${sc}" var="s">
			                <tr>
			                    <td><c:out value="${s.id}"/></td>
			                    <td><c:out value="${s.gioBatDau}"/></td>
			                    <td><c:out value="${s.ngayChieu}"/></td>
			                    <td><c:out value="${s.giaVe}"/></td>
			                    <td><c:out value="${s.tenRap}"/></td>
			                    <td><c:out value="${s.idPhong}"/></td>
			                    <td><c:out value="${s.tenPhim}"/></td>
			                    <td><c:out value="${s.theLoai}"/></td>
			                    
			                    <td>
			                    <a class="btn btn-danger" href="/admin/xoaSC?idSc=${s.id}&idPhim=${idPhim}">
								  Xóa
								</a>&ensp;
								<a class="btn btn-primary" href="/admin/showformSuaSC?idSc=${s.id}&idPhim=${idPhim}&idPhong=${s.idPhong}">
								  Sửa
								</a>
								</td>
								
			                </tr>
			         
			            </c:forEach>
					</table>
					
                </div>
            </main>
        </div>
    </div>
   
    </body>
</html>
