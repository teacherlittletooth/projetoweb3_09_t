package model;

import java.sql.SQLException;

public class Titular {
    private int idTitular;
    private String nome;
    private String nascimento;
    private String cpf;
    private String cep;
    private String tipo;
    private String senha;

    public Titular(int id, String nome, String nascimento, String cpf, String cep, String tipo) {
        this.idTitular = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.cep = cep;
        this.tipo = tipo;
    }
    
    public Titular(String nome, String nascimento, String cpf, String cep, String tipo, String senha) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.cep = cep;
        this.tipo = tipo;
        this.senha = senha;
    }
    
    public Titular(){}

    //Getter e Setter
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public int getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(int idTitular) {
        this.idTitular = idTitular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    public boolean isLogged() throws ClassNotFoundException, SQLException {
        TitularDAO tdao = new TitularDAO();
        Titular tBanco = tdao.listByName(this.nome);
        
        if(tBanco.getNome() != null){
            //Nesse bloco, o usuário foi encontrado, então a senha
            //será testada
            return (tBanco.getSenha().equals(this.senha));
        } else {
            //Neste bloco, o nome de usuário não foi encontrado
            return false;
        }
    }
        
}
