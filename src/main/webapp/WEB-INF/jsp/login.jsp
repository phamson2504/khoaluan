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
        <link href="<c:url value="/resources/css/css.css"/>" rel="stylesheet" type="text/css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
   		<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  	
        <title>Đăng Nhập</title>
    </head>
    <body>
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
