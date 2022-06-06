package View;

import Singleton.Singleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Work9 {
    JFileChooser fileChooser;
    private JPanel jPanel;
    private JTextArea textArea1;

    public Work9() {
        Singleton singleton = Singleton.getInstance();
        var x = singleton.getX();
        var m1 = singleton.getM1();
        var m2 = singleton.getM2();
        var m3 = singleton.getM3();

        m1.addActionListener(arg0 -> {
            File file = null;
            fileChooser = new JFileChooser();
            int result = fileChooser.showDialog(null, "Open file");
            if (result == JFileChooser.APPROVE_OPTION )
                file = fileChooser.getSelectedFile();
            if(file!=null) {
                if (!file.exists()) {
                    textArea1.setText("file not found!");
                    return;
                }
            }
            else return;
            try {
                textArea1.setText(Files.readString(file.toPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        m2.addActionListener(arg0 -> {
            File file = null;
            fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int result = fileChooser.showDialog(null,"Save as");
            if (result == JFileChooser.APPROVE_OPTION )
                file = fileChooser.getSelectedFile();
            if(file!=null){
                if(!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }}
            else return;
            try {
                Path path = Files.writeString(file.toPath(), textArea1.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        m3.addActionListener(arg0 -> System.exit(0));

    }
    public JPanel getJPanel() {
        return jPanel;
    }
}
