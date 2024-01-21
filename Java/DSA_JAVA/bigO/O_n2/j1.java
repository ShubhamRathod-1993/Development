package bigO.O_n2;

class j1 {

    public static void printItem(int n){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.println(i + " " + j);
            }
        }
    }
    public static void main(String[] args) {
        printItem(10);
    }
}

// loop within loop so time complexity is O(n^2)
