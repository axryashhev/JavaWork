package View;

import example.LabWork1;

import javax.swing.*;

public class Work4_one_part {
    private JPanel jPanel;
    private JButton BtnTab;
    private JButton infinityRowButton;
    private JTextArea textArea1;
    private JScrollPane scrollPane;
    private JTextArea textArea2;

    public Work4_one_part() {
        BtnTab.addActionListener(actionEvent -> LabWork1.printAction(text -> textArea1.setText(textArea1.getText() + text)).partOne());

        infinityRowButton.addActionListener(actionEvent -> LabWork1.printAction(text -> textArea2.setText(textArea2.getText() + text)).partTwo());
    }

    public JPanel getjPanel() {
        return jPanel;
    }
}
