<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<c:set value="<%=path%>" var="path" />  
<header>
 <h1><img src="images/admin_logo.png"/></h1>
 <ul class="rt_nav">
  <li><a  class="admin_icon">${adminUser.username}</a></li>
  
  <li><a href="../user/logout" class="quit_icon">安全退出</a></li>
  
 </ul>
</header>

<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 <ul>
  <li>
   <dl>
    <dt>商品管理</dt>
    <!--当前链接则添加class:active-->
    <dd><a href="../admin/getGoodsControll?page=1&pageSize=3">商品列表</a></dd>
    <dd><a href="../admin/addGoods">添加商品</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>活动管理</dt>
    <dd><a href="../admin/getAct">查看活动列表</a></dd>
    <!-- <dd><a href="../admin/addGoods">添加活动</a></dd> -->
   </dl>
  </li>
  <li>
   <dl>
    <dt>会员管理</dt>
    <dd><a href="#">会员列表</a></dd>
   <!--  <dd><a href="#">添加会员</a></dd> -->
   </dl>
  </li>
  <li>
   <dl>
    <dt>消息管理</dt>
    <dd><a href="../admin/getMessageList?page=1&pageSize=3">消息列表</a></dd>
   </dl>
  </li>
 </ul>
</aside>
