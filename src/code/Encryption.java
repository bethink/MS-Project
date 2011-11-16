package code;

import com.sun.xml.internal.ws.api.server.Module;

import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: manoj
 * Date: 23/8/11
 * Time: 11:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Encryption {

    public static void execute(String plainText, String fileName){

        String cipherText = "";
        String keyText = "000102030405060708090a0b0c0d0e0f101112131415161718191a1b1c1d1e1f";

        p("======================== Module 1 =======================");

        try {

            byte[] key = Util.hex2byte(keyText);

            ModifiedAES aes = new ModifiedAES();
            aes.setKey(key);
            cipherText = aes.Encrypt(plainText);
//            cipherText = cipher.toString();

            p("Cipher text: ====" + cipherText + "====");

        } catch (Exception e) {
            p("Error in encrypting the plain text: " + e.getMessage());
        }

        p("======================== Module 2 =======================");

        SecurityModule securityModule = new SecurityModule( cipherText );
        securityModule.generateKeysAndText();

        p("Key3 : ====" + securityModule.getKey3() + "====");
        String serializedObj = securityModule.getKey3String();
        p("Key3 Serialized : ====" + serializedObj + "====");

//        SecurityModuleReverse smr = new SecurityModuleReverse();
//        List<Integer> res = null;
//
//        try {
//            res = smr.deserialize(securityModule.getKey3String());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        p("Key3 Deserialized : " + res);

        p("Key4 : ====" + securityModule.getKey4() + "====");

        String imageText = securityModule.getFirst7Alphabets();
        p("Image Text : ====" + imageText + "====");

        p("======================== Module 3 =======================");

        p("Key image : ====" + fileName);

        p("Result image : ====" + "secret.png" );

        Crypter crypter = new Crypter(fileName);
        crypter.encrypt(imageText, "secret.png");
    }

    private static void p(String string){
        System.out.println(string+"\n");
    }
    
}
