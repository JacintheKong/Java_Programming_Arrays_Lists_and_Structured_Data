import java.util.*;
import edu.duke.*;
import java.io.File;

public class VigenereBreaker {
    private int[] validKey;
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //REPLACE WITH YOUR CODE
        String newMessage = "";
        for (int i = whichSlice; i < message.length(); i += totalSlices){
        newMessage += message.charAt(i);
        }
        
        return newMessage;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        CaesarCracker cc = new CaesarCracker();
        for (int i = 0; i < klength; i++){
            String newMessage = sliceString(encrypted, i, klength);
            int dkey = cc.getKey(newMessage);
            key[i]= dkey;
        }
        return key;
    }

    public void breakVigenere () {
       FileResource fr = new FileResource();
       String encrypted = fr.asString();

       int[] key = tryKeyLength(encrypted, 5,'e');
       VigenereCipher vc = new VigenereCipher(key);
       System.out.println(vc.decrypt(encrypted));
    }
    
    public void breakVigenere2 () {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        
        FileResource dic = new FileResource();
        HashSet dictionary = readDictionary(dic);
        
        String answer = breakForLanguage(encrypted, dictionary);
        System.out.println(answer);
    }
    
    public void tester(){
        //System.out.println(sliceString("abcdefghijklm", 4, 5));
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        
        FileResource dic = new FileResource();
        HashSet dictionary = readDictionary(dic);
        
        int[] key = tryKeyLength(encrypted, 38,'e');
        VigenereCipher vc = new VigenereCipher(key);
        String decrypted = vc.decrypt(encrypted);
        int count = countWords(decrypted, dictionary);
        System.out.println(count);
        //for (int i=0; i< key.length; i++){
            //System.out.println(key[i]);
        //}
        
        //breakVigenere2();
    }
    
    public HashSet readDictionary (FileResource fr){
    HashSet<String> hs = new HashSet<String>();
    for (String s : fr.words()){
        s = s.toLowerCase();
        hs.add(s);
    }
    return hs;
    }
    
    public int countWords(String message, HashSet<String> dictionary){
        String[] wordsArray = message.split("\\W+");
        int count = 0;
        for (int i = 0; i < wordsArray.length; i++){
            if (dictionary.contains(wordsArray[i].toLowerCase())){
                count +=1;
            }
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int maxCount = 0;
        String answer = "";
        char ch = mostCommonCharIn(dictionary);
        for (int i = 1; i <= 100; i++ ){
          int[] key = tryKeyLength(encrypted, i, ch);
          VigenereCipher vc = new VigenereCipher(key);
          String decrypted = vc.decrypt(encrypted);
          int count = countWords(decrypted, dictionary);
            if (count > maxCount){
                maxCount = count;
                answer = decrypted;
                validKey = key;
            }
        }
        System.out.println("This file contains " + maxCount + " valid words and keylength " + validKey.length);
        return answer;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary){
        HashMap<Character, Integer> characters = new HashMap<Character, Integer>();
        char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o',
                        'p','q','r','s','t','u','v','w','x','y','z'};
        char ch = 'a';
        for(int i=0; i<chars.length; i++){
            characters.put(chars[i],0);
        }
        
        for (String word : dictionary){
           for(char s : characters.keySet()){
               if (word.contains(Character.toString(s))){
                   characters.put(s, characters.get(s)+1);
               }
            }
        }
        
        int maxValue = 0;
        for(char s : characters.keySet()){
            int value = characters.get(s);
            if (value > maxValue) {
                maxValue = value;
                ch = s;
            }
        }
        return ch;
    }
   

    public void breakForAllLangs(String encrypted, HashMap<String, HashSet<String>> languages){
        for (String lang : languages.keySet()) {
            HashSet dictionary = languages.get(lang);
            String answer = breakForLanguage(encrypted, dictionary);
            int count = countWords(answer, dictionary);
            System.out.println("language = " + lang);
            System.out.println("Decrypted message  ="+ answer);
            //System.out.println("Words counted = "+ count);
        }
    }
    
    public void breakVigenere3 () {
        //WRITE YOUR CODE HERE
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        
        DirectoryResource dr = new DirectoryResource();
        HashMap<String, HashSet<String>> languages = new HashMap<String, HashSet<String>>();
        for (File f : dr.selectedFiles()) {
            FileResource fr2 = new FileResource(f);
            HashSet dictionary = readDictionary(fr2);
            languages.put(f.getName(), dictionary);
        }
        breakForAllLangs(encrypted, languages);
    }
    
    public void testerBreakForLanguage(){
        //breakVigenere3();
       FileResource fr = new FileResource();
       String encrypted = fr.asString();
       
       FileResource dic = new FileResource();
       HashSet dictionary = readDictionary(dic);
        //System.out.println(mostCommonCharIn(dictionary));
       String answer = breakForLanguage(encrypted, dictionary);
       System.out.println(answer);
    }
    
    public void tester3(){
        breakVigenere3();
    }
}

