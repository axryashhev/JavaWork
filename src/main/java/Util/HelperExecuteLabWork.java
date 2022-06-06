package Util;

import Interface.PrintIterator;
import Singleton.Singleton;
import Util.Work6.*;
import View.*;
import example.LabWork1;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import works.Work5;
import works.*;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HelperExecuteLabWork {

    private PrintIterator printIterator;

    private HelperExecuteLabWork(PrintIterator printStream) {
        this.printIterator = printStream;
    }

    public static HelperExecuteLabWork printAction(PrintIterator printStream) {
        return new HelperExecuteLabWork(printStream);
    }

    public static void runSeven() {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Work7().getJPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,300);
        frame.setVisible(true);
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
        Disposable subscribe = Observable.just(
                        new Work4_one_part().getjPanel(),
                        new Work4_two_part().getJPanel(),
                        new Work4_three_part().getJPanel())
                .unsubscribeOn(Schedulers.io())
                .subscribe(next -> {
                    JFrame frame = new JFrame("App");
                    frame.setContentPane(next);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setSize(600,400);
                    frame.setVisible(true);
                });
        subscribe.dispose();
    }

    public static void runFive() {
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();
        Disposable disposable = behaviorSubject.subscribe(System.out::println);

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char ch = scanner.next().charAt(0);

        Work5 work5 = Work5.builder().ch(ch).str(str).subject(behaviorSubject).build();
        work5.executeOne();
        work5.executeTwo();

        disposable.dispose();

        JFrame frame = new JFrame("App");
        frame.setContentPane(new View.Work5().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,400);
        frame.setVisible(true);
    }

    public static void runSix() {
        Work6 work = Work6.builder()
                .oneWayLinearList(new OneWayLinearList())
                .bidirectionalLinearList(new BidirectionalLinearList())
                .queue(new Queue())
                .stack(new Stack())
                .tree(new Tree())
                .build();

        work.partOne().subscribe(System.out::print);

        work.partTwo().subscribe(System.out::print);

        work.partThree().subscribe(System.out::print);

        work.partFour().subscribe(System.out::print);

        work.partFive().subscribe(System.out::print);
    }

    public static void runEight() {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Work8().getJPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600,300);
        frame.setVisible(true);
    }

    public static void runNine() {
        Singleton singleton = Singleton.getInstance();
        var x = singleton.getX();
        var m1 = singleton.getM1();
        var m2 = singleton.getM2();
        var m3 = singleton.getM3();
        var mb = singleton.getMb();
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Work9().getJPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        x.add(m1);
        x.add(m2);
        x.add(m3);
        mb.add(x);
        frame.setJMenuBar(mb);
        frame.setSize(500, 500);
        frame.setVisible(true);

        ThreadWork9.runOne();
        ThreadWork9.runTwo();
    }
}
