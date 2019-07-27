<%@ page import="model.Continent" %>
<%@ page import="model.Country" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ar
  Date: 21.07.2019
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>City Form</title>
</head>
<body>
<%@include file="/header.jsp"%>
<%= wypiszPasekNawigacyjny()%>

<form action="/city/add" method="post">
    Name of City:  <input type="text" name="name"><br>


    Select Country: <select name="countryId">
    <%
        List<Country> countries = (List<Country>) request.getAttribute("countryList");
        for (Country c : countries) {
    %>
    <option value="<%=c.getId()%>"><%=c.getName() + " " + c.getContinent()%></option>
    <%
        }
    %>
</select><br>


    <input type="submit">
</form>
</body>
</html>
