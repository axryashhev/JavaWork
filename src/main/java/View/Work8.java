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
            }catch (NullPointerException ex) //����������, ������� ������������� ������ ���, ����� �� ����������� � ������ ��� ���� ������� �� ������, ������� ����� null
            {
                textArea1.setText("\n������ ��������� ���� ����� x � y,\n�������� ������ �������");
                return;
            }
            catch (NumberFormatException ex) {
                textArea1.setText("\n������ ��������� ���� ����� x � y,\n�������� ������ ��� ��� �� �����");
                return;
            }
            finally {
                textArea1.setText(textArea1.getText()+"\n ��������� finaly � �������� �����");
            }

            int s;
            try {
                s = x/y;
                textArea1.setText(textArea1.getText()+"\n��������� �������: "+ s);
            }
            catch (ArithmeticException ex)
            {
                textArea1.setText("\n������ ������� �� 0");
            }
            finally {
                textArea1.setText(textArea1.getText()+"\n ��������� finaly ��� �������");
            }
        });
        button.addActionListener(e -> {
            textArea1.setText("");
            Exception ex = new ArithmeticException();

            try {
                throw ex; //������������ ��� ����������� ����������
            }
            catch (Exception exception) {
                textArea1.setText("\n������������� ������������� ����������\n" +
                        "������!\n" + exception);
            }
            finally {
                textArea1.setText(textArea1.getText()+"\n ��������� finally ���\n" +
                        "������������� ������������� ����������");
            }
        });

        button2.addActionListener(e -> {
            textArea1.setText("");

            try{
                throwOne();
            }catch(IllegalAccessException exception){
                textArea1.setText(textArea1.getText()+"\n������ � ������ throwOne!");
                textArea1.setText(textArea1.getText() + "\n���������: \n"+exception);
            }
            finally {
                textArea1.setText(textArea1.getText()+"\n ��������� finaly ���\n" +
                        "������������ ���������� �������");
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
                    textArea1.setText(textArea1.getText() + "\n���������: \n"+ex);
                }
                finally {
                    textArea1.setText(textArea1.getText()+"\n ��������� finaly ���\n" +
                            "������ ����������");
                }
            }
        });
    }

    static void throwOne() throws IllegalAccessException{
        //������ � ������ throwOne!
        throw new IllegalAccessException("������!");
    }


    public JPanel getJPanel() {
        return jPanel;
    }

}
