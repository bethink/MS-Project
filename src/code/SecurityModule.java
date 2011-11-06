package code;

import sun.font.EAttribute;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ErrorManager;

/**
 * Created by IntelliJ IDEA.
 * User: manoj
 * Date: 27/10/11
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class SecurityModule {

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

    private String cipherText;

    public String getCipherText() {
        return cipherText;
    }

    public void setCipherText(String cipherText) {
        this.cipherText = cipherText;
    }

    public String getIntegers() {
        return integers;
    }

    public void setIntegers(String integers) {
        this.integers = integers;
    }

    public String getAlphebets() {
        return alphebets;
    }

    public void setAlphebets(String alphebets) {
        this.alphebets = alphebets;
    }

    public String getOrderedCipher() {
        return orderedCipher;
    }

    public void setOrderedCipher(String orderedCipher) {
        this.orderedCipher = orderedCipher;
    }

    public String getFirst7Alphabets() {
        return first7Alphabets;
    }

    public void setFirst7Alphabets(String first7Alphabets) {
        this.first7Alphabets = first7Alphabets;
    }

    public String getRemainingAlphabets() {
        return remainingAlphabets;
    }

    public void setRemainingAlphabets(String remainingAlphabets) {
        this.remainingAlphabets = remainingAlphabets;
    }

    public String getKey4() {
        return key4;
    }

    public void setKey4(String key4) {
        this.key4 = key4;
    }

    public List<Integer> getIntPositions() {
        return intPositions;
    }

    public void setIntPositions(List<Integer> intPositions) {
        this.intPositions = intPositions;
    }

    public List<Integer> getAlpaPositions() {
        return alpaPositions;
    }

    public void setAlpaPositions(List<Integer> alpaPositions) {
        this.alpaPositions = alpaPositions;
    }

    public List<Integer> getFirst7AlphaPositions() {
        return first7AlphaPositions;
    }

    public void setFirst7AlphaPositions(List<Integer> first7AlphaPositions) {
        this.first7AlphaPositions = first7AlphaPositions;
    }

    public List<Integer> getRemainingAlpaPositions() {
        return remainingAlpaPositions;
    }

    public void setRemainingAlpaPositions(List<Integer> remainingAlpaPositions) {
        this.remainingAlpaPositions = remainingAlpaPositions;
    }

    public List<Integer> getKey3() {
        return key3;
    }

    public void setKey3(List<Integer> key3) {
        this.key3 = key3;
    }

    // ==================== Constructor ====================

    public SecurityModule(String cipher) {
        setCipherText(cipher);
        setIntegers("");
        setAlphebets("");
        setAlpaPositions(new ArrayList<Integer>());
        setIntPositions(new ArrayList<Integer>());
        setKey3(new ArrayList<Integer>());
    }

    // ==================== Computation methods ====================

    public void generateKeysAndText(){
        generateKeysAndText(getCipherText());
    }

    public void generateKeysAndText(String cipherText){

        if(cipherText == null || cipherText.isEmpty()){
            p("==== Error: Cipher text is null or empty ====");
            return;
        }

        generateKey4( cipherText );
        computeKey3();

    }

    private String generateKey4(String cipherText) {

        p("Cipher text: " + cipherText);
        String alphabetsIntegers = getOrderedCipher(cipherText);
        this.key4 = computeKey4();
        p("Key4: " + this.key4);
        return this.key4;
    }

    private String getOrderedCipher(String cipherText) {

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

        p("Integers: " + this.integers);
        p("Alphabets: " + this.alphebets);
        p("Ordered cipher: " + this.orderedCipher);

        return this.orderedCipher;
    }

    private String computeKey4( ){
        this.remainingAlphabets = this.alphebets.substring(7, this.alphebets.length());
        this.remainingAlpaPositions = this.alpaPositions.subList(7, this.alpaPositions.size());
        String key4 = integers.concat(remainingAlphabets);
        return key4;
    }

//    private List<Integer> computeKey3() {
//        first7Alphabets();
//        this.key3.addAll(this.intPositions);
//        this.key3.addAll(this.remainingAlpaPositions);
//        this.key3.addAll(this.first7AlphaPositions);
//        p( getKey3().toString() );
//        return this.key3;
//    }

    private List<Integer> computeKey3() {
        first7Alphabets();
        this.key3.addAll(this.intPositions);
        this.key3.addAll(this.remainingAlpaPositions);
        this.key3.addAll(this.first7AlphaPositions);
        p( getKey3().toString() );
        return this.key3;
    }

    public String serialize(List<Integer> key3) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bos);
        out.writeObject(key3);
        out.close();
        return bos.toString();
    }

    private String first7Alphabets( ) {

        this.first7Alphabets = this.alphebets.substring(0, 7);
        this.first7AlphaPositions = this.alpaPositions.subList(0, 7);

        p("First 7 alphabets: " + this.first7Alphabets);

        return this.first7Alphabets;
    }

    private static void p(String string){
        System.out.println(string);
    }

}
