package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TitularDAO {
    private static Connection con;
    
    public TitularDAO() throws ClassNotFoundException, SQLException{
        con = MyConnection.getConnection();    
    }
    
    public void insertTitular(Titular titular) throws SQLException{
        String sql = "INSERT INTO titulares(nome,nascimento,cpf,cep,tipo)"
                + "VALUES(?,?,?,?,?)";
        
        PreparedStatement prep = con.prepareStatement(sql);
        
        prep.setString(1, titular.getNome());
        prep.setString(2, titular.getNascimento());
        prep.setString(3, titular.getCpf());
        prep.setString(4, titular.getCep());
        prep.setString(5, titular.getTipo());
        
        prep.execute();
        prep.close();
    }
}

