package works;

import Interface.PrintIterator;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.lang.Math;

public class Work1 {

    @Value
    @Builder(toBuilder = true)
    public static class One {
        @NonNull
        double a, b, from, to, dx;

        PrintIterator printIterator;

        public double f(double x) {
            if(a-x>b) {
                if(x > 0) return f1(x);

                if(x < 0) return f3(x);
            }

            if (a-x<b)  return f2(x);

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
            if(x == 0)
                throw new ArithmeticException("Div by zero");

            return Math.cos(Math.abs((2 * a) / (b * x))) + 3.7;
        }

        public void execute(double x) {
            printIterator.print("   x           f(x)\n");
            while (x<=to) {
                printIterator.print("| " + x + "\t\t| " + f(x) + "\n");
                x+=dx;
            }
        }
    }

    @Builder
    public static class Two {
        @NonNull
        double eps, Xn, Xk, dX;

        @NonNull
        PrintIterator printIterator;

        public void execute() {
            double x=Xn;
            double T,s=0;
            T= Math.sin(x);
            printIterator.print("   x: ");
            while(x<=Xk) {
                int n = 1;
                while (Math.abs(T) > eps) {
                    s += T;
                    n += 1;
                    T = (Math.sin(2 * n - 1) * x) / (2 * n - 1);
                }
//                printIterator.print("  " + s + ' ');
                printIterator.print("  " + x + '\n');
                x+=dX;
            }

            printIterator.print("\nSum = "+s);
        }
    }
}
