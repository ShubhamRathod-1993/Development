package DSA_JAVA.java_files.bigO.O_n;

class j2 {
    public static void printItem(int n){
        for (int i=0; i<n; i++){
            System.out.println(i);
        }
        for (int j=0; j<n; j++){
            System.out.println(j);
        }
    }
    public static void main(String[] args) {
        printItem(10);
    }
}

//The outer loop in the printItem method runs 10 times and the inner loop also runs 10 times. So, total number of
// drop constant 2n so its O(n)