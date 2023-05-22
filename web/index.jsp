<%-- 
    Document   : index
    Created on : 8 de mai. de 2023, 14:29:40
    Author     : QI
--%>

<%
    if(session.getAttribute("userNameSession") != null){
        response.sendRedirect("home.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="img/clube.png"/>
        <link rel="stylesheet" href="css/style.css"/>
        <title>ClubSocial</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="verifica_usuario.java" method="post" id="form-login">
            
            <img src="img/clube.png" alt="Logotipo do clube" width="250" />
            <br>
            
            <input type="text" name="user" id="user" class="field-login" placeholder="Insira seu email" required>
            <br><br>
            
            <input type="password" name="pass" id="pass" class="field-login" placeholder="Insira sua senha" required>
            <br><br>
            
            <input type="submit" value="Entrar">
        </form>
    </body>
</html>

