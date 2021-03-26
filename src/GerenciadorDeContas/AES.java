package GerenciadorDeContas;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

//    Metodo usado para criptografiar os dados
//    A Chave é feita usando os bytes da chave de encriptação e o algoritmo que é o AES 
//    Os dados são em seguida criptografados usando a chave, o metodo da cifra e o iv
 public byte[] encrypt(String textopuro, String chaveencriptacao, String IV){
     try {
         Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
         SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
         encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
         return encripta.doFinal(textopuro.getBytes("UTF-8"));
     } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
         Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
     } 
     return null;
 }
//    Metodo usado para descriptografiar os dados
//    É usado quase os mesmo passos que na hora de criptografar os dados, excepto
//    que no cipher usa-se o DECRYPT_MODE que é o modo para descriptogtafar os dados
 public String decrypt(byte[] textoencriptado, String chaveencriptacao,String IV){
     try {
        Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(decripta.doFinal(textoencriptado),"UTF-8");
     } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
          Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, e);
     }
      return null;
 }
}
