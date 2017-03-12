<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Contact</title>
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
</head>
<script>
function send(){
	var name =$("#name")[0].value;
	var price =$("#email")[0].value;
	var info =$("#info")[0].value;
	var phone =$("#phone")[0].value;
	
	if(!name||!price||!info||!phone){
		alert("请检查数据！");
		return;
	}
	var pattern = /^1[34578]\d{9}$/;
	if(!pattern.test(phone)){
		alert("手机号码不正确")
		return;
	}
	
	$.ajax({
		cache: true,
		type: "POST",
		url:'addMessage',
		data:$('#message').serialize(),// 你的formid
		async: false,
		error: function(rs) {
			alert(rs.responseText);
		},
		success: function(responseJSON) {
			alert(responseJSON);
		}
	});
}
</script>
<body>
<!--header-->
<%@ include  file="/shop/home_head.jsp"%>
<!--//header-->
<div class="contact">
			<div class="container">
				<h1>Contact</h1>
				
				<div class="contact-grids">
					<div class="contact-form">
							<form method="post" enctype="multipart/form-data" onsubmit="return false;" id="message">
								<div class="contact-bottom">
									<div class="col-md-4 in-contact">
										<span>Name</span>
										<input type="text" id="name" name="name" style="color:#333">
									</div>
									<div class="col-md-4 in-contact">
										<span>Email</span>
										<input type="text" id="email" name="email" style="color:#333">
									</div>
									<div class="col-md-4 in-contact">
										<span>Phonenumber</span>
										<input type="text"  id="phone" name="phone" style="color:#333">
									</div>
									<div class="clearfix"> </div>
								</div>
							
								<div class="contact-bottom-top">
									<span>Message</span>
									<textarea id="info" name="info" style="color:#333"> </textarea>								
									</div>
							</form>
							<input type="submit" onClick="send()">
						</div>
				<div class="address">
					<div class=" address-more">
						<h2>Address</h2>
						<div class="col-md-4 address-grid">
							<i class="glyphicon glyphicon-map-marker"></i>
							<div class="address1">
								<p>Lorem ipsum dolor</p>
								<p>TL 19034-88974</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="col-md-4 address-grid ">
							<i class="glyphicon glyphicon-phone"></i>
							<div class="address1">
								<p>+885699655</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="col-md-4 address-grid ">
							<i class="glyphicon glyphicon-envelope"></i>
							<div class="address1">
								<p><a href="mailto:@example.com"> @example.com</a></p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!--//content-->

<!--footer-->
<%@ include  file="/shop/home_footer.jsp"%>
<!--//footer-->
</body>
</html>