package works;

import Interface.PrintIterator;
import Util.UtilArray;

import java.io.Serializable;
import java.util.Arrays;

public class Work2 {
    private final PrintIterator printIterator;
    private Work2(PrintIterator printStream) {
        this.printIterator = printStream;
    }
    public static Work2 printAction(PrintIterator printStream) {
        return new Work2(printStream);
    }
    public One workOne(int[] a, int[] b) {
        return new One(a, b);
    }
    public Two workTwo(String text) {
        return new Two(text);
    }
    public class One {
        private final int[] a;
        private final int[] b;
        public One(int[] a, int[] b) {
            this.a = a;
            this.b = b;
        }
        public void execute() {
            printIterator.print("Begin: \n" +
                    "a = " + Arrays.toString(a) + '\n' +
                    "b = " + Arrays.toString(b) + '\n');

            UtilArray.barrierElement(a, 4);
            UtilArray.insertionSort(b);

            printIterator.print("Sort array: \n" +
                    "b = " + Arrays.toString(b) + '\n');

            final int findItem = Arrays.binarySearch(b, 4);
            final Serializable textFindItem = findItem < 0 ? "undenfided" : findItem;

            printIterator.print("First: " + UtilArray.barrierElement(a, 4) + '\n');
            printIterator.print("Second: " +  textFindItem + '\n');

            printIterator.print("Unique: " + Arrays.toString(unionListUnique(a, b)) + '\n');
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

    public class Two {
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
            printIterator.print(Arrays.toString(mas));
        }
    }
}
