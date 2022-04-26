package Util;

import lombok.NonNull;

public class UtilArray {

    public static int barrierElement(int @NonNull[] arr, int value) {
        final int size = arr.length;
        if (size != 0) {
            int last = arr[size - 1];//Сохраним прежний элемент массива
            arr[size - 1] = value;//Гарантируем, что value есть в массиве
            //Есть гарантия того, что элемент есть в массиве, значит индекс можно не проверять
            int i = 0;
            for (i = 0; arr[i] != value; ++i) {//Одно условие в цикле
            }
            arr[size - 1] = last;//Восстанавливаем последний элемент
            if (i != (size - 1) || value == last) {//Не уткнулись в барьер или последний элемент был искомым
                return i;
            }
        }
        return -1;
    }

    public static void insertionSort(int @NonNull [] arrayPtr) // сортировка вставками
    {
        int temp;// временная переменная для хранения значения элемента сортируемого массива
                // индекс предыдущего элемента
        int item;
        for (int counter = 1; counter < arrayPtr.length; counter++)
        {
            temp = arrayPtr[counter]; // инициализируем временную переменную текущим значением элемента массива
            item = counter-1; // запоминаем индекс предыдущего элемента массива
            while(item >= 0 && arrayPtr[item] > temp) // пока индекс не равен 0 и предыдущий элемент массива больше текущего
            {
                arrayPtr[item + 1] = arrayPtr[item]; // перестановка элементов массива
                arrayPtr[item] = temp;
                item--;
            }
        }
    }
}
