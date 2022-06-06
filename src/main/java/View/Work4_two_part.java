package View;

import Util.Convert;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import works.Work2;

import javax.swing.*;
import java.util.*;

public class Work4_two_part {
    private JPanel panel;
    private JButton createArrayButton;
    private JTextArea textArea1;
    private JButton sortArrayAndMergeButton;
    private JTextArea textArea2;
    private JButton bubbleSortButton;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private Disposable mSubscription;

    List<Integer> mas1 = new ArrayList<>();
    List<Integer> mas2 = new ArrayList<>();
    public Work4_two_part() {
        createArrayButton.addActionListener(actionEvent -> {
            mSubscription = Observable.range(0, 10).buffer(2).subscribe(next -> {
                mas1.add(next.get(0));
                mas2.add(next.get(1));
                textArea1.setText(textArea1.getText() + (next.get(0) + " "));
                textArea4.setText(textArea4.getText() + (next.get(1) + " "));
            });
            mSubscription.dispose();
        });

        sortArrayAndMergeButton.addActionListener(actionEvent -> {
            BehaviorSubject<String> subject = BehaviorSubject.create();
            Disposable disposable = subject.subscribe(textArea2::setText);

            Work2 work2 = Work2.printAction(subject::onNext);

            int[] emit1 = Convert.covertListToArrayInteger(mas1);
            int[] emit2 = Convert.covertListToArrayInteger(mas2);
            Work2.One one = work2.workOne(emit1, emit2);
            one.execute();
            disposable.dispose();
        });

        bubbleSortButton.addActionListener(actionEvent -> {
                BehaviorSubject<String> subject = BehaviorSubject.create();
                Disposable disposable = subject.subscribe(textArea3::setText);

                Work2 work2 = Work2.printAction(subject::onNext);

                Work2.Two two = work2.workTwo("REST14342");
                two.execute();
                disposable.dispose();
            });
    }

    public JPanel getJPanel() {
        return panel;
    }
}
