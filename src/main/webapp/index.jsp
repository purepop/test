<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <base href="<%=basePath%>">
</head>
<body>
<h2>Hello World!</h2>
<jsp:forward page = "/WEB-INF/jsp/HelloSpringMVC.jsp" />
</body>
</html>
