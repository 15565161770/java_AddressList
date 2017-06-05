<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top.jsp</title>
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
    </style>
  </head>
  
  <body >
    <h1 style="font-size:38px;">我的通信录</h1>
     
    <form action="<c:url value='/ContactorServlet'/>" method="post">
    	<input type="hidden" name="method" value="2"> 
    	用户名:<input type="text" name="username"/><br/>
    	密 &nbsp;  码:<input type="password" name="password"/><br/>
    	<input type="submit" value="登录">
    <a href="<c:url value='/jsp/register.jsp'/>" target="body" >注册</a>
  </form>
  </body>
</html>
