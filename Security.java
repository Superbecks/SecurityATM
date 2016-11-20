import java.security.Key;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
//import sun.misc.Base64Decoder;
//import sun.misc.Base64Encoder;

public class Security {
	private static final String aes="AES";
	private byte[] keyvalue;
	
	public Security(String key){
		keyvalue = key.getBytes();
		
	}
	
	public String encrypt (String Data) throws Exception{
		Key key = generateKey();
		Cipher c = Cipher.getInstance(aes);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		String encrytedValue = Base64.getEncoder().encodeToString(encVal);
		return encrytedValue;
		
		
	}
	
	
	public String decrypt (String encrytedData)throws Exception{
		Key key = generateKey();
		Cipher c = Cipher.getInstance(aes);
		c.init(Cipher.DECRYPT_MODE,key);
		byte[] decordedValue = Base64.getDecoder().decode(encrytedData);
		byte[] decValue = c.doFinal(decordedValue);
		String decrytedValue = new String (decValue);
		return decrytedValue;
	}
	
	
	private Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyvalue, aes);
		return key;
		
		
	}
	
	private String HashPassword (String password) throws Exception {
		MessageDigest md = MessageDigest.getInstance("Sha");
		md.update(password.getBytes());
		byte[] b = md.digest();
		StringBuffer sb = new StringBuffer();
		for(byte bl: b){
			sb.append(Integer.toHexString(bl & 0xff ).toString());
		}
		
		return sb.toString();
	}
	
	
	
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
 */
	
}
