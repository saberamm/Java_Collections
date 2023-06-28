import java.util.Random;
import java.util.TreeSet;

public class Test2 {
//this methode create two tree set and put 10 character in it
    public static void run() {
        Random random = new Random();
        TreeSet<Character> set1 = new TreeSet<>();
        TreeSet<Character> set2 = new TreeSet<>();

        for (int i = 0; i < 10; i++) {
            char letter = (char) ('a' + random.nextInt(26));
            set1.add(letter);
        }

        for (int i = 0; i < 10; i++) {
            char letter = (char) ('a' + random.nextInt(26));
            set2.add(letter);
        }
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        union(set1, set2);
        interSection(set1,set2);

    }
//this methode union two treeset and print them together
    public static void union(TreeSet<Character> set1, TreeSet<Character> set2) {
        TreeSet<Character> unionSet = new TreeSet<>(set1);
        unionSet.addAll(set2);

        System.out.println("Union set: " + unionSet);
    }
    //this methode print the same character that they have
    public static void interSection(TreeSet<Character> set1, TreeSet<Character> set2) {

        TreeSet<Character> intersectionSet = new TreeSet<>(set1);
        intersectionSet.retainAll(set2);

        System.out.println("Intersection set: " + intersectionSet);
    }
}
