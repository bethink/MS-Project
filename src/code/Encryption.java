package code;

/**
 * Created by IntelliJ IDEA.
 * User: manoj
 * Date: 23/8/11
 * Time: 11:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Encryption {

    public static void execute(String plainText){

        String cipherText = "";

        try {
            cipherText = AESImplementation.encrypt(plainText);
        } catch (Exception e) {
            p("Error in encrypting the plain text: " + e.getMessage());
        }

        SecurityModule securityModule = new SecurityModule( cipherText );
        securityModule.generateKeysAndText();
        securityModule.getKey4();
        securityModule.getKey3();
        securityModule.getFirst7Alphabets();
    }

    private static void p(String string){
        System.out.println(string);
    }
    
}
