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
		     <h2><strong style="color:grey;">商品列表</strong></h2>
		     <div class="page_title">
		      <h2 class="fl">商品列表</h2>
		     </div>
		     <table class="table">
		      <tr>
		       <th>项目1</th>
		       <th>项目2</th>
		       <th>项目3</th>
		       <th>项目4</th>
		       <th>项目5</th>
		       <th>项目6</th>
		       <th>项目7</th>
		      </tr>
		      <tr>
		       <td style="width:265px;"><div class="cut_title ellipsis">265px宽·长标题字符串截取，仅适合单行截取，多行截取程序定义一下。</div></td>
		       <td>内容二</td>
		       <td>内容三</td>
		       <td>内容四</td>
		       <td>内容五</td>
		       <td>内容六</td>
		       <td>
		        <a href="#">表内链接</a>
		        <a href="#" class="inner_btn">表内按钮</a>
		       </td>
		      </tr>
		      <tr>
		       <td style="width:265px;"><div class="cut_title ellipsis">265px宽·长标题字符串截取，仅适合单行截取，多行截取程序定义一下。</div></td>
		       <td>内容二</td>
		       <td>内容三</td>
		       <td>内容四</td>
		       <td>内容五</td>
		       <td>内容六</td>
		       <td>
		        <a href="#">表内链接</a>
		        <a href="#" class="inner_btn">表内按钮</a>
		       </td>
		      </tr>
		      <tr>
		       <td style="width:265px;"><div class="cut_title ellipsis">265px宽·长标题字符串截取，仅适合单行截取，多行截取程序定义一下。</div></td>
		       <td>内容二</td>
		       <td>内容三</td>
		       <td>内容四</td>
		       <td>内容五</td>
		       <td>内容六</td>
		       <td>
		        <a href="#">表内链接</a>
		        <a href="#" class="inner_btn">表内按钮</a>
		       </td>
		      </tr>
		     </table>
		     <aside class="paging">
		      <a>第一页</a>
		      <a>1</a>
		      <a>2</a>
		      <a>3</a>
		      <a>…</a>
		      <a>1004</a>
		      <a>最后一页</a>
		     </aside>
		    </section>
		</div>
	</section>
</body>
</html>
