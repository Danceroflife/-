<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>12306网站</title>
		<style type="text/css">
			
              a {text-decoration: none}
			 html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img{margin:0;padding:0}
			  body{font-family: "微软雅黑"; font-size: 20px;}
			  #one,#two,#three,#four,#five{ width: 1920px; margin:  0 auto; }
			  #one{ height: 76px; background: white;}
			  #one .m p.one{ position: absolute; left:349px; top:18px; }
			  #one .m p.four{ position: absolute; left:1350px; top:34px; }
			  #one .m p.five{ position: absolute; left:1409px; top:34px; }	
			  #two{position:absolute; top:76px;height: 56px; background-color: #6495ED}
			  #two .n p.one{ position: absolute; left:549px; top:13px; }
			  #two .n p.two{ position: absolute; left:700px; top:13px; }
              #two .n p.three{ position: absolute; left: 900px; top:13px; }
			  #two .n p.four{ position: absolute; left:1100px; top:13px; }  
			 
			  #three{ height: 452px;}
			  #three .p img{ position: absolute; top:56px;}
			  
			  #four{ height: 474px;}
			  #four img{ position: absolute; left: 366px; top:568px;}
			  
			  #five{ height: 543px;}
			  #five img{ position: absolute; left: 366px; top:1042px;}
		</style>
		
		
	</head>
	<body>
	
		<div id="one">
			<div class="m">
	  	    <p class="one">
	  	    	<img src="img/logo.jpg" />
	  	    </p>
	  	    
	  		<p class="four">
	  			<a href="enter.jsp">登录</a>
	  		</p>
	  		<p class="five">
	  			<a href="register.jsp">注册</a>
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
	  	
	  	<div id="three">
	  		<div class="p">
		    <img src="img/banner10.jpg" width="1920px" height="452"/>
		</div>
	  		
	    <div id="four" align="center">
	    	<img src="img/picture01.png" width="1188px" height="474" />
	    </div>
		<div id="five" align="center">
	    	<img src="img/picture02.png" width="1188px" height="543" />
	    </div>
		
	</body>
</html>
