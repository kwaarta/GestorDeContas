package GerenciadorDeContas;

/**
 * 
 * @author Duane Lopes <duwaynelopez@gmail.com>
 * @version 1.0
 */
public class Usuario {
//    Atributos da classe Usuario
    private String Nome;
    private String Email;
    private String password;
    private int iduser;
    
//    Construtor
    public Usuario() {
    }
    
//    Getters & Setters
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int id) {
        this.iduser = id;
    }
 
    
}
