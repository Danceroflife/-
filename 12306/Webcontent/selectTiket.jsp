<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<! DOCTYPE html>
<meta charset="UTF-8">
<head>
<script type="text/javascript">
	//确认出发地的合法性
	function valibirthplace() {
		var _name = document.getElementById('birthplace').value;
		if (!(/^[\u4e00-\u9fa5]{2,}$/.test(_name))) {
			window.alert('输入的出发地不合法!');
			return false;
		}
		return true;
	}

	//确认的合法性
	function valiendplace() {
		var _name = document.getElementById('endplace').value;
		if (!(/^[\u4e00-\u9fa5]{2,}$/.test(_name))) {
			window.alert('输入的目的地不合法!');
			return false;
		}
		return true;
	}

	function validateuser() {
		if (valibirthplace() == true && valiendplace() == true) {
			return true;
		}
		return false;
	}

	//根据车的编号查看车次信息
	function queryTrainById(Tid){
		window.location.href='<%=path%>/QueryInputTrain?trainid='+Tid;
	}
 
</script>
<title>select tiket</title>
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
	 <form action="<%=path%>/QueryTrainServlet" method="get"
		onsubmit="return validateuser();">
		<tr>
		    <td>出发地<input id='birthplace' type="text" size="22" maxlength="20" name="train_start"  value="${train_start}"></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <td>目的地<input id='endplace' type="text" size="22" maxlength="20" name="train_end" value="${train_end}" ></td>
            
            <td><input type="submit" name="submit" value="查询"/></td>

		</tr>
		
	</form>
	<br>
	<br>
		
	<table border="1" font-size: 24px;>
		<tr>
			<td>编号</td>
			<td>车次</td>
			<td>起始站</td>
			<td>目的站</td>
			<td>开始时间</td>
			<td>到站时间</td>
			<td>运行时间</td>
			<td>软卧剩余数量</td>
			<td>硬卧剩余数量</td>
			<td>硬座剩余数量</td>
			<td>站票剩余数量</td>
			<td>软卧票价</td>
			<td>硬卧票价</td>
			<td>硬座票价</td>
			<td>站票票价</td>
			<td>管理员编号</td>
			<td>备注</td>
		</tr>
		 <c:choose>
  	<c:when test="${empty data}">
  		<tr>
  			<td colspan="17">查无数据!</td>
  		</tr>
  	</c:when>
  	<c:otherwise>
  		<c:forEach items="${data}" var="v">
  			<tr>
		  	<td>${v.train_id}</td>
		  	<td>${v.train_number}</td>
		  	<td>${v.train_start}</td>
		  	<td>${v.train_end}</td>
		  	<td>${v.train_start_time}</td>
		  	<td>${v.train_end_time}</td>
		  	<td>${v.train_runtime}</td>
		  	<td>${v.soft_berth_number}</td>
		  	<td>${v.hard_berth_number}</td>
		  	<td>${v.hard_seat_number}</td>
		  	<td>${v.stand_number}</td>
		  	<td>${v.soft_berth_price}</td>
		  	<td>${v.hard_berth_price}</td>
		  	<td>${v.hard_seat_price}</td>
		  	<td>${v.stand_price}</td>
		    <td>${v.admin_id}</td>
		  	<center><td><a href="javaScript:queryTrainById(${v.train_id})" >预定</a></td></center>
		  	
		  </tr>
  		</c:forEach>
  	</c:otherwise>
  </c:choose>
    <center>
     <tr>
  			<td colspan="17">
  			<center>总页数:${totalpage }&nbsp;&nbsp;
  			当前页:${currentpage }&nbsp;&nbsp;
  			
  		    <a href="<%=path%>/QueryTrainServlet?setcurrentpage=1&train_start=${train_start}&train_end=${train_end}">首页</a>&nbsp;&nbsp;
  	        
  			<a href="<%=path%>/QueryTrainServlet?setcurrentpage=${currentpage <=1? 1 :(currentpage-1)}&train_start=${train_start}&train_end=${train_end}">上一页</a>&nbsp;&nbsp;
  			<a href="<%=path%>/QueryTrainServlet?setcurrentpage=${currentpage >=totalpage?totalpage:(currentpage+1)}&train_start=${train_start}&train_end=${train_end}">  下一页  </a>&nbsp;&nbsp;
  			<a href="<%=path%>/QueryTrainServlet?setcurrentpage=${totalpage }&train_start=${train_start}&train_end=${train_end}">末页</a></center></td>
  
  </tr>
  </div> 
  </center>
  </table>

		
</center>
</body>
</html>
