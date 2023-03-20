
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo(int key1, int key2){
            alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
            shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
        }

    public String encrypt (String input){
        StringBuilder sb = new StringBuilder(input);
        String alphaLower = alphabet.toLowerCase();
        String shiftLower1 = shiftedAlphabet1.toLowerCase();
        String shiftLower2 = shiftedAlphabet2.toLowerCase();
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < sb.length(); i+=2) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = sb.charAt(i);
            int idx = alphabet.indexOf(currChar);
            int idxLower = alphaLower.indexOf(currChar);
            
            if(Character.isLowerCase(currChar)){
                if(idxLower != -1){
                    currChar = shiftLower1.charAt(idxLower);
                    sb.setCharAt(i, currChar);
                }
            }
                else{
                if (idx != -1){
                    currChar = shiftedAlphabet1.charAt(idx);
                    sb.setCharAt(i, currChar);
                }
            }
        }
        
        for(int i = 1; i < sb.length(); i+=2) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = sb.charAt(i);
            int idx = alphabet.indexOf(currChar);
            int idxLower = alphaLower.indexOf(currChar);
            
            if(Character.isLowerCase(currChar)){
                if(idxLower != -1){
                    currChar = shiftLower2.charAt(idxLower);
                    sb.setCharAt(i, currChar);
                }
            }
                else{
                if (idx != -1){
                    currChar = shiftedAlphabet2.charAt(idx);
                    sb.setCharAt(i, currChar);
                }
            }
        }
        return sb.toString();
    }
    
    public void testEncrypt(){
    System.out.println(encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
    } 
    
    public String decrypt (String input){
            CaesarCipherTwo cct = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2); 
            return cct.encrypt(input);
    }
}
