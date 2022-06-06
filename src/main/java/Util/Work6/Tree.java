package Util.Work6;

class Item{
    int d;//����
    Item left;
    Item right;

    //�����������:
    Item(int value){
        d=value;
    }
}

public class Tree{
    public Item root;// ������ ������

    //������������ ������� �������� ������
    public void first(int value){
        Item pv=new Item(value);
        pv.left=null;
        pv.right=null;
        root=pv;
    }

    //����� � ����������
    public void search_insert(int value){
        Item pv=root;
        Item prev=null;
        while(pv!=null){
            prev=pv;
            if (value==-pv.d) return;
            else if (value<pv.d) pv=pv.left;
            else pv=pv.right;
        }

        //�������� ������ ����
        Item pnew=new Item(value);
        pnew.left=null;
        pnew.right=null;
        if (value<prev.d)
            prev.left=pnew;//������������� � ������ ��������� ������
        else
            prev.right=pnew;//������������� � ������� ��������� ������
    }

    //����� ������
    public void print_tree (Item p){
        if (p!=null){
            System.out.println(" "+p.d);
            print_tree (p.left);//����� ������ ���������
            print_tree (p.right);//����� ������� ���������
        }
    }

    public void poisk(int value){
        boolean t = false;//�������� ������ �� �������
        Item pv=root;
        Item prev=null;
        while(pv!=null){
            prev=pv;
            if (value==pv.d){
                System.out.println("Item " + value + " found!");
                return;}
            else if (value<pv.d) pv=pv.left;
            else pv=pv.right;
        }
        if (!t) System.out.println("Item " + value + " found!");
    }
}

