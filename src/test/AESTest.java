package test;

import code.AES;
import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
//import code
/**
 * Created by IntelliJ IDEA.
 * User: manoj
 * Date: 6/11/11
 * Time: 1:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class AESTest {


//  Example AES test values (taken from FIPS-197) are:
//
//  Key:        000102030405060708090a0b0c0d0e0f
//  Plaintext:  00112233445566778899aabbccddeeff
//  Ciphertext: 69c4e0d86a7b0430d8cdb78070b4c55a
//
//  Key:        000102030405060708090a0b0c0d0e0f1011121314151617
//  Plaintext:  00112233445566778899aabbccddeeff
//  Ciphertext: dda97ca4864cdfe06eaf70a0ec0d7191
//
//  Key:        000102030405060708090a0b0c0d0e0f101112131415161718191a1b1c1d1e1f
//  Plaintext:  00112233445566778899aabbccddeeff
//  Ciphertext: 8ea2b7ca516745bfeafc49904b496089
//

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\n");
    }

    @Test
    public void testModifiedAESEncryptionDecryptionWith128bitKey(){
//      @params( plainText, key )
        assertTrue(AES.modifiedAESTest("00112233445566778899aabbccddeeff", "000102030405060708090a0b0c0d0e0f"));
    }

    @Test
    public void testModifiedAESEncryptionDecryptionWith192bitKey(){
//      @params( plainText, key )
        assertTrue(AES.modifiedAESTest("00112233445566778899aabbccddeeff", "000102030405060708090a0b0c0d0e0f1011121314151617"));
    }

    @Test
    public void testModifiedAESEncryptionDecryptionWith256bitKey(){
//      @params( plainText, key )
        assertTrue(AES.modifiedAESTest("00112233445566778899aabbccddeeff", "000102030405060708090a0b0c0d0e0f101112131415161718191a1b1c1d1e1f"));
    }


//    @Test
//    public void testAESEncryptionDecryptionWith128bitKey(){
////        (String hkey, String hplain, String hcipher, int lev)
//        assertTrue(AES.self_test("000102030405060708090a0b0c0d0e0f", "00112233445566778899aabbccddeeff", "69c4e0d86a7b0430d8cdb78070b4c55a", 2));
//    }
//
//    @Test
//    public void testAESEncryptionDecryptionWith256bitKey(){
////        (String hkey, String hplain, String hcipher, int lev)
//        assertTrue(AES.self_test("000102030405060708090a0b0c0d0e0f1011121314151617", "00112233445566778899aabbccddeeff", "dda97ca4864cdfe06eaf70a0ec0d7191", 2));
//    }
//
//    @Test
//    public void testAESEncryptionDecryptionWithbitKey(){
////        (String hkey, String hplain, String hcipher, int lev)
//        assertTrue(AES.self_test("000102030405060708090a0b0c0d0e0f101112131415161718191a1b1c1d1e1f", "00112233445566778899aabbccddeeff", "8ea2b7ca516745bfeafc49904b496089", 2));
//    }

}
