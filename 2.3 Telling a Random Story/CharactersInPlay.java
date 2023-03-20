
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> names;
    private ArrayList<Integer> counts;

    public CharactersInPlay() {
        names = new ArrayList<String>();
        counts = new ArrayList<Integer>();
    }
    
    public void update(String person) {
        int index = names.indexOf(person);
        if (index == -1){
            names.add(person);
            counts.add(1);
        }
        else {
            int freq = counts.get(index);
            counts.set(index,freq+1);
        }
    }
    
    public void findAllCharacters() {
        names.clear();
        counts.clear();
        FileResource fr = new FileResource();
        for(String l : fr.lines()){
            //l = l.toLowerCase();
            if (l.contains(".")) {
                int endPosition = l.indexOf(".");
                String name = l.substring(0, endPosition);
                update(name);
            }
        }
    }
    
    public void tester(){
        counts.clear();
        names.clear();
        findAllCharacters();
        for (int i=0; i < names.size(); i++){
            if (counts.get(i) < 100){
                System.out.println(names.get(i) + "\t" + counts.get(i));
            }
        }
        charactersWithNumParts(10,100);
    }
    
    public void charactersWithNumParts(int num1, int num2){
        System.out.println("Characters that have between "+ num1 + " and " + num2+ " lines:");
        for (int i=0; i < names.size(); i++){
            if (counts.get(i) >= num1 && counts.get(i)<= num2){
               System.out.println(names.get(i) + "\t" + counts.get(i));
            }
        }
    }
}

