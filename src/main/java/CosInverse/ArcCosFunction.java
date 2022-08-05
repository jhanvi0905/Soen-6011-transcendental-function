package CosInverse;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
Calculator Arccos Class
 */
public class ArcCosFunction {

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
     * @param p_parameter number to calculate Acos of.
     * @return Acos value of the input number.
     */
    public double acos(double p_parameter) {
        double negative_number = p_parameter<0?1:0;

        if(p_parameter==1) return 0;
        if(p_parameter==-1) return Constants.PI;
        if(p_parameter< -1 | p_parameter>1) return -1;

        p_parameter = (p_parameter<0) ? p_parameter*-1: p_parameter;
        double l_finalResult = Constants.FIXED_VARIABLE_1;
        l_finalResult = l_finalResult * p_parameter;
        l_finalResult = l_finalResult + Constants.FIXED_VARIABLE_2;
        l_finalResult = l_finalResult * p_parameter;
        l_finalResult = l_finalResult + Constants.FIXED_VARIABLE_3;
        l_finalResult = l_finalResult * p_parameter;
        l_finalResult = l_finalResult + Constants.FIXED_VARIABLE_4;
        l_finalResult = l_finalResult * squareRoot(1.0-p_parameter);
        l_finalResult = l_finalResult - 2 * negative_number * l_finalResult;
        return negative_number * Constants.PI + l_finalResult;
    }

    /**
     * Computes degree value for given radian.
     * @param p_radian_value number.
     * @return degree value.
     */
    public double convert_to_degree(double p_radian_value)
    {
        return p_radian_value * (180/Constants.PI);
    }

    /**
     * Main function.
     * @param args Null.
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArcCosFunction o_ac = new ArcCosFunction();
        char inp = 'x';
        while(inp!='e') {
            System.out.println("Output In Radian 1, Output In Degree 2, Exit e");
            inp = input.next().charAt(0);
            if (inp!='e'){
                try {
                    System.out.println("Please enter the value of x (to exit press e): ");
                    double x = input.nextDouble();
                    double result = o_ac.acos(x);
                    if( inp=='1'){
                        System.out.println("Result in (Radian): " + result);
                    }
                    else{
                        double result_deg = o_ac.convert_to_degree(result);
                        System.out.println("Result (In Degree): " + result_deg);
                    }
                } catch(NullPointerException | InputMismatchException c){
                    System.out.println("Invalid Input Format ");
                }
            }
        }
    }

}
