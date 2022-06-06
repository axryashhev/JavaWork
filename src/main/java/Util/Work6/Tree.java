package Util.Work6;

class Item{
    int d;//ключ
    Item left;
    Item right;

    //конструктор:
    Item(int value){
        d=value;
    }
}

public class Tree{
    public Item root;// корень дерева

    //формирование первого элемента дерева
    public void first(int value){
        Item pv=new Item(value);
        pv.left=null;
        pv.right=null;
        root=pv;
    }

    //поиск с включением
    public void search_insert(int value){
        Item pv=root;
        Item prev=null;
        while(pv!=null){
            prev=pv;
            if (value==-pv.d) return;
            else if (value<pv.d) pv=pv.left;
            else pv=pv.right;
        }

        //Создание нового узла
        Item pnew=new Item(value);
        pnew.left=null;
        pnew.right=null;
        if (value<prev.d)
            prev.left=pnew;//присоединение к левому поддереву предка
        else
            prev.right=pnew;//присоединение к правому поддереву предка
    }

    //Обход дерева
    public void print_tree (Item p){
        if (p!=null){
            System.out.println(" "+p.d);
            print_tree (p.left);//вывод левого поддерева
            print_tree (p.right);//вывод правого поддерева
        }
    }

    public void poisk(int value){
        boolean t = false;//проверка найден ли элемент
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

