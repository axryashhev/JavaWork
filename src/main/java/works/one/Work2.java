package works.one;

import lombok.Builder;
import lombok.NonNull;

@Builder
public class Work2 {
    @NonNull
    double eps, Xn, Xk, dX;

    public void execute() {
        System.out.println("   x           s");
        double x=Xn;
        double T,s=0;
        T= Math.sin(x);
        while(x<=Xk) {
            int n = 1;
            while (Math.abs(T) > eps) {
                s += T;
                n += 1;
                T = (Math.sin(2 * n - 1) * x) / (2 * n - 1);
            }
            System.out.println("  "+x);
            x+=dX;
        }

        System.out.println("\nSum = "+s);
    }
}
