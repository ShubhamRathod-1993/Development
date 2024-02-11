package DSA_JAVA.java_files.bigO.O_n;

class j1 {

    public static void printItem(int n){
        for (int i=0; i<n; i++){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        printItem(10);
    }
}
// o(n) -- 10 operations with for loop
