package DSA.hashtables;

import java.util.HashMap;

public class itemInCommon {
    //Solution 1 - using nested for loop
    public static boolean itemInCommon_on2(int[] array1, int[] array2){
        for (int i: array1){
            for (int j: array2){
                if (i==j) return true;
            }
        }
        return false;
    }
    
    //Solution 2 - using hashtable data structure
    public static boolean itemInCommon_hash(int[] array1, int[] array2){
        HashMap<Integer, Boolean> myHashMap=new HashMap<>();
        //add all elements of the first array to the hashmap with "true" as
        //the value corresponding to each key (element in the array).
        for (int i : array1){ 
            myHashMap.put(i, true);
        }
        //check every element in the second array. If it is in the hashmap,
        //return true immediately. Otherwise continue checking next one.
        for (int j : array2){
            if(myHashMap.get(j)!=null) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        //Items in common
        int[] array1={1,3,5};
        int[] array2={2,4,5};
        int[] array3={2,4,6};
        System.out.println(itemInCommon_on2(array1,array2));
        System.out.println(itemInCommon_on2(array1,array3));

        //Using HashMap
        System.out.println(itemInCommon_hash(array1,array2));
        System.out.println(itemInCommon_hash(array1,array3));
    }
}
