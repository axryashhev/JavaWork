package Util.Work6;

public class BidirectionalLinearList {

    private Item head; // ��������� �� ������ �������
    private Item tail; // ��������� �� ��������� �������

    public void addBack(int data) { //���������� � ����� ������
        Item a = new Item(); //������ ����� �������
        a.data = data;
        if (tail == null) //���� ������ ����
        { //�� ��������� ������ ������ � ����� �� ����� �������
            head = a; //�.�. ������ ������ ������� �� ������ ��������
            tail = a;
        }
        else {
            tail.next = a; //����� "������" ��������� ������� ������ ��������� �� �����
            a.prev = tail; //� � ��������� �� ��������� ������� ���������� ����� ������ ��������
            tail = a;
        }
    }

    public void printList() //������ ������
    {
        Item t = head; //�������� ������ �� ������ �������
        while (t != null) //���� ������� ����������
        {
            System.out.print(t.data + " "); //�������� ��� ������
            t = t.next; //� ������������� �� ���������
        }
    }

    public void delEl(int data) //�������� ��������
    {
        if(head == null) //���� ������ ���� -
            return; //������ �� ������
        if (head == tail) { //���� ������ ������� �� ������ ��������
            head = null; //������� ��������� ������ � �����
            tail = null;
            return; //� �������
        }
        if (head.data == data) { //���� ������ ������� - ���, ��� ��� �����
            head = head.next; //����������� ��������� ������ �� ������ �������
            return; //� �������
        }
        Item t = head; //����� �������� ������
        while (t.next != null) { //���� ��������� ������� ����������
            if (t.next.data == data) { //��������� ��������� �������
                if(tail == t.next) //���� �� ���������
                {
                    tail = t; //�� ����������� ��������� �� ��������� ������� �� �������
                }
                t.next = t.next.next; //��������� ������� ����������
                return; //� �������
            }
            t = t.next; //����� ���� ������
        }
    }

    public void delEnd()
    {
        if (head == tail) { //���� ������ ������� �� ������ ��������
            head = null; //������� ��������� ������ � �����
            tail = null;
            return; //� �������
        }

        Item t = head;
        while (t!=null) {
            if(tail == t.next) //���� ��������� ������� ���������
            {
                tail = t; //�� ����������� ��������� � ���������� ������� �� �������
                t.next = t.next.next; //���������� ��������� �������
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
        Item next; // ��������� �� ���������
        Item prev; // ��������� �� ���������� �������
        int data; // ���� ������ ���� int
    }
}

