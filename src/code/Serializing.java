package code;

import java.io.*;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: manoj
 * Date: 28/10/11
 * Time: 12:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class Serializing {

    public static void main(String[] args) throws IOException, ClassNotFoundException { //throws IOException, ClassNotFoundException {

          System.out.println("=== Start ===");

          HashMap<String, String> map = new HashMap<String, String>();
          map.put("1", "one");
          map.put("1", "one");

          // Serialize to a byte array
          ByteArrayOutputStream bos = new ByteArrayOutputStream();
          ObjectOutput out = new ObjectOutputStream(bos);
          out.writeObject(map);
          out.close();



          byte[] buf = bos.toByteArray();
          // Deserialize from a byte array
          ObjectInputStream in;
        in = new ObjectInputStream(new ByteArrayInputStream(buf));
        String stringMap = in.toString();
//        String mapAgain = (String) in.readObject();
         HashMap<String, String> mapAgain = (HashMap<String, String>) in.readObject();
         in.close();

         System.out.println( "Result: " + map.get("1") );
         System.out.println( "Result: " + mapAgain.get("1") );

         System.out.println("=== End ===");

      }


}
