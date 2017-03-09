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
//删除
function delGoods(e){
	$.ajax({  
	    url: "removeMessage?id="+e.name,  
	    //data: { "selectedIDs": _list },  
	    type: "POST",  
	    //traditional: true,  
	    success: function (responseJSON) {  
	        // your logic
	        alert(responseJSON);
	        location.href="getMessageList?page=1&pageSize=3";
	    },
	    error: function (rs){
	    	alert(rs.responseText);
	    	return;
	    }
	});
}
</script>
</head>
<body>
<!--header-->
<%@ include  file="../../head.jsp"%>
	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">
			<section>
		     <h2><strong style="color:grey;">消息列表</strong></h2>
		     <div class="page_title">
		      <h2 class="fl">消息列表</h2>
		     </div>
		     <table class="table">
		      <tr>
		       <th>消息编号</th>
		       <th>留言用户</th>
		       <th>留言信息</th>
		       <th>用户手机</th>
		       <th>操作</th>
		      </tr>
		      <c:forEach items="${pageList.data}" var="item">
		      <tr>
		       <td style="width:25px;"><div class="cut_title ellipsis">${item.id}</div></td>
		       <td>${item.member_name}</td>
		       <td>${item.message}</td>
		       <td>${item.member_phone}</td>
		       <td>
		        <a href="javascript:void(0)" class="inner_btn" name="${item.id}" onClick="delGoods(this)">删除</a>
		       </td>
		      </tr>
		      </c:forEach>
		     </table>
		     
		     <aside class="paging">
		      <a onClick="goUP(${pageList.currentPage})">上一页</a>
		      <a href="#">${pageList.currentPage}</a>
		      <a onClick="goDown(${pageList.totalPage},${pageList.currentPage})">下一页</a>
		     </aside>
		     
		    </section>
		</div>
	</section>
</body>
</html>
