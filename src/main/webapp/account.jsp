<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>Account</title>
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
<script type="text/javascript">
function send(){
	var name =$("#memberName")[0].value;
	var password =$("#password")[0].value;
	alert("111");
	if(!name||!password){
		alert("请检查数据！");
		return;
	}
	
	$.ajax({
		cache: true,
		type: "POST",
		url:'login',
		data:$('#login').serialize(),// 你的formid
		async: false,
		error: function(rs) {
			alert(rs.responseText);
			alert("111");
			//location.href="index.jsp";
			location.href="account.jsp";
		},
		success: function(responseJSON) {
			alert(responseJSON);
			location.href="index.jsp";
		}
	});
}
</script>
<body>
<!--header-->
<%@ include  file="/shop/home_head.jsp"%>
<!--//header-->
<div class="account">
	<div class="container">
		<h1>Account</h1>
		<div class="account_grid">
			   <div class="col-md-6 login-right">
				<form method="post" enctype="multipart/form-data" onsubmit="return false;" id="login">

					<span>用户名</span>
					<input type="text" id="memberName" name="memberName"> 
				
					<span>密码</span>
					<input type="text" id="password" name="password"> 
					<div class="word-in">
				  		
				 		 <input type="submit" value="Login" onClick="send()">
				  	</div>
			    </form>
			   </div>	
			    <div class="col-md-6 login-left">
			  	 <h4>新用户注册</h4>
				 <p>这是孙颖毕业设计这是孙颖毕业设计这是孙颖毕业设计这是孙颖毕业设计这是孙颖毕业设计这是孙颖毕业设计这是孙颖毕业设计这是孙颖毕业设计</p>
				 <a class="acount-btn" href="register.jsp">创建账户</a>
			   </div>
			   <div class="clearfix"> </div>
			 </div>
	</div>
</div>

<!--footer-->
<%@ include  file="/shop/home_footer.jsp"%>
<!--//footer-->
</body>
</html>