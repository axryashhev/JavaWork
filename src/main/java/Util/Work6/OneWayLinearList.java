package Util.Work6;

class ListElement {
    ListElement next; // ��������� �� ��������� �������
    int data; // ���� ������ ���� int
}
public class OneWayLinearList {

    private ListElement head; // ��������� �� ������ �������
    private ListElement tail; // ��������� �� ��������� �������

    public void addFront(int data) //�������� �������
    {
        ListElement a = new ListElement(); //������ ����� �������
        a.data = data; //�������������� ������.

        // ��������� �� ��������� ������� ������������� ���������������� ��� null
        if (head == null) //���� ������ ����
        { //�� ��������� ������ ������ � ����� �� ����� �������
            head = a; //�.�. ������ ������ ������� �� ������ ��������
            tail = a;
        } else {
            a.next = head; //����� ����� ������� ������ ��������� �� "������" ������
            head = a; //� ��������� �� ������ ������� ������ ��������� �� ����� �������
        }
    }

    public void addBack(int data) { //���������� � ����� ������
        ListElement a = new ListElement(); //������ ����� �������
        a.data = data;
        if (tail == null) //���� ������ ����
        { //�� ��������� ������ ������ � ����� �� ����� �������
            head = a; //�.�. ������ ������ ������� �� ������ ��������
            tail = a;
        } else {
            tail.next = a; //����� "������" ��������� ������� ������ ��������� �� �����
            tail = a; //� � ��������� �� ��������� ������� ���������� ����� ������ ��������
        }
    }

    public void printList() //������ ������
    {
        ListElement t = head; //�������� ������ �� ������ �������
        while (t != null) //���� ������� ����������
        {
            System.out.print(t.data + " "); //�������� ��� ������
            t = t.next; //� ������������� �� ���������
        }
    }

    public void delEl(int data) //�������� ��������
    {
        if (head == null) //���� ������ ���� -
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
        ListElement t = head; //����� �������� ������
        while (t.next != null) { //���� ��������� ������� ����������
            if (t.next.data == data) { //��������� ��������� �������
                if (tail == t.next) //���� �� ���������
                {
                    tail = t; //�� ����������� ��������� �� ��������� ������� �� �������
                }
                t.next = t.next.next; //��������� ������� ����������
                return; //� �������
            }
            t = t.next; //����� ���� ������
        }
    }

    public void delEnd() {
        if (head == tail) { //���� ������ ������� �� ������ ��������
            head = null; //������� ��������� ������ � �����
            tail = null;
            return; //� �������
        }

        ListElement t = head;
        while (t != null) {
            if (tail == t.next) //���� ��������� ������� ���������
            {
                tail = t; //�� ����������� ��������� � ���������� ������� �� �������
                t.next = t.next.next; //���������� ��������� �������
                return;
            }
            t = t.next;
        }
    }
}
