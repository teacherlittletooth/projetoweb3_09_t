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
        String sql = "INSERT INTO titulares(nome,nascimento,cpf,cep,tipo,senha)"
                + "VALUES(?,?,?,?,?,?)";
        
        PreparedStatement prep = con.prepareStatement(sql);
        
        prep.setString(1, titular.getNome());
        prep.setString(2, titular.getNascimento());
        prep.setString(3, titular.getCpf());
        prep.setString(4, titular.getCep());
        prep.setString(5, titular.getTipo());
        prep.setString(6, titular.getSenha());
        
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
    
    
    //DELETE
    public void deleteTitular(int id) throws SQLException{
        String query = "DELETE FROM titulares WHERE id_titular = " + id;
        
        PreparedStatement prep = con.prepareStatement(query);
        
        prep.execute();
        prep.close();
    }
    
    
    //UPDATE
    public void updateTitular(Titular titu) throws SQLException{
        //Query genérica
        String query = "UPDATE titulares SET nome = ?, "
                + "nascimento = ?, cpf = ?, cep = ?,"
                + "tipo = ? WHERE id_titular = ?";
        
        //Preparando a query para ser executada no BD
        PreparedStatement prep = con.prepareStatement(query);
        
        //Inserir valores no lugar das interrogações
        prep.setString(1, titu.getNome());
        prep.setString(2, titu.getNascimento());
        prep.setString(3, titu.getCep());
        prep.setString(4, titu.getCpf());
        prep.setString(5, titu.getTipo());
        prep.setInt(6, titu.getIdTitular());
        
        //Executando query pronta
        prep.execute();
        prep.close();
    }
    
    
    //Selecionar apenas 1 registro
    public Titular listById(int i) throws SQLException {
        //Criar um objeto vazio
        Titular tt = new Titular();
        
        //Criar query genérica
        String query = "SELECT * FROM titulares "
                + "WHERE id_titular = " + i;
        
        //Preparar a query para o BD
        PreparedStatement prep = con.prepareStatement(query);
        
        //Capturar o resultado da query
        ResultSet res = prep.executeQuery();
        
        //Inserir valores das colunas do resultado nos
        //atributos do objeto que desejamos retornar
        if(res.next()) {
            tt.setIdTitular(res.getInt("id_titular"));
            tt.setNome(res.getString("nome"));
            tt.setCpf(res.getString("cpf"));
            tt.setCep(res.getString("cep"));
            tt.setNascimento(res.getString("nascimento"));
            tt.setTipo(res.getString("tipo"));
        }
        
        //Retornando o objeto preenchido
        return tt;
    }
    
    
    public Titular listByName(String nome) throws SQLException {
        //Criar um objeto vazio
        Titular tt = new Titular();
        
        //Criar query genérica
        String query = "SELECT * FROM titulares "
                + "WHERE nome = ?";
        
        //Preparar a query para o BD
        PreparedStatement prep = con.prepareStatement(query);
        prep.setString(1, nome);
        
        //Capturar o resultado da query
        ResultSet res = prep.executeQuery();
        
        //Inserir valores das colunas do resultado nos
        //atributos do objeto que desejamos retornar
        if(res.next()) {
            tt.setIdTitular(res.getInt("id_titular"));
            tt.setNome(res.getString("nome"));
            tt.setCpf(res.getString("cpf"));
            tt.setCep(res.getString("cep"));
            tt.setNascimento(res.getString("nascimento"));
            tt.setTipo(res.getString("tipo"));
            tt.setSenha(res.getString("senha"));
        }
        
        //Retornando o objeto preenchido
        return tt;
    }
    
}//Fim da classe