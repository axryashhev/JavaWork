package example;

import Interface.PrintIterator;
import works.Work1;

public class LabWork1 {

    private PrintIterator printIterator;

    private LabWork1(PrintIterator printStream) {
        this.printIterator = printStream;
    }

    public static LabWork1 printAction(PrintIterator printIterator) {
        return new LabWork1(printIterator);
    }

    public void partOne() {
        Work1.One work1 = Work1.One.builder().printIterator(printIterator).a(-2.83).b(2.05)
                .from(-2).to(2).dx(0.5).build();

        work1.execute(-2);
    }

    public void partTwo() {
        Work1.Two work2 = Work1.Two.builder().printIterator(printIterator).Xn(Math.PI/10).Xk((9 * Math.PI)/10)
                .dX(0.005 * Math.PI).eps(Math.pow(10, -3)).build();
        work2.execute();
    }
}
