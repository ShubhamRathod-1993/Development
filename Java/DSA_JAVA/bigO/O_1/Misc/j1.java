package bigO.O_1.Misc;

class j1 {
    public static void printItem(int a, int b){
        for (int i=0; i<a; i++){
            System.out.println(i);
        }
        for (int j=0; j<b; j++){
            System.out.println(j);
        }
    }
    public static void main(String[] args) {
        printItem(10,10);
    }
}
 // Different terms of inputs
 // O(a) + O(b)
 // O(a + b)