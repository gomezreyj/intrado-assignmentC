package assignmentC.main;

import java.util.*;

public class ListOfWords {

    // This list of words was generated using the web site at https://randomwordgenerator.com/
    String words[] = {"horse", "bang", "candidate", "strap", "credibility", "deadly", "animal", "make", "electron", "diameter",
                      "beach", "wing", "formation", "torch", "bell", "dimension", "embark", "ministry", "castle", "familiar",
                      "agree", "sausage", "minority", "colony", "fault", "miner", "compartment", "award", "norm", "float",
                      "afford", "gallery", "epicalyx", "disappoint", "vote", "combine", "crisis", "reaction","constellation",
                      "appointment", "topple", "organ", "splurge", "undermine", "reproduce", "nightmare", "red", "cheque", "brick", "bland"};

    List<String> wordsList = Arrays.asList(words);

    public long wordsBeginWith(char c)
    {
        
        return wordsList.stream().filter(word -> Character.toLowerCase(word.charAt(0)) == c).count();
    }

    public long wordsEndingWith(char c)
    {
       
        return wordsList.stream().filter(word -> Character.toLowerCase(word.charAt(word.length() - 1)) == c).count();
    }

    public String shortestWordBeginsWith(char c) {
        
        Optional<String> shortestWord = wordsList.stream().filter(word -> Character.toLowerCase(word.charAt(0)) == c).reduce((w1,w2)-> w1.length() < w2.length() ? w1 : w2);
        return shortestWord.isPresent() ? shortestWord.get() : "none";

    }

    public String longestWordBeginsWith(char c) {
        
        Optional<String> shortestWord = wordsList.stream().filter(word -> Character.toLowerCase(word.charAt(0)) == c).reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2);
        return shortestWord.isPresent() ? shortestWord.get() : "none";
    }

    public double averageNumberCharactersBeginWith(char c)
    {
        
        return wordsList.stream().filter(word -> Character.toLowerCase(word.charAt(0)) == c).mapToInt(String::length).average().orElse(0);
    }

    public static void main(String args[])
    {
        ListOfWords low = new ListOfWords();

        for ( char alphabet = 'a'; alphabet <= 'z'; alphabet++)
        {
            System.out.println("Words beginning with " + alphabet + ":" + low.wordsBeginWith(alphabet));
            System.out.println("Words ending with " + alphabet + ":" + low.wordsEndingWith(alphabet));
            System.out.println("Shortest Word Beginning with " + alphabet + ":" + low.shortestWordBeginsWith(alphabet));
            System.out.println("Longest Word Beginning with " + alphabet + ":" + low.longestWordBeginsWith(alphabet));
            System.out.println("Average Number of Characters in Words Begin With " + alphabet + ": " + low.averageNumberCharactersBeginWith(alphabet));
            System.out.println("=======================================");
        }

    }
}
