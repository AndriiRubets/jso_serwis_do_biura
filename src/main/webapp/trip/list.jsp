<%@ page import="model.Country" %>
<%@ page import="java.util.List" %>
<%@ page import="model.City" %>
<%@ page import="model.Trip" %><%--
  Created by IntelliJ IDEA.
  User: ar
  Date: 21.07.2019
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trip List</title>
</head>
<body>
<%@include file="/header.jsp"%>
<%= wypiszPasekNawigacyjny()%>


    <%!
        public String linkDodania() {
            return "<td>" +
                    "<a href=\"/trip/add\">Add Trip</a>" +
                    "</td>";
        }

    %>

<%= linkDodania()%>
<table>
    <tr>
        <th style="width: 100px;">From</th>
        <th style="width: 100px;">To</th>
        <th style="width: 100px;">Date of Departure</th>
        <th style="width: 100px;">Date of Return</th>
        <th style="width: 100px;">Days</th>
        <th style="width: 100px;">Type of Meal</th>
        <th style="width: 100px;">Price for Adult</th>
        <th style="width: 100px;">Price for Child</th>
        <th style="width: 100px;">Adults seats</th>
        <th style="width: 100px;">Child seats</th>>
        <th style="width: 100px;">Is Promotion</th>>
        <th style="width: 100px;">REMOVE</th>>
    </tr>
    <% List<Trip> trips = (List<Trip>) request.getAttribute("tripList");
        for (int i = 0; i < trips.size(); i++) {
            Trip t = trips.get(i);

            out.print("<tr>");
            out.print("<td>" + t.getFromCity().getName() + "</td>");
            out.print("<td>" + t.getToCity().getName() + "</td>");
            out.print("<td>" + t.getDateDeparture() + "</td>");
            out.print("<td>" + t.getDateReturn() + "</td>");
            out.print("<td>" + t.getDays() + "</td>");
            out.print("<td>" + t.getTypeOfMeal() + "</td>");
            out.print("<td>" + t.getPriceForAdult() + "</td>");
            out.print("<td>" + t.getPriceForChild() + "</td>");
            out.print("<td>" + t.getSeatsForAdult() + "</td>");
            out.print("<td>" + t.getSeatsForChild() + "</td>");
            out.print("<td>" + t.isPromotion() + "</td>");
            out.print("<td>" +
                    "<a href=\"/trip/remove?tripId=" + t.getId() + "\">Remove</a>" +
                    "</td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
