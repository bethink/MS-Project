package code;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by IntelliJ IDEA.
 * User: manoj
 * Date: 23/8/11
 * Time: 9:10 PM
 * To change this template use File | Settings | File Templates.
 */

public class SecurityModuleV1 {

    public String cipherText;

    private String integers;
    private String alphebets;
    private String orderedCipher;
    private String first7Alphabets;
    private String remainingAlphabets;
    private String key4;

    private List<Integer> intPositions;
    private List<Integer> alpaPositions;
    private List<Integer> first7AlphaPositions;
    private List<Integer> remainingAlpaPositions;
    private List<Integer> key3;


    public SecurityModuleV1() {
        this.integers = "";
        this.alphebets = "";
        this.alpaPositions = new ArrayList<Integer>();
        this.intPositions = new ArrayList<Integer>();
        this.key3 = new ArrayList<Integer>();
    }

    public static void main(String[] args) {

        System.out.println("===== START =====\n");

        String cipherText = "ABCD0123456789EFGHIJKLMN";

        SecurityModuleV1 securityModuleV1 = new SecurityModuleV1();
        securityModuleV1.cipherText = cipherText;
        String key4 = securityModuleV1.generateKey4(cipherText);

        securityModuleV1.key3 = securityModuleV1.getKey3();


        System.out.print("Key3 : ");
        printList( securityModuleV1.key3 );
        System.out.println("\n===== End =====");

        getCipherFromKey3Key4ImageText( securityModuleV1.key3, securityModuleV1.key4, securityModuleV1.first7Alphabets );

        System.out.println("\n===== End 2=====");
    }

    private static void printList(List<Integer> list) {
        for (int position : list) {
            System.out.print(position + " ");
        }
    }

    public String generateKey4(String cipherText) {

        System.out.println("Cipher text: " + cipherText);
        String alphabetsIntegers = orderedCipher(cipherText);
        this.key4 = getKey4();
        System.out.println("Key4: " + this.key4);
        return this.key4;
    }

    public List<Integer> getKey3() {
        first7Alphabets();
        this.key3.addAll(this.intPositions);
        this.key3.addAll(this.remainingAlpaPositions);
        this.key3.addAll(this.first7AlphaPositions);

        return this.key3;
    }

    public String getKey4() {

        this.remainingAlphabets = this.alphebets.substring(7, this.alphebets.length());
        this.remainingAlpaPositions = this.alpaPositions.subList(7, this.alpaPositions.size());
        String key4 = integers.concat(remainingAlphabets);

        return key4;
    }

    public String first7Alphabets( ) {

        this.first7Alphabets = this.alphebets.substring(0, 7);
        this.first7AlphaPositions = this.alpaPositions.subList(0, 7);

        System.out.println("First 7 alphabets: " + this.first7Alphabets);

        return this.first7Alphabets;
    }

    public String orderedCipher(String cipherText) {

        int i;

        for (i = 0; i < cipherText.length(); i++) {

            char chr = cipherText.charAt(i);

            if (Character.isDigit(chr)) {
                this.integers = this.integers.concat(Character.toString(chr));
                this.intPositions.add(i);
            } else {
                this.alphebets = this.alphebets.concat(Character.toString(chr));
                this.alpaPositions.add(i);
            }

        }

        this.orderedCipher = alphebets.concat(integers);

        System.out.println("Integers: " + this.integers);
        System.out.println("Alphabets: " + this.alphebets);
        System.out.println("Ordered cipher: " + this.orderedCipher);

        return this.orderedCipher;
    }

//    ========================= DECRYPTION =======================

    public static String getCipherFromKey3Key4ImageText( List<Integer> key3, String key4, String imageText /* imageText => first7alphabets */ ){

        char[] cipherArray = new char[key3.size()];
        int i;

        String jumbledCipher = key4.concat(imageText);

        for( i = 0; i < key3.size(); i++ ){
            cipherArray[ key3.get(i) ] = jumbledCipher.charAt(i);
        }

        String cipher = new String( cipherArray );

        System.out.println( "Cipher text :" + cipher );

        return cipher;
    }

}