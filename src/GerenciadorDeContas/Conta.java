package GerenciadorDeContas;

/**
 *
 * @author Duane Lopes <duwaynelopez@gmail.com>
 * @version 1.0
 */
public class Conta {
//    Atributos da Classe
    private String username,email,password,site;
    private int id_user,idconta;

//    Construtor
    public Conta() {
    }

//    Getters & Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getIdconta() {
        return idconta;
    }

    public void setIdconta(int idconta) {
        this.idconta = idconta;
    }
    
    
}
