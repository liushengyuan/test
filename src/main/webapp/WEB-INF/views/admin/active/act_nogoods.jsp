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
			location.href="getNoActGoods?page="+e+"&pageSize=3&act_id="+$("#act_id").attr("name");
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
			location.href="getNoActGoods?page="+page+"&pageSize=3&act_id="+$("#act_id").attr("name");
		}
	}
	//改变图片大消
	function changImg(e){
		var url =e.name;
		var url2 =url.split("springmvc");
		e.src = "/springmvc"+url2[1];
	}
	//添加活动关联
	function delGoods(e){
		$.ajax({  
		    url: "addActGoods?goods_id="+e.name+"&act_id="+$("#act_id").attr("name"),  
		    //data: { "selectedIDs": _list },  
		    type: "POST",  
		    //traditional: true,  
		    success: function (responseJSON) {  
		        // your logic
		        alert(responseJSON);
		        location.href="getNoActGoods?page=1&pageSize=3&act_id="+$("#act_id").attr("name");
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
		<input value="${act_id}" id="act_id" type="hidden" name="${act_id}"/>
			<section>
		     <h2><strong style="color:grey;">商品列表</strong></h2>
		     <div class="page_title">
		      <h2 class="fl">商品列表</h2>
		     </div>
		     <table class="table">
		      <tr>
		       <th>商品名称</th>
		       <th>商品价格</th>
		       <th>详细信息</th>
		       <th>商品图片</th>
		       <th>商品图片</th>
		       <th>商品图片</th>
		       <th>操作</th>
		      </tr>
		      <c:forEach items="${ActNoGoods.data}" var="item">
		      <tr>
		       <td style="width:265px;"><div class="cut_title ellipsis">${item.goods_name}</div></td>
		       <td>${item.price}</td>
		       
		       <td>${item.info}</td>
		       <td><img src='/springmvc/1488808685274'  style="width:100px;height:100px;" name="${item.image1}" onload='changImg(this)'/></td>
		       <td><img src='/springmvc/1488808685274'  style="width:100px;height:100px;" name="${item.image2}" onload='changImg(this)'/> </td>
		       <td><img src='/springmvc/1488808685274'  style="width:100px;height:100px;" name="${item.image3}" onload='changImg(this)'/></td>
		       <td>
		        <a href="javascript:void(0)" class="inner_btn" name="${item.id}" onClick="delGoods(this)">添加活动关联</a>
		       </td>
		      </tr>
		      </c:forEach>
		     </table>
		     
		     <aside class="paging">
		      <a onClick="goUP(${ActNoGoods.currentPage})">上一页</a>
		      <a href="#">${ActNoGoods.currentPage}</a>
		      <a onClick="goDown(${ActNoGoods.totalPage},${ActNoGoods.currentPage})">下一页</a>
		     </aside>
		     
		    </section>
		</div>
	</section>
</body>
</html>
