<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<! DOCTYPE html>
<meta charset="UTF-8">
<head>

<title>select order</title>
 <style type="text/css">
		     
             a {text-decoration: none}
			 html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img{margin:0;padding:0}
			  body{font-family: "微软雅黑";  font-size: 20px;}
			  #one,#two,#four,#five,#six{ width: 1920px; margin:  0 auto; }
			  #one{ height: 76px; background: white;}
			  #one .m p.one{ position: absolute; left:349px; top:18px; }	
			  #two{position:absolute; top:76px;height: 56px; background-color: #6495ED}
			  #two .n p.one{ position: absolute; left:549px; top:13px; }
			  #two .n p.two{ position: absolute; left:700px; top:13px; }
              #two .n p.three{ position: absolute; left: 900px; top:13px; }
			  #two .n p.four{ position: absolute; left:1100px; top:13px; }
              #two .n p.three{ position: absolute; left: 900px; top:13px; }
			  #two .n p.four{ position: absolute; left:1100px; top:13px; }
              #four{ position:absolute; font-size: 20px; top:60px}
			  
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
	   <div id="four" align="center">
	     
		<table  bgcolor="white" border="3" font-size: 24px;>
			<tr>
				<td>用户名</td>
				<td>订单编号</td>&nbsp;&nbsp;
				<td>创建时间</td>&nbsp;&nbsp;
				<td>出发地</td>
				<td>目的地</td>
				<td>票价</td>
				<td>支付类型</td>
				<td>座位类型</td>
				
			</tr>
			 <c:choose>
	  	<c:when test="${empty data}">
	  		<tr>
	  			<td colspan="5">查无数据!</td>
	  		</tr>
	  	</c:when>
	  	<c:otherwise>
	  		<c:forEach items="${data}" var="v">
	  			<tr>
			  	<td>${v[0]}</td>
			  	<td>${v[1]}</td>&nbsp;&nbsp;
			  	<td>${v[2]}</td>&nbsp;&nbsp;
			  	<td>${v[3]}</td>
			  	<td>${v[4]}</td>
			  	<td>${v[5]}</td>
			  	<td>${v[6]}</td>
			  	<td>${v[7]}</td>
			  	
			  </tr>
	  		</c:forEach>
	  	</c:otherwise>
	  </c:choose>
	
	  </table>
	
   </div>
	</body>
	</html>
