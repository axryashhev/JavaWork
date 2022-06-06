package View;

import Util.Randomize;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import works.Work3;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Work4_three_part {
    private JPanel panel;
    private JButton createMatrixButton;
    private JTextArea textArea1;

    public Work4_three_part() {
        createMatrixButton.addActionListener(actionEvent -> {
            BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();
            Work3 work3 = Work3.printAction(behaviorSubject::onNext);
            Disposable disposable = behaviorSubject.subscribe(next -> {
                textArea1.setText(textArea1.getText() + next + ' ');
            });

            for (int i = 0; i < 3; i++) {
                List<Integer> one = Arrays.stream(Randomize.getRandom(5, 0, 10)).boxed().collect(Collectors.toList());
                work3.setData(one);
            }

            work3.average();
            disposable.dispose();
        });
    }

    public JPanel getJPanel() {
        return panel;
    }
}
