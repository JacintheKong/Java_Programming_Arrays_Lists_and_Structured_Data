
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordPlay {
    public Boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        if ((ch == 'a')||(ch == 'e')||(ch == 'i')||(ch == 'o')||(ch == 'u')) 
        {
            return true;
        }
        
        else 
            return false;
    }
    
    public void testWordPlay(){
        System.out.println(isVowel('F'));
        System.out.println(isVowel('a'));
    }
    
    public String replaceVowels(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder(phrase);
        for(int i = 0; i < newPhrase.length(); i++){
            char currChar = newPhrase.charAt(i);
            currChar = Character.toLowerCase(currChar);
            if ((currChar == 'a')||(currChar == 'e')||(currChar == 'i')||
            (currChar == 'o')||(currChar == 'u'))
            {
                newPhrase.setCharAt(i, ch);
            }
        }
        return newPhrase.toString();
    }
    
    public void testReplaceVowels(){
        System.out.println(replaceVowels("Hello World", '*'));
    }
    
    public String emphasize(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder(phrase);
        for(int i = 0; i < newPhrase.length(); i++){
            char currChar = newPhrase.charAt(i);
            currChar = Character.toLowerCase(currChar);
            if (currChar == ch){
               if (i % 2 == 0)
                newPhrase.setCharAt(i, '*');
               else 
                newPhrase.setCharAt(i, '+');
            }
        }
        return newPhrase.toString();
    }

    public void testEmphasize(){
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
}
