package Scaler_JAVA.beginners;

// https://www.tutorialstonight.com/pattern-program-in-java
public class StarPatternPrograms {

    private static void prob1(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "The square pattern in Java");
        int size = 5;
        System.out.println("Size of pattern : " + size);
        
        // Define the size of the square (or you can take user input).
        // Create a nested loop where the external loop is the number of size and the inner loop is the number of columns.
        // Print the star in each column and print a new line after each row.     
        
        for (int i = 1; i <= size; ++i) {
            for (int j = 1; j <= size; ++j) {
                System.out.print("* ");
            }
            System.out.println();
        }
            
    }

    private static void prob2(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        // Set size of the square (or take user input).
        // Create a nested loop where the external loop executes the number of size.
        // In the internal loop, print star in the first and last row and only at the first and last column.

        for (int i=0; i<size; i++){
            for (int j =0; j< size; j++){
                if (i==0 || i==size-1){
                    System.out.print("*");
                } else {
                    if (j==0 || j==size-1){
                        System.out.print("*");
                    } else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    private static void prob3(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Left triangle star pattern in Java");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        // Take the size of the triangle.
        // Create a nested loop and repeat the outer loop for times equal to the size of the triangle.
        // Repeat the inner loop for times equal to the index of the outer loop and print star (*).
        // Use println to break the line after each row.

        for(int i=0; i<size ; i++){
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void prob4(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Right triangle pattern program in Java");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        // Repeat the external loop to print columns of the triangle.
        // Inside this loop use, 2 different loops first to print spaces and second to print stars.
        // At the end of each row, create a new line.

        for (int i=0; i < size; i++){
            for(int j=1; j< size -i; j++){
                System.out.print(" ");
            }
            for (int k=0; k<=i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void prob5(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Left Down Triangle");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        // Take the size of your triangle.
        // Create an external loop to print size of triangles.
        // Create an inner loop that print star for times equal to size minus the outer loop index.
        
        for (int i=0; i < size; i++){
            for (int j=0; j<size-i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void prob6(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Right Down Triangle");
        int size = 5;
        System.out.println("Size of pattern : " + size);



        for (int i=0; i< size; i++){
            for(int j=0; j<i; j++){
                System.out.print(" ");
            }
            for(int j=size; j>i; j--){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    private static void prob7(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow triangle star pattern in Java");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        // Set a size for the triangle and create an outer loop to print size.
        // Inside the inner loop, if the index of the inner loop is last then print star (*) at first and last index of the inner loop.
        // If it is the last row then print only star
        // Change line after each row.

        for(int i=0; i<=size; i++){
            for(int j=0; j< i; j++){
                // not last row
                if (i!= size){
                    if (j==0 || j==i-1){
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                // last row
                else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }

    }

    private static void prob8(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Pyramid star pattern in Java");
        int size = 5;
        System.out.println("Size of pattern : " + size);


        // Take the size and create an external loop to print all size.
        // Inside the outer loop, we have to create 2 inner loops. First for printing spaces and second for printing stars.
        // print number of spaces equal to size minus the outer loop index in the first inner loop.
        // Inside the second inner loop, print the number of stars equal to 2 times the outer loop index minus 1.
        // A the end of these 2 inner loops create a new line. 
        
        for(int i=0; i< size; i++){
            // print spaces
            for(int j=0; j <size-i-1; j++){
                System.out.print(" ");
            }

            // print stars
            for (int k=0; k < 2*i +1 ; k++){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    private static void prob9(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Reverse pyramid star pattern in Java");
        int size = 5;
        System.out.println("Size of pattern : " + size);



        for(int i=0; i < size ; i++){
            // print spaces
            for(int j=0; j<i;j++){
                System.out.print(" ");
            }
            // print stars
            for(int k=0; k< 2*(size-i)-1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void prob10(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow pyramid pattern program in Java");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        // Set size of the hollow pyramid.
        // Inside the external loop, we have to create 2 inner loops. First for printing spaces and second for printing stars.
        // The first loop print a number of spaces equal to size minus the outer loop index.
        // The second inner loop will run for 2 times the outer loop index plus 1 and print star only at the first and last index of the row.
        // Keep changing line after each row. 
        
        for(int i=0; i < size ; i++){
            // print spaces
            for(int j=0; j < size -i-1; j++){
                System.out.print(" ");
            }
            //print stars
            for(int k=0; k< 2*i+1; k++){
                if(i==0 || i==size-1){
                    System.out.print("*");
                }
                else {
                    if(k==0 || k == 2*i){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
        
    }

    private static void prob11(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Diamond star pattern in Java");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        // upside pyramid
        for(int i=1; i<=size; i++){
            // printing spaces
            for(int j= size; j>i; j--){
                System.out.print(" ");
            }
            // printing star
            for(int k=0; k< i*2-1; k++){
                System.out.print("*");
            }
            System.out.println();
        }

        // downside pyramid
        for(int i=1; i<=size-1; i++){
            // printing spaces
            for(int j=0; j< i; j++){
                System.out.print(" ");
            }
            //printing star
            for(int k=(size-i)*2-1; k> 0; k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void prob12(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow diamond star pattern in Java");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        // upside pyramid
        for(int i=1; i<= size ; i++){
            //printing spaces
            for(int j=size; j > i;j--) {
                System.out.print(" ");
            }
            // printing star
            for(int k=0; k < 2*i-1; k++){
                if (k==0 || k==2*i-2){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        //downside pyramid
        for(int i=1; i < size; i++){
            //printing spaces
            for(int j=0; j< i; j++){
                System.out.print(" ");
            }
            //printing star
            for(int k =(size-i)*2-1; k >=1;k--){
                if (k==1 || k==(size-i)*2-1){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void prob13(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hourglass star pattern in Java");
        int size = 5;
        System.out.println("Size of pattern : " + size);


        // reversed pyramid start pattern
        for(int i=0; i < size; i++){
            // printing spaces
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }

            //printing star
            for(int k=0; k < 2*(size-i) -1; k++){
                System.out.print("*");
            }
            System.out.println();
        }

        // pyramid star pattern
        for(int i=2; i <=size; i++){
            //printing spaces
            for(int j=size; j > i; j--){
                System.out.print(" ");
            }

            //printing star
            for(int k=0; k < 2*i -1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void prob14(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Right pascal star pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        // right pascal triangle
        for (int i=1; i <= size; i++){
            for(int j=0; j< i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=1; i <=size-1; i++){
            for(int j=0; j < size-i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    private static void prob15(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Left pascal star pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        // left pascal triangle
        for(int i=1; i <=size; i++){
            for(int j=0; j < size -i; j++){
                System.out.print(" ");
            }
            for(int k=0; k < i; k++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=1;i <=size -1; i++){
            for(int j=0; j < i; j++){
                System.out.print(" ");
            }
            for(int k=0; k < size-i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void prob16(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Heart pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        // heart star pattern
        for(int i= size/2; i < size;i+=2){
            // print first spaces
            for(int j=1; j < size -i; j+=2){
                System.out.print(" ");
            }
            // print first stars
            for(int j=1; j<i+1; j++){
                System.out.print("*");
            }
            //  print second spaces
            for(int j=1; j <size-i+1; j++){
                System.out.print(" ");
            }
            //print second stars
            for( int j=1; j < i +1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        // lower part
        // inverted pyramid
        for(int i=size; i>0; i--){
            for(int j=0; j < size-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j < i*2; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    private static void prob17(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        for(int i=0; i < size; i++){
            for(int j=0; j < size; j++){
                // print only stars in middle row
                if(i==size/2){
                    System.out.print("*");
                }

                // Other than middle row, print star only at index size/2
                else{
                    if(j==size/2){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    private static void prob18(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Cross pattern program in Java");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(i==j || i+j == size-1){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }

    private static void prob19(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob20(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob21(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob22(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob23(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob24(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob25(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob26(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    public static void main(String[] args) {
        System.out.println("Starting Java Session for Input & Output");
        prob1(1);
        prob2(2);
        prob3(3);
        prob4(4);
        prob5(5);
        prob6(6);
        prob7(7);
        prob8(8);
        prob9(9);
        prob10(10);
        prob11(11);
        prob12(12);
        prob13(13);
        prob14(14);
        prob15(15);
        prob16(16);
        prob17(17);
        prob18(18);
        prob19(19);
        prob20(20);
        prob21(21);
        prob22(22);
        prob23(23);
        prob24(24);
        prob25(25);
        prob26(26);
    }
}


