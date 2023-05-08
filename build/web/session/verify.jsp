<%
   if(session.getAttribute("userNameSession") == null) {
       response.sendRedirect(request.getContextPath());
   }
%>