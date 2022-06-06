package Util.Work6;

public class Stack {
    public Item top=null;//указатель на вершину стека

    public void first(char value){
        Item pv=new Item(value);
        pv.next=null;
        top=pv;
    }

    //Занесение в стек
    public void push(char value){
        Item pv=new Item(value);
        pv.next=top;
        top=pv;
    }

    //Выборка из стека
    public char pop (){
        char temp=top.d;
        top=top.next;
        return temp;
    }

    public void poisk(char a){
        boolean t=false; //проверка найден ли элемент
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
        char d;//ключ
        Item next;

        //конструктор:
        Item(char value){
            d=value;
        }
    }
}

