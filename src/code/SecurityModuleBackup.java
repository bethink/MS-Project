package code;

/**
 * Created by IntelliJ IDEA.
 * User: manoj
 * Date: 25/8/11
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */


public class SecurityModuleBackup {

    public String cipherText;
    private String integers;
    private String alphebets;
    private String orderedCipher;
    private String remainingAlphabets;
    private String first7Charectors;
    private String key4;

    public void SecurityModule(){
        this.integers = "";
        this.alphebets = "";
    }

     public static void main(String[] args) {

         System.out.println("===== START =====\n");

         String cipherText = "ABCD0123456789EFGHIJKLMN";

         SecurityModuleV1 securityModuleV1 = new SecurityModuleV1();
         securityModuleV1.cipherText = cipherText;
         String key4 = securityModuleV1.generateKey4( cipherText );

         System.out.println( "\n===== End =====" );
     }

    public String generateKey4( String cipherText ){

        System.out.println( "Cipher text: " + cipherText );
        String alphabetsIntegers = orderedCipher( cipherText );
        this.key4 = getKey4();
        System.out.println( "Key4: " + this.key4 );
        return this.key4;
    }

    public String getKey4( ){

        this.remainingAlphabets = this.alphebets.substring(7, this.alphebets.length());
        String key4 = integers.concat(remainingAlphabets);
        return key4;
    }

    public String first7Charectors( String string ){

        this.first7Charectors = string.substring(0, 7);
        System.out.println( "First 7 alphabets: " + first7Charectors );
        return this.first7Charectors;
    }

    public String orderedCipher( String cipherText ){

        int i;

        for(i=0; i< cipherText.length(); i++){

            char chr = cipherText.charAt(i);

            if( Character.isDigit( chr ) ){
                this.integers = this.integers.concat( Character.toString( chr) );
            }else{
                this.alphebets = this.alphebets.concat( Character.toString( chr ) );
            }

        }

        this.orderedCipher = alphebets.concat(integers);

        System.out.println( "Integers: " + this.integers );
        System.out.println( "Alphabets: " + this.alphebets );
        System.out.println( "Ordered cipher: " + this.orderedCipher );

        return this.orderedCipher;
    }

}
