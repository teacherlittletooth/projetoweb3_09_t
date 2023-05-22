package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import model.Titular;
import model.TitularDAO;


@WebServlet(name = "TitularController", urlPatterns = {"/TitularController"})
public class TitularController extends HttpServlet {      
    private int id;
    private String nome;
    private String nascimento;
    private String cpf;
    private String cep;
    private String tipo;
    private String senha;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Verificando a existência do ID
        if(request.getParameter("id") != null){
            this.id = Integer.parseInt(request.getParameter("id"));
        }
        
        //Recebendo os dados do formulário
        this.nome = request.getParameter("user");
        this.nascimento = request.getParameter("nasc");
        this.cpf = request.getParameter("cpf");
        this.cep = request.getParameter("cep");
        this.tipo = request.getParameter("tipo");
        this.senha = request.getParameter("senha");
                        
        try{
            
            TitularDAO tdao = new TitularDAO();
            
            if(request.getParameter("id") != null) {
                
                Titular t = new Titular(
                    this.id,
                    this.nome,
                    this.nascimento,
                    this.cpf,
                    this.cep,
                    this.tipo
                );
                tdao.updateTitular(t);
                
            } else {
                
                Titular t = new Titular(
                    this.nome,
                    this.nascimento,
                    this.cpf,
                    this.cep,
                    this.tipo,
                    this.senha
                );
                tdao.insertTitular(t);
                
            }
            
            response.sendRedirect("lista.jsp");
            
        } catch(SQLException | ClassNotFoundException erro){ 
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TitularController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>erro: " + erro + "</h1>");
            out.println("</body>");
            out.println("</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}