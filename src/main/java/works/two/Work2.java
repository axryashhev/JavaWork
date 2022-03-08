package works.two;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

public class Work2 {

    public static class One {
        private static final Random rand = new Random();
        private final int[] a;
        private final int[] b;

        public One(int[] a, int[] b) {
            this.a = a;
            this.b = b;
        }

        public static int[] getRandom(int size, int origin, int bound) {
            return rand.ints(size, origin, bound).toArray();
        }

        public void execute() {
//            final int[] a = getRandom(5, 1, 5);
//            final int[] b = getRandom(5, 1, 5);

            System.out.println("Begin: \n" +
                    "a = " + Arrays.toString(a) + '\n' +
                    "b = " + Arrays.toString(b) + '\n');

            Arrays.sort(a);
            final int[] c = Arrays.stream(b).filter(i -> Arrays.binarySearch(b, i) < 0).toArray();

            System.out.println(Arrays.toString(a));
            System.out.println(Arrays.toString(b));
            System.out.println(Arrays.toString(c));

            System.out.println("Unique: " + Arrays.toString(unionListUnique(a, c)));
        }

        private int[] unionListUnique(int[] a, int[] c) {
            int[] arr = unionList(a,c);
            return Arrays.stream(arr).distinct().toArray();
        }

        private int[] unionList(int[] a, int[] b) {
            int[]c = new int[a.length+b.length];
            int count = 0;
            for(int i = 0; i<a.length; i++) {
                c[i] = a[i];
                count++;
            }
            for(int j = 0;j<b.length;j++) {
                c[count++] = b[j];
            }
            return c;
        }
    }

    public static class Two {
        private String word;

        public Two(String word) {
            this.word = word;
        }

        public void execute() {
            char[] mas = word.toCharArray();
            boolean isSorted = false;
            char buf;
            while(!isSorted) {
                isSorted = true;
                for (int i = 0; i < word.length()-1; i++) {
                    if(mas[i] > mas[i+1]){
                        isSorted = false;

                        buf = mas[i];
                        mas[i] = mas[i+1];
                        mas[i+1] = buf;
                    }
                }
            }
            System.out.println(Arrays.toString(mas));
        }
    }
}
