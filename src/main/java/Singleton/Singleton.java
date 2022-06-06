package Singleton;

import javax.swing.*;

public class Singleton {
    private JMenuBar mb = new JMenuBar();;
    private JMenu x= new JMenu("Menu");;
    private JMenuItem m1= new JMenuItem("Open..."),
            m2= new JMenuItem("Save as..."),
            m3= new JMenuItem("Exit");
    private static volatile Singleton instance;

    public static Singleton getInstance() {
        Singleton localInstance = instance;
        if (localInstance == null) {
            synchronized (Singleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Singleton();
                }
            }
        }
        return localInstance;
    }

    public JMenuItem getM3() {
        return m3;
    }

    public void setM3(JMenuItem m3) {
        this.m3 = m3;
    }

    public JMenuItem getM2() {
        return m2;
    }

    public void setM2(JMenuItem m2) {
        this.m2 = m2;
    }

    public JMenuItem getM1() {
        return m1;
    }

    public void setM1(JMenuItem m1) {
        this.m1 = m1;
    }

    public JMenu getX() {
        return x;
    }

    public void setX(JMenu x) {
        this.x = x;
    }

    public JMenuBar getMb() {
        return mb;
    }

    public void setMb(JMenuBar mb) {
        this.mb = mb;
    }
}
