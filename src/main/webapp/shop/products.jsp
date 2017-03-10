<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<title>Home</title>
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
<script src="js/responsiveslides.min.js"></script>
   <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
    function changImg(e){
		var url =e.name;
		var url2 =url.split("springmvc");
		e.src = "/springmvc"+url2[1];
	}
  </script>
</head>
<body>
<!--header-->
<%@ include  file="home_head.jsp"%>
<!--content-->
<div class="products">
	<div class="container">
		<h1>Products</h1>
		<div class="col-md-9">
			<div class="content-top1">
				<c:forEach items="${goodsList}" var="item">
				<div class="col-md-3 col-md2">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="single.html">
							<img class="img-responsive" src="images/pi3.png" alt="" name="${item.image1}" onload='changImg(this)' />
						</a>
						<h3><a href="single.html">${item.name}</a></h3>
						<div class="price">
								<h5 class="item_price">$${item.price}</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
					</div>
				</div>
				</c:forEach>	
			<div class="clearfix"> </div>
			</div>	
		</div>
		<div class="col-md-3 product-bottom">
			<!--categories-->
				<div class=" rsidebar span_1_of_left">
						<h3 class="cate">分类</h3>
							 <ul class="menu-drop">
							<li class="item1"><a href="">男装 </a>
								<ul class="cute">
									<li class="subitem1"><a href="getSeachList?cla=0&child_cla=0">上衣 </a></li>
									<li class="subitem2"><a href="getSeachList?cla=0&child_cla=1">裤子 </a></li>
									<li class="subitem3"><a href="getSeachList?cla=0&child_cla=2">鞋子 </a></li>
								</ul>
							</li>
							<li class="item2"><a href="#">女装 </a>
								<ul class="cute">
									<li class="subitem1"><a href="getSeachList?cla=1&child_cla=0">上衣 </a></li>
									<li class="subitem2"><a href="getSeachList?cla=1&child_cla=1">裤子 </a></li>
									<li class="subitem3"><a href="getSeachList?cla=1&child_cla=2">鞋子 </a></li>
								</ul>
							</li>
							<li class="item3"><a href="#">童装</a>
								<ul class="cute">
									<li class="subitem1"><a href="getSeachList?cla=2&child_cla=0">上衣 </a></li>
									<li class="subitem2"><a href="getSeachList?cla=2&child_cla=1">裤子 </a></li>
									<li class="subitem3"><a href="getSeachList?cla=2&child_cla=2">鞋子 </a></li>
								</ul>
							</li>
							
						</ul>
					</div>
				<!--initiate accordion-->
						<script type="text/javascript">
							$(function() {
							    var menu_ul = $('.menu-drop > li > ul'),
							           menu_a  = $('.menu-drop > li > a');
							    menu_ul.hide();
							    menu_a.click(function(e) {
							        e.preventDefault();
							        if(!$(this).hasClass('active')) {
							            menu_a.removeClass('active');
							            menu_ul.filter(':visible').slideUp('normal');
							            $(this).addClass('active').next().stop(true,true).slideDown('normal');
							        } else {
							            $(this).removeClass('active');
							            $(this).next().stop(true,true).slideUp('normal');
							        }
							    });
							
							});
						</script>
<!--//menu-->
<!--seller-->
<!--//seller-->
<!--tag-->
			
		</div>
		<div class="clearfix"> </div>
	</div>
</div>
<!--//content-->
<!--footer-->
<%@ include  file="/shop/home_footer.jsp"%>
<!--//footer-->
</body>
</html>