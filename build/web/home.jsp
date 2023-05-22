<%-- 
    Document   : home
    Created on : 26 de abr. de 2023, 14:27:21
    Author     : QI
--%>

<%@page import="model.Titular" %>
<%
    Titular uSession = (Titular)session.getAttribute("userNameSession");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="session/verify.jsp" %>
        <p>
            Bem vindo <%= (uSession != null)
                          ? uSession.getNome() : "Visitante" %>!
            <button onclick="window.location.href='session/logout.jsp'">Logout</button>
        </p>
        
        <button onclick="window.location.href='cadastro.jsp'">CADASTRAR</button>
        <button onclick="window.location.href='lista.jsp'">LISTAR</button>
    </body>
</html>
