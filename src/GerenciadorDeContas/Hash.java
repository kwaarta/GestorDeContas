package GerenciadorDeContas;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duane Lopes <duaynelopez@gmail.com>
 * @version 1.0
 */
public class Hash {
//    Metodo para criação do hash 
  public String gerarHash(String senha)  {
        StringBuilder texto = new StringBuilder();
      try {
          MessageDigest algorithm = MessageDigest.getInstance("SHA-1");
          byte hash[] = algorithm.digest(senha.getBytes("UTF-8"));
          for (byte b : hash) {
              texto.append(String.format("%02X", 0xFF & b));
          }
      } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
          Logger.getLogger(Hash.class.getName()).log(Level.SEVERE, null, ex);
      }
      return texto.toString();
  }
}
