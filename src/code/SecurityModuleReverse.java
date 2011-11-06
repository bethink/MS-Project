package code;

import sun.awt.image.BufImgSurfaceData;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: manoj
 * Date: 27/10/11
 * Time: 12:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class SecurityModuleReverse {

    private String text;
    private List<Integer> key3;
    private String key4;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Integer> getKey3() {
        return key3;
    }

    public void setKey3(List<Integer> key3) {
        this.key3 = key3;
    }

    public String getKey4() {
        return key4;
    }

    public void setKey4(String key4) {
        this.key4 = key4;
    }

    public String getCipherFromKey3Key4ImageText(){
        return getCipherFromKey3Key4ImageText( getKey3(), getKey4(), text);
    }

    public String getCipherFromKey3Key4ImageText( List<Integer> key3, String key4, String imageText /* imageText => first7alphabets */ ){

        char[] cipherArray = new char[key3.size()];
        int i;

        String jumbledCipher = key4.concat(imageText);

        for( i = 0; i < key3.size(); i++ ){
            cipherArray[ key3.get(i) ] = jumbledCipher.charAt(i);
        }

        String cipher = new String( cipherArray );

        p( "Cipher text :" + cipher );

        return cipher;
    }

    public List<Integer> deserialize(String key3) throws IOException, ClassNotFoundException {

        byte[] buf = key3.getBytes();
        ObjectInputStream in;
        in = new ObjectInputStream(new ByteArrayInputStream(buf));
        List<Integer> key3Ary = (List<Integer>) in.readObject();
        in.close();

        return key3Ary;
    }

    private static void p(String string){
        System.out.println(string);
    }
}
