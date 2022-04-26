package View;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Work4_two_part {
    private JPanel panel;
    private JButton createArrayButton;
    private JButton findHowManyElementsInButton;
    private JButton findHowManyElementsAfterButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextField textField1;

    private final short SIZE = 10;
    List<Double> mas;

    public Work4_two_part() {
        assert false;
        createArrayButton.addActionListener(actionEvent -> {
            mas = Arrays.asList(0.0, 11.0, 25.4, 13.0, 4.0, 52.43, 6.0, -72.0, 61.0, 9.0);
            mas.forEach(item-> textArea1.setText(textArea1.getText() + item + "  "));
        });


    }

    public JPanel getJPanel() {
        return panel;
    }
}
