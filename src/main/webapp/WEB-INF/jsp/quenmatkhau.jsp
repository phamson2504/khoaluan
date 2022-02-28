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
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
        <title>Đăng Ký</title>
    </head>
    <script>
	  $(document).on("click","#btnLogin",function(e){
		    // Get the Login Name value and trim it
		    var name = $.trim($('#email').val());
			var matkhau = $.trim($('#matKhau').val());
			var xacnhapmatkhau = $.trim($('#xacNhanMatKhau').val());
		    // Check if empty of not
		    if (name  === '') {
		        alert('Không được để trống email.');
		        return false;
		    }
		    else{
		    	return true;
		    }
		});
</script>
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
			
			                <c:url value="/quenMatKhau" var="quenMatKhauUrl"/>
							<form action="${quenMatKhauUrl}" method="post" modelAttribute="user" id="dangki">
			
			                  <div class="d-flex align-items-center mb-3 pb-1">
			                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
			                    <span class="h1 fw-bold mb-0"> Quên Mật Khẩu</span>
			                  </div>
			                  <div class="form-outline mb-2">
			                  <label class="form-label" for="form2Example17">Email</label>
			                    <input type="email" id="email" name="email" class="form-control form-control-lg" />
			                    
			                  </div>
			                  <c:if test="${inform !=null}">
									<div class="alert alert-danger" role="alert">${inform}</div>
								</c:if>
			                  <div class="pt-2 mb-2">
			                    <button class="btn btn-danger btn-lg btn-block" type="submit" id="btnLogin">Cấp Lại Mật Khẩu</button>
			                  </div>
			                   <p class="mb-1 pb-lg-1" style="color: #393f81;">Quay Lại Đăng Nhập? <a href="/login" style="color: #393f81;"><u><i>Quay Lại</i></u></a></p>
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
