<%@ page import="model.Continent" %><%--
  Created by IntelliJ IDEA.
  User: ar
  Date: 21.07.2019
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Country Form</title>
</head>
<body>
<%@include file="/header.jsp"%>

<form action="/country/add" method="post">
    Name of Country:  <input type="text" name="name"><br>
    Select Continent: <select name="continent">
    <%
        for (Continent c :
                Continent.values()) {%>
    <option value="<%=c%>"><%=c%></option>
    <%
        }
    %>
</select><br>

    <input type="submit">
</form>
</body>
</html>
