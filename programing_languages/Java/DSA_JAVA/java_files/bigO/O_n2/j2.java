package DSA_JAVA.java_files.bigO.O_n2;

class j2 {
    public static void printItem(int n){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.println(i + " " + j);
            }
        }

        for (int k =0; k<n; k++){
            System.out.println(k);
        }
    }
    public static void main(String[] args) {
        printItem(10);
    }
}

// o(n^2) + o(n) = o(n2+n)
//so the n2 is dominent term and n is non dominent so drop n & then the time complexity is O(n^2)