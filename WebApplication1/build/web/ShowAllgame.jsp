<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, Model.Game" %>
<%
  List<Game> games = (List<Game>) request.getAttribute("games");
%>
<table border="1">
  <tr><th>Game</th><th>UID</th><th>Price</th><th>Bank</th></tr>
  <c:forEach var="g" items="${games}">
    <tr>
      <td>${g.gameName}</td>
      <td>${g.gameId}</td>
      <td>${g.gamePrice}</td>
      <td>${g.gameBank}</td>
    </tr>
  </c:forEach>
</table>
