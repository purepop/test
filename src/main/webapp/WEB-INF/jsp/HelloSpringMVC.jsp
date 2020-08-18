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
    <link href="${cxt}/Content/jquery.bsgrid-1.37/builds/merged/bsgrid.all.min.css" rel="stylesheet" />
    <script src="${cxt}/Content/jquery.bsgrid-1.37/builds/merged/bsgrid.all.min.js"></script>
    <script src="${cxt}/Content/jquery.bsgrid-1.37/builds/js/lang/grid.zh-CN.min.js"></script>
</head>

<body>
    <h1>Hello Spring MVC</h1>

    <table id="tbTeacherInfor">
        <tr>
            <th w_num="total_line">序号</th>
            <th w_index="carid">carid</th>
            <th w_index="name">名称</th>
            <th w_index="factoryid">factoryid</th>
            <th w_index="year">年份</th>
            <th w_index="id">id</th>
            <th w_index="manufactory">生产厂家</th>
            <th w_index="address">地址</th>
        </tr>
    </table>

    <script>
        $.fn.bsgrid.init("tbTeacherInfor", {
            url: "${cxt}/Hello/toBsgrid",
            pageSize: 10,
            autoLoad: true,
            rowHoverColor: true,
            stripeRows: true,
            rowHoverColor: true,
            rowSelectedColor: true,
            pagingLittleToolbar: true
        });

        $.post("${cxt}/Hello/toHello", function (data) {
            console.log(data);
        });

        $.post("${cxt}/Hello/toDate", { birthday: "2000-03-12 12:00:00" }, function (data) {
            console.log(data);
        }, "json")
    </script>
</body>

</html>