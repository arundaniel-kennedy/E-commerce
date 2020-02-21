import java.util.Base64;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Program to Encrypt/Decrypt String Using AES 128 bit Encryption Algorithm
 */
 public class AES_256 {
/*
   private static final String key = "aesEncryptionKeyaesEncryptionKey";
   private static final String initVector = "encryptionIntVec";

   public static String encrypt(String value) {
     String encryptedText = "";
    try {
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

        //byte[] encrypted = cipher.doFinal(value.getBytes());

        byte[] cipherText = cipher.doFinal(value.getBytes("UTF8"));
        Base64.Encoder encoder = Base64.getEncoder();
        encryptedText = encoder.encodeToString(cipherText);

        return encryptedText;



    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
  }

  public static String decrypt(String encrypted) {
    String decryptedText = "";
    try {
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        //byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] cipherText = decoder.decode(encrypted.getBytes("UTF8"));
        decryptedText = new String(cipher.doFinal(cipherText), "UTF-8");

        return decryptedText;
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return null;
}
*/

private static String secretKey = "boooooooooom!!!!";
private static String salt = "ssshhhhhhhhhhh!!!!";

public static String encrypt(String strToEncrypt, String secret)
{
    try
    {
        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        IvParameterSpec ivspec = new IvParameterSpec(iv);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
        return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
    }
    catch (Exception e)
    {
        System.out.println("Error while encrypting: " + e.toString());
    }
    return null;
}

public static String decrypt(String strToDecrypt, String secret) {
    try
    {
        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        IvParameterSpec ivspec = new IvParameterSpec(iv);

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    }
    catch (Exception e) {
        System.out.println("Error while decrypting: " + e.toString());
    }
    return null;
}

public static void main(String[] args) {
  try{
  Scanner sc = new Scanner(System.in);
  long sec=1,msec,diff=500;
  Timestamp start=new Timestamp(System.currentTimeMillis());
  Timestamp curtime;
  //System.out.println("Enter String : ");
  File file = new File("plaintext.txt");
  BufferedReader br = new BufferedReader(new FileReader(file));
  String plainString = br.readLine();

  String encyptStr   = encrypt(plainString);
  curtime=new Timestamp(System.currentTimeMillis());
  diff+=curtime.getTime()-start.getTime();
  sec+=diff/1000;msec=diff%1000;
  System.out.println("Text encrypted in "+sec+"s "+msec+"milli_sec");

  String decryptStr  = decrypt(encyptStr);
  curtime=new Timestamp(System.currentTimeMillis());
  diff+=curtime.getTime()-start.getTime();
  sec+=diff/1000;msec=diff%1000;
  System.out.println("Text decrypted in "+sec+"s "+msec+"milli_sec");

  FileWriter fw;
  fw=new FileWriter("encrypted.txt");
    fw.write(encyptStr);
    fw.close();
  fw=new FileWriter("decrypted.txt");
  fw.write(decryptStr);
    fw.close();
  }
  catch(Exception e){
    System.out.println(e);
  }
}
}
