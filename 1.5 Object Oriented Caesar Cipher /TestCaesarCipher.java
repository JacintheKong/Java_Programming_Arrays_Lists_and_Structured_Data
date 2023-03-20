
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipher {
    
    public int[] countLetters(String message){
       String alph = "abcdefghijklmnopqrstuvwxyz";
       int[] counts = new int[26]; 
    for (int i=0; i<message.length(); i++) {
	        char ch = Character.toLowerCase(message.charAt(i));
	        int index = alph.indexOf(ch);
	        if (index != -1) {
	           counts[index] += 1;
	           }
    } 
    return counts;
}

    public int maxIndex(int[] values){
        int maxIndex = 0;
       for (int i=0; i<values.length; i++) {
	        if (values[i]>values[maxIndex]) {
	            maxIndex = i;
	           }
	       }
	       return maxIndex;
}

    public void simpleTests(){
    FileResource fr = new FileResource();
    CaesarCipher cc = new CaesarCipher(18); 
    String encrypted = cc.encrypt(fr.asString());
    System.out.println("Encrypted message = " + encrypted);
    String decrypted = cc.decrypt(encrypted);
    System.out.println("Decrypted message = " + decrypted);
    breakCaesarCipher(encrypted);
    }
    
    public int getKey(String s){
    int[] counts = countLetters(s);
    int maxValue = maxIndex(counts);
    int key = maxValue - 4;
    if (maxValue < 4) {
     key = 26 - (4-maxValue);
    }
    return key;
    }

    public void breakCaesarCipher (String input) {
    int key = getKey(input);
    CaesarCipher cc = new CaesarCipher(key);
    String decrypted = cc.decrypt(input);
    System.out.println(key);
    System.out.println("Decrypted message = " + decrypted);
    }
   
}
