
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLengths {
    public void countWordLengths (FileResource resource, int[] counts){
    for(String word : resource.words()){
		int wordLength = countLetters(word);
		counts[wordLength]++;
    }
    
    for(int i=0; i < counts.length; i++){
		System.out.println("For length: " + i + "\t" + "the number of words are "+ counts[i]);
    }

}

   public int countLetters(String word){
       int cnt = 0; 
    for (int i=0; i<word.length(); i++) {
	        if (Character.isLetter(word.charAt(i))) {
	               cnt++;
	           }
    } 
    return cnt;
}

public void testCountLetters(){
    //int cnt = countLetters("hello,"); 
    //int cnt = countLetters("blue-jeans"); 
    //int cnt = countLetters("!-Check-!");
    int cnt = countLetters("$");
    System.out.println(cnt);
}

   public void testCountWordLengths(){
       FileResource resource = new FileResource();
       int[] counts = new int[30];
       countWordLengths (resource, counts);
       System.out.println(indexOfMax(counts));
    }
    
    public int indexOfMax(int[] values){
        int maxIndex = 0;
       for (int i=0; i<values.length; i++) {
	        if (values[i]>values[maxIndex]) {
	            maxIndex = i;
	           }
	       }
	       return maxIndex;
}
}
