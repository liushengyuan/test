<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>后台管理系统</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery.js"></script>
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>
	(function($){
		$(window).load(function(){
			String addr = "admin/goods/goods_list.jsp";
			$("a[rel='load-content']").click(function(e){
				e.preventDefault();
				var url=$(this).attr("href");
				$.get(url,function(data){
					$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
					//scroll-to appended content 
					$(".content").mCustomScrollbar("scrollTo","h2:last");
				});
			});
			
			$(".content").delegate("a[href='top']","click",function(e){
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
			
		});
	})(jQuery);
</script>
</head>
<body>
<!--header-->
<%@ include  file="../../head.jsp"%>
	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">
		<section>
	      <h2><strong style="color:grey;">添加商品</strong></h2>
	      <ul class="ulColumn2">
	       <li>
	        <span class="item_name" style="width:120px;">商品名称：</span>
	        <input type="text" class="textbox textbox_295" placeholder="输入你的商品名称..."/>
	        <span class="errorTips">错误提示信息...</span>
	       </li>
	       <li>
	        <span class="item_name" style="width:120px;">分类：</span>
	        <select class="select">
	         <option>选择分类</option>
	        </select>
	        <span class="errorTips">错误提示信息...</span>
	       </li>
	       <li>
	        <span class="item_name" style="width:120px;">二级分类：</span>
	        <select class="select">
	         <option>选择子分类</option>
	        </select>
	        <span class="errorTips">错误提示信息...</span>
	       </li>
	        <li>
	        <span class="item_name" style="width:120px;">三级分类：</span>
	        <select class="select">
	         <option>选择子分类</option>
	        </select>
	        <span class="errorTips">错误提示信息...</span>
	       </li>
	       <li>
	        <span class="item_name" style="width:120px;">是否上架：</span>
	        <label class="single_selection"><input type="radio" name="name"/>是</label>
	        <label class="single_selection"><input type="radio" name="name"/>否</label>
	       </li>
	       <li>
	        <span class="item_name" style="width:120px;">详细信息：</span>
	        <textarea placeholder="详细信息" class="textarea" style="width:500px;height:100px;"></textarea>
	       </li>
	       <li>
	        <span class="item_name" style="width:120px;">上传图片：</span>
	        <label class="uploadImg">
	         <input type="file"/>
	         <span>上传图片</span>
	        </label>
	        <span class="item_name" style="width:120px;">上传图片：</span>
	        <label class="uploadImg">
	         <input type="file"/>
	         <span>上传图片</span>
	        </label>
	        <span class="item_name" style="width:120px;">上传图片：</span>
	        <label class="uploadImg">
	         <input type="file"/>
	         <span>上传图片</span>
	        </label>
	       </li>
	       <li>
	        <span class="item_name" style="width:120px;"></span>
	        <input type="submit" class="link_btn"/>
	       </li>
	      </ul>
	     </section>
		</div>
	</section>
</body>
</html>
