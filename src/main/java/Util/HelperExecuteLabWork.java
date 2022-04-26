package Util;

import Interface.PrintIterator;
import View.Work4_one_part;
import example.LabWork1;
import works.Work2;
import works.Work3;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HelperExecuteLabWork {

    private PrintIterator printIterator;

    private HelperExecuteLabWork(PrintIterator printStream) {
        this.printIterator = printStream;
    }

    public static HelperExecuteLabWork printAction(PrintIterator printStream) {
        return new HelperExecuteLabWork(printStream);
    }

    public void runOne() {
        LabWork1 labWork1 = LabWork1.printAction(printIterator);
        labWork1.partOne();
        labWork1.partTwo();
    }


    public void runTwo() {
        System.out.println("1 Work");
        Work2 work2 = Work2.printAction(System.out::print);

        Work2.One one = work2.workOne(Randomize.getRandom(5, 1, 5),
                Randomize.getRandom(5, 1, 5));
        one.execute();

        System.out.println("\n2 Work");
        Work2.Two two = work2.workTwo("REST14342");
        two.execute();
    }

    public void runThree() {
        List<Integer> one = Arrays.stream(Randomize.getRandom(5, 0, 10)).boxed().collect(Collectors.toList());
        List<Integer> two = Arrays.stream(Randomize.getRandom(5, 0,     10)).boxed().collect(Collectors.toList());
        List<Integer> three = Arrays.stream(Randomize.getRandom(5, 0, 10)).boxed().collect(Collectors.toList());
        Work3 work3 = Work3.printAction(System.out::print);

        work3.setData(one);
        work3.setData(two);
        work3.setData(three);

        work3.average();
    }

    public static void runFour() {
        JPanel panel = new Work4_one_part().getjPanel();
        JFrame frame = new JFrame("App");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,400);
        frame.setVisible(true);
    }
}
