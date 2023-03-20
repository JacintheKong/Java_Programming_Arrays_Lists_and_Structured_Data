import edu.duke.*;
   
public class CaesarCipher {
        private String alphabet;
        private String shiftedAlphabet;
        private int mainKey;
        
        public CaesarCipher(int key){
            alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
            mainKey = key;
        }
        //Make a StringBuilder with message (encrypted)
        
        public String encrypt (String input){
        StringBuilder sb = new StringBuilder(input);
        String alphaLower = alphabet.toLowerCase();
        String shiftLower = shiftedAlphabet.toLowerCase();
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < sb.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = sb.charAt(i);
            int idx = alphabet.indexOf(currChar);
            int idxLower = alphaLower.indexOf(currChar);
            if(Character.isLowerCase(currChar)){
                if(idxLower != -1){
                    currChar = shiftLower.charAt(idxLower);
                    sb.setCharAt(i, currChar);
                }
            }
                else{
                if (idx != -1){
                    currChar = shiftedAlphabet.charAt(idx);
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
            CaesarCipher cc = new CaesarCipher(26 - mainKey); 
            return cc.encrypt(input);
        }
    }