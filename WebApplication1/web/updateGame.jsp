
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Model.Game" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>updateGame</title>
    </head>
    <body>
        <%
            Game oldGame = (Game) session.getAttribute("toJsp");
        %>

        <h2>แก้ไขอาหาร</h2>
        <p>ข้อมูลเดิม: <%= oldGame.getGameName()%>,
            <%= oldGame.getGameId()%> , 
            <%= oldGame.getGamePrice()%>,  
            <%= oldGame.getGameBank()%>
        </p>



        <form action="AddNewGameMySQL" method="post">
            
            <%
            String gameName = oldGame.getGameName();
            boolean hasFF = false;
            boolean hasPG = false;
            boolean hasValo = false;
            boolean hasRog = false;
            boolean hasBS = false;

%>
            
            ชื่อเกมส์ :
            <input type="radio" name="game" value="FreeFire" <%= hasFF ? "checked" : ""  %> >FreeFire<br/>
            <input type="radio" name="game" value="PubG" <%= hasPG ? "checked" : ""  %> >PubG Moblie<br/>
            <input type="radio" name="game" value="Valorant" <%= hasValo ? "checked" : ""  %> >Valorant<br/>
            <input type="radio" name="game" value="Ragnarok" <%= hasRog? "checked" : ""  %> >Ragnarok<br/>
            <input type="radio" name="game" value="BloodStrike" <%= hasBS? "checked" : ""  %> >BloodStrike<br/>
            

            UID : <input type ="text" name="game_id" value="<%= oldGame.getGameId()%>"><br/>
            เลือกราคาเกมที่ต้องการ : <input type ="text" name="game_price" value="<%= oldGame.getGamePrice()%>"><br/>
           
           ช่องทางการชำระเงิน  :
            <select name="bank" selected="Prompay QRcode">
                <option value="Prompay QRcode"<%= oldGame.getGameBank().equals("Prompay QRcode") ? "selected" : "" %>>Prompay QRcode</option>
                <option value="True Money "<%= oldGame.getGameBank().equals("True Money") ? "selected" : "" %>>True Money</option>
                <option value="Krungsri Bank"<%= oldGame.getGameBank().equals("Krungsri Bank") ? "selected" : "" %>>Krungsri Bank</option>
                <option value="Krungthai Bank" <%= oldGame.getGameBank().equals("Krungthai Bank") ? "selected" : "" %>>Krungthai Bank</option>
                <option value="Kasrikorn Bank" <%= oldGame.getGameBank().equals("Kasrikorn Bank") ? "selected" : "" %>>Kasrikorn Bank</option>
            </select><br/>  
            <input type="submit" value="เพิ่มอาหาร">
        </form>



    </body>
</html>
    