<%-- 
    Document   : lista
    Created on : 8 de mai. de 2023, 16:22:55
    Author     : QI
--%>

<%@page import="model.Titular" %>
<%@page import="model.TitularDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clube</title>
    </head>
    <body>
        <h1>Lista</h1>
        <hr>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NOME</th>
                    <th>NASCIMENTO</th>
                    <th>CPF</th>
                    <th>CEP</th>
                    <th>TIPO</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    TitularDAO tdao = new TitularDAO();
                    for(Titular t : tdao.listTitular()) {
                %>
                <tr>
                    <td><%= t.getIdTitular() %></td>
                    <td><%= t.getNome() %></td>
                    <td><%= t.getNascimento() %></td>
                    <td><%= t.getCpf() %></td>
                    <td><%= t.getCep() %></td>
                    <td><%= t.getTipo() %></td>
                    <td>
                        <a href="TitularUpdate?id=<%= t.getIdTitular() %>">✏</a>
                    </td>
                    
                    <td>
                        <a onclick="confirmaDelete(<%= t.getIdTitular() %>);">🗑</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>

        <hr>
        <a href="home.jsp">Voltar para página inicial</a>
        
        <script>
            function confirmaDelete(cod) {
                if(confirm("Deseja mesmo excluir?")){
                    window.location.replace("TitularDelete?id=" + cod);
                } else {
                    alert("Exclusão cancelada.");
                }
            }
        </script>
    </body>
</html>
