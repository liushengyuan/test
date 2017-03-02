<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>后台登录</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="js/jquery.js"></script>
<script src="js/verificationNumbers.js"></script>
<script src="js/Particleground.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //验证码
  createCode();
  //测试提交，对接程序删除即可
  $(".submit_btn").click(function(){
	  //判断验证码
	  var Iscode = validate();
	  if(!Iscode){
		  alert("验证码不正确");
		  return;
	  }
	  //判断用户名或密码是否输入
	  var username = document.getElementById("username").value;
	  var passwprdValue = document.getElementById("password");
	  var password = passwprdValue.value;
	  if(!username||!password){
		  alert("用户名或密码不正确");
		  return;
	  }
	  $.ajax({  
		    url: 'login?username='+username+'&password='+password,  
		    //data: { "selectedIDs": _list },  
		    type: "POST",  
		    //traditional: true,  
		    success: function (responseJSON) {  
		        // your logic
		        location.href="isLogin";
		    },
		    error: function (rs){
		    	alert(rs.responseText);
		    	return;
		    }
		    
	  }); 
	});
  
});
</script>
</head>
<body>
<dl class="admin_login">
 <dt>
  <strong>站点后台管理系统</strong>
  <em>Management System</em>
 </dt>
 <dd class="user_icon">
  <input type="text" placeholder="账号" class="login_txtbx" id="username"/>
 </dd>
 <dd class="pwd_icon">
  <input type="password" placeholder="密码" class="login_txtbx" id="password"/>
 </dd>
 <dd class="val_icon">
  <div class="checkcode">
    <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
    <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
  </div>
  <input id="J_down" type="button" value="验证码核验" class="ver_btn" onClick="validate();">
 </dd>
 <dd>
  <input type="button" value="立即登陆" class="submit_btn" />
 </dd>
 <dd>
  <p>© 孙颖   商城后台毕业设计</p>
  <p>冀A2-20170224-1</p>
 </dd>
</dl>
</body>
</html>
