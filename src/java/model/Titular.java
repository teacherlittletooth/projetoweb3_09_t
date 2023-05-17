package model;

public class Titular {
    private int idTitular;
    private String nome;
    private String nascimento;
    private String cpf;
    private String cep;
    private String tipo;

    public Titular(int id, String nome, String nascimento, String cpf, String cep, String tipo) {
        this.idTitular = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.cep = cep;
        this.tipo = tipo;
    }
    
    public Titular(String nome, String nascimento, String cpf, String cep, String tipo) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.cep = cep;
        this.tipo = tipo;
    }
    
    public Titular(){}

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
    
    
}
