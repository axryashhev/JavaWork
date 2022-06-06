package works;

import Interface.PrintIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

class ItemList {
    private int id;
    private int value;

    ItemList(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }
}

public class Work3 {

    private final PrintIterator printIterator;

    private Work3(PrintIterator printStream) {
        this.printIterator = printStream;
    }

    public static Work3 printAction(PrintIterator printStream) {
        return new Work3(printStream);
    }

    List<List<ItemList>> data = new ArrayList<>();
    private int num = 0;
    private double avg = 0.0;
    private int count = 0;

    public void setData(List<Integer> list) {
        printIterator.print("Set data: ");
        list.forEach(result -> printIterator.print(result + " "));
        printIterator.print("\n");
        this.data.add(this.convertList(list));
    }

    private List<ItemList> convertList(List<Integer> list) {
        List<ItemList> itemLists = new ArrayList<>();
        list.forEach(item -> {
            itemLists.add(new ItemList(num++, item));
        });
        return itemLists;
    }

    public void average() {
        Supplier<Stream<ItemList>> supplier = () -> data.stream().flatMap(List::stream).filter(item -> item.getValue() % 10 == 3);
        printIterator.print("In even rows: ");
        filterAndShowStream(supplier, list -> list.getId() / 2 == 0);

        printIterator.print("\n");
        printIterator.print("In odd rows: ");
        filterAndShowStream(supplier, list -> list.getId() / 2 != 0);
    }

    private void filterAndShowStream(Supplier<Stream<ItemList>> supplier, Predicate<ItemList> var1) {
        supplier.get().filter(var1).forEach(result -> {
            avg += result.getValue();
            count++;
            printIterator.print("{ " + result.getId() + ": " + result.getValue() + " }, ");
        });
        double result = avg/count;
        if(Double.isNaN(result))
            result = 0;

        printIterator.print("\nAvg: " + result + '\n');
        avg = 0.0;
        count = 0;
    }
}
