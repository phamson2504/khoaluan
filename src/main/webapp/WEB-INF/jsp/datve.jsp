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

    <body>
   		<!-- navbar -->
    <div class="col-md-12 navbar bg-dark">
        <a href="index.html" class="logo navbar-brand text-white offset-md-2">Sơn Hảo Phim</a>
        <ul class="nav">
            <li class="nav-item"><a href="/home" class="nav-link">Trang chủ</a></li>
            <li class="nav-item"><a href="/home" class="nav-link">Đăng Xuất</a></li>


        </ul>
    </div>

    <!-- Chia layout -->
    <div class="container-fluid mt-3">
        <div class="row">

            <!-- Hình ảnh phim -->
            <div class="col-3" style="font-weight: bold;">
                <div class="card" style="width: 100%; background-color: antiquewhite;">
                    <img class="card-img-top" src="/resources/img/avanger.jpg" alt="Card image cap" style="height: 500px;">
                    <div class="card-body">
                        <p class="card-text">Lootte Gò Vấp - AVANGER</p>
                        <p class="card-text">Ngày Chiếu:...</p>
                        <p class="card-text">Giờ Chiếu:...</p>
                    </div>
                </div>
            </div>

            <!-- Đặt vé -->
            <div class="col-6">
                <h3 class="text-center" style="background-color: green; color: aliceblue; height: 40px; width: 97%;">Màn
                    Hình</h3>

                <div class="m-3">
					
                    <!-- Hàng A -->
                    <div class="m-2 text-center">
                    	
                        <button type="button" class="btn btn-danger" style="width: 50px;">A</button>
                        <button type="button" class="btn btn-success">1</button>
                        <button type="button" class="btn btn-success">2</button>
                        <button type="button" class="btn btn-success">3</button>
                        <button type="button" class="btn btn-success">4</button>
                        <button type="button" class="btn btn-success">5</button>
                        <button type="button" class="btn btn-success">6</button>
                        <button type="button" class="btn btn-success">7</button>
                        <button type="button" class="btn btn-success">8</button>
                        <button type="button" class="btn btn-success">9</button>
                        <button type="button" class="btn btn-success">10</button>
                      
                    	

                    </div>


                    <!-- Hàng B -->
                    <div class="m-2 text-center" >
                        <button type="button" class="btn btn-danger" style="width: 50px;">B</button>
                        <button type="button" class="btn btn-success">1</button>
                        <button type="button" class="btn btn-success">2</button>
                        <button type="button" class="btn btn-success">3</button>
                        <button type="button" class="btn btn-success">4</button>
                        <button type="button" class="btn btn-success">5</button>
                        <button type="button" class="btn btn-success">6</button>
                        <button type="button" class="btn btn-success">7</button>
                        <button type="button" class="btn btn-success">8</button>
                        <button type="button" class="btn btn-success">9</button>
                        <button type="button" class="btn btn-success">10</button>
                       
                    </div>

                    <!-- Hàng C -->
                    <div class="m-2 text-center">
                        <button type="button" class="btn btn-danger" style="width: 50px;">C</button>
                        <button type="button" class="btn btn-success">1</button>
                        <button type="button" class="btn btn-success">2</button>
                        <button type="button" class="btn btn-success">3</button>
                        <button type="button" class="btn btn-success">4</button>
                        <button type="button" class="btn btn-success">5</button>
                        <button type="button" class="btn btn-success">6</button>
                        <button type="button" class="btn btn-success">7</button>
                        <button type="button" class="btn btn-success">8</button>
                        <button type="button" class="btn btn-success">9</button>
                        <button type="button" class="btn btn-success">10</button>
                       
                    </div>

                    <!-- Hàng D -->
                    <div class="m-2 text-center">
                        <button type="button" class="btn btn-danger" style="width: 50px;">D</button>
                        <button type="button" class="btn btn-success">1</button>
                        <button type="button" class="btn btn-success">2</button>
                        <button type="button" class="btn btn-success">3</button>
                        <button type="button" class="btn btn-success">4</button>
                        <button type="button" class="btn btn-success">5</button>
                        <button type="button" class="btn btn-success">6</button>
                        <button type="button" class="btn btn-success">7</button>
                        <button type="button" class="btn btn-success">8</button>
                        <button type="button" class="btn btn-success">9</button>
                        <button type="button" class="btn btn-success">10</button>
                      
                    </div>


                    <!-- Hàng E -->
                    <div class="m-2 text-center">
                        <button type="button" class="btn btn-danger" style="width: 50px;">E</button>
                        <button type="button" class="btn btn-success">1</button>
                        <button type="button" class="btn btn-success">2</button>
                        <button type="button" class="btn btn-success">3</button>
                        <button type="button" class="btn btn-success">4</button>
                        <button type="button" class="btn btn-success">5</button>
                        <button type="button" class="btn btn-success">6</button>
                        <button type="button" class="btn btn-success">7</button>
                        <button type="button" class="btn btn-success">8</button>
                        <button type="button" class="btn btn-success">9</button>
                        <button type="button" class="btn btn-success">10</button>
                     
                    </div>


                    <!-- Hàng F -->
                    <div class="m-2 text-center">
                        <button type="button" class="btn btn-danger" style="width: 50px;">F</button>
                        <button type="button" class="btn btn-success">1</button>
                        <button type="button" class="btn btn-success">2</button>
                        <button type="button" class="btn btn-success">3</button>
                        <button type="button" class="btn btn-success">4</button>
                        <button type="button" class="btn btn-success">5</button>
                        <button type="button" class="btn btn-success">6</button>
                        <button type="button" class="btn btn-success">7</button>
                        <button type="button" class="btn btn-success">8</button>
                        <button type="button" class="btn btn-success">9</button>
                        <button type="button" class="btn btn-success">10</button>
                     
                    </div>


                    <!-- Hàng G -->
                    <div class="m-2 text-center">
                        <button type="button" class="btn btn-danger" style="width: 50px;">G</button>
                        <button type="button" class="btn btn-success">1</button>
                        <button type="button" class="btn btn-success">2</button>
                        <button type="button" class="btn btn-success">3</button>
                        <button type="button" class="btn btn-success">4</button>
                        <button type="button" class="btn btn-success">5</button>
                        <button type="button" class="btn btn-success">6</button>
                        <button type="button" class="btn btn-success">7</button>
                        <button type="button" class="btn btn-success">8</button>
                        <button type="button" class="btn btn-success">9</button>
                        <button type="button" class="btn btn-success">10</button>
                    
                    </div>


                    <!-- Hàng H -->
                    <div class="m-2 text-center">
                        <button type="button" class="btn btn-danger" style="width: 50px;">H</button>
                        <button type="button" class="btn btn-success">1</button>
                        <button type="button" class="btn btn-success">2</button>
                        <button type="button" class="btn btn-success">3</button>
                        <button type="button" class="btn btn-success">4</button>
                        <button type="button" class="btn btn-success">5</button>
                        <button type="button" class="btn btn-success">6</button>
                        <button type="button" class="btn btn-success">7</button>
                        <button type="button" class="btn btn-success">8</button>
                        <button type="button" class="btn btn-success">9</button>
                        <button type="button" class="btn btn-success">10</button>
                
                    </div>


                    <!-- Hàng i -->
                    <div class="m-2 text-center">
                        <button type="button" class="btn btn-danger" style="width: 50px;">I</button>
                        <button type="button" class="btn btn-success">1</button>
                        <button type="button" class="btn btn-success">2</button>
                        <button type="button" class="btn btn-success">3</button>
                        <button type="button" class="btn btn-success">4</button>
                        <button type="button" class="btn btn-success">5</button>
                        <button type="button" class="btn btn-success">6</button>
                        <button type="button" class="btn btn-success">7</button>
                        <button type="button" class="btn btn-success">8</button>
                        <button type="button" class="btn btn-success">9</button>
                        <button type="button" class="btn btn-success">10</button>
                     
                    </div>


                    <!-- Hàng j -->
                    <div class="m-2 text-center">
                        <button type="button" class="btn btn-danger" style="width: 50px;">J</button>
                        <button type="button" class="btn btn-success">1</button>
                        <button type="button" class="btn btn-success">2</button>
                        <button type="button" class="btn btn-success">3</button>
                        <button type="button" class="btn btn-success">4</button>
                        <button type="button" class="btn btn-success">5</button>
                        <button type="button" class="btn btn-success">6</button>
                        <button type="button" class="btn btn-success">7</button>
                        <button type="button" class="btn btn-success">8</button>
                        <button type="button" class="btn btn-success">9</button>
                        <button type="button" class="btn btn-success">10</button>
                    
                    </div>


                    <div class="row mt-5 text-center">

                        <div class="col-4">
                            <p> <button type="button" class="btn btn-danger"
                                    style="width: 15px; height: 20px;"></button> Hàng Ghế </p>

                        </div>

                        <div class="col-4">
                            <p> <button type="button" class="btn btn-secondary"
                                    style="width: 15px; height: 20px;"></button> Đã có người đặt</p>

                        </div>
                        <div class="col-4">
                            <p> <button type="button" class="btn btn-success"
                                    style="width: 15px; height: 20px;"></button> Ghế còn trống</p>

                        </div>

                    </div>


                </div>

            </div>


            <!-- Hóa đơn -->
            <div class="col-3">
                <div class="card" style="width: 100%; background-color: antiquewhite;">
                    <img class="card-img-top" src="/resources/img/avanger.jpg" alt="Card image cap">
                    <div class="card-body">
                        <p class="card-text" style="font-weight: bold;">AVANGER</p>
                        <p class="card-text">Rạp: Lotte Gò Vấp</p>
                        <p class="card-text">Suất Chiếu: 15h | Thứ 7, ngày 26 tháng 2 năm 2022</p>
                        <p class="card-text">Ghế: G1, G2, G3</p>
                        <p class="card-text">Tổng Tiền: 500.000 (vnd)</p>

                        <div class="text-center mt-5">
                            <button type="button" class="btn btn-danger m-3"
                                style="width: 150px; height: 50px; font-weight: bold;">Quay Lại</button>
                            <button type="button" class="btn btn-warning"
                                style="width: 150px; height: 50px; font-weight: bold;">Thanh Toán</button>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

   
    </body>
</html>
