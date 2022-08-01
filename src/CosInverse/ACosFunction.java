package CosInverse;

import java.util.Scanner;

public class ACosFunction {
    public static double scuareRoot(double b_num)
    {
        double l_iterator;
        double scrt=b_num/2;
        do
        {
            l_iterator=scrt;
            scrt=(l_iterator+(b_num/l_iterator))/2;
        }
        while((l_iterator-scrt)!= 0);
        return scrt;
    }

    public static double acos(double x) {
        double a, b, c, d=0, e, f;
        boolean negative = x < 0;
        if (negative) {
            x = -x;
        }
        if (!(x <= 1)) {
            return -1;
        }
        if (x == 1) {
            return negative ? Constants.PI : 0;
        }
        if(x < 1/ Constants.eps){
            return Constants.PI/2;
        }
        a = x < 0.5 ? x*x : (negative ? (1 + x) * 0.5 : (1 - x) * 0.5);
        b = a * (Constants.b0 + a * (Constants.b1 + a * (Constants.b2 + a * (Constants.b3 + a * (Constants.b4 + a * Constants.b5)))));
        c = 1 + a * (Constants.c0 + a * (Constants.c1 + a * (Constants.c2 + a * Constants.c3)));
        if (x < 0.5) {
            d = x - (Constants.PI_L / 2 - x * (b / c));
            return negative ? ((Constants.PI) / 2 + d) : (Constants.PI / 2 - d);
        }
        e = scuareRoot(a);
        double df = (float) e;
        double g = (a - df * df) / (e + df);
        f = negative ? b / c * e - Constants.PI_L / 2 : b / c * e + g;
        if (negative){
            return 2 * (e + f);
        }
        return 2 * (df + f);
    }

    public static void main(String[] args) {

        Scanner inbut = new Scanner(System.in);
        System.out.println("Please enter the value of x: ");
        double x = inbut.nextDouble();
        double res = acos(x);
        System.out.println("Outbut :"+ res);
    }

}
