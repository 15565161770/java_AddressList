<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>list.jsp</title> 
      <style type="text/css">
    body{
    	text-align: center;
    	font-size:38px;
    }
   	  *{
   		font-family:华文楷体;
   		font-size:18px;
   		color:#F0F";
   }
   h1{
  	 text-align: center;
   	 font-size:38px;
   }
   a:link{
   	 color: #999;
   	 text-decoration: none;
   }
   a:VISITED {
	text-decoration: none;
	color: #c60;
}
	a:HOVER {
	text-decoration: none;
	color: #00F;
}
    </style>
     
  </head>
  
  <body >
    <h1 style="font-size:38px;">欢迎登录到通信录系统</h1>
    <a  style="font-size:26px;" href="<c:url value='/ContactorServlet?method=3&userId=${userId }'/>">查看联系人</a>
    <a  style="font-size:26px;" href="<c:url value='/jsp/add.jsp'/>">添加联系人</a>
    <a 	style="font-size:26px;" href="<c:url value='/jsp/top.jsp'/>">退出系统</a>
    
	<table border="1" align="center" width="60%">
		<tr>
			<th>姓名</th>
			<th>电话</th>
			<th>地址</th>
			<th>邮编</th>
			<th>操作1</th>
			<th>操作2</th>
			
		</tr>
		<c:forEach items="${contactorList }" var="c">
		<tr>
			<td>${c.name }</td>
			<td>${c.tel }</td>
			<td>${c.address }</td>
			<td>${c.zipcode }</td>
			
			<td><a href="<c:url value='/ContactorServlet?method=5&id=${c.id }'/>">编辑</a>
			</td>
			<td>
				<a href="<c:url value='/ContactorServlet?method=7&id=${c.id }'/>" >删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
  </body>
</html>
