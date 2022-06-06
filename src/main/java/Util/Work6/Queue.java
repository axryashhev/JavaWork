package Util.Work6;

public class Queue {
    public Item pbeg=null;//указатель на начало очереди
    public Item pend=null;//указатель на конец очереди

    public void first(double value){
        Item pv=new Item(value);
        pv.next=null;
        pbeg=pv;
        pend=pbeg;
    }

    //ƒобавление в конец очереди
    public void add(double value){
        Item pv=new Item(value);
        pv.next=null;
        pend.next=pv;
        pend=pv;
    }

    //¬ыборка из начала очереди с удалением
    public double pop (){
        double temp=pbeg.d;
        pbeg=pbeg.next;
        return temp;
    }

    public void poisk(double a){
        boolean t=false; //проверка найден ли элемент
        while (pbeg!=null){ //пока очередь не пуста
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
        double d;//ключ
        Item next;

        //конструктор:
        Item(double value){
            d=value;
        }
    }
}

