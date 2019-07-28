<%@ page import="model.Continent" %>
<%@ page import="model.Country" %>
<%@ page import="java.util.List" %>
<%@ page import="model.City" %>
<%@ page import="model.TypeOfMeal" %><%--
  Created by IntelliJ IDEA.
  User: ar
  Date: 21.07.2019
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trip Form</title>
</head>
<body>
<%@include file="/header.jsp"%>
<%= wypiszPasekNawigacyjny()%>

<form action="/trip/add" method="post">
    Trip From: <select name="cityIdFrom">
    <%
        List<City> citiesFrom = (List<City>) request.getAttribute("cityList");
        for (City c : citiesFrom) {
    %>
    <option value="<%=c.getId()%>"><%=c.getName()%></option>
    <%
        }
    %>
</select><br>
    Trip To: <select name="cityIdTo">
    <%
        List<City> citiesTo = (List<City>) request.getAttribute("cityList");
        for (City c : citiesTo) {
    %>
    <option value="<%=c.getId()%>"><%=c.getName()%></option>
    <%
        }
    %>
</select><br>
    Departure date: <input type="date" name="dateDeparture"><br>
    Return date: <input type="date" name="dateReturn"><br>
    Days: <input type="number" min="1" max="21" step="1" name="days"><br>

    Select Type of Meal: <select name="typeOfMeal">
    <%
        for (TypeOfMeal t :
                TypeOfMeal.values()) {%>
    <option value="<%=t%>"><%=t%></option>
    <%
        }
    %>
</select><br>
    Price for Adult: <input type="number" min="1"  step="1" name="priceForAdult"><br>
    Price for Child: <input type="number" min="1"  step="1" name="priceForChild"><br>

    Seats for Adult: <input type="number" min="1"  step="1" name="seatsForAdult"><br>
    Seats for Child: <input type="number" min="1"  step="1" name="seatsForChild"><br>
    Promotion: <input type="checkbox" name="promotion" ><br>

    <input type="submit">
</form>
</body>
</html>
