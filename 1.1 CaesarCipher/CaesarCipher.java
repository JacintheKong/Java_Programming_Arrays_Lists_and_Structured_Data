import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet2 = "abcdefghijklmnopqrstuvwxyz";
        //Compute the shifted alphabet
        String shiftedAlphabet1 = alphabet1.substring(key)+
        alphabet1.substring(0,key);
        String shiftedAlphabet2 = alphabet2.substring(key)+
        alphabet2.substring(0,key);
        
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            if (Character.isUpperCase(currChar)){
                //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet1.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1) {
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet1.charAt(idx);
                //Replace the ith character of encrypted with newChar
                
                encrypted.setCharAt(i, newChar);
                } 
            }else {
                int idx = alphabet2.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1) {
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet2.charAt(idx);
                //Replace the ith character of encrypted with newChar
                
                encrypted.setCharAt(i, newChar);
            
            };
            
            //Otherwise: do nothing
        }
    }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public void testCaesar() {
        //int key = 17;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        //String encrypted = encrypt(message, key);
        //System.out.println(encrypted);
        //String decrypted = encrypt(encrypted, 26-key);
        //System.out.println(decrypted);
        System.out.println(encrypt("First Legion", 23));
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
    }
    
    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        //String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String shiftedEven = alphabet.substring(key1)+alphabet.substring(0,key1);
        String shiftedOdd = alphabet.substring(key2)+alphabet.substring(0,key2);
        //Compute the shifted alphabet

        for(int i = 0; i < encrypted.length(); i+=2) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            currChar = Character.toLowerCase(currChar);
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1) {
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedEven.charAt(idx);
                //Replace the ith character of encrypted with newChar
                
                encrypted.setCharAt(i, newChar);
                } 
        }
        
        for(int i = 1; i < encrypted.length(); i+=2) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            currChar = Character.toLowerCase(currChar);
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1) {
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedOdd.charAt(idx);
                //Replace the ith character of encrypted with newChar
                
                encrypted.setCharAt(i, newChar);
                } 
        }
    return encrypted.toString();
    }

    public void testEncryptTwoKeys() {
        //System.out.println(encryptTwoKeys("First Legion", 23, 17));
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
        
    }
}

