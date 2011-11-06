package code;

/**
 * Created by IntelliJ IDEA.
 * User: manoj
 * Date: 23/8/11
 * Time: 11:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Decryption {

    public static void execute(){
        SecurityModuleReverse reverse = new SecurityModuleReverse();
        String CipherText = reverse.getCipherFromKey3Key4ImageText();
        try {
            String plainText = AESImplementation.decrypt(CipherText);
        } catch (Exception e) {
            p("Error in decrypting the cipher text:" + e.getMessage());
        }
    }

    private static void p(String string){
        System.out.println(string);
    }

}
