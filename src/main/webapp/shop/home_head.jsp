<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<script type="text/javascript">
function goCart(){
	var member_id = $("#memberid").attr("value")?$("#memberid")[0].value:"";
	if(!member_id){
		alert("请先登陆")
		return;
	}
	location.href="getCartGoods";
}

</script>
<div class="header">
	<div class="header-top">
		<div class="container">
		<div class="col-sm-4 world">
					<c:if test="${sessionScope.member==null}">
					<ul >
						<p class="log"><a href="account.jsp"  >Login</a>
						<span>or</span><a  href="account.jsp"  >Signup</a></p>
					</ul>
					</c:if>
					<c:if test="${sessionScope.member!=null}">
						<p class="log">用户:
						<span>${sessionScope.member.memberName}</span>
						<input type="hidden" value="${sessionScope.member.id}" id="memberid"/></p>
					</c:if>
				</div>
				<div class="col-sm-4 logo">
					<a href="index.jsp"><img src="images/logo.png" alt=""></a>	
				</div>
		
			<div class="col-sm-4 header-left">		
					
					<div class="cart box_1">
						<h3> <div class="total">
							</div>
							<img src="images/cart.png" alt="" onClick="goCart()"/></h3>
						</a>

					</div>
					<div class="clearfix"> </div>
			</div>
				<div class="clearfix"> </div>
		</div>
		</div>
		<div class="container">
			<div class="head-top">
				<div class="col-sm-2 number">
					<span><i class="glyphicon glyphicon-phone"></i>085 596 234</span>
				</div>
		 <div class="col-sm-8 h_menu4">
				<ul class="memenu skyblue">
					  <li class=" grid"><a  href="index.jsp">首页</a></li>	
				      <li><a  href="#">男装</a>
				      	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>上衣</h4>
									<ul>
									<li><a href="getSeachList?cla=0&child_cla=0&three_cla=1">棉衣</a></li>
									<li><a href="getSeachList?cla=0&child_cla=0&three_cla=2">毛衣</a></li>
									<li><a href="getSeachList?cla=0&child_cla=0&three_cla=3">风衣</a></li>
									<li><a href="getSeachList?cla=0&child_cla=0&three_cla=4">大衣</a></li>
									<li><a href="getSeachList?cla=0&child_cla=0&three_cla=5">衬衫</a></li>	
									<li><a href="getSeachList?cla=0&child_cla=0&three_cla=6">卫衣</a></li>	
									<li><a href="getSeachList?cla=0&child_cla=0&three_cla=7">小西装</a></li>	
									<li><a href="getSeachList?cla=0&child_cla=0&three_cla=8">小背心</a></li>
									<li><a href="getSeachList?cla=0&child_cla=0&three_cla=9">T恤</a></li>	
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>裤子</h4>
									<ul>
									<li><a href="getSeachList?cla=0&child_cla=1&three_cla=10">牛仔裤 </a></li>
									<li><a href="getSeachList?cla=0&child_cla=1&three_cla=11">休闲裤</a></li>	
									<li><a href="getSeachList?cla=0&child_cla=1&three_cla=12">运动裤</a></li>	
									<li><a href="getSeachList?cla=0&child_cla=1&three_cla=13">打底裤</a></li>	
									<li><a href="getSeachList?cla=0&child_cla=1&three_cla=14">背带裤</a></li>
									<li><a href="getSeachList?cla=0&child_cla=1&three_cla=15">靴裤</a></li>	
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>鞋</h4>
									<ul>
									<li><a href="getSeachList?cla=0&child_cla=2&three_cla=16">皮鞋 </a></li>
									<li><a href="getSeachList?cla=0&child_cla=2&three_cla=17">凉鞋</a></li>	
									<li><a href="getSeachList?cla=0&child_cla=2&three_cla=18">布鞋</a></li>	
									<li><a href="getSeachList?cla=0&child_cla=2&three_cla=19">人造革鞋</a></li>	
									<li><a href="getSeachList?cla=0&child_cla=2&three_cla=20">饰品鞋</a></li>
									</ul>	
								</div>												
							</div>
						  </div>
						</div>
					</li>
				    <li class="grid"><a  href="#">	女装</a>
					  	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<h4>上衣</h4>
									<ul>
									<li><a href="getSeachList?cla=1&child_cla=0&three_cla=1">棉衣</a></li>
									<li><a href="getSeachList?cla=1&child_cla=0&three_cla=2">毛衣</a></li>
									<li><a href="getSeachList?cla=1&child_cla=0&three_cla=3">风衣</a></li>
									<li><a href="getSeachList?cla=1&child_cla=0&three_cla=4">大衣</a></li>
									<li><a href="getSeachList?cla=1&child_cla=0&three_cla=5">衬衫</a></li>	
									<li><a href="getSeachList?cla=1&child_cla=0&three_cla=6">卫衣</a></li>	
									<li><a href="getSeachList?cla=1&child_cla=0&three_cla=7">小西装</a></li>	
									<li><a href="getSeachList?cla=1&child_cla=0&three_cla=8">小背心</a></li>
									<li><a href="getSeachList?cla=1&child_cla=0&three_cla=9">T恤</a></li>
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>裤子</h4>
									<ul>
									<li><a href="getSeachList?cla=1&child_cla=1&three_cla=10">牛仔裤 </a></li>
									<li><a href="getSeachList?cla=1&child_cla=1&three_cla=11">休闲裤</a></li>	
									<li><a href="getSeachList?cla=1&child_cla=1&three_cla=12">运动裤</a></li>	
									<li><a href="getSeachList?cla=1&child_cla=1&three_cla=13">打底裤</a></li>	
									<li><a href="getSeachList?cla=1&child_cla=1&three_cla=14">背带裤</a></li>
									<li><a href="getSeachList?cla=1&child_cla=1&three_cla=15">靴裤</a></li>	
									</ul>
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>鞋</h4>
									<ul>
									<li><a href="getSeachList?cla=1&child_cla=2&three_cla=16">皮鞋 </a></li>
									<li><a href="getSeachList?cla=1&child_cla=2&three_cla=17">凉鞋</a></li>	
									<li><a href="getSeachList?cla=1&child_cla=2&three_cla=18">布鞋</a></li>	
									<li><a href="getSeachList?cla=1&child_cla=2&three_cla=19">人造革鞋</a></li>	
									<li><a href="getSeachList?cla=1&child_cla=2&three_cla=20">饰品鞋</a></li>
									</ul>	
								</div>												
							</div>
						  </div>
						</div>
			    </li>
				<li><a class="color6" href="contact.jsp">联系我们</a></li>
			  </ul> 
			</div>