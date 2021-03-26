package GerenciadorDeContas;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Duane Lopes <duwaynelopez@gmail.com>
 * @version 1.0
 */
public class connect {
//    Atributos da classe
    private Connection conexao = null;
    private Hash hash = null; 
    private String database = null;
//    Caminho para a pasta Database C:\GestorDeSenhas\Database
    private File path = new File(System.getenv("HOMEDRIVE")+"\\GestorDeSenhas\\Database");
    private String url;
    
    public connect() {
    }
    
    public Connection getConexao(){
            return conexao;
    }
    
/** 
 *  Contrutor que cria a conexao com a base de dados
 *  recebe como parametro o nome do usuario
 *  o hash do nome do usuario é usada como o nome da base de dados
*/
    public connect(String user){
        try {
            hash = new Hash();
            database = hash.gerarHash(user);
            
            Class.forName("org.sqlite.JDBC");
            url = "jdbc:sqlite:"+path.getAbsolutePath()+"\\"+database+".db";
            conexao = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

/**    
 *  Metodo usado para verificar se a pasta Database dentro do projecto 
 *  e a base de dados se não existe a pasta, esse metodo criar
*/
    public boolean ExisteDatabase(String user){
            hash = new Hash();
            database = hash.gerarHash(user);
            path.mkdirs();
            path = new File(path.getAbsolutePath()+"\\"+database+".db");
        return path.exists();
    }

/**
 *  Metodo usado para Verificar se existe duas contas com o mesmo nome
 *  se existe retorna verdadeiro
*/
    public boolean VerificaNome(String user){
        path.mkdirs();
        hash = new Hash();
        String username= hash.gerarHash(user);
        File novo = new File(path.getAbsolutePath());
        File afile[] = novo.listFiles();
        int i = 0;
            for (int j = afile.length; i < j; i++) {
                File arquivos = afile[i];
                if(arquivos.getName().equals(username+".db")){
                    return true;
                }
            }
        return false;
    }
}
