﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
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
<header>
 <h1><img src="images/admin_logo.png"/></h1>
 <ul class="rt_nav">
  <li><a  class="admin_icon">${adminUser.username}</a></li>
  <li><a href="logout" class="quit_icon">安全退出</a></li>
 </ul>
</header>

<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 <ul>
  <li>
   <dl>
    <dt>商品管理</dt>
    <!--当前链接则添加class:active-->
    <dd><a href="#">商品列表</a></dd>
    <dd><a href="../goods/addGoods">添加商品</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>活动管理</dt>
    <dd><a href="#">查看活动列表</a></dd>
    <dd><a href="#">添加活动</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>会员管理</dt>
    <dd><a href="#">会员列表</a></dd>
    <dd><a href="#">添加会员</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>消息管理</dt>
    <dd><a href="#">消息列表</a></dd>
   </dl>
  </li>
 </ul>
</aside>
<section class="rt_wrap content mCustomScrollbar">
	<div class="rt_content">
	<!-- 商品列表 -->
	<%-- <%@ include  file="admin/goods/goods_list.jsp"%> --%>
	<!-- 添加商品 -->
	<%-- <c:if test="${addr!=null}"> --%>
	<%-- <%@ include  file=${addr} %>  --%>
	<%-- </c:if> --%>
	 <jsp:include page="admin/goods/goods_list.jsp"/>
	</div>
</section>


