
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
        <title>Thanh Toán</title>
    </head>
    <script type="text/javascript">
    $(document).on("click","#btnThanhToan",function(e){
    	localStorage.setItem('gheNgoi', "");
	  	localStorage.setItem('idSuat', "");
	  	localStorage.setItem('gia', '');
	  	localStorage.setItem('tenGhe','');
    })
    </script>
    <body>
     <div style="background-color: rgba(243, 217, 232, 0.3); min-width: 100%; height: 890px; ">
    <div class="container-fluid">


      <!-- Menu -->
      <div class="row">
        <div class="col-md-12 navbar bg-dark">
          <a href="/" class="logo navbar-brand text-white offset-md-2">Sơn Hảo Phim</a>
          <nav class="navbar navbar-light bg-dark">
            <form class="form-inline">
              <input class="form-control mr-sm-2" type="search" placeholder="Nhập tên phim..."
                aria-label="Tìm tên phim">
              <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Tìm kiếm</button>
            </form>
          </nav>
           <ul class="nav">
                        <c:choose>
						    <c:when test="${sessionScope.username==null}">
						        <li class="nav-item"><a href="/login" class="nav-link">Đăng Nhập</a></li>

                        		<li class="nav-item"><a href="/showdangki" class="nav-link">Đăng Ký</a></li>
						    </c:when>    
						    <c:otherwise>
						    <li class="nav-item"><a href="/thongtinNd" class="nav-link">${sessionScope.username}</a></li>
						    <li class="nav-item"><a href="/lichSuDatVe" class="nav-link">Lịch Sử Đặt Vé</a></li>
						    <c:choose>
							    <c:when test="${sessionScope.role==2}">
							     	<li class="nav-item"><a href="/admin/phim" class="nav-link">Quản Lý</a></li>
							    </c:when>    
							</c:choose>
						    	
						        <li class="nav-item"><a href="/logout" class="nav-link">Đăng Xuất</a></li>
						       
						    </c:otherwise>
						</c:choose>      

            </ul>
        </div>
      </div>



    


     



      <div class="row mt-5">

        <div class="col-6">

          <div style="font-weight: bold;">
            <div class="card" style="width: 70%; background-color: antiquewhite;">
              <img class="card-img-top" src="https://png.pngtree.com/png-vector/20210701/ourlarge/pngtree-online-payment-concept-transfers-more-convenient-png-image_3547562.jpg" alt="Card image cap" style="height: 620px;">
              <!-- <div class="card-body">
                <p class="card-text">Lootte Gò Vấp - AVANGER</p>
                <p class="card-text">Ngày Chiếu:...</p>
                <p class="card-text">Giờ Chiếu:...</p>
              </div> -->
            </div>
          </div>
        </div>

        <div class="col-6" style="margin-left: -90px;">
          <h4  style="font-weight: bold; color: red;  margin-top: -18px; ">THANH TOÁN</h4>

              <!-- Thông tin rạp -->
              <div class="mt-4">
                <div class="card">
                  <div class="card-header" style="font-weight: bold;">
                    Thông Tin Thanh Toán
                  </div>
                  <div class="card-body">
                  <c:url value="/chonve/pay" var="payUrl"/>
                    <form:form action="${payUrl}" method="post">
                      <div class="form-group">
                        <label for="exampleInputEmail1" style="font-weight: bold;">Hình Thức Thanh Toán</label>
                        <select class="form-control" id="exampleFormControlSelect1">
      
                          <option>Paypal</option>
            
                         
                        </select>
                      </div>



                      <div class="form-group">
                        <label for="hoten" style="font-weight: bold;">Họ và tên</label>
                        ${nd.hoTen}
                      </div>

                      <div class="form-group">
                        <label for="hoten" style="font-weight: bold;">Số điện thoại</label>
                        ${nd.sdt}
                      </div>
                      <div class="form-group">
                        <label for="hoten" style="font-weight: bold;">Ghế đã chọn là:</label>
                        <c:forEach items="${g}" var="g" >
                        		${ g.viTriHang}${ g.viTriCot} 		 
                        </c:forEach>
                      </div>


                      <div class="form-group">
                        <label for="hoten" style="font-weight: bold;">Tổng Cộng:</label>
                        ${gia}
                        <input type="hidden" class="form-control"  name="price" placeholder="Nhập số điện thoại..." value="${gia}" readonly="readonly">
                      </div>

                      <a  href="/chonve/suat?id=${idSuat}" class="btn btn-warning" style="margin-left: 200px; width: 200px;">Quay lại</a>
                     
							
						<button type="submit" id="btnThanhToan" class="btn btn-success" style="margin-left: 100px; width: 200px;">Thanh Toán</button>
					
                    
                    </form:form>

  
                  </div>
                </div>
              </div>

            </div>



          </div>

        </div>
      </div>

       
    </body>
</html>
