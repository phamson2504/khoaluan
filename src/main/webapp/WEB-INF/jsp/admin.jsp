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
        <title>Admin</title>
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
                <a href="/" class="easion-logo"><i class="fa fa-home"></i> <span>Home</span></a>
            </header>
            <nav class="dash-nav-list">
                <a href="" class="dash-nav-item">
                    <i class="fa fa-desktop" aria-hidden="true"></i> Dashboard </a>
                <a href="" class="dash-nav-item"><i class="fa fa-user" aria-hidden="true"></i> Người Dùng </a>
                <a href="/admin/phim" class="dash-nav-item"> <i class="fa fa-film" aria-hidden="true"></i> Phim </a>
                <a href="/admin/KhuVucs" class="dash-nav-item"> <i class="fa fa-th-list" aria-hidden="true"></i> Quản lý Rạp </a>
                <a href="/admin/theLoais" class="dash-nav-item"> <i class="fa fa-th-list" aria-hidden="true"></i> Thể Loại </a>
               <a class="dash-nav-item" href="/logout"><i class="fa fa-outdent" aria-hidden="true"></i>Logout</a>
    				
				
                
            </nav>
        </div>
        <div class="dash-app">
            <main class="dash-content">
                <div class="container-fluid">
                
                    <h1 class="dash-title">Quản lý Phim</h1>
 					   <!-- Trigger the modal with a button -->
					
					
					<a class="btn btn-primary" href="/admin/showThemPhim">
								  Thêm Phim
								</a>&ensp;

                    <table >
						  <tr>
						    <th>Id</th>
						    <th>Tên Phim</th>
						    <th>Hình Ảnh</th>
						    <th>Ngày Công Chiếu</th>
						    <th>Thời Lượng</th>
							<th>Thể Loại</th>
						    <th>Hành Động</th>
						  </tr>
						  <c:forEach items="${phim}" var="p">
			                <tr>
			                    <td><c:out value="${p.id}"/></td>
			                    <td><c:out value="${p.tenPhim}"/></td>
			                    <td><img src="${p.hinhAnh}"  width="100" height="150"></td>
			                    <td><c:out value="${p.ngayCongChieu}"/></td>
			                    <td><c:out value="${p.thoiLuong}"/></td>
			                    <td><c:out value="${p.theLoai}"/></td>
			                    
			                    <td>
			                    <a class="btn btn-primary" href="/admin/showSuaPhim?idPhim=${p.id}" style="margin-left: 50px">
								  Sửa Phim
								</a>&ensp;
								<a class="btn btn-danger" href="/admin/xoaPhim?idPhim=${p.id}">
								  Xóa Phim
								</a>
								<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" value="${p.id}" id="clickmodal${p.id}">
					 				 Thêm Suất Chiếu
								</button>
								<a class="btn btn-info"  href="/admin/suatTheoPhim?idPhim=${p.id}">
								  Chi Tiết
								</a>
								
								</td>
								
			                </tr>
			         
			            </c:forEach>
					</table>
					<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">Sửa Khu Vực</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        	 <form>
					        	 <input id="idPhim" type="hidden" class="form-control"/>
					        	 <div class="form-group row">
					        	 <label for="formGroupExampleInput" class="col-sm-3 col-form-label">ID Phong</label>
								<div class="col-sm-9">
					        	 	<input id="idphong" type="number" class="form-control"/>
									</div>
					        	 </div>
					        	 <div class="form-group row">
					        	 <label for="formGroupExampleInput" class="col-sm-3 col-form-label">Thể Loại</label>
								<div class="col-sm-9">
					        	 	<select class="form-control" id="idTheLoai">
					        	 	 <c:forEach items="${tl}" var="tl">
					        	 		 <option value="${tl.id}">${tl.ten}</option>
									  
					        	 	 </c:forEach>
									  
									</select>
									</div>
					        	 </div>
								  <div class="form-group row">
										    <label for="formGroupExampleInput" class="col-sm-3 col-form-label">Ngày Chiếu</label>
										    <div class="col-sm-9">
			                         			<input id="datepicker" class="form-control" type="text" ></span>        
                    					</div> 
								    </div>
								    <div class="form-group row">
										    <label for="formGroupExampleInput" class="col-sm-3 col-form-label">Ngày Kết Thúc</label>
										    <div class="col-sm-9">
			                         			<input id="datepicker2" class="form-control" type="text" ></span>        
                    					</div> 
								    </div>
								    <div class="form-group row">
								    	 <label for="formGroupExampleInput" class="col-sm-3 col-form-label">Giờ Chiếu</label>
										    <div class="col-sm-9">
										   		 <input type="time" id="gioBatDau" class="form-control">
										    </div>
								    </div>
								    <div class="form-group row">
										    <label for="formGroupExampleInput" class="col-sm-3 col-form-label">Giá Vé</label>
										    <div class="col-sm-9">
										      <input id="giaVe" type="number" class="form-control"/>
										    </div>
								  </div>
							      <div class="modal-footer">
							        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
							        <button type="submit" id="addNew"class="btn btn-primary">Save changes</button>
							      </div>
					       </form>
					    </div>
					  </div>
					</div>
					</div>
                </div>
            </main>
        </div>
    </div>
   
    </body>
</html>