<!-- <section class="rt_wrap content mCustomScrollbar">
  <div class="rt_content"> 
     开始：以下内容则可删除，仅为素材引用参考
     <h1 style="color:red;font-size:20px;font-weight:bold;text-align:center;">Example/Explanation</h1>
     <p style="color:red;font-size:16px;font-weight:bold;text-align:center;">这里是相关常用性样式预设，具体根据内容版块调整，列表添加字段注意考虑笔记本屏幕显示；<br/>此页面仅为样式参考，程序对接可移除，具体布局根据项目内容而定<br/>注意保留rt_content.parent</p>
     点击加载
     <script>
     $(document).ready(function(){
		$("#loading").click(function(){
			$(".loading_area").fadeIn();
             $(".loading_area").fadeOut(1500);
			});
		 });
     </script>
     <section class="loading_area">
      <div class="loading_cont">
       <div class="loading_icon"><i></i><i></i><i></i><i></i><i></i></div>
       <div class="loading_txt"><mark>数据正在加载，请稍后！</mark></div>
      </div>
     </section>
     结束加载
     弹出框效果
     <script>
     $(document).ready(function(){
		 //弹出文本性提示框
		 $("#showPopTxt").click(function(){
			 $(".pop_bg").fadeIn();
			 });
		 //弹出：确认按钮
		 $(".trueBtn").click(function(){
			 alert("你点击了确认！");//测试
			 $(".pop_bg").fadeOut();
			 });
		 //弹出：取消或关闭按钮
		 $(".falseBtn").click(function(){
			 alert("你点击了取消/关闭！");//测试
			 $(".pop_bg").fadeOut();
			 });
		 });
     </script>
     <section class="pop_bg">
      <div class="pop_cont">
       title
       <h3>弹出提示标题</h3>
       content
       <div class="pop_cont_input">
        <ul>
         <li>
          <span>标题</span>
          <input type="text" placeholder="定义提示语..." class="textbox"/>
         </li>
         <li>
          <span class="ttl">城市</span>
          <select class="select">
           <option>选择省份</option>
          </select>
          <select class="select">
           <option>选择城市</option>
          </select>
          <select class="select">
           <option>选择区/县</option>
          </select>
         </li>
         <li>
          <span class="ttl">地址</span>
          <input type="text" placeholder="定义提示语..." class="textbox"/>
         </li>
         <li>
          <span class="ttl">地址</span>
          <textarea class="textarea" style="height:50px;width:80%;"></textarea>
         </li>
        </ul>
       </div>
       以pop_cont_text分界
       <div class="pop_cont_text">
        这里是文字性提示信息！
       </div>
       bottom:operate->button
       <div class="btm_btn">
        <input type="button" value="确认" class="input_btn trueBtn"/>
        <input type="button" value="关闭" class="input_btn falseBtn"/>
       </div>
      </div>
     </section>
     结束：弹出框效果

     <section>
      <h2><strong style="color:grey;">常用按钮（水平块元素，无区域限制）</strong></h2>
      <a class="link_btn" id="loading">点击加载</a>
      <button class="link_btn" id="showPopTxt">测试弹出框</button>
      <input type="button" value="按钮input" class="link_btn"/>
     </section>
      <section>
      <h2><strong style="color:grey;">表单样式（组合）</strong></h2>
      <input type="text" class="textbox" placeholder="默认宽度..."/>
      <input type="text" class="textbox textbox_295" placeholder="class=295px..."/>
      <input type="text" class="textbox textbox_225" placeholder="class=225px..."/>
      <select class="select">
       <option>下拉菜单</option>
       <option>菜单1</option>
      </select>
      <input type="button" value="组合按钮" class="group_btn"/>
     </section>
    
     
     tabStyle
     <script>
     $(document).ready(function(){
		 //tab
		 $(".admin_tab li a").click(function(){
		  var liindex = $(".admin_tab li a").index(this);
		  $(this).addClass("active").parent().siblings().find("a").removeClass("active");
		  $(".admin_tab_cont").eq(liindex).fadeIn(150).siblings(".admin_tab_cont").hide();
		 });
		 });
     </script>
     <section>
      <ul class="admin_tab">
       <li><a class="active">自定义标题</a></li>
       <li><a>自定义标题</a></li>
       <li><a>...可追加</a></li>
      </ul>
      tabCont
      <div class="admin_tab_cont" style="display:block;">添加时，对其增加一个父级，tabContent01子项无样式，具体情况单独定义。</div>
      <div class="admin_tab_cont">tabContent02，内容根据具体数据二次单独定义，公共样式单独调用</div>
      <div class="admin_tab_cont">可追加</div>
     </section>
          <section>
      <ul class="admin_tab">
       <li><a class="active">自定义标题</a></li>
       <li><a>自定义标题</a></li>
       <li><a>...可追加</a></li>
      </ul>
      tabCont
      <div class="admin_tab_cont" style="display:block;">
      左右分栏：左侧栏目
       <div class="cont_col_lt mCustomScrollbar" style="height:500px;">
           <table class="table fl">
            <tr>
             <th>角色</th>
             <th>操作</th>
            </tr>
            <tr>
             <td class="center">顶级管理员</td>
             <td class="center"><a class="inner_btn">DeathGhost</a></td>
            </tr>
            <tr>
             <td class="center">采购人员</td>
             <td class="center"><a class="inner_btn">DeathGhost</a></td>
            </tr>
           </table>
           <table class="table fl" style="margin-top:8px;">
            <tr>
             <th>角色</th>
             <th>操作</th>
            </tr>
            <tr>
             <td class="center">顶级管理员</td>
             <td class="center"><a class="inner_btn">DeathGhost</a></td>
            </tr>
            <tr>
             <td class="center">采购人员</td>
             <td class="center"><a class="inner_btn">DeathGhost</a></td>
            </tr>
           </table>
       </div>
       左右分栏：右侧栏
       <div class="cont_col_rt">
           <table class="table fl">
            <tr>
             <th>资源</th>
             <th>描述</th>
             <th>操作</th>
            </tr>
            <tr>
             <td class="center">测试</td>
             <td>数据信息过多（扩展性太大），不建议使用此布局，以免数据溢出。</td>
             <td class="center"><a class="inner_btn">DeathGhost</a></td>
            </tr>
            <tr>
             <td class="center">测试</td>
             <td>数据信息过多（扩展性太大），不建议使用此布局，以免数据溢出。</td>
             <td class="center"><a class="inner_btn">DeathGhost</a></td>
            </tr>
           </table>
       </div>
      </div>
      <div class="admin_tab_cont">tabContent02，内容根据具体数据二次单独定义，公共样式单独调用</div>
      <div class="admin_tab_cont">可追加</div>
 </section>
    结束：以下内容则可删除，仅为素材引用参考
 </div>
</section> -->
</body>
</html>
