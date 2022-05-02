
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
    <script type="text/javascript" src="<c:url value="/resources/js/lichRap.js"/>"></script>
    	
        <title>Lịch Rạp</title>
    </head>
    <body>
     <div style="background-color: rgba(243, 217, 232, 0.3); min-width: 100%; height: 100%; ">
        <div class="container-fluid">


            <!-- Menu -->
            <div class="row">
                <div class="col-md-12 navbar bg-dark">
                    <a  class="logo navbar-brand text-white offset-md-2" href="/">Sơn Hảo Phim</a>
                    <nav class="navbar navbar-light bg-dark">
                     
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

           

            <!-- Hình ảnh rạp -->
            <h3 class="mt-3" style="font-weight: bold;">HÌNH ẢNH RẠP</h3>
            <div class="row mt-3 text-center">


                <div class="col-3">
                    <img src="https://www.galaxycine.vn/media/2021/3/3/naml3226-2000x1xxx_1614762682363.jpg"
                        style="width: 400px; height: 200px;" />

                </div>


                <div class="col-3">
                    <img src="https://www.galaxycine.vn/media/2019/5/6/rapgiave-hinhrap-camau-02_1557128259980.jpg"
                        style="width: 400px; height: 200px;" />

                </div>

                <div class="col-3">
                    <img src="https://www.galaxycine.vn/media/2019/5/6/rapgiave-hinhrap-camau-03_1557128024900.jpg"
                        style="width: 400px; height: 200px;" />

                </div>

                <div class="col-3">
                    <img src="https://www.galaxycine.vn/media/2021/3/3/naml3213-2000x1xxx_1614762720108.jpg"
                        style="width: 400px; height: 200px;" />

                </div>

               


            </div>


            <h4 class="mt-3" style="font-weight: bold; ">PHIM ĐANG CHIẾU</h4>

            <div class="row">

                <div class="col-7 m-2">

                  
                        <input id="datepicker" placeholder="Nhập ngày cần tìm kiếm" width="330"  value="${n}"/>
                       
                   
                   

                    <select id="kvSelect" class="custom-select mt-3" style="width: 35%;">
                       <c:forEach items="${kv}" var="kv" >
                       	<c:choose>
						    <c:when test="${kvChon==kv.id}">
						  		<option value="${kv.id}" selected>${kv.tenKhuVuc}</option>
						    </c:when>  
						    <c:otherwise>
						  		<option value="${kv.id}">${kv.tenKhuVuc}</option>
						    </c:otherwise>  
						</c:choose>
                        		
                        </c:forEach>
                    </select>
					
                     <br>
                    <select id="rapSelect" class="custom-select mt-3" style="width: 35%;">
                        <c:forEach items="${r}" var="r">
                        <c:choose>
						    <c:when test="${rapChon==r.id}">
						  		 <option value="${r.id}" selected>${r.tenRap}</option>
						    </c:when>  
						    <c:otherwise>
						  		 <option value="${r.id}">${r.tenRap}</option>
						    </c:otherwise>  
						</c:choose>
                       
                        </c:forEach>
                    </select>
                    <br>
					<select id="tlSelect" class="custom-select mt-3" style="width: 35%;">
                        <c:forEach items="${tl}" var="tl">
                        <c:choose>
						    <c:when test="${tlChon==tl.id}">
						  		 <option value="${tl.id}" selected>${tl.ten}</option>
						    </c:when>  
						    <c:otherwise>
						  		 <option value="${tl.id}">${tl.ten}</option>
						    </c:otherwise>  
						</c:choose>
                        
                        </c:forEach>
                    </select>
                  
                    

                </div>

            </div>



            <div class="row mt-1">
                       
                    <div class="col-6" id="phim">
                    <c:forEach items="${p}" var="p">
                        <div class="row" style="margin-top: 20px">
						
                            <div class="col-6" >
                                <img src="${p.hinhAnh}" style="width: 200px; height: 250px;" />


                            </div>
                            <div class="col-6 m-0" style="left: -160px;">
                                <h4>${p.tenPhim}</h4>
                                <i class="fa fa-stopwatch">  ${p.thoiLuong}</i>
                                 <div class="m-2" >
                             <c:forEach items="${s}" var="s">
                                  	<c:choose>
									    <c:when test="${s.idPhim==p.id}">
                              
                               				 <a href="/chonve/suat?id=${s.id}" type="button" class="btn btn-secondary m-2" style="margin-left: 10px; width: 70px; margin: 4px;">${s.gioBatDau}</a>
                                
                              
                                		</c:when>  
								</c:choose>
                                    
                             </c:forEach>
                              </div>
                            </div>
                            
                        </div>
					</c:forEach>
                     
                    </div>

                    <div class="col-6">
                        <img src="/resources/img/giave.png" style="margin-top: -150px;" />
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.552865306777!2d106.77686881458972!3d10.845489792274732!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175270c3672eead%3A0x48a232403125539e!2zVmluY29tIFBsYXphIEzDqiBWxINuIFZp4buHdA!5e0!3m2!1svi!
                        2s!4v1647006130811!5m2!1svi!2s" width="765" height="380" style="border:0;margin-top: 60px" allowfullscreen="" loading="lazy"></iframe>
                    </div>
                  

            </div>


            

        </div>
    </div>
    <div class="card-footer text-muted bg-dark mt-3">
        <img src="/resources/img/footer.png" style="width: 100%;" />
    </div>
       
    </body>
</html>
