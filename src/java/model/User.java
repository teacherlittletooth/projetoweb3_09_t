package model;

public class User {
    //Atributos
    private String userName;
    private String userPass;
    
    //Construtor
    public User(String u, String p){
        this.userName = u;
        this.userPass = p;
    }
    
    //Getter e Setter
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    //toString - Representação genérica do objeto
    @Override
    public String toString() {
        return "<hr>Nome: " + userName +
               "<br>Senha: " + userPass;
    }
    
    public boolean isLogged() {
        return (userName.equals("email@email")
                && userPass.equals("senha1234"));
    } 
    
}//Fim da classe
