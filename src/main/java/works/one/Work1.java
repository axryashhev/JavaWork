package works.one;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.lang.Math;

@Value
@Builder
public class Work1 {
    @NonNull
    double a, b, from, to, dx;

    public double f(double x) {
//        System.out.println("a-x: " + (a-x));
//        System.out.println("b: " + b);
//        System.out.println("x: " + x);
        if(a-x>b) {
            if(x > 0) return f1(x);

            if(x < 0) return f3(x);
        }
        else if (a-x<b)  return f2(x);

        throw new ArithmeticException("Unknown");
    }

    public double f1(double x) {
//        System.out.println("f1");
        return 2.805 * Math.log(Math.pow(x, 4) - (2 * a));
    }

    public double f2(double x) {
//        System.out.println("f2");
        return Math.sqrt(Math.pow(a, 2) * Math.pow(b, 3) - 4) + x;
    }

    public double f3(double x) {
//        System.out.println("f3");
        return Math.cos(Math.abs((2 * a) / (b * x))) + 3.7;
    }

    public void execute(double x) {
        while (x<=to) {
            System.out.println("| " + x + "\t\t| " + f(x) + "\n");
            x+=dx;
        }
    }
}
