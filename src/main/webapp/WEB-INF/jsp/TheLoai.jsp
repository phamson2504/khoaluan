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
        <meta name="viewport" content="width=device-width, initial-scale=1">  
       
        <link href="<c:url value="/resources/css/admin.css"/>" rel="stylesheet" type="text/css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

       <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
 		<link rel="stylesheet prefetch" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css">
		<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js">
		</script>
  	
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
                
                    <h1 class="dash-title">Thể Loại</h1>
 					   <!-- Trigger the modal with a button -->
					
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
					  Thêm Thể Loại
					</button>
					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">Thêm Thể Loại</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        	<c:url var="saveTL" value="/admin/luuTheLoai" />
					        	 <form modelAttribute="tl" action="${saveTL}" method="POST">
					        	 <div class="form-group row">
								    <label for="formGroupExampleInput" class="col-sm-3 col-form-label">Tên Thể Loại</label>
								    <div class="col-sm-9">
								      <input name="ten" type="text" class="form-control"/>
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
						    <th>Tên The Loai</th>
						    <th>Hành Động</th>
						  </tr>
						  <c:forEach items="${tl}" var="tl">
			                <tr>
			                    <td><c:out value="${tl.id}"/></td>
			                    <td><c:out value="${tl.ten}"/></td>
			                   	
			                    <td>
			                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal${tl.id}">
					 				 Sửa Thể Loại
								</button>&ensp;
								<a class="btn btn-danger" href="/admin/xoaTheLoai?idTL=${tl.id}">
								  Xóa Thể Loại
								</a>
								
								
								</td>
								
			                </tr>
			         <div class="modal fade" id="exampleModal${tl.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">Sửa TheLoai</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        	<c:url var="UpdateTheLoai" value="/admin/luuTheLoai" />
					        	 <form modelAttribute="tl" action="${UpdateTheLoai}" method="POST">
					        	 <div class="form-group row">
					        	 <input name="id" type="hidden" class="form-control" value="${tl.id}"/>
								    <label for="formGroupExampleInput" class="col-sm-3 col-form-label">Tên Thể Loại</label>
								    <div class="col-sm-9">
								      <input name="ten" type="text" class="form-control" value="${tl.ten}"/>
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
