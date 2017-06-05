<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>edit.jsp</title>

	<script type="text/javascript" src="<c:url value='/jquery/contactor.js'/>"></script> 
 
	
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
    <h1 style="font-size:38px;">修改联系人信息</h1>
    <form action="<c:url value='/ContactorServlet'/>" method="post" onsubmit="return checkForm()">
    	<input type="hidden" name="method" value="6">
    	<input type="hidden" name="id" value="${contactor.id }">
    	<table border="1" width="50%" align="center">
    		<tr>
    			<td>姓名</td>
    			<td>
    				<input type="text" name="name" value="${contactor.name }" id="name" onfocus="nameFocus()" onblur="nameBlur()"/>
    				<div id="nameId"></div>
    			</td>
    		</tr>
    		<tr>
    			<td>电话</td>
    			<td>
    				<input type="text" name="tel" value="${contactor.tel }" id="tel" onfocus="telFocus()" onblur="telBlur()" />
    				<div id="telId"></div>
    			</td>
    		</tr>
    		<tr>
    			<td>地址</td>
    			<td>
    				<input type="text" id="address" name="address" value="${contactor.address }" />
    			</td>
    		</tr>    	
     		<tr>
    			<td>邮编</td>
    			<td>
    				<input type="text" name="zipcode" value="${contactor.zipcode }" />
    			</td>
    		</tr>	
    		
        </table>
        <input style="margin-right:200px;" type="submit" value="更改"/>
        			
			
    </form>
  </body>
</html>
