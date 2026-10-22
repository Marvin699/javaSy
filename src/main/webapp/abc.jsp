<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2026/10/16
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head><title>abc页面</title></head>
<body><% System.out.println("你好，Tomcat控制台");
    String realPath = application.getRealPath("");
    response.getWriter().print("web项目的根目录或部署后的绝对物理路径是：" + realPath); %></body>
</html>
