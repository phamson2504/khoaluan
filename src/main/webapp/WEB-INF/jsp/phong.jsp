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
  	
        <title>Phong</title>
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
                <a href="/" class="easion-logo"><i class="fa fa-home"></i> <span>Trang Ch???</span></a>
            </header>
            <nav class="dash-nav-list">
                <a href="/admin/thongke" class="dash-nav-item">
                    <i class="fa fa-desktop" aria-hidden="true"></i> Th???ng K?? </a>
                <a href="/admin/nguoidung" class="dash-nav-item"><i class="fa fa-user" aria-hidden="true"></i> Ng?????i D??ng </a>
                <a href="/admin/phim" class="dash-nav-item"> <i class="fa fa-film" aria-hidden="true"></i> Phim </a>
                <a href="/admin/KhuVucs" class="dash-nav-item"> <i class="fa fa-th-list" aria-hidden="true"></i> Qu???n l?? R???p </a>
                <a href="/admin/theLoais" class="dash-nav-item"> <i class="fa fa-th-list" aria-hidden="true"></i> Th??? Lo???i </a>
               <a class="dash-nav-item" href="/logout"><i class="fa fa-outdent" aria-hidden="true"></i>????ng xu???t</a>
    				
				
                
            </nav>
        </div>
        <div class="dash-app">
            <main class="dash-content">
                <div class="container-fluid">
                
                    <h1 class="dash-title">Ph??ng</h1>
 					   <!-- Trigger the modal with a button -->
					<a class="btn btn-danger" href="/admin/raps?idKhuVuc=${idKhuVuc}">R???p</a>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
					  Th??m Ph??ng
					</button>
					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">Th??m Khu V???c</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        	<c:url var="savePhong" value="/admin/luuPhong?idRap=${idRap}&idKhuVuc=${idKhuVuc}" />
					        	 <form modelAttribute="phong" action="${savePhong}" method="POST">
					        	 <div class="form-group row">
								    <label for="formGroupExampleInput" class="col-sm-3 col-form-label">T??n Phong</label>
								    <div class="col-sm-9">
								      <input name="tenPhong" type="text" class="form-control"/>
								    </div>
								  </div>
								  <div class="form-group row">
								    <label for="formGroupExampleInput" class="col-sm-3 col-form-label">S??? L?????ng C???t</label>
								    <div class="col-sm-9">
								      <input name="cot" type="text" class="form-control"/>
								    </div>
								  </div>
								  <div class="form-group row">
								    <label for="formGroupExampleInput" class="col-sm-3 col-form-label">S??? L?????ng H??ng</label>
								    <div class="col-sm-9">
								      <input name="hang" type="text" class="form-control"/>
								    </div>
								  </div>
					        	
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">????ng</button>
					        <button type="submit" class="btn btn-primary">L??u</button>
					      </div>
					       </form>
					    </div>
					  </div>
					</div>

                    <table >
						  <tr>
						    <th>Id</th>
						    <th>T??n Ph??ng</th>
						    <th>S??? L?????ng H??ng</th>
						    <th>S??? L?????ng C???t</th>
						    
						    <th>H??nh ?????ng</th>
						  </tr>
						  <c:forEach items="${phong}" var="p">
			                <tr>
			                    <td><c:out value="${p.id}"/></td>
			                    <td><c:out value="${p.tenPhong}"/></td>
			                   	<td><c:out value="${p.hang}"/></td>
			                   	<td><c:out value="${p.cot}"/></td>
			                    <td>
			                    
								<a class="btn btn-danger" href="/admin/xoaPhong?idPhong=${p.id}&idRap=${idRap}&idKhuVuc=${idKhuVuc}">
								  X??a Ph??ng
								</a>
								
								
								
								</td>
								
			                </tr>
			        <div class="modal fade" id="exampleModal${p.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="exampleModalLabel">S???a Ph??ng</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-body">
					        	<c:url var="savePhong" value="/admin/UpdatePhong?idRap=${idRap}&idKhuVuc=${idKhuVuc}" />
					        	 <form modelAttribute="phong" action="${savePhong}" method="POST">
					        	  <input name="id" type="hidden" class="form-control" value="${p.id}"/>
					        	 <div class="form-group row">
								    <label for="formGroupExampleInput" class="col-sm-3 col-form-label">T??n Phong</label>
								    <div class="col-sm-9">
								      <input name="tenPhong" type="text" class="form-control" value="${p.tenPhong}"/>
								    </div>
								  </div>
								  <div class="form-group row">
								    <label for="formGroupExampleInput" class="col-sm-3 col-form-label">S??? L?????ng C???t</label>
								    <div class="col-sm-9">
								      <input name="cot" type="text" class="form-control" value="${p.cot}"/>
								    </div>
								  </div>
								  <div class="form-group row">
								    <label for="formGroupExampleInput" class="col-sm-3 col-form-label">S??? L?????ng H??ng</label>
								    <div class="col-sm-9">
								      <input name="hang" type="text" class="form-control"value="${p.hang}"/>
								    </div>
								  </div>
					        	
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">????ng</button>
					        <button type="submit" class="btn btn-primary">L??u</button>
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
