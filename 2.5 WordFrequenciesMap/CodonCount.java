
/**
 * Write a description of CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;

public class CodonCount {
    private HashMap<String,Integer> map;

    public CodonCount(){
        map = new HashMap<String,Integer>();
    }
    
    public void buildCodonMap(int start, String dna){
        map.clear();
        for (int i = start; i <dna.length()-2; i+=3){
            String codon = dna.substring(i, i+3);
            if (!map.containsKey(codon)){
		map.put(codon,1);
	    }
	    else {
		map.put(codon,map.get(codon)+1);
	    }
        }
        System.out.println("Reading frame starting with " + start);
    }
    
    public String getMostCommonCodon(){
        int maxValue = 0;
        String mostCommon = "";
        for(String codon : map.keySet()){
	    if (map.get(codon) > maxValue){
		maxValue = map.get(codon);
		mostCommon = codon;
	    }
	}
	return "Most common codon is " + mostCommon + " with count " + maxValue;
    }
    
    public void printCodonCounts(int start, int end){
        for(String codon : map.keySet()){
            int value = map.get(codon);
            if (value >= start && value <= end){
		System.out.println(codon+"\t"+value);
	    }
        }
    }
    
    public void tester(){
	int start = 1;
        String dna = "CAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCTAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCCAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATC";
        buildCodonMap(start,dna);
        System.out.println(getMostCommonCodon());
        printCodonCounts(1,12);
	}
}
