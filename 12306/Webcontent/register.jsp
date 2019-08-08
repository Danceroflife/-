<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%> 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>注册界面</title>
		<script type="text/javascript">
			//验证登录用户名输入的合法性
			function validateloginname(){
				//1.获取输入的登录用户名
				var _loginname = document.getElementById('loginname').value;
				var pattern= /^\w{1,20}$/;
				if(!pattern.test(_loginname)){
					window.alert('用户名输入不合法');
					return false;
				}
				
				 return true;
			}
			
			//校验密码的合法性
			function validatepwd(){
				var _loginpwd =document.getElementById('loginpwd').value;
				var pattern = /^.{6,20}$/;
				if(!pattern.test(_loginpwd)){
					window.alert('密码长度必须是6~20位');
					return false;
				}
				return  true;
			}
			
			//确定密码是否一样
			function check(){
				var _loginpwd =document.getElementById('loginpwd').value;
				var _loginpwd0 =document.getElementById('loginpwd0').value;
				if(!(_loginpwd==_loginpwd0)){
					window.alert('密码不一致');
					return false;
				}
				return true;
			}
			
			//确认姓名合法性
            function validatename(){
                   var _name=document.getElementById('name').value; 
                   if(!(/^[\u4e00-\u9fa5]{2,}$/.test(_name))){
                   window.alert('输入的姓名不合法!');
                   return false;
            }
                return true;
            }
			
			//校检证件号码合法性
            function validatecardnum(){
            var _cardnumber =document.getElementById('cardnumber').value;
            if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(_cardnumber))) {
                window.alert("输入的证件号不合法!");
                return false; 
                }
                return true;
               }
            
            //校检手机号码合法性
            function validatephone(){
            var _phonenumber =document.getElementById('phonenumber').value;
            if(!(/^1[3,4,5,7,8]\d{9}$/g.test(_phonenumber))){
            window.alert("输入的手机号不合法！");
            return false;
             }
            return true;
             }
			
            
			function validateuser(){
				if(validateloginname()==true && validatepwd()==true && check()==true && validatename()==true
				&&validatecardnum()==true&&validatephone()==true){
					window.alert('注册成功!');
					return true;
				}
				return false;
			}
			
			
			
		</script>
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
              #three{position:absolute; top:100px;left:1200px}
              
              #five{ height: 474px;}
			  #five img{ position: absolute; left: 366px; top:568px;}
			  
			  #six{ height: 543px;}
			  #six img{ position: absolute; left: 366px; top:1042px;}
            
              
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
	  	
	  	<div id="four">
	  		<div class="p">
		    <img src="img/banner08.jpg" width="1920px" height="452"/>
		    <div  id = "three" >
			<form action="<%=path%>/AddUserServlet" method="get" onsubmit="return validateuser();">
			<table bgcolor="white">	
			<tr>
				 <td colspan="2"><center><h3>注册</h3></center></td>
				</tr>
			<tr>
				<td>用户名：</td>
				<td><input  id='loginname' type="text" size="22" maxlength="20" name="loginname"  >
								<span style="color:#F00;">*</span>
				</td>
				<td >用户名只能包含字母，数字，下划线</td>
			</tr>
			<tr>
				<td>登录密码：</td>
				<td><input id='loginpwd' type="password" size="22" maxlength="20" name="loginpwd" placeholder="请输入您的密码">
				<span style="color:#F00;">*</span></td>
				<td>密码长度是6~20位</td>
			</tr>
			<tr>
				<td>确认密码：</td>
				<td><input id='loginpwd0' type="password" size="22" maxlength="20" name="confirmpassword" placeholder="再次输入您的登录密码" ></td>
			
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input id ='name' type="text" size="22" maxlength="10" name="realname" placeholder="请输入姓名" >
				<span style="color:#F00;">*</span></td>
				<td>用于身份核验，请正确填写</td>
			</tr>
			<tr>
				<td>身份证号：</td>
				<td><input id ='cardnumber' type="text" size="22" name="cardnumber" placeholder="请输入您的证件号码">
				<span style="color:#F00;">*</span></td>
				<td>用于身份核验，请正确填写</td>
			</tr>
			<tr>
				<td>电话号码：</td>
				<td><input  id ='phonenumber' type="text" size="22" maxlength="14" name="telephone" placeholder="请输入您的电话号码">
				<span style="color:#F00;">*</span></td>
			
				<td>请正确填写电话号码</td>
			</tr>
			<tr>
				<td>性别：</td>
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input  type="radio" name="gender"  checked="checked" value="M"/>男
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;					
					<input type="radio" name="gender" value="F" />女
				</td>
			</tr>
			<!--
            <tr>
            	<td>出生日期：</td>
            	<td><input id ='cardbir' type="date" size="22" ></td>
            </tr>
           -->

		<tr>
				<td>出生日期</td>
				<td>
				 <select id ="cardbiry"  name ="year">
					<option value="1991">1991</option>
					<option value="1992">1992</option>
					<option value="1993">1993</option>
					<option value="1994">1994</option>
					<option value="1995">1995</option>
					<option value="1996">1996</option>
					<option value="1997">1997</option>
					<option value="1998">1998</option>
					<option value="1999">1999</option>
					<option value="2000">2000</option>
					<option value="2001">2001</option>
					<option value="2002">2002</option>
					<option value="2003">2003</option>
					<option value="2004">2004</option>
					<option value="2005">2005</option>
					<option value="2006">2006</option>
					<option value="2007">2007</option>
					<option value="2008">2008</option>
					<option value="2009">2009</option>
					<option value="2010">2010</option>
					<option value="2011">2011</option>
					<option value="2012">2012</option>
					<option value="2013">2013</option>
					<option value="2014">2014</option>
					<option value="2015">2015</option>
					<option value="2016">2016</option>
					<option value="2017">2017</option>
					<option value="2018">2018</option>
					<option value="2019">2019</option>					
				</select>年
					<select id ="cardbirm" name="month">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>	
					</select>月
				
				</td>
			</tr>
		
			<tr>
				<td colspan="2">
			<center>
				&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" name="submit" value="确定"/>
			</center> 
				</td>
			</tr>
		</table>
		</form>
        </div>
		</div>
		 <div id="five" align="center">
	    	<img src="img/picture01.png" width="1188px" height="474" />
	    </div>
		<div id="six" align="center">
	    	<img src="img/picture02.png" width="1188px" height="543" />
	    </div>	
			
	</body>
</html>
