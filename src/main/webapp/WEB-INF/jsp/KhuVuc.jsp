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
  	
        <title>KhuVuc</title>
    </head>
    <script type="text/javascript">
    $(document).ready(function(){
        $(".dash-nav-dropdown-toggle").click(function(){
            $(this).closest(".dash-nav-dropdown")
                .toggleClass("show")
                .find(".dash-nav-dropdown")
                .removeClass("show");

            $(this).parent()
                .siblings()
                .removeClass("show");
        });

        $(".menu-toggle").click(function(){
            if (mobileBreakpoint.matches) {
                $(".dash-nav").toggleClass("mobile-show");
            } else {
                $(".dash").toggleClass("dash-compact");
            }
        });

        $(".searchbox-toggle").click(function(){
            $(".searchbox").toggleClass("show");
        });
        
    });
  
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
                
                    <h1 class="dash-title">KhuVuc</h1>
 					   <!-- Trigger the modal with a button -->
					
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
					  Thêm Khu Vực
					</button>
					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">Thêm Khu Vực</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        	<c:url var="saveKV" value="/admin/luuKhuVuc" />
					        	 <form modelAttribute="khuvuc" action="${saveKV}" method="POST">
					        	 <div class="form-group row">
								    <label for="formGroupExampleInput" class="col-sm-3 col-form-label">Tên Khu Vực</label>
								    <div class="col-sm-9">
								      <input name="tenKhuVuc" type="text" class="form-control"/>
								    </div>
								  </div>
					        	
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					        <button type="submit" class="btn btn-primary">Save changes</button>
					      </div>
					       </form>
					    </div>
					  </div>
					</div>

                    <table >
						  <tr>
						    <th>Id</th>
						    <th>Tên Khu Vực</th>
						    <th>Hành Động</th>
						  </tr>
						  <c:forEach items="${kv}" var="kv">
			                <tr>
			                    <td><c:out value="${kv.id}"/></td>
			                    <td><c:out value="${kv.tenKhuVuc}"/></td>
			                   	
			                    <td>
			                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal${kv.id}">
					 				 Sửa Khu Vực
								</button>&ensp;
								<a class="btn btn-danger" href="/admin/xoaKhuVuc?idKV=${kv.id}">
								  Xóa Khu Vực
								</a>
								<a class="btn btn-info" href="/admin/raps?idKhuVuc=${kv.id}">
								  Quản Lý Rạp
								</a>
								
								
								</td>
								
			                </tr>
			         <div class="modal fade" id="exampleModal${kv.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">Sửa Khu Vực</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        	<c:url var="saveKV" value="/admin/luuKhuVuc" />
					        	 <form modelAttribute="khuvuc" action="${saveKV}" method="POST">
					        	 <div class="form-group row">
					        	 <input name="id" type="hidden" class="form-control" value="${kv.id}"/>
								    <label for="formGroupExampleInput" class="col-sm-3 col-form-label">Tên Khu Vực</label>
								    <div class="col-sm-9">
								      <input name="tenKhuVuc" type="text" class="form-control" value="${kv.tenKhuVuc}"/>
								    </div>
								  </div>
					        	
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					        <button type="submit" class="btn btn-primary">Save changes</button>
					      </div>
					       </form>
					    </div>
					  </div>
					</div>
			            </c:forEach>
					</table>
                </div>
            </main>
        </div>
    </div>
   
    </body>
</html>
