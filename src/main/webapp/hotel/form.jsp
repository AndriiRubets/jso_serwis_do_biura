
<%@ page import="java.util.List" %>
<%@ page import="model.City" %><%--
  Created by IntelliJ IDEA.
  User: ar
  Date: 21.07.2019
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel Form</title>
</head>
<body>
<%@include file="/header.jsp" %>
<%= wypiszPasekNawigacyjny()%>

<form action="/hotel/add" method="post">
    Name of Hotel: <input type="text" name="name"><br>
    Number of stars: <input type="number" min="1" max="5" step="1" name="stars"><br>
    Description: <input type="text" name="description"><br>


    Select City: <select name="cityId">
    <%
        List<City> cities = (List<City>) request.getAttribute("cityList");
        for (City c : cities) {
    %>
    <option value="<%=c.getId()%>"><%=c.getName() %>
    </option>
    <%
        }
    %>
</select><br>
    <input type="submit">
</form>
</body>
</html>
