<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="cxt" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html;">  
<title>Insert title here</title>  
<script type="text/javascript" src="${cxt}/Content/jquery-3.3.1.min.js"></script>
</head>  
<body>  
<h1>Hello Spring MVC</h1>
<script>
    $.post("${cxt}/Hello/toHello", function(data){
        console.log(data);
    })
</script>
</body>
</html>  