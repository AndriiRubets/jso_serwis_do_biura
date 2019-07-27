<%@ page import="model.Country" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ar
  Date: 21.07.2019
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Country List</title>
</head>
<body>
<%@include file="/header.jsp"%>
<%= wypiszPasekNawigacyjny()%>


    <%!
        public String linkDodania() {
            return "<td>" +
                    "<a href=\"/country/add\">Add Country</a>" +
                    "</td>";
        }

    %>

<%= linkDodania()%>
<table>
    <tr>
        <th style="width: 100px;">Country Name</th>
        <th style="width: 100px;">Continent</th>
        <th style="width: 100px;">REMOVE</th>
    </tr>
    <% List<Country> countries = (List<Country>) request.getAttribute("countryList");
        for (int i = 0; i < countries.size(); i++) {
            Country c = countries.get(i);

            out.print("<tr>");
            out.print("<td>" + c.getName() + "</td>");
            out.print("<td>" + c.getContinent() + "</td>");
            out.print("<td>" +
                    "<a href=\"/country/remove?countryId=" + c.getId() + "\">Remove</a>" +
                    "</td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
