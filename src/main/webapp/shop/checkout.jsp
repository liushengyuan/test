<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Checkout</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
<!-- slide -->
<script type="text/javascript">
function changImg(e){
	var url =e.name;
	var url2 =url.split("springmvc");
	e.src = "/springmvc"+url2[1];
}
function goCart(){
	alert("此功能尚未开发！")
}
</script>
</head>
<body>
<!--header-->
<%@ include  file="home_head.jsp"%>
<!--//header-->
<!---->
<div class="container">
	<div class="check-out">
		<h1>Checkout</h1>
    	    <table >
		  <tr>
			<th>Item</th>
			<th>num</th>		
			<th>Prices</th>
		  </tr>
		  <c:forEach items="${list}" var="item">
		  <tr>
			<td class="ring-in"><a href="getGoodsInfo?goods_id=${item.goods_id}" class="at-in"><img src="images/ce.jpg" class="img-responsive" alt="" name="${item.goods_image1}" onload='changImg(this)'></a>
			<div class="sed">
				<h5>${item.goods_name}</h5>
			
			</div>
			<div class="clearfix"> </div></td>
			<td class="check">1</td>		
			<td>$${item.goods_price}</td>
		  </tr>
		 </c:forEach>
	</table>
	<a href="javaScript:void(0)" class=" to-buy" onClick="goCart()">立即购买</a>
	<div class="clearfix"> </div>
    </div>
</div>
<!--footer-->
<%@ include  file="/shop/home_footer.jsp"%>
<!--//footer-->
</body>
</html>