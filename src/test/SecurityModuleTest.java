package test;

import static org.testng.Assert.*;

import code.Encryption;
import code.SecurityModule;
import code.SecurityModuleReverse;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: manoj
 * Date: 27/8/11
 * Time: 11:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class SecurityModuleTest {

//    @Test
//    public void sampleTest(){
//
//        Encryption.execute("A1BCD2EF3GHi4jk5lmn6op7qr890stuvwxyz");
//        assertEquals("", "");
//        System.out.print("this is test by manoj");
//
//    }


    @Test
    public void serializeTest() throws IOException, ClassNotFoundException {

//        List<Integer> list = Arrays.asList(1, 2, 3);
//        SecurityModule sm = new SecurityModule("cipher text");
//        String str = sm.serialize(list);
//
//        SecurityModuleReverse smr = new SecurityModuleReverse();
//        List<Integer> deserializedList = smr.deserialize(str);
//
//        assertEquals(list, deserializedList);

    }




    @Test
    public void securityModuleValidCipher(){

        p("\n==================Test1================");

        String cipherText = "111111 Cipher Text from module-1 111111";
        SecurityModule sm = new SecurityModule(cipherText);
        sm.generateKeysAndText();

        p( "Cipher Text:" + cipherText );
        p( "Key3:" + sm.getKey3() );
        p( "Key4:" + sm.getKey4() );
        p( "Image Text:" + sm.getFirst7Alphabets() );

//        sm.getKey3();
//        sm.getKey4();
//        sm.getFirst7Alphabets();

        p("==================Test1 - Reverse================");


        SecurityModuleReverse smr = new SecurityModuleReverse();
        String resultText = smr.getCipherFromKey3Key4ImageText(sm.getKey3(), sm.getKey4(), sm.getFirst7Alphabets());

        assertEquals(resultText, cipherText);
    }

    @Test
    public void securityModuleOnlyAlphabets(){

        p("\n==================Test2================");

        String cipherText = "111111 Cipher Text from module-1 111111";
        SecurityModule sm = new SecurityModule(cipherText);
        sm.generateKeysAndText();

        p( "Cipher Text:" + cipherText );
        p( "Key3:" + sm.getKey3() );
        p( "Key4:" + sm.getKey4() );
        p( "Image Text:" + sm.getFirst7Alphabets() );

        p("==================Test2 - Reverse================");

        SecurityModuleReverse smr = new SecurityModuleReverse();
        String resultText = smr.getCipherFromKey3Key4ImageText(sm.getKey3(), sm.getKey4(), sm.getFirst7Alphabets());

        assertEquals(resultText, cipherText);
    }


//    @Test
//    public void securityModuleIntegers(){
//
//        SecurityModule sm = new SecurityModule("123456789123456789");
//        sm.generateKeysAndText();
//
//        sm.getKey3();
//        sm.getKey4();
//        sm.getFirst7Alphabets();
//
//
//        SecurityModuleReverse smr = new SecurityModuleReverse();
//        String cipherText = smr.getCipherFromKey3Key4ImageText(sm.getKey3(), sm.getKey4(), sm.getFirst7Alphabets());
//
//        assertEquals(cipherText, "123456789123456789");
//    }


    private static void p(String string){
        System.out.println(string + "\n");
    }

}
