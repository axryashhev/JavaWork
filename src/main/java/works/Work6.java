package works;

import Util.Work6.OneWayLinearList;
import Util.Work6.BidirectionalLinearList;
import Util.Work6.Queue;
import Util.Work6.Stack;
import Util.Work6.Tree;
import io.reactivex.rxjava3.core.Observable;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Work6 {
   @NonNull
   OneWayLinearList oneWayLinearList;
   @NonNull BidirectionalLinearList bidirectionalLinearList;
   @NonNull Queue queue;

   @NonNull Stack stack;
   @NonNull Tree tree;

    public Observable<String> partFive() {
        return Observable.create(observer -> {
            int b[] = {10, 25, 20, 6, 21, 8, 1, 30};
            Tree m = new Tree();
            m.first(b[0]);
            for (int i = 1; i < 8; i++)
                m.search_insert(b[i]);
            m.print_tree(m.root);

            m.poisk(-4);
            m.poisk(20);
        });
    }
    public Observable<String> partFour() {
        return Observable.create(observer -> {
            stack.first('a');

            char k;
            for (char i='b';i<'e';i++){
                stack.push(i);
            }

            while (stack.top!=null){
                observer.onNext(" "+ stack.pop());
            }
            observer.onNext("\n\r");

            stack.first('a');
            for (char i='b';i<'e';i++){
                stack.push(i);
            }

            stack.poisk('a');

        });
    }
    public Observable<String> partThree() {
        return Observable.create(observer -> {
            //заполняем список
            queue.first(1.9);
            for (double i=2;i<2.6;i=i+0.1){
                queue.add(i);
            }

            while (queue.pbeg!=null){
                observer.onNext(" "+ queue.pop());
            }
            observer.onNext("\n\r");

            queue.first(1.9);
            for (double i=2;i<2.6;i=i+0.1){
                queue.add(i);
            }

            queue.poisk(2.1);
            queue.poisk(1.8);


            observer.onComplete();
        });
    }
    public Observable<String> partOne() {
        return Observable.create(observer -> {
            //заполняем список
            for (int i = 0; i < 10; i++) {
                oneWayLinearList.addBack(i + 1);
            }

            observer.onNext("List until last element removed: ");
            oneWayLinearList.printList();
            observer.onNext("\n\r");

            oneWayLinearList.delEnd();
            observer.onNext("List after removing last element: ");
            oneWayLinearList.printList();
            observer.onComplete();
        });
    }

    public Observable<String> partTwo() {
        return Observable.create(observer -> {
            //заполняем список
            for (int i=0;i<10;i++){
                bidirectionalLinearList.addBack(i+1);
            }

            observer.onNext("List before rearrangement: ");
            bidirectionalLinearList.printList();
            observer.onNext("\n\r");

            bidirectionalLinearList.p_end_start();

            observer.onNext("List after permutation: ");
            bidirectionalLinearList.printList();

            observer.onComplete();
        });
    }
}

