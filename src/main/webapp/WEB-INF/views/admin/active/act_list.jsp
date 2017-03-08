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
<script>
//上一页
function goUP(e){
	if(e==1){
		alert("当前是第一页")
	}else{
		e=e-1;
		location.href="getMessageList?page="+e+"&pageSize=3";
	}
}
//下一页
function goDown(e,f){
	var pagelast = parseInt(f); 
	var pagetotal = parseInt(e); 
	if(pagelast>=pagetotal){
		alert("当前是最后一页");
	}else{
		var page =pagelast+1;
		location.href="getMessageList?page="+page+"&pageSize=3";
	}
}
//查看活动关联的商品
function addActGoods(e){
	location.href="getActGoods?page=1&pageSize=3&act_id="+e.name;
}
//添加活动商品
function getNoActGoods(e){
	location.href="getNoActGoods?page=1&pageSize=3&act_id="+e.name;
}
</script>
</head>
<body>
<!--header-->
<%@ include  file="../../head.jsp"%>
	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">
			<section>
		     <h2><strong style="color:grey;">活动列表</strong></h2>
		     <div class="page_title">
		      <h2 class="fl">活动列表</h2>
		     </div>
		     <table class="table">
		      <tr>
		       <th>活动编号</th>
		       <th>活动名称</th>
		       <th>活动介绍</th>
		       <th>操作</th>
		      </tr>
		     <%--  <c:forEach items="${pageList.data}" var="item"> --%>
		      <tr>
		       <td style="width:25px;"><div class="cut_title ellipsis">${actList.id}</div></td>
		       <td>${actList.act_name}</td>
		       <td>${actList.act_info}</td>
		       <td>
		        <a href="javascript:void(0)" class="inner_btn" name="${actList.id}" onClick="addActGoods(this)">查看活动关联商品</a>
		        <a href="javascript:void(0)" class="inner_btn" name="${actList.id}" onClick="getNoActGoods(this)">添加活动关联商品</a>
		       </td>
		      </tr>
		      <%-- </c:forEach> --%>
		     </table>
		     
		    <%--  <aside class="paging">
		      <a onClick="goUP(${pageList.currentPage})">上一页</a>
		      <a href="#">${pageList.currentPage}</a>
		      <a onClick="goDown(${pageList.totalPage},${pageList.currentPage})">下一页</a>
		     </aside> --%>
		     
		    </section>
		</div>
	</section>
</body>
</html>
