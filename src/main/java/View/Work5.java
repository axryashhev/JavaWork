package View;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Work5 {
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton executeButton;
    private JPanel panel;

    public Work5() {
        executeButton.addActionListener(e -> {
            String str = textField1.getText();
            char ch = textField2.getText().charAt(0);

            BehaviorSubject<String> behaviorSubject1 = BehaviorSubject.create();
            Disposable disposable1 = behaviorSubject1.subscribe(textArea2::setText);

            BehaviorSubject<String> behaviorSubject2 = BehaviorSubject.create();
            Disposable disposable2 = behaviorSubject2.subscribe(textArea1::setText);


            works.Work5 work5 = works.Work5.builder().ch(ch).str(str).subject(behaviorSubject1).build();
            work5.executeOne();

            var task2 = work5.toBuilder().subject(behaviorSubject2).build();

            task2.executeTwo();

            disposable1.dispose();
            disposable2.dispose();
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
