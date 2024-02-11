package Scaler_JAVA.beginners;

public class NumberPatternProgram {

    private static void prob1(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Left triangle number pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        // loop to print the pattern
        for(int i=0; i < size; i ++){
            //print columns
            for(int j=0; j <=i; j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
    }

    private static void prob2(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Right triangle number pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        // loop to print the pattern
        for(int i=0; i <size; i++){
            //print spaces
            for(int j=1; j < size-i; j++){
                System.out.print(" ");
            }

            // print number
            for(int k=0; k <=i; k++){
                System.out.print(k+1);
            }

            System.out.println();
        }
    }

    private static void prob3(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Number pyramid pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        for(int i=0; i < size; i++){
            //print spaces
            for(int j=0;j< size-i;j++){
                System.out.print(" ");
            }

            // print number
            for(int k=0; k <2*i+1; k++){
                System.out.print(k+1);
            }
            System.out.println();
        }
    }

    private static void prob4(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Number pyramid reverse pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        for(int i=0; i < size; i++){
            //print space
            for(int j=0; j < i; j++){
                System.out.print(" ");
            }

            // print number
            for(int k=0; k<2*(size-i)-1; k++){
                System.out.print(k+1);
            }

            System.out.println();
            
        }
    }

    private static void prob5(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow number pyramid pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        for(int i=0; i < size; i++){
            // print spaces before each line
            for(int j=0; j < size-i -1; j++){
                System.out.print(" ");
            }
            // print numbers after each line
            int num=1;
            for(int k=0; k < 2*i+1; k++){
                if(i==0 || i == size-1){
                    System.out.print(num++);
                } else{
                    if(k==0 || k==2*i){
                        System.out.print(num++);
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    private static void prob6(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Number diamond pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        int num =1;

        //upside pyramid
        for(int i=1; i<=size ; i++){
            //printing spaces
            for(int j=size; j>i; j--){
                System.out.print(" ");
            }
            //printing number
            for(int k=0; k < 2*i -1; k++){
                System.out.print(num++);
            }

            //set the number to 1
            num=1;
            System.out.println();
        }
        // down pyramid
        for(int i=1; i <=size-1; i++){
            // printing spaces
            for(int j=0; j<i; j++){
                System.out.print(" ");
            }
            // printing number
            for(int k=(size-i)*2-1; k>0; k--){
                System.out.print(num++);
            }
            // set the num to 1
            num=1;
            System.out.println();
        }
    }

    private static void prob7(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow number diamond pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);

        int num=1;

        // upside pyramid
        for(int i=1; i <=size; i++){
            // printing spaces
            for(int j=size; j>i; j--){
                System.out.print(" ");
            }
            //printing number
            for(int k=0; k< i*2-1;k++){
                if(k==0 || k==2*i-2){
                    System.out.print(num++);
                } else {
                    System.out.print(" ");
                }
            }
            // set the number to 1
            num=1;
            System.out.println();
        }

        // downside pyramid
        for(int i=1; i < size; i++){
            // print leading space
            for(int j=0; j<i; j++){
                System.out.print(" ");
            }
            // print trailing number
            for(int k=(size-i)*2-1; k >=1;k--){
                if(k==1 || k==(size-i)*2-1){
                    System.out.print(num++);
                } else {
                    System.out.print(" ");
                }
            }
            // set the number to 1
            num=1;
            System.out.println();
        }
    }

    private static void prob8(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob9(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob10(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob11(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob12(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob13(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }
    
    private static void prob14(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob15(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob16(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob17(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
    }

    private static void prob18(int  problemNo){
        System.out.println("Problem No : " + problemNo);
        System.out.println("Pattern name : "+ "Hollow square pattern");
        int size = 5;
        System.out.println("Size of pattern : " + size);
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

    public static void main(String[] args) {
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
    }
}
