package Util.Work6;

public class Stack {
    public Item top=null;//��������� �� ������� �����

    public void first(char value){
        Item pv=new Item(value);
        pv.next=null;
        top=pv;
    }

    //��������� � ����
    public void push(char value){
        Item pv=new Item(value);
        pv.next=top;
        top=pv;
    }

    //������� �� �����
    public char pop (){
        char temp=top.d;
        top=top.next;
        return temp;
    }

    public void poisk(char a){
        boolean t=false; //�������� ������ �� �������
        while (top!=null){
            if (top.d == a) {
                System.out.println("Item " + a + " found!");
                t = true;
                break;
            }
            top = top.next;
        }
        if (!t) System.out.println("Item " + a + " not found!");
    }

    static class Item{
        char d;//����
        Item next;

        //�����������:
        Item(char value){
            d=value;
        }
    }
}

