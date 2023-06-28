import java.util.ArrayList;

public class Test3 {
    //this methode will delete the last number of array if array size is odd
    //then in the for while it will remove the two number that not Appropriate
    public static void removeUnsuitablePairs(ArrayList<Integer> arrayList) {
        if (arrayList.size() % 2 == 1) {
            arrayList.remove(arrayList.size()-1);
        }

        for (int i = arrayList.size() - 2; i >= 0; i -= 2) {
            if (arrayList.get(i) < arrayList.get(i+1)) {
                arrayList.remove(i);
                arrayList.remove(i);
            }
        }
        System.out.println(arrayList);
    }
}
