import works.two.Work2;

public class Main {
    public static void main(String[] args) {
        System.out.println("|\tx\t|\tf(x)");
//        Work1 work1 = Work1.builder().a(-2.83).b(2.05)
//                .from(-2).to(2).dx(0.5).build();
//
//        work1.execute(-2);

//        Work2 work2 = Work2.builder().Xn(Math.PI/10).Xk((9 * Math.PI)/10)
//                .dX(0.005 * Math.PI).eps(Math.pow(10, -3)).build();
//        work2.execute();

//        Work2.Two two = new Work2.Two("test123");
//        two.execute();

        Work2.One one = new Work2.One(
                Work2.One.getRandom(5, 1, 5),
                Work2.One.getRandom(5, 1, 5));
        one.execute();
    }
}
