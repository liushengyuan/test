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
<script src="js/jquery-form.js"></script>
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
var image1="";//第一张图片的地址
var image2="";//第2张图片的地址
var image3="";//第3张图片的地址
var is_check="";//是否推荐
//二级分类点击事件
function selectOnchang(obj){
	//调用cont
	var child = obj.value;
	if(child==3){
		 $("#threeClass").html("");
	     $("#threeClass").append("<option>选择三级分类</option>");
		return;
	}
	$.ajax({  
	    url: 'getClass?child='+child,  
	    //data: { "selectedIDs": _list },  
	    type: "POST",  
	    //traditional: true,  
	    success: function (responseJSON) {  
	       var json = responseJSON;
	       $("#threeClass").html("");
	       $("#threeClass").append("<option>选择三级分类</option>");
	       for(var o in json){  
	           $("#threeClass").append("<option value='"+json[o].id+"'>"+json[o].three_cla+"</option>");
	         }  
	    },
	    error: function (rs){
	    	alert(rs.responseText);
	    	return;
	    }
	    
  }); 
}
//form 表单提交
function submit(){
	var name =$("#name").value;
	var price =$("#is_check").value;
	var info =$("#info").value;
	var class2 =$("#class2").value;
	var childClass =$("#childClass").value;
	var threeClass =$("#threeClass").value;
	test();
	if(name==""||price==""||info==""||is_check==""||image1==""||image2==""||image3==""||class2==""||childClass==""||threeClass==""){
		alert("请检查数据！");
		return;
	}
	var goods = {goods_name:name,price:price,info:info,is_check:is_check,image1:image1,image2:image1,image3:image3};
	$.ajax({  
	    url: 'login?username='+username+'&password='+password,  
	    data: goods,  
	    type: "POST",  
	    //traditional: true,  
	    success: function (responseJSON) {  
	        // your logic
	        /* location.href="isLogin"; */
	    },
	    error: function (rs){
	    	alert(rs.responseText);
	    	return;
	    }
	    
  }); 
}
/* 上传图片 */
function uploadfile(e,f,g){
	
	var fileupload = document.getElementById(e);
	var size = fileupload.files[0].size;
    if(size>1024000){
    	alert("上传图片过大！"); 
    	return;
    }
   var options = {  
       url:'photoUpload',
       success: function(rs){
    	   if(g=="s1"){
    		   image1=rs;
    	   }else if(g=="s2"){
    		   image2=rs;
    	   }else if(g=="s3"){
    		   image3=rs;
    	   }
    	   $("#"+g).html("已上传");
       },  //处理完成
       error: function (rs){
	    	alert(rs.responseText);
	    	if(rs.responseText=="上传成功"){
	    		$("#"+g).html("已上传");
	    	}
	    	return;
	   },
       resetForm: true,  
       dataType:  'json'  
      };  
    $("#"+f).ajaxSubmit(options); 
}   
/* 判断radio的值 */
function test(){
  var temp = document.getElementsByName("radio");
  for(var i=0;i<temp.length;i++)
  {
     if(temp[i].checked)
    	 is_check = temp[i].value;
  }
  
} 
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
	        <span class="item_name" style="width:120px;" id="name">商品名称：</span>
	        <input type="text" class="textbox textbox_295" placeholder="输入你的商品名称..."/>
	       </li>
	       <li>
	        <span class="item_name" style="width:120px;">商品价格：</span>
	        <input type="number" class="textbox textbox_295" placeholder="输入你的商品价格..." id="price"/>
	       </li>
	       <li>
	        <span class="item_name" style="width:120px;">分类：</span>
	        <select class="select" id="class2">
	         <option value="0">男装</option>
	         <option value="1">女装</option>
	         <option value="2">童装</option>
	        </select>
	       </li>
	       <li>
	        <span class="item_name" style="width:120px;">二级分类：</span>
	        <select class="select" onchange="selectOnchang(this)" id="childClass">
	        <option value="3">选择分类</option>
	         <option value="0">上衣</option>
	         <option value="1">裤子</option>
	         <option value="2">鞋子</option>
	        </select>
	       </li>
	        <li>
	        <span class="item_name" style="width:120px;">三级分类：</span>
	        <select class="select" id="threeClass">
	         <option>选择三级分类</option>
	        </select>
	       </li>
	       <li>
	        <span class="item_name" style="width:120px;">是否上架：</span>
	        <label class="single_selection"><input type="radio" name="radio" value="1"/>是</label>
	        <label class="single_selection"><input type="radio" name="radio" value="0"/>否</label>
	       </li>
	       <li>
	        <span class="item_name" style="width:120px;">详细信息：</span>
	        <textarea placeholder="详细信息" class="textarea" style="width:500px;height:100px;" id="info"></textarea>
	       </li>
	       <li>
	        
	        <!-- 第一张图片 -->
	        <form  method="post" enctype="multipart/form-data" id="yourformid" onsubmit="return false;">
	        	<span class="item_name" style="width:120px;">上传图片：</span>  
	        	<label class="uploadImg">
				<input id="file_Up" name="file" type="file"  onchange="uploadfile('file_Up','yourformid','s1')" />
				<span id="s1">上传图片</span>
				</label>
			</form> 
			<!-- 第二张图片 -->
			 <form  method="post" enctype="multipart/form-data" id="formid" onsubmit="return false;">
	        	<span class="item_name" style="width:120px;">上传图片：</span>  
	        	<label class="uploadImg">
				<input id="fileUp" name="file" type="file"  onchange="uploadfile('fileUp','formid','s2')" />
				<span id="s2">上传图片</span>
				</label>
			</form> 
			<!-- 第三张图片 -->
			 <form  method="post" enctype="multipart/form-data" id="formid2" onsubmit="return false;">
	        	<span class="item_name" style="width:120px;">上传图片：</span>  
	        	<label class="uploadImg">
				<input id="fileUp2" name="file" type="file"  onchange="uploadfile('fileUp2','formid2','s3')" />
				<span id="s3">上传图片</span>
				</label>
			</form> 
	       
	       </li>
	       <li>
	        <span class="item_name" style="width:120px;"></span>
	        <input type="submit" class="link_btn" onClick="submit()" id="sub_Import" />
	       </li>
	      </ul>
	     </section>
		</div>
	</section>
</body>
</html>
