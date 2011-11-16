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

        p("======================== Decryption =======================");

        Crypter crypter = new Crypter("key.png");
        String firstNChar = crypter.deCrypt("secret.png");

        p("First n char: ====" + firstNChar + "====");

        String k4 = "1472";
        String k33 = "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAALdwQAAAAQ\n" +
                "c3IAEWphdmEubGFuZy5JbnRlZ2VyEuKgpPeBhzgCAAFJAAV2YWx1ZXhyABBqYXZhLmxhbmcuTnVt\n" +
                "YmVyhqyVHQuU4IsCAAB4cAAAAANzcQB+AAIAAAAGc3EAfgACAAAACHNxAH4AAgAAAApzcQB+AAIA\n" +
                "AAAAc3EAfgACAAAAAXNxAH4AAgAAAAJzcQB+AAIAAAAEc3EAfgACAAAABXNxAH4AAgAAAAdzcQB+\n" +
                "AAIAAAAJeA";

        p("======================== Module 2 =======================");

        SecurityModuleReverse reverse = new SecurityModuleReverse();
        reverse.setText(firstNChar);
        reverse.setKey3(k33);
        reverse.setKey4(k4);

        p( "Key3 : ====" + reverse.getKey3() );
        p( "Key4 : ====" + reverse.getKey4() );

        String cipherText = reverse.getCipherFromKey3Key4ImageText();

        p("======================== Module 3 =======================");

        try {
            ModifiedAES modifiedAES = new ModifiedAES();

             String keyText = "000102030405060708090a0b0c0d0e0f101112131415161718191a1b1c1d1e1f";
             byte[] key = Util.hex2byte(keyText);
             modifiedAES.setKey(key);

            String plainText = modifiedAES.Decrypt(cipherText);
            p("Plain text : ====" + plainText + "====" );
        } catch (Exception e) {
            p("Error in decrypting the cipher text:" + e.getMessage());
        }

        p("======================== End =======================");
    }

    private static void p(String string){
        System.out.println(string);
    }

}
