package CosInverse;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
Calculator Acos Class
 */
public class ACosFunction {

    /**
     * Computes SquareRoot of input number.
     * @param b_num number to derive squareRoot.
     * @return squareroot of input number.
     */
    public static double squareRoot(double b_num)
    {
        double l_iterator;
        double sqrt=b_num/2;
        do
        {
            l_iterator=sqrt;
            sqrt=(l_iterator+(b_num/l_iterator))/2;
        }
        while((l_iterator-sqrt)!= 0);
        return sqrt;
    }

    /**
     * Computes Acos Function.
     * @param x number to calculate Acos of.
     * @return Acos value of the input number.
     */
    public static double acos(double x) {
        double negative_number = x<0?1:0;
        x = Math.abs(x);
        double ret = -0.0187293;
        ret = ret * x;
        ret = ret + 0.0742610;
        ret = ret * x;
        ret = ret - 0.2121144;
        ret = ret * x;
        ret = ret + 1.5707288;
        ret = ret * squareRoot(1.0-x);
        ret = ret - 2 * negative_number * ret;
        return negative_number * 3.14159265358979 + ret;
    }

    /**
     * Main function.
     * @param args Null.
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        char inp = 'x';
        while(inp!='e') {
            System.out.println("Output In Radian 1, Output In Degree 2, Exit e");
            inp = input.next().charAt(0);
            if (inp!='e'){
                try {
                    System.out.println("Please enter the value of x (to exit press e): ");
                    double x = input.nextDouble();
                    double result = acos(x);
                    if( inp=='1'){
                        System.out.println("Result in (Radian): " + result);
                    }
                    else{
                        double result_deg = result * 180 / (Constants.PI);
                        System.out.println("Result (In Degree): " + result_deg);
                    }
                } catch(NullPointerException | InputMismatchException c){
                    System.out.println("Invalid Input Format ");
                }
            }
        }
    }

}
