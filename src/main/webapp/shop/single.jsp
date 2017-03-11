<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Single</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Fashion Mania Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!---->
</head>
<body>
<!--header-->
<%@ include  file="home_head.jsp"%>
<!---->
<div class="single">

<div class="container">
<div class="col-md-9">
	<div class="col-md-5 grid">		
		<div class="flexslider">
			  <ul class="slides">
			    <li data-thumb= "${goodsinfo.image1}">
			        <div class="thumb-image"> <img src="${goodsinfo.image1}" data-imagezoom="true" class="img-responsive" > </div>
			    </li>
			    <li data-thumb= "${goodsinfo.image1}">
			         <div class="thumb-image"> <img src="${goodsinfo.image1}" data-imagezoom="true" class="img-responsive"> </div>
			    </li>
			    <li data-thumb= "${goodsinfo.image1}">
			       <div class="thumb-image"> <img src="${goodsinfo.image1}" data-imagezoom="true" class="img-responsive" > </div>
			    </li> 
			  </ul>
		</div>
	</div>	
<div class="col-md-7 single-top-in">
						<div class="single-para simpleCart_shelfItem">
							<h1>${goodsinfo.goods_name}</h1>
							<p>${goodsinfo.info}</p>
							<div class="star-on">
								<ul>
									<li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
									<li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
									<li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
									<li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
									<li><a href="#"><i class="glyphicon glyphicon-star"> </i></a></li>
								</ul>
								
							<div class="clearfix"> </div>
							</div>
							
								<label  class="add-to item_price">$${goodsinfo.price}</label>
							
						
								<a href="#" class="cart item_add">Add Cart</a>
						</div>
					</div>
			<div class="clearfix"> </div>
			<div class="content-top1">
				<div class="col-md-4 col-md3">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="single.html">
							<img class="img-responsive" src="images/pi6.png" alt="" />
						</a>
						<h3><a href="single.html">Jeans</a></h3>
						<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
					</div>
				</div>	
			<div class="col-md-4 col-md3">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="single.html">
							<img class="img-responsive" src="images/pi7.png" alt="" />
						</a>
						<h3><a href="single.html">Tops</a></h3>
						<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
						
					</div>
				</div>	
			<div class="col-md-4 col-md3">
					<div class="col-md1 simpleCart_shelfItem">
						<a href="single.html">
							<img class="img-responsive" src="images/pi.png" alt="" />
						</a>
						<h3><a href="single.html">Tops</a></h3>
						<div class="price">
								<h5 class="item_price">$300</h5>
								<a href="#" class="item_add">Add To Cart</a>
								<div class="clearfix"> </div>
						</div>
						
					</div>
				</div>	
			
			<div class="clearfix"> </div>
			</div>	
</div>
<!----->
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
<!--footer-->
<%@ include  file="/shop/home_footer.jsp"%>
<!-- slide -->
<script src="js/jquery.min.js"></script>
<script src="js/imagezoom.js"></script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
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
<!-- FlexSlider -->
<script defer src="js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>
<!---pop-up-box---->
					<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
					<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
					<!---//pop-up-box---->
					 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});
						
				</script>	
</body>
</html>