<%-- 
    Document   : cadastro
    Created on : 8 de mai. de 2023, 16:22:48
    Author     : QI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clube</title>
    </head>
    <body>
        <h1>Cadastro</h1>
        <hr>
                
        <form action="TitularController" method="post">
            <h3>Novo usuário</h3>
            <input type="text" name="user" placeholder="Nome do usuário" required>
            
            <br><br>
            <input type="date" name="nasc" required>
            
            <br><br>
            <input type="text" name="cpf" placeholder="CPF" required>

            <br><br>
            <input type="text" name="cep" placeholder="CEP" required>
            
            <br><br>
            <select name="tipo" required>
                <option value="">Selecione o tipo de usuário...</option>
                <option value="Titular">Titular</option>
                <option value="Dependente">Dependente</option>
                <option value="Outro">Outro</option>
            </select>
            
            <br><br>
            <input type="password" name="senha" onmouseover="show();" onmouseout="hide();" placeholder="Informe uma senha" id="senha" required>
            
            <br><br>
            <input type="submit" value="Cadastrar">
            <input type="reset" value="Limpar">
        </form>
        
        <hr>
        <a href="home.jsp">Voltar para página inicial</a>
        
        <script>
            var senha = document.getElementById("senha");
            
            function show() {
                senha.type = "text";
            }
            
            function hide() {
                senha.type = "password";
            }
        </script>
    </body>
</html>
