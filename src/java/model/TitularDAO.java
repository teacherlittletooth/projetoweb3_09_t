package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TitularDAO {
    private static Connection con;
    
    public TitularDAO() throws ClassNotFoundException, SQLException{
        con = MyConnection.getConnection();    
    }
    
    //Métodos do CRUD
    //INSERT (Create)
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
    
    //SELECT (Read)
    public ArrayList<Titular> listTitular() throws SQLException{
        //Criando lista vazia
        ArrayList<Titular> list = new ArrayList<>();
        
        //Criando a query para o BD
        String query = "SELECT * FROM titulares";
        
        //Preparando a query para ser executada no BD
        PreparedStatement prep = con.prepareStatement(query);
        
        //Executar a query e receber o resultado com o auxílio
        //da classe ResultSet
        ResultSet result = prep.executeQuery();
        
        //Enquanto houverem registros, o código será executado
        while(result.next()) {
            //Criando um objeto vazio da classe Titular
            Titular titular = new Titular();
            
            //Pegando os elementos do BD e preenchendo o objeto vazio
            titular.setIdTitular(result.getInt("id_titular"));
            titular.setNome(result.getString("nome"));
            titular.setNascimento(result.getString("nascimento"));
            titular.setCpf(result.getString("cpf"));
            titular.setCep(result.getString("cep"));
            titular.setTipo(result.getString("tipo"));
            
            //Adicionando objeto cheio para a lista de Titulares
            list.add(titular);
        }
        
        //Retornando a lista completa
        return list;
    }
}

