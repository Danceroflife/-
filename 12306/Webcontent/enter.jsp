<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	
	<head>
		<meta charset="UTF-8">
		<title>登录界面</title>
		<style type="text/css">
		     
             a {text-decoration: none}
			 html,body,ul,li,ol,dl,dd,dt,p,h1,h2,h3,h4,h5,h6,form,fieldset,legend,img{margin:0;padding:0}
			  body{font-family: "微软雅黑"; font-size: 20px;}
			  #one,#two,#four,#five,#six{ width: 1920px; margin:  0 auto; }
			  #one{ height: 76px; background: white;}
			  #one .m p.one{ position: absolute; left:349px; top:18px; }	
			  #two{position:absolute; top:76px;height: 56px; background-color: #6495ED}
			  #two .n p.one{ position: absolute; left:549px; top:13px; }
			  #two .n p.two{ position: absolute; left:700px; top:13px; }
              #two .n p.three{ position: absolute; left: 900px; top:13px; }
			  #two .n p.four{ position: absolute; left:1100px; top:13px; }
              #four{ height: 452px;}
			  #four .p img{ position: absolute; top:56px;}
              #three{position:absolute; top:200px;left:1400px}
              
              #five{ height: 474px;}
			  #five img{ position: absolute; left: 366px; top:568px;}
			  
			  #six{ height: 543px;}
			  #six img{ position: absolute; left: 366px; top:1042px;}
            
              
		</style>
	</head>
	<body  bgcolor="aliceblue">
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
		<div id="four">
	  		<div class="p">
		    <img src="img/banner08.jpg" width="1920px" height="452"/>
		    <div  id = "three" >
			<form action="<%=path%>/SelectEnter" method="get" >	
				
				
				<table width="300px"  bgcolor="white">
				<tr>
				 <td colspan="2"><center><h3>登录</h3></center></td>
				</tr>
	
				<tr>
					<td>用户名：</td>
					<td><input id='loginname' type="text" size="20" maxlength="20" name="loginname" placeholder="用户名"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input  id='loginpwd' type="password" size="20" maxlength="20" name="loginpwd" placeholder="密码"></td>
				</tr>	
				<tr>
							<td colspan="2">
								<center>
									&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="submit" name="submit" value="登录" />
										
								</center>
						   </td></tr>
	
				
				</table>
	        </form>
        </div>
       </div>
		 <div id="five">
	    	<img src="img/picture01.png" width="1188px" height="474" />
	    </div>
		<div id="six">
	    	<img src="img/picture02.png" width="1188px" height="543" />
	    </div> 	
	</body>
	</center>
</html>
