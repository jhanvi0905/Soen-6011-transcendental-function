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
        double a, b, c, d=0, e, f;
        boolean negate = x < 0;
        if (negate) {
            x = -x;
        }
        if ((x > 1) | (x < -1)) {
            return -1;
        }
        if (x == 1) {
            return negate ? Constants.PI : 0;
        }
        if(x < 1/ Constants.eps){
            return Constants.PI/2;
        }
        a = x < 0.5 ? x*x : (negate ? (1 + x) * 0.5 : (1 - x) * 0.5);
        b = a * (Constants.b0 + a * (Constants.b1 + a * (Constants.b2 + a * (Constants.b3 + a * (Constants.b4 + a * Constants.b5)))));
        c = 1 + a * (Constants.c0 + a * (Constants.c1 + a * (Constants.c2 + a * Constants.c3)));
        if (x < 0.5) {
            d = x - (Constants.PI_L / 2 - x * (b / c));
            return negate ? ((Constants.PI) / 2 + d) : (Constants.PI / 2 - d);
        }
        e = squareRoot(a);
        double g = (a - e * e) / (e + e);
        f = negate ? b / c * e - Constants.PI_L / 2 : b / c * e + g;
        return 2 * (e + f);
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
