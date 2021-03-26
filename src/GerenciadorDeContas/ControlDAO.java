package GerenciadorDeContas;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duane Lopes <duwaynelopez@gmail.com>
 * @version 1.0
 */
public class ControlDAO {
    private Usuario user = null;
    private Hash hash = null;
    private AES aes = null;
    private String MasterPassword;
    private String MasterUsername;
    private String IV;
    
/**    Metodo usado para adição no usuario na base de dados
    O nome de usuario e a senha são criptografadas pela classe Hash 
*/
    public boolean InsertUser(Usuario user){
        String query = "insert into user (username,password) values (?,?)";
        int status = 0;
        hash = new Hash();
        String loginUsername = hash.gerarHash(user.getNome());
        String loginPassword = hash.gerarHash(user.getPassword());
        try {
            connect conexao = new connect(user.getNome());
            PreparedStatement pstmt = conexao.getConexao().prepareStatement(query);
            pstmt.setString(1, loginUsername);
            pstmt.setString(2, loginPassword);
            status = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (status == 1);
    }
    
//    Metodo SelectUser retorna o usuario da base de dados
    public Usuario SelectUser(Usuario user){
        this.user = new Usuario();
        String query = "select * from user where username = ? and password = ?";
        try {
            hash = new Hash();
            connect conexao = new connect(user.getNome());
            PreparedStatement pstmt = conexao.getConexao().prepareStatement(query);
            pstmt.setString(1, hash.gerarHash(user.getNome()));
            pstmt.setString(2, hash.gerarHash(user.getPassword()));
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                this.user.setIduser(result.getInt("iduser"));
                this.user.setNome(result.getString("username"));
                this.user.setPassword(result.getString("password"));
            }
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.user;
    }
 
/**  Metodo InsertConta usado para adicionar os dados na tabela Conta
 *   Os dados adicionados na tabela são criptografados simetricamente usando o algoritmo AES
 *   IV é 16 bytes do hash do MasterPassword e MasterUsername
 *   aes.encrypt é o metodo que faz a criptografia dos dados antes de ir para base de dados
 *   Usa-se o MasterPassword que é a senha do usuario para criptografar os dados
 */
    
    public boolean InsertConta(Conta conta, String user){
        String query = "insert into conta (username,password,site,email,id_user) values (?,?,?,?,?)";
        this.user = new ControlDAO().Select(user);
        MasterPassword = this.user.getPassword();
        MasterUsername = this.user.getNome();
        int status = 0;
        aes = new AES();
        hash = new Hash();
        IV = hash.gerarHash(MasterPassword+MasterUsername).substring(0, 16);
        byte[] username = aes.encrypt(conta.getUsername(), MasterPassword.substring(0, 16), IV);
        byte[] password = aes.encrypt(conta.getPassword(), MasterPassword.substring(0, 16), IV);
        byte[] email    = aes.encrypt(conta.getEmail(), MasterPassword.substring(0, 16), IV) ;
        byte[] site     = aes.encrypt(conta.getSite(), MasterPassword.substring(0, 16), IV);
        try {
            connect conexao = new connect(user);
            PreparedStatement pstmt = conexao.getConexao().prepareStatement(query);
            pstmt.setBytes(1, username);
            pstmt.setBytes(2, password);
            pstmt.setBytes(3, site );
            pstmt.setBytes(4, email);
            pstmt.setInt(5, conta.getId_user());
            status = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (status == 1);
    }
    
/**    Metodo SelectConta retorna os dados da base de dados
    Os dados adicionados na tabela são descriptografados usando o mesmo algoritmo
    IV é 16 bytes do hash do MasterPassword e MasterUsername
    aes.decrypt é o metodo que faz a descriptografia dos dados apos sair da base de dados
    Usa-se o MasterPassword que é a senha do usuario para descriptografar os dados
*/    
    public ArrayList<Conta> SelectConta(String user) throws SQLException{
        ArrayList<Conta> contas = new ArrayList<>();
        aes = new AES();  
        hash = new Hash();
        this.user = new Usuario();
        this.user = new ControlDAO().Select(user);
        MasterPassword = this.user.getPassword();
        MasterUsername = this.user.getNome();
        IV = hash.gerarHash(MasterPassword+MasterUsername).substring(0, 16);
        int i = 0;
        String query = "select idconta,username,password,site,email from conta";
            connect conexao = new connect(user);
            PreparedStatement pstmt = conexao.getConexao().prepareStatement(query);
            ResultSet result = pstmt.executeQuery();
            while(result.next()){
                Conta conta = new Conta();
                conta.setUsername(aes.decrypt(result.getBytes("username"), MasterPassword.substring(0, 16), IV));
                conta.setPassword(aes.decrypt(result.getBytes("password"), MasterPassword.substring(0, 16), IV));
                conta.setEmail(aes.decrypt(result.getBytes("email"), MasterPassword.substring(0, 16), IV));
                conta.setSite(aes.decrypt(result.getBytes("site"), MasterPassword.substring(0, 16), IV));
                conta.setIdconta(result.getInt("idconta"));
                contas.add(i, conta);
                i++;
            }
        return contas;
    }
    
//    Metodo DeleteConta elimina uma conta da base de dados 
    public boolean DeleteConta(String user, int idconta){
        String query = "delete from conta where idconta = ?";
        int status = 0;
        try {
            connect conexao = new connect(user);
            PreparedStatement pstmt = conexao.getConexao().prepareStatement(query);
            pstmt.setInt(1, idconta);
            status = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (status == 1);
    }
    
/**    Metodo UpdateConta faz a actualização dos dados na na tabela conta
    Esse metodo possui algumas semelhanças com o MetodoInsertUser
    Tendo como principal diferença a query
*/
    public boolean UpdateConta(String user,Conta conta){
        String query =" update conta set username = ?,password = ?,site = ?,email = ? where idconta = ?";
        this.user = new Usuario();
        this.user = new ControlDAO().Select(user);
        MasterPassword = this.user.getPassword();
        MasterUsername = this.user.getNome();
        aes = new AES();
        hash = new Hash();
        IV = hash.gerarHash(MasterPassword+MasterUsername).substring(0, 16);
        byte[] username = aes.encrypt(conta.getUsername(), MasterPassword.substring(0, 16), IV);
        byte[] password = aes.encrypt(conta.getPassword(), MasterPassword.substring(0, 16), IV);
        byte[] email    = aes.encrypt(conta.getEmail(), MasterPassword.substring(0, 16), IV) ;
        byte[] site     = aes.encrypt(conta.getSite(), MasterPassword.substring(0, 16), IV);
        int status = 0;
        try {
            connect conexao = new connect(user);
            PreparedStatement pstmt = conexao.getConexao().prepareStatement(query);
            pstmt.setBytes(1, username);
            pstmt.setBytes(2, password);
            pstmt.setBytes(3, site );
            pstmt.setBytes(4, email);
            pstmt.setInt(5, conta.getIdconta());
            status = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (status == 1);
    }
    
//    Metodo CreateTable responsavel por criar as tabelas da base de dados
    public boolean CreateTable(Usuario user){
        this.user = user;
        String tabelauser = "CREATE TABLE user (" +
                            "    iduser      INTEGER    PRIMARY KEY ASC AUTOINCREMENT" +
                            "                           UNIQUE" +
                            "                           NOT NULL," +
                            "    username    TEXT (256) NOT NULL," +
                            "    password    TEXT (256) NOT NULL" +
                            ");";
        String tabelaconta = "CREATE TABLE conta (" +
                            "    idconta  INTEGER    PRIMARY KEY ASC AUTOINCREMENT" +
                            "                        UNIQUE" +
                            "                        NOT NULL," +
                            "    username TEXT (256) NOT NULL," +
                            "    password TEXT (256) NOT NULL," +
                            "    site     TEXT (256) NOT NULL," +
                            "    email    TEXT (256) NOT NULL," +
                            "    id_user  INTEGER    CONSTRAINT user_conta REFERENCES user (iduser) " +
                            "                        NOT NULL" +
                            ");";
         int status = 1;
        try {
            connect conexao = new connect(this.user.getNome());
            PreparedStatement pstmt = conexao.getConexao().prepareStatement(tabelauser);
            pstmt.executeUpdate();
            pstmt.close();
            pstmt = conexao.getConexao().prepareStatement(tabelaconta);
            status = pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (status == 0);
    }

/**    Verifica se dois contas tem o mesmo nome
    Se for verdadeiro mostra uma mensagem de erro
*/
    public boolean VerificaNome(String user){
        boolean status = new connect().VerificaNome(user);
        return status;
    }

/**    Verifica se a base de dados ja existe 
    se for falso mostra uma mensagem de erro
*/
    public boolean ExisteDatabase(String user){
        boolean status = new connect().ExisteDatabase(user);
        return status;
    }
    
/**    Metodo Select auxilia os metodos InsertConta, SelectConta e UpdateConta
    Fornecendo o username e password do usuario, esses dados são usado
    na criptografia dos dados e criação do IV 
*/
    public Usuario Select(String username){
        this.user = new Usuario();
        String query = "select username,password from user ";
        try {
            hash = new Hash();
            connect conexao = new connect(username);
            PreparedStatement pstmt = conexao.getConexao().prepareStatement(query);
            ResultSet result = pstmt.executeQuery();
            if(result.next()){
                this.user.setNome(result.getString("username"));
                this.user.setPassword(result.getString("password"));
            }
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.user;
    }
}
