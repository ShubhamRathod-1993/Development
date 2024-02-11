package DSA_JAVA.java_files.pointers;
import java.util.HashMap;
public class pointer {
    public static void main(String[] args) {
        HashMap<String, Integer> map1= new HashMap<>();
        HashMap<String, Integer> map2= new HashMap<>();

        map1.put("value", 11);
        map2=map1;

        System.out.println(map1);
        System.out.println(map2);
        //Adding element to the first Map using a reference of the second Map
        map1.put("value",22);
        System.out.println(map1);
        System.out.println(map2);
    }
}
