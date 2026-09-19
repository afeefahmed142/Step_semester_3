package scr.main.java.feature_session2.assigment_problems;

import java.util.*;

public class StopWordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        
        String cleanedText = feedback.toLowerCase();

        
        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

       
        String[] words = cleanedText.split("\\s+");

        
        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

       
        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            boolean isStopWord = false;

            
            for (int j = 0; j < stopWords.length; j++) {

                if (word.equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            
            if (isStopWord) {
                continue;
            }

            
            frequency.put(
                word,
                frequency.getOrDefault(word, 0) + 1
            );
        }

        
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        
        list.sort(
            (a, b) -> b.getValue().compareTo(a.getValue())
        );

       
        for (Map.Entry<String, Integer> entry : list) {

            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter feedback:");

        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}