<%@page import="model.MyConnection" %>
<%@page import="java.sql.SQLException" %>
<%
  try {
  MyConnection.getConnection();
  out.print("conexão ok: ");
  out.print(MyConnection.getConnection().getCatalog());
    }  catch(SQLException e){
    out.print("falha de conexão: " + e);
    }
%>