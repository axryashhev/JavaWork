package View;

import Util.Work8.Exc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Work8 {
    private JButton button;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextArea textArea1;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel jPanel;

    public Work8() {
        button3.addActionListener(e -> {
            textArea1.setText("");
            int x;
            int y;
            try {
                x = Integer.parseInt(textField1.getText());
                y = Integer.parseInt(textField2.getText());
            }catch (NullPointerException ex) //исключение, которое выбрасывается каждый раз, когда вы обращаетесь к методу или полю объекта по ссылке, которая равна null
            {
                textArea1.setText("\nОшибка проверьте поля ввода x и y,\nвозможно пустая строчка");
                return;
            }
            catch (NumberFormatException ex) {
                textArea1.setText("\nОшибка проверьте поля ввода x и y,\nвозможно ошибка или это не число");
                return;
            }
            finally {
                textArea1.setText(textArea1.getText()+"\n Сработало finaly в проверки ввода");
            }

            int s;
            try {
                s = x/y;
                textArea1.setText(textArea1.getText()+"\nРезультат деления: "+ s);
            }
            catch (ArithmeticException ex)
            {
                textArea1.setText("\nОшибка деление на 0");
            }
            finally {
                textArea1.setText(textArea1.getText()+"\n Сработало finaly при деление");
            }
        });
        button.addActionListener(e -> {
            textArea1.setText("");
            Exception ex = new ArithmeticException();

            try {
                throw ex; //используется для возбуждения исключения
            }
            catch (Exception exception) {
                textArea1.setText("\nИскусственное генерирование исключения\n" +
                        "Ошибка!\n" + exception);
            }
            finally {
                textArea1.setText(textArea1.getText()+"\n Сработало finally при\n" +
                        "Искусственном генерированом исключение");
            }
        });

        button2.addActionListener(e -> {
            textArea1.setText("");

            try{
                throwOne();
            }catch(IllegalAccessException exception){
                textArea1.setText(textArea1.getText()+"\nОшибка в методе throwOne!");
                textArea1.setText(textArea1.getText() + "\nСлучилась: \n"+exception);
            }
            finally {
                textArea1.setText(textArea1.getText()+"\n Сработало finaly при\n" +
                        "Выбрасывание исключения методом");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                try {
                    throw new Exc();
                }
                catch (Exc ex)
                {
                    textArea1.setText(textArea1.getText() + "\nСлучилось: \n"+ex);
                }
                finally {
                    textArea1.setText(textArea1.getText()+"\n Сработало finaly при\n" +
                            "Личном исключении");
                }
            }
        });
    }

    static void throwOne() throws IllegalAccessException{
        //Ошибка в методе throwOne!
        throw new IllegalAccessException("Ошибка!");
    }


    public JPanel getJPanel() {
        return jPanel;
    }

}
