package Util.Work6;

class ListElement {
    ListElement next; // указатель на следующий элемент
    int data; // поле данных типа int
}
public class OneWayLinearList {

    private ListElement head; // указатель на первый элемент
    private ListElement tail; // указатель на последний элемент

    public void addFront(int data) //добавить спереди
    {
        ListElement a = new ListElement(); //создаём новый элемент
        a.data = data; //инициализируем данные.

        // указатель на следующий элемент автоматически инициализируется как null
        if (head == null) //если список пуст
        { //то указываем ссылки начала и конца на новый элемент
            head = a; //т.е. список теперь состоит из одного элемента
            tail = a;
        } else {
            a.next = head; //иначе новый элемент теперь ссылается на "бывший" первый
            head = a; //а указатель на первый элемент теперь ссылается на новый элемент
        }
    }

    public void addBack(int data) { //добавление в конец списка
        ListElement a = new ListElement(); //создаём новый элемент
        a.data = data;
        if (tail == null) //если список пуст
        { //то указываем ссылки начала и конца на новый элемент
            head = a; //т.е. список теперь состоит из одного элемента
            tail = a;
        } else {
            tail.next = a; //иначе "старый" последний элемент теперь ссылается на новый
            tail = a; //а в указатель на последний элемент записываем адрес нового элемента
        }
    }

    public void printList() //печать списка
    {
        ListElement t = head; //получаем ссылку на первый элемент
        while (t != null) //пока элемент существует
        {
            System.out.print(t.data + " "); //печатаем его данные
            t = t.next; //и переключаемся на следующий
        }
    }

    public void delEl(int data) //удаление элемента
    {
        if (head == null) //если список пуст -
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
        ListElement t = head; //иначе начинаем искать
        while (t.next != null) { //пока следующий элемент существует
            if (t.next.data == data) { //проверяем следующий элемент
                if (tail == t.next) //если он последний
                {
                    tail = t; //то переключаем указатель на последний элемент на текущий
                }
                t.next = t.next.next; //найденный элемент выкидываем
                return; //и выходим
            }
            t = t.next; //иначе ищем дальше
        }
    }

    public void delEnd() {
        if (head == tail) { //если список состоит из одного элемента
            head = null; //очищаем указатели начала и конца
            tail = null;
            return; //и выходим
        }

        ListElement t = head;
        while (t != null) {
            if (tail == t.next) //если следующий элемент последний
            {
                tail = t; //то переключаем указатель с последнего элемент на текущий
                t.next = t.next.next; //выкидываем последний элемент
                return;
            }
            t = t.next;
        }
    }
}
