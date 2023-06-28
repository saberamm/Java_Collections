import java.util.*;

public class Test1 {
    //this method take a String word and then put it as characters
    //in an ArrayList and send it to back track methode
    //and after that return an Array list as an answer
    public static List<String> backtrackRun(String word) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : word.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        backtrack(charCount, "", result);
        return result;
    }

    //this methode searching in the Array list of characters and return all the word we can write with them
    private static void backtrack(java.util.Map<Character, Integer> charCount, String current, List<String> result) {
        boolean isValid = true;
        for (char c : charCount.keySet()) {
            if (charCount.get(c) > 0) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            result.add(current);
            return;
        }
        for (char c : charCount.keySet()) {
            if (charCount.get(c) > 0) {
                charCount.put(c, charCount.get(c) - 1);
                backtrack(charCount, current + c, result);
                charCount.put(c, charCount.get(c) + 1);
            }
        }
    }
//this methode compare two list of character and if thy can write the same words return true else return false
    public static boolean backtrackComparator(String a, String b) {
        List<String> set1 = backtrackRun(a);
        List<String> set2 = backtrackRun(b);

        return set1.equals(set2);
    }
}
