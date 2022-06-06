package works;

import io.reactivex.rxjava3.subjects.BehaviorSubject;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
@Value
@Builder(toBuilder = true)
public class Work5 {
    @NonNull
    String str;
    @NonNull
    char ch;
    BehaviorSubject<String> subject;

    public void executeOne() {
        subject.onNext("Task 1: \n");
        StringBuilder sb = new StringBuilder();

        int index =  str.lastIndexOf('a');

        for (int i = 0; i < str.length(); i++) {
            if (i == index) {
                sb.append(ch);
            }
            else {
                sb.append(str.charAt(i));
            }
        }

        subject.onNext(sb.toString() + '\n');
    }

    public void executeTwo() {
        subject.onNext("Task 2: \n");
        String[] arr = str.split("[ ,.!?]+");
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            char c = s.charAt(0);
            if ((c == 'a')||(c == 'o') || (c == 'i') || (c == 'u') || (c == 'e')) {
                sb.append(s).append(" ");
            }
        }
        subject.onNext(sb.toString() + '\n');
    }
}


