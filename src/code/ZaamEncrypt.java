package code; /**
 * Created by IntelliJ IDEA.
 * User: manoj
 * Date: 17/8/11
 * Time: 12:35 AM
 * To change this template use File | Settings | File Templates.
 */

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.NoSuchAlgorithmException;

public class ZaamEncrypt {

  public static SecretKeySpec getKeySpec() throws IOException, NoSuchAlgorithmException {


	byte[] bytes = new byte[16];
	File f = new File("sample_aes_key");
	SecretKey key = null;
	SecretKeySpec spec = null;

	if (f.exists()) {
	  new FileInputStream(f).read(bytes);
	} else {
	   KeyGenerator kgen = KeyGenerator.getInstance("ModifiedAES");
	   kgen.init(256);
	   key = kgen.generateKey();
	   bytes = key.getEncoded();
	   new FileOutputStream(f).write(bytes);
	}
	spec = new SecretKeySpec(bytes,"ModifiedAES");

    System.out.println("======= key " + bytes);

	return spec;
  }
  public static void encrypt(String text) throws Exception {
	SecretKeySpec spec = getKeySpec();
	Cipher cipher = Cipher.getInstance("ModifiedAES");
	cipher.init(Cipher.ENCRYPT_MODE, spec);
	BASE64Encoder enc = new BASE64Encoder();
	System.out.println("===== encrypted text:" + enc.encode(cipher.doFinal(text.getBytes())));
  }
  public static void decrypt(String text) throws Exception {
	SecretKeySpec spec = getKeySpec();
	Cipher cipher = Cipher.getInstance("ModifiedAES");
	cipher.init(Cipher.DECRYPT_MODE, spec);
	BASE64Decoder dec = new BASE64Decoder();
	System.out.println("======= decrypted text:" + new String(cipher.doFinal(dec.decodeBuffer(text))));
  }
  public static void main(String[] args) throws Exception {
	String mode = "encrypt";
	String text = "zameer";
	if (mode.equals("encrypt")) {
      System.out.println("======= given plain text:" + text);
	  encrypt(text);
	} else if (mode.equals("decrypt")) {
      System.out.println("======= encrypted text:" + text);
	  decrypt(text);
	}
  }
}