/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * System password function
 * 
 * @author CuongNQ
 */
public class LibPassword {

	// Defined instance of LibPassword
	private static LibPassword instance = new LibPassword();

	/**
	 * Static method get instance of LibPassword
	 */
	public static LibPassword getInstance() {
		return instance;
	}

	/**
	 * Decrypt pass to raw pass
	 * 
	 * @param ePass
	 *            is password crypted
	 * @return raw password
	 */
	public String decryptPass(String ePass) {
		// Defined
		PBEKeySpec pbeKeySpec;
		PBEParameterSpec pbeParaSpec;
		SecretKeyFactory sKeyFac;
		SecretKey sKey;
		Cipher cip;
		byte[] decrypt;
		// Salt
		byte[] salt = Messages.getString("LibPassword.0").getBytes(); //$NON-NLS-1$
		// Iteration count
		int count = 10;
		// ePass
		String dePass = null;
		try {
			// Create PBE parameter set
			pbeKeySpec = new PBEKeySpec(Messages
					.getString("LibPassword.1").toCharArray()); //$NON-NLS-1$
			pbeParaSpec = new PBEParameterSpec(salt, count);
			// Create a secret key
			sKeyFac = SecretKeyFactory.getInstance(Messages
					.getString("LibPassword.2")); //$NON-NLS-1$
			sKey = sKeyFac.generateSecret(pbeKeySpec);
			// Create PBE Cipher
			cip = Cipher.getInstance(Messages.getString("LibPassword.3")); //$NON-NLS-1$
			cip.init(Cipher.DECRYPT_MODE, sKey, pbeParaSpec);
			// Encrypted the file data and store it in a byte array
			@SuppressWarnings("static-access")
			byte[] dec = Base64.getInstance().decode(ePass);
			decrypt = cip.doFinal(dec);
			dePass = new String(decrypt, Messages.getString("LibPassword.4")); //$NON-NLS-1$
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dePass;
	}

	/**
	 * Encrypt MD5 password
	 * 
	 * @param rawPass
	 *            is password
	 * @return Password encrypted
	 */
	public String encryptMD5(String rawPass) {
		try {
			// Create instance of MessageDigest
			MessageDigest md = MessageDigest.getInstance(Messages
					.getString("LibPassword.5")); //$NON-NLS-1$
			// Resets the digest for further use.
			md.reset();
			// Update the digest using the specified ByteBuffer.
			md.update(rawPass.getBytes());
			// The array of bytes for the resulting hash value.
			byte[] digest = md.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			String hashtext = bigInt.toString(16);
			// Now we need to zero pad it to be the full 32 chars.
			while (hashtext.length() < 32) {
				hashtext = Messages.getString("LibPassword.6") + hashtext; //$NON-NLS-1$
			}
			return hashtext;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * This method encrypt password
	 * 
	 * @param rawPass
	 *            is raw Password must be encrypted
	 * @return encrypted password
	 */
	@SuppressWarnings("static-access")
	public String encryptPass(String rawPass) {
		// Defined
		PBEKeySpec pbeKeySpec;
		PBEParameterSpec pbeParaSpec;
		SecretKeyFactory sKeyFac;
		SecretKey sKey;
		Cipher cip;
		byte[] encrypt;
		// Salt
		byte[] salt = Messages.getString("LibPassword.7").getBytes(); //$NON-NLS-1$
		// Iteration count
		int count = 10;
		// ePass
		String ecryptPass = null;

		try {
			// Create PBE parameter set
			pbeKeySpec = new PBEKeySpec(Messages
					.getString("LibPassword.8").toCharArray()); //$NON-NLS-1$
			pbeParaSpec = new PBEParameterSpec(salt, count);
			// Create a secret key
			sKeyFac = SecretKeyFactory.getInstance(Messages
					.getString("LibPassword.9")); //$NON-NLS-1$
			sKey = sKeyFac.generateSecret(pbeKeySpec);
			// Create PBE Cipher
			cip = Cipher.getInstance(Messages.getString("LibPassword.10")); //$NON-NLS-1$
			cip.init(Cipher.ENCRYPT_MODE, sKey, pbeParaSpec);
			// Encrypty the file data and store it in a byte array
			encrypt = cip.doFinal(rawPass.getBytes(Messages
					.getString("LibPassword.11"))); //$NON-NLS-1$
			// Convert to BASE64 and return
			ecryptPass = Base64.getInstance().encode(encrypt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ecryptPass;
	}
}
