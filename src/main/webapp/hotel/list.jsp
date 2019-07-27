<%@ page import="model.Country" %>
<%@ page import="java.util.List" %>
<%@ page import="model.City" %>
<%@ page import="model.Hotel" %><%--
  Created by IntelliJ IDEA.
  User: ar
  Date: 21.07.2019
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel List</title>
</head>
<body>
<%@include file="/header.jsp"%>
<%= wypiszPasekNawigacyjny()%>


    <%!
        public String linkDodania() {
            return "<td>" +
                    "<a href=\"/hotel/add\">Add Hotel</a>" +
                    "</td>";
        }

    %>

<%= linkDodania()%>
<table>
    <tr>
        <th style="width: 100px;">Hotel Name</th>
        <th style="width: 100px;">Hotel Stars</th>
        <th style="width: 100px;">Description</th>
        <th style="width: 100px;">City</th>
        <th style="width: 100px;">REMOVE</th>
    </tr>
    <% List<Hotel> hotels = (List<Hotel>) request.getAttribute("hotelList");
        for (int i = 0; i < hotels.size(); i++) {
            Hotel h = hotels.get(i);

            out.print("<tr>");
            out.print("<td>" + h.getName() + "</td>");
            out.print("<td>" + h.getStars()+ "</td>");
            out.print("<td>" + h.getDescription()+ "</td>");
            out.print("<td>" + h.getCity()+ "</td>");
            out.print("<td>" +
                    "<a href=\"/hotel/remove?hotelId=" + h.getId() + "\">Remove</a>" +
                    "</td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
