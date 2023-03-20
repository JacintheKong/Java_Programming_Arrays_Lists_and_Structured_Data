
/**
 * Write a description of twoKeysDecrypt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.lang.*;
public class CaesarBreaker {
    public String decrypt(String encrypted){
    CaesarCipher cc = new CaesarCipher();
    int[] freqs = countLetters(encrypted);
    int maxIndex = maxIndex(freqs);
    System.out.println(maxIndex);
    int dkey = maxIndex - 4;
    if (maxIndex < 4) {
     dkey = 26 - (4-maxIndex);
    }
    return cc.encrypt(encrypted, 26-dkey);
}

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

public void testDecrypt(){
    System.out.println(decrypt("hello"));
}

public String halfOfString(String message, int start){
    StringBuilder newMessage = new StringBuilder("");
    for (int i=start; i<message.length(); i+=2) {
	        char ch = message.charAt(i);
	        newMessage.append(ch);
    } 
    return newMessage.toString();
}

public void testHalfOfString(){
    System.out.println(halfOfString("hellopq", 2));
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
    
public void testGetKey(){
    System.out.println(getKey("gufqeurhilqubc"));
}

public String decryptTwoKeys(String encrypted){
    String string1 = halfOfString(encrypted, 0);
    String string2 = halfOfString(encrypted, 1);
    String decrypt1 = decrypt(string1);
    String decrypt2 = decrypt(string2);
    int key1 = getKey(string1);
    int key2 = getKey(string2);
    System.out.println("decrypt1: " + decrypt1 + " and the key is: " + key1);
    System.out.println("decrypt2: " + decrypt2 + " and the key is: " + key2);
    StringBuilder sb = new StringBuilder();
       int a = 0;
       int b = 0;
       for (int i=0; i < decrypt1.length()+decrypt2.length(); i++){
           //If the char is at even position:
           if (i % 2 == 0){
                sb = sb.append(decrypt1.charAt(a));
                a += 1;
            }
           else {
                sb = sb.append(decrypt2.charAt(b));
                b += 1;
            }
        }
       return sb.toString();
}

public void testDecryptTwoKeys(){
    //FileResource fr = new FileResource();
    //System.out.println(decryptTwoKeys(fr.asString()));
    System.out.println(decryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy."));
}
}
