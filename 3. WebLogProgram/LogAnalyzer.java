
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource fr = new FileResource(filename);
         for (String line : fr.lines()){
             LogEntry le = WebLogParser.parseEntry(line);
             records.add(le);
            }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs() {
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for (LogEntry le : records) {
            String ipAddr = le.getIpAddress();
            if (!uniqueIPs.contains(ipAddr)){
                uniqueIPs.add(ipAddr);
            }
         }
            return uniqueIPs.size();
     }
        
     public ArrayList uniqueIPVisitsOnDay(String someday) {
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for (LogEntry le : records) {
            String ipDate = le.getAccessTime().toString();
            //System.out.println(ipDate);
            String date = ipDate.substring(4,10);
            //System.out.println(date);
            if (date.equals(someday)){
               String ipAddr = le.getIpAddress();
               if (!uniqueIPs.contains(ipAddr)){
                uniqueIPs.add(ipAddr);
               }
            }
         }
            return uniqueIPs;
     }
     
     public int countUniqueIPsInRange(int low, int high) {
         ArrayList<String> uniqueIPs = new ArrayList<String>();
         for (LogEntry le : records) {
            int code = le.getStatusCode();
            if (code >= low && code <= high){
               String ipAddr = le.getIpAddress();
               if (!uniqueIPs.contains(ipAddr)){
                uniqueIPs.add(ipAddr);
               }
            }
         }
            return uniqueIPs.size();
        }
        
     public void printAllHigherThanNum(int num) {
         for (LogEntry le : records) {
            int code = le.getStatusCode();
            if (code > num){
               System.out.println(le);
               }
            }
         }
         
     public HashMap countVisitsPerIP (){
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        for (LogEntry le : records) {
            String ipAddr = le.getIpAddress();
            if (!counts.containsKey(ipAddr)){
                counts.put(ipAddr, 1);
            }
         
            else {
                counts.put(ipAddr, counts.get(ipAddr)+1);
            }
        }
        return counts;
     }
     
     public int mostNumberVisitsByIP (HashMap<String, Integer> map){
         int maxCount = 0;
        for (LogEntry le : records) {
            String ipAddr = le.getIpAddress();
            int count = map.get(ipAddr);
            if (count > maxCount) {
            maxCount = count;
            }
        }
        return maxCount;
      }
      
     public ArrayList iPsMostVisits (HashMap<String, Integer> map){
        ArrayList<String> Ips = new ArrayList<String>();
        int maxCount = mostNumberVisitsByIP(map);
        for (LogEntry le : records) {
            String ipAddr = le.getIpAddress();
            int count = map.get(ipAddr);
            if ((count == maxCount) && (!Ips.contains(ipAddr))){
                Ips.add(ipAddr);
            }
        }
        return Ips;
     }
     
     public HashMap iPsForDays() {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (LogEntry le : records) {
            String ipDate = le.getAccessTime().toString();
            String date = ipDate.substring(4,10);
            //System.out.println(date);
            String ipAddr = le.getIpAddress();
            //System.out.println(ipAddr);
            if (!map.containsKey(date)) {
                ArrayList<String> Ips = new ArrayList<String>();
                Ips.add(ipAddr);
                map.put(date, Ips);
                }
            else {
                ArrayList<String> Ips = map.get(date);
                Ips.add(ipAddr);
                map.put(date, Ips);
            }
            
        }
     return map;
     }
     
     public String dayWithMostIPVisits(HashMap<String, ArrayList<String>> map){
        int maxCount = 0;
        String mostKey = "";
        for (String key : map.keySet()) {
            int count = map.get(key).size();
            if (count > maxCount) {
            maxCount = count;
            mostKey = key;
            }
        }
        return mostKey;
     }
     
     public ArrayList iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> map, String date){
        for (String key: map.keySet()){
            if (key.contains(date)){
                return map.get(key);
            }
        }
        return null;
     }
}
