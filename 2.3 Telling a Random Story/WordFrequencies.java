
/**
 * Find out how many times each word occurs, and
 * in particular the most frequently occurring word.
 * 
 * @author Duke Software Team
 * @version 1.0
 */
import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies
{
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        
        FileResource fr = new FileResource();
        for(String s : fr.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1);
            }
        }
    }
    
    public int findIndexOfMax(){
        int maxValue = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++){
            if (myFreqs.get(k) > maxValue){
                maxValue = myFreqs.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }
    
    public void wordsAndFreqs () {
        for (int i = 0; i < myFreqs.size(); i++){
            System.out.println(myFreqs.get(i) + " " + myWords.get(i));
        }
    }
    
    public void tester(){
        findUnique();
        System.out.println(myWords.size());
        wordsAndFreqs ();
        int index = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are: "+myWords.get(index)+" "+myFreqs.get(index));
    }
}
