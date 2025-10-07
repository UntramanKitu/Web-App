
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Model.Game" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TermgameSuccess</title>
    </head>
    <style>
        ul{
            list-style: none;
        }
    </style>
    <body>
        <%
            Game newGame = (Game) session.getAttribute("toJsp");
        %>
        <p>ชื่อเกมส์: <%= newGame.getGameName()%></p>
        <p>รหัสผู้ใช้งาน <%= newGame.getGameId()%></p>

        <p>ราคาที่ต้องการเติม: <%= newGame.getGamePrice()%></p>
        <p>ช่องทางที่ต้องการชำระ : <%= newGame.getGameBank()%></p>
        
        <a href="updateGame.jsp">แก้ไขอาหาร</a>
        <a href="index.html">หน้าแรก</a>
    </body>
</html>
    