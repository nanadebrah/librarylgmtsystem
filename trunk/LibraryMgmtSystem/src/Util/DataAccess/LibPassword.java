/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.DataAccess;

import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import sun.misc.BASE64Encoder;

/**
 *
 * @author CuongNQ
 */
public class LibPassword {

    /**
     * This method enctypt password
     * @param rawPass is raw Password must be enctypted
     * @return ectyped password
     */
    public static String encryptPass(String rawPass) {
        // Defined
        PBEKeySpec pbeKeySpec;
        PBEParameterSpec pbeParaSpec;
        SecretKeyFactory sKeyFac;
        SecretKey sKey;
        Cipher cip;
        byte[] encrypt;
        // Salt
        byte[] salt = "12345678".getBytes();
        // Iteration count
        int count = 10;
        //ePass
        String ecryptPass = null;

        try {
            // Create PBE parameter set
            pbeKeySpec = new PBEKeySpec("".toCharArray());
            pbeParaSpec = new PBEParameterSpec(salt, count);
            // Create a secret key
            sKeyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            sKey = sKeyFac.generateSecret(pbeKeySpec);
            // Create PBE Cipher
            cip = Cipher.getInstance("PBEWithMD5AndDES");
            cip.init(Cipher.ENCRYPT_MODE, sKey, pbeParaSpec);
            // Encrypty the file data and store it in a byte array
            encrypt = cip.doFinal(rawPass.getBytes("UTF8"));
            // Convert to BASE64 and return
            ecryptPass = new sun.misc.BASE64Encoder().encode(encrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ecryptPass;
    }

    public static String decryptPass(String ePass){
        // Defined
        PBEKeySpec pbeKeySpec;
        PBEParameterSpec pbeParaSpec;
        SecretKeyFactory sKeyFac;
        SecretKey sKey;
        Cipher cip;
        byte[] decrypt;
        // Salt
        byte[] salt = "12345678".getBytes();
        // Iteration count
        int count = 10;
        //ePass
        String dePass = null;
        try {
            // Create PBE parameter set
            pbeKeySpec=new PBEKeySpec("".toCharArray());
            pbeParaSpec=new PBEParameterSpec(salt, count);
            // Create a secret key
            sKeyFac=SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            sKey=sKeyFac.generateSecret(pbeKeySpec);
            // Create PBE Cipher
            cip=Cipher.getInstance("PBEWithMD5AndDES");
            cip.init(Cipher.DECRYPT_MODE, sKey, pbeParaSpec);
            // Decrypty the file data and store it in a byte array
            byte[] dec=new sun.misc.BASE64Decoder().decodeBuffer(ePass);
            decrypt=cip.doFinal(dec);
            dePass=new String(decrypt,"UTF8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dePass;
    }
    /**
     *
     * @param rawPass is password unencrypt
     * @return Password encrypted
     */
    public static String encryptMD5(String rawPass) {
        try {
            //Create instane of MessageDigest
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Digest pass and convert it to byte
            byte[] b = md.digest(rawPass.getBytes());
            //Return pass encrypted
            return new BASE64Encoder().encode(b);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
