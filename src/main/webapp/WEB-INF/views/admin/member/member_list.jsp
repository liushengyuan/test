<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!--[if lt IE 9]>
<script src="js/html5.js"></script>
<![endif]-->
<style>
	.member-table td{
		text-align:center;
	}
</style>
<script src="js/jquery.js"></script>
<script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
</head>
<body>
	<%@ include  file="../../head.jsp"%>
	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">
			<section>
		     <h2><strong style="color:grey;">会员列表</strong></h2>
		     <div class="page_title">
		      <h2 class="fl">会员列表</h2>
		     </div>
		     <table class="table">
		      <tr>
		       <th>序号</th>
		       <th>会员名</th>
		       <th>地址</th>
		       <th>手机号</th>
		       <th>创建日期</th>
		       <th>账号状态</th>
		       <th>操作</th>
		      </tr>
		      <c:forEach items="${memberInfos}" var="memberInfo" varStatus="status"> 
		      <tr class="member-table">
		       <td style="width:100px;">${ status.index+memberInfoPage.getStartIndex()+1 }</td>
		       <td><c:out value="${memberInfo.memberName}" /></td>
		       <td><c:out value="${memberInfo.address}" /></td>
		       <td><c:out value="${memberInfo.mobile}" /></td>
		       <td><c:out value="${memberInfo.createDate}" /></td>
		       <td class="accountStatus"><c:if test="${memberInfo.ifFrozenAccount==0}">
   					    正常
				   </c:if>
				   <c:if test="${memberInfo.ifFrozenAccount==1}">
   					    被冻结
				   </c:if>
			   </td>
			   <!--<c:out value="${memberInfo.ifFrozenAccount}" />  -->
		       <td>
		        <a href="#" onClick="ifFrozenAccount(${memberInfo.id},1,${status.index})">冻结</a>
		        <a href="#" class="inner_btn" onClick="ifFrozenAccount(${memberInfo.id},0,${status.index})">解冻</a>
		       </td>
		      </tr>
		      </c:forEach>
		     </table>
		     <aside class="paging">
		      <a href="../admin/getMemberList?page=1&numPerPage=10">第一页</a>
	       	  <%-- <c:forEach  items="${pageResult}" begin="0" var="result" varStatus="status">
	       	  	<a>${ result+1 }</a>
              </c:forEach> --%>
              <a id="upPage" ><<<</a>
              <a>当前页[<c:out value="${memberInfoPage.getCurrentPage()}" />]</a>
              <a id="downPage">>>></a>
		      <a href="../admin/getMemberList?page=${memberInfoPage.getTotalPages()}&numPerPage=10">最后一页</a>
		      <a>总共[<c:out value="${memberInfoPage.getTotalPages()}" />]页</a>
		      
		     </aside>
		    </section>
		</div>
	</section>
	<script type="text/javascript">
		//上一页
		$("#upPage").on('click',function(){
			if(${memberInfoPage.getCurrentPage()}-1 == 0){
				alert("已经到达第一页");
				return;
			}
			window.location.href = "../admin/getMemberList?page="+(${memberInfoPage.getCurrentPage()}-1)+"&numPerPage=10";
		});
		//下一页
		$("#downPage").on('click',function(){
			if(${memberInfoPage.getCurrentPage()}+1 > ${memberInfoPage.getTotalPages()}){
				alert("已经到达最后一页");
				return;
			}
			window.location.href = "../admin/getMemberList?page="+(${memberInfoPage.getCurrentPage()}+1)+"&numPerPage=10";
		});
		function ifFrozenAccount(id,status,index){
			console.log(id+"---"+status);
			
			console.log(index);
			$.ajax({  
	              type:"POST",  
	              url:"updateMemberAccountStatus",  
	              data:{id:id,ifFrozenAccount:status},  
	              dataType: "json",   //返回值类型       使用json的话也可以，但是需要在JS中编写迭代的html代码，如果格式样式  
	              cache:false,  
	              success:function(data){  
	                  //var json = eval('('+msg+')');//拼接的json串  
	                  //$('#flushDIV').html(data);
	                    
	                  console.log(data);
	                  
	                  if(data){
	                	  var changeValue = $(".accountStatus")[index];
		                  if(status == 1){
		                	 
		                	 $(changeValue).html("被冻结");
				          }else{
				        	 $(changeValue).html("正常");
						  } 
		              }else{
		            	  if(status == 1){
		                	  alert("该账号已经是冻结状态,无需进行此操作");
				          }else{
				        	  alert("该账号已经是正常状态,无需进行此操作");
						  }
				      }
	                  
		              
	              },  
	              error:function(error){console.log(data);}  
	          });
		}
		    
		function ajax(type,url,data){
			$.ajax({
			    type:"POST",
			    url:"",
			})
		}
		
	</script>
</body>
</html>