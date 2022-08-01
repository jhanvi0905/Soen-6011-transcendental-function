package CosInverse;

import java.util.Scanner;

public class ACosFunction {
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

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String inp = "";
        while(!inp.equalsIgnoreCase("e")) {
            System.out.println("Please enter the value of x (to exit press e): ");
            inp = input.next();
            if (!inp.equalsIgnoreCase("e")){
                try {
                    double x = Double.parseDouble(inp);
                    double result = acos(x);
                    System.out.println("Output :" + result);
                } catch(NullPointerException | NumberFormatException c){
                    System.out.println("Invalid Input Format ");
                }
            }
        }
    }

}
