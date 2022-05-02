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
  	
        <title>Đăng Nhập</title>
    </head>
    <body>
    	<div class="col-md-12 navbar bg-dark">
                    <a href="/" class="logo navbar-brand text-white offset-md-2">Sơn Hảo Phim</a>
                    <nav class="navbar navbar-light bg-dark">
                        
                    </nav>
                    <ul class="nav">
                        <li class="nav-item"><a href="/" class="nav-link">Trang chủ</a></li>
                        <c:choose>
						    <c:when test="${sessionScope.username==null}">
						        <li class="nav-item"><a href="/login" class="nav-link">Đăng Nhập</a></li>

                        		<li class="nav-item"><a href="/showdangki" class="nav-link">Đăng Ký</a></li>
						    </c:when>    
						    <c:otherwise>
						    	<li class="nav-item"><a href="/showdangki" class="nav-link">${sessionScope.username}</a></li>
						        <li class="nav-item"><a href="/logout" class="nav-link">Đăng Xuất</a></li>
						    </c:otherwise>
						</c:choose>
						<c:choose>
						    <c:when test="${sessionScope.role==2}">
						     	<li class="nav-item"><a href="/admin/phim" class="nav-link">Quản Lý</a></li>
						    </c:when>    
						</c:choose>
                        
                        
                        

                    </ul>
                </div>
   		<section class="vh-100" style="background-color: #f5f5f5;">
			  <div class="container py-5 h-100">
			    <div class="row d-flex justify-content-center align-items-center h-100">
			      <div class="col col-xl-10"	style="height:625px" >
			        <div class="card" style="border-radius: 1rem;">
			          <div class="row g-0" style="box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2),0 5px 8px 0 rgba(0, 0, 0, 0.2),0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);border-radius: 1rem 1rem 1rem 1rem;">
			          
			            <div class="col-md-6 col-lg-5 d-none d-md-block">
			              <img
			                src="/resources/img/raplogin.jpg"
			                alt="login form"
			                class="img-fluid" style="border-radius: 1rem 0 0 1rem;"
			              />
			            </div>
			            <div class="col-md-6 col-lg-7 d-flex align-items-center">
			              <div class="card-body p-4 p-lg-5 text-black">
			
			                <c:url value="/login" var="loginUrl"/>
							<form action="${loginUrl}" method="post" modelAttribute="user">
			
			                  <div class="d-flex align-items-center mb-3 pb-1">
			                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
			                    <span class="h1 fw-bold mb-0">Đăng Nhập</span>
			                  </div>
			
			     
			
			                  <div class="form-outline mb-1">
			                   	<label class="form-label" for="form2Example17">Email</label>
			                    <input type="email" id="email" name="email" class="form-control form-control-lg" />
			                   
			                  </div>
			
			                  <div class="form-outline mb-1">
			                  	<label class="form-label" for="form2Example27">Mật Khẩu</label>
			                    <input type="password"  id="matKhau" name="matKhau" class="form-control form-control-lg" />
			                    
			                  </div>
								<c:if test="${param.error !=null}">
									<div class="alert alert-danger" role="alert">Invalid login or password.</div>
								</c:if>
			                  <div class="pt-1 mb-1">
			                    <button class="btn btn-danger btn-lg btn-block" type="submit">Đăng Nhập</button>
			                  </div>
			
			                  <a class="small text-muted" href="/showqmk"><u>Quên Mật Khẩu?</u></a>
			                  <p class="mb-5 pb-lg-2" style="color: #393f81;">Bạn Chưa Có Tài Khoản? <a href="/showdangki" style="color: #393f81;"><u><i>Đăng ký Tại Đây</i></u></a></p>
			                </form>
			
			              </div>
			            </div>
			          </div>
			        </div>
			      </div>
			    </div>
			  </div>
			</section>

    </body>
</html>
