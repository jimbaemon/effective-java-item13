import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetExample {

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("def");
        hashSet.add("abc");
        System.out.println("HashSet: " + hashSet);

        Set<String> treeSet = new TreeSet<>(hashSet);

        System.out.println("TreeSet: " + treeSet);
    }
}
