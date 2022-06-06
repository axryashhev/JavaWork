package Util.Work6;

public class BidirectionalLinearList {

    private Item head; // указатель на первый элемент
    private Item tail; // указатель на последний элемент

    public void addBack(int data) { //добавление в конец списка
        Item a = new Item(); //создаём новый элемент
        a.data = data;
        if (tail == null) //если список пуст
        { //то указываем ссылки начала и конца на новый элемент
            head = a; //т.е. список теперь состоит из одного элемента
            tail = a;
        }
        else {
            tail.next = a; //иначе "старый" последний элемент теперь ссылается на новый
            a.prev = tail; //а в указатель на последний элемент записываем адрес нового элемента
            tail = a;
        }
    }

    public void printList() //печать списка
    {
        Item t = head; //получаем ссылку на первый элемент
        while (t != null) //пока элемент существует
        {
            System.out.print(t.data + " "); //печатаем его данные
            t = t.next; //и переключаемся на следующий
        }
    }

    public void delEl(int data) //удаление элемента
    {
        if(head == null) //если список пуст -
            return; //ничего не делаем
        if (head == tail) { //если список состоит из одного элемента
            head = null; //очищаем указатели начала и конца
            tail = null;
            return; //и выходим
        }
        if (head.data == data) { //если первый элемент - тот, что нам нужен
            head = head.next; //переключаем указатель начала на второй элемент
            return; //и выходим
        }
        Item t = head; //иначе начинаем искать
        while (t.next != null) { //пока следующий элемент существует
            if (t.next.data == data) { //проверяем следующий элемент
                if(tail == t.next) //если он последний
                {
                    tail = t; //то переключаем указатель на последний элемент на текущий
                }
                t.next = t.next.next; //найденный элемент выкидываем
                return; //и выходим
            }
            t = t.next; //иначе ищем дальше
        }
    }

    public void delEnd()
    {
        if (head == tail) { //если список состоит из одного элемента
            head = null; //очищаем указатели начала и конца
            tail = null;
            return; //и выходим
        }

        Item t = head;
        while (t!=null) {
            if(tail == t.next) //если следующий элемент последний
            {
                tail = t; //то переключаем указатель с последнего элемент на текущий
                t.next = t.next.next; //выкидываем последний элемент
                return;
            }
            t = t.next;
        }
    }

    public void p_end_start() {
        int a = tail.data;
        int b= head.data;
        head.data = a;
        tail.data = b;
    }

    static class Item {
        Item next; // указатель на следующий
        Item prev; // указатель на предыдущий элемент
        int data; // поле данных типа int
    }
}

