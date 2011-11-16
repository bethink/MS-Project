package test;

import code.*;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: manoj
 * Date: 28/10/11
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class EncryptionTest {


    @Test
    public void testFlow(){


        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("  SECURE DATA TRANSFER  ");
        System.out.println("   -----  ---- ------- ");
        String cryptKey = "aPb4x9q0H4W8rPs7"; // "aPb4x9q0H4W8rPs7";
        String data = "S.MANOJKUMAR M.S(BITS,Pilani)   ";
        System.out.println("");
        System.out.println("");
        System.out.println("--------Module 1-------------");
        System.out.println("");


        System.out.println("The Input Plain Data to ModifiedAES is :::::::::::::" + data);
        System.out.println("");

        String data1;
        String PlainData;


        ModifiedAES aes;
        aes = new ModifiedAES();
        aes.setKey(cryptKey);

        data = aes.Encrypt(data);

        System.out.println("The ModifiedAES Cipher Data is ::::::::::::::" + data);

        System.out.println("");
        System.out.println("--------Module 3-------------");
        System.out.println("");
        Crypter c = new Crypter("key.png"); // Key picture.

        //Crypt
        c.encrypt(data, "secret-old.png");
        System.out.println("The ModifiedAES Cipher Data is now hidden in the Secret Image.");

        //Decrypt
        System.out.println("The ModifiedAES Cipher data from the Secret image is:::" + c.deCrypt("secret-old.png"));
        System.out.println("");
        System.out.println("");
        data = c.deCrypt("secret-old.png");


        System.out.println("The ModifiedAES Cipher Data is now given to ModifiedAES for Decrypt......");
        data1 = aes.Decrypt(data);
        System.out.println("");
        System.out.println("The Plain recovered data Data is ::::::::" + data1);



    }




//    @Test
//    public void testModifiedAESEncryption(){
//        Encryption.execute("S.MANOJKUMAR M.S(BITS,Pilani) 620004 1234", "key.png");
//
//
////        String k3 = "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAALdwQAAAAQc3IAEWphdmEubGFuZy5JbnRlZ2VyEuKgpPeBhzgCAAFJAAV2YWx1ZXhyABBqYXZhLmxhbmcuTnVtYmVyhqyVHQuU4IsCAAB4cAAAAANzcQB+AAIAAAAGc3EAfgACAAAACHNxAH4AAgAAAApzcQB+AAIAAAAAc3EAfgACAAAAAXNxAH4AAgAAAAJzcQB+AAIAAAAEc3EAfgACAAAABXNxAH4AAgAAAAdzcQB+AAIAAAAJeA";
//
////        String k4 = "1472";
////        String k33 = "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAALdwQAAAAQ\n" +
////                "c3IAEWphdmEubGFuZy5JbnRlZ2VyEuKgpPeBhzgCAAFJAAV2YWx1ZXhyABBqYXZhLmxhbmcuTnVt\n" +
////                "YmVyhqyVHQuU4IsCAAB4cAAAAANzcQB+AAIAAAAGc3EAfgACAAAACHNxAH4AAgAAAApzcQB+AAIA\n" +
////                "AAAAc3EAfgACAAAAAXNxAH4AAgAAAAJzcQB+AAIAAAAEc3EAfgACAAAABXNxAH4AAgAAAAdzcQB+\n" +
////                "AAIAAAAJeA";
//
//
//
////        Decryption.execute();
//    }




}
