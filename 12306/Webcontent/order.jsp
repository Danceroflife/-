<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- 引入标签指令 -->
<%
	String path = request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>预定</title>

<style type="text/css">
		     
             a {text-decoration: none}
			 html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img{margin:0;padding:0}
			  body{font-family: "微软雅黑"; font-size: 20px;}
			  #one,#two,#four{ width: 1920px; margin:  0 auto; }
			  #one{ height: 76px; background: white;}
			  #one .m p.one{ position: absolute; left:349px; top:18px; }	
			  #two{position:absolute; top:76px;height: 56px; background-color: #6495ED}
			  #two .n p.one{ position: absolute; left:549px; top:13px; }
			  #two .n p.two{ position: absolute; left:700px; top:13px; }
              #two .n p.three{ position: absolute; left: 900px; top:13px; }
			  #two .n p.four{ position: absolute; left:1100px; top:13px; }
              #four{position: absolute; height: 452px; top:100px;font-size: 20px;}
			 
            
              
		</style>
</head>
<body bgcolor="aliceblue">

	<div id="one">
				<div class="m">
		  	    <p class="one">
		  	    	<img src="img/logo.jpg" />
		  	    </p>
		  	    
		  	</div>
		  	
		  	<div id="two" >
		  		<div class="n">
		  	 
		  	   
		  	    <p class="one">
		  	    	<a><a href="index.jsp">首页</a>
		  	    </p>
		  	    <p class="two">
		  	    	<a><a href="selectTiket.jsp">票务信息</a>
		  	    </p>
		  	     <p class="three">
		  	    	<a href="<%=path%>/QueryUserServlet">个人中心</a>
		  	    </p>
		  	      <p class="four">
		  	    	<a><a href="<%=path%>/QueryOrderServlet">我的订单</a>
		  	    </p>
		  	</div>
	  <div id = "four" align="center"> 
		<form action="<%=path%>/AddOrderServlet" method="get">
		<input type="hidden" name="trainid" value="${obj.train_id}" />
		<table>
		    <tr>
				<td>起始地：</td>
				<td>
				<input type="text" size="20" name="start" value="${obj.train_start}" />
				</td>
			</tr>
			<tr>
				<td>目的地：</td>
				<td>
				<input type="text"  size="20" name="end" value="${obj.train_end}" />
				 </td>
			</tr>
			<tr>
				<td>座位类型：</td>
				<td>
				<input type="radio" name="gender" value="soft_berth" checked="checked" />软卧
				 <input type="radio" name="gender" value="hard_berth" />硬卧 
				 <input type="radio" name="gender" value="hard_seat" />硬座 
				 <input type="radio" name="gender" value="stand" />无座</td>
			</tr>
			<tr>
				<td>支付方式：</td>
				<td><input type="radio" name="pay" value="微信" checked="checked" />微信
					<input type="radio" name="pay" value="支付宝" />支付宝 
					<input type="radio" name="pay" value="银联卡" />银联卡
				</td>
			</tr>
			<tr>
				<td colspan="2">
				       <center>
						<input name="btn" type="submit" value="预定"/>
					    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				        <a href="selectTiket.jsp" >退出</a>
					  </center>
				</td>
			</tr>
		</table>
		</form>
		</div>
	
</body>
</html>
