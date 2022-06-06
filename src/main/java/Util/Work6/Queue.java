package Util.Work6;

public class Queue {
    public Item pbeg=null;//��������� �� ������ �������
    public Item pend=null;//��������� �� ����� �������

    public void first(double value){
        Item pv=new Item(value);
        pv.next=null;
        pbeg=pv;
        pend=pbeg;
    }

    //���������� � ����� �������
    public void add(double value){
        Item pv=new Item(value);
        pv.next=null;
        pend.next=pv;
        pend=pv;
    }

    //������� �� ������ ������� � ���������
    public double pop (){
        double temp=pbeg.d;
        pbeg=pbeg.next;
        return temp;
    }

    public void poisk(double a){
        boolean t=false; //�������� ������ �� �������
        while (pbeg!=null){ //���� ������� �� �����
            if (pbeg.d == a) {
                System.out.println("Item " + a + " found!");
                t = true;
                break;
            }
            pbeg = pbeg.next;
        }
        if (!t) System.out.println("Item " + a + " not found!");
    }

    static class Item {
        double d;//����
        Item next;

        //�����������:
        Item(double value){
            d=value;
        }
    }
}

