
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
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

   public String halfOfString(String message, int start){
    StringBuilder newMessage = new StringBuilder("");
    for (int i=start; i<message.length(); i+=2) {
	        char ch = message.charAt(i);
	        newMessage.append(ch);
    } 
    return newMessage.toString();
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
   
   public void simpleTests(){
    FileResource fr = new FileResource();
    CaesarCipherTwo cct = new CaesarCipherTwo(17, 3); 
    String encrypted = cct.encrypt(fr.asString());
    System.out.println("Encrypted message = " + encrypted);
    String decrypted = cct.decrypt(encrypted);
    System.out.println("Decrypted message = " + decrypted);
    }
    
   public String breakCaesarCipher (String input){
       String string1 = halfOfString(input, 0);
       String string2 = halfOfString(input, 1);
       int key1 = getKey(string1);
       int key2 = getKey(string2);
       
       CaesarCipherTwo cct = new CaesarCipherTwo(26-key1, 26-key2);
       
       String decrypt1 = cct.decrypt(string1);
       String decrypt2 = cct.decrypt(string2);

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
    
    public void testBreakCaesarCipher(){
    FileResource fr = new FileResource();
    breakCaesarCipher(fr.asString());
    }
}
