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
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
		
        <title>Đăng Ký</title>
    </head>
    <script>
	  $(function() {
		$("#datepicker").datepicker({         
			autoclose: true,         
			todayHighlight: true 
		}).datepicker('update', new Date());
	  });
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
		    else if( matkhau!=xacnhapmatkhau){
		    	alert('Xac Nhap Mat Khau Sai.');
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
			      <div class="col col-xl-10"	style="height:830px" >
			        <div class="card" style="border-radius: 1rem;">
			          <div class="row g-0" style="box-shadow: 0 5px 8px 0 rgba(0, 0, 0, 0.2),0 5px 8px 0 rgba(0, 0, 0, 0.2),0 5px 8px 0 rgba(0, 0, 0, 0.2), 0 9px 26px 0 rgba(0, 0, 0, 0.19);border-radius: 1rem 1rem 1rem 1rem;">
			          
			            <div class="col-md-6 col-lg-6 d-none d-md-block">
			              <img
			                src="/resources/img/raplogin.jpg"
			                alt="login form"
			                class="img-fluid" style="border-radius: 1rem 0 0 1rem;height:830px;"
			              />
			            </div>
			            <div class="col-md-6 col-lg-6 d-flex align-items-center">
			              <div class="card-body p-4 p-lg-5 text-black">
			
			                <c:url value="/dangki" var="dangkiUrl"/>
							<form action="${dangkiUrl}" method="post" modelAttribute="user" id="dangki">
			
			                  <div class="d-flex align-items-center mb-3 pb-1">
			                    <i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
			                    <span class="h1 fw-bold mb-0"> Đăng Ký</span>
			                  </div>
			
			     
			
			                  <div class="form-outline mb-1">
			                  <label class="form-label" for="form2Example17">Email</label>
			                    <input type="email" id="email" name="email" class="form-control form-control-lg" />
			                    
			                  </div>
			
			                  <div class="form-outline mb-1">
			                  <label class="form-label" for="form2Example27">Mật Khẩu</label>
			                    <input type="password"  id="matKhau" name="matKhau" class="form-control form-control-lg" />
			                    
			                  </div>
			                  <div class="form-outline mb-1">
			                 	 <label class="form-label" for="form2Example27">Xác Nhận Mật Khẩu</label>
			                    <input type="password"  id="xacNhanMatKhau" class="form-control form-control-lg" />
			                    
			                  </div>
			                  <div class="form-outline mb-1">
			                  <label class="form-label" for="form2Example17">Họ Tên</label>
			                    <input type="text" id="hoTen" name="hoTen" class="form-control form-control-lg" />
			                    
			                  </div>
			                  <div class="form-outline mb-1">
			                  	<label class="form-label" for="form2Example27">Số Điện Thoại</label>
			                    <input type="number"  id="sdt" name="sdt" class="form-control form-control-lg" />
			                 
			                  </div>
			                  <div class="form-outline mb-1">
			                  <label class="form-label" for="form2Example27">Giới Tính</label>
			                  	<select class="custom-select" name="gioiTinh">
								  <option value="Nam">Nam</option>
								  <option value="Nữ">Nữ</option>
								</select>
			                  </div>
			                  <div class="form-outline mb-4">
			                  	<label class="form-label" for="form2Example27">Ngày sinh</label>
			                  
			                        <input id="datepicker" class="form-control" type="text" name="ngaySinh">      
			                        
			                 
			                 
                    			
			                    
			                  </div>
			                 
			                  <c:if test="${loi !=null}">
									<div class="alert alert-danger" role="alert">${loi}</div>
								</c:if>
			                  
								
			                  <div class="pt-1 mb-1">
			                    <button class="btn btn-danger btn-lg btn-block" type="submit" id="btnLogin">Đăng Ký</button>
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
