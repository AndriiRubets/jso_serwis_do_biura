<%@ page import="model.Country" %>
<%@ page import="java.util.List" %>
<%@ page import="model.City" %><%--
  Created by IntelliJ IDEA.
  User: ar
  Date: 21.07.2019
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>City List</title>
</head>
<body>
<%@include file="/header.jsp"%>
<%= wypiszPasekNawigacyjny()%>


    <%!
        public String linkDodania() {
            return "<td>" +
                    "<a href=\"/city/add\">Add City</a>" +
                    "</td>";
        }

    %>

<%= linkDodania()%>
<table>
    <tr>
        <th style="width: 100px;">City Name</th>
        <th style="width: 100px;">Country</th>
        <th style="width: 100px;">REMOVE</th>
    </tr>
    <% List<City> cities = (List<City>) request.getAttribute("cityList");
        for (int i = 0; i < cities.size(); i++) {
            City c = cities.get(i);

            out.print("<tr>");
            out.print("<td>" + c.getName() + "</td>");
            out.print("<td>" + c.getCountry().getName() + "</td>");
            out.print("<td>" +
                    "<a href=\"/city/remove?cityId=" + c.getId() + "\">Remove</a>" +
                    "</td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
