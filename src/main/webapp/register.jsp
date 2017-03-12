<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
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
<script type="text/javascript">
function send(){
	var name =$("#memberName")[0].value;
	var address =$("#address")[0].value;
	var password =$("#password")[0].value;
	var conpassword =$("#conpassword")[0].value;
	
	if(!name||!address||!password||!conpassword){
		alert("请检查数据！");
		return;
	}
	if(password!=conpassword){
		alert("两次输入的密码不一致！")
		return;
	}
	$.ajax({
		cache: true,
		type: "POST",
		url:'addMember',
		data:$('#regist').serialize(),// 你的formid
		async: false,
		error: function(rs) {
			alert(rs.responseText);
			alert("111");
			//location.href="index.jsp";
			location.href="register.jsp";
		},
		success: function(responseJSON) {
			alert(responseJSON);
			location.href="account.jsp";
		}
	});
}
</script>
<!-- slide -->
</head>
<body>
<!--header-->
<%@ include  file="/shop/home_head.jsp"%>
<!--//header-->
<div class="container">
	<div class="register">
		<h1>Register</h1>
		  	  <form method="post" enctype="multipart/form-data" onsubmit="return false;" id="regist"> 
				 <div class="col-md-6  register-top-grid">
					
					<div class="mation">
						<span>你的用户名</span>
						<input type="text" name="memberName" id="memberName"> 
						
						 <span>你的地址</span>
						 <input type="text"  name="address" id="address"> 
					</div>
					 <div class="clearfix"> </div>
					  
					 </div>
				     <div class=" col-md-6 register-bottom-grid">
						   
							<div class="mation">
								<span>密码</span>
								<input type="text" name="password" id="password">
								<span>确认密码</span>
								<input type="text"  id="conpassword">
							</div>
					 </div>
					 <div class="clearfix"> </div>
				</form>
				
				<div class="register-but">
				   <form onsubmit="return false;">
					   <input type="submit" value="submit" onClick="send()">
					   <div class="clearfix"> </div>
				   </form>
				</div>
		   </div>
</div>

<!--footer-->
<%@ include  file="/shop/home_footer.jsp"%>
<!--//footer-->
</body>
</html>