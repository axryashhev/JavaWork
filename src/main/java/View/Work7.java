package View;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import models.Learner;
import models.SchoolChild;
import models.Student;

import javax.swing.*;

public class Work7 {
    private JPanel jPanel;
    private JTextArea textArea1;
    private JButton createLearnersButton;
    private JButton unsubscribeLearnersButton;
    private JButton showMeStudentsButton;
    private JButton showMeSchoolChildButton;
    private Observable<Learner> learnerObservable = null;
    private BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();
    private Disposable disposableStudent = null, disposableSchoolChild = null;

    public Work7() {
        behaviorSubject.subscribe(text -> textArea1.setText(textArea1.getText() + text + "\n\n"));

        createLearnersButton.addActionListener(e -> {
            createLearner();
        });

        unsubscribeLearnersButton.addActionListener(e -> {
            if(disposableStudent != null) {
                behaviorSubject.onNext("unsubscribe Student Data");
                if(!disposableStudent.isDisposed()) {
                    disposableStudent.dispose();
                }
            }

            if(disposableSchoolChild != null) {
                behaviorSubject.onNext("unsubscribe SchoolChild Data");
                if(!disposableSchoolChild.isDisposed()) {
                    disposableSchoolChild.dispose();
                }
            }
        });

        showMeStudentsButton.addActionListener(e -> {
            if(learnerObservable != null) {
               disposableStudent = learnerObservable
                        .filter(learner -> learner instanceof Student)
                        .subscribe(student -> behaviorSubject.onNext(student.toString()));
            }
        });

        showMeSchoolChildButton.addActionListener(e -> {
            if(learnerObservable != null) {
                disposableSchoolChild = learnerObservable
                        .filter(learner -> learner instanceof SchoolChild)
                        .subscribe(schoolChild -> behaviorSubject.onNext(schoolChild.toString()));
            }
        });

    }

    private void createLearner() {
        if(learnerObservable == null) {
            learnerObservable = Observable.fromArray(new SchoolChild(0, "SchoolChild1", "4A"),
                    new SchoolChild(1, "SchoolChild2", "6D"),
                    new SchoolChild(2, "SchoolChild3", "5F"),
                    new SchoolChild(3, "SchoolChild4", "1S"),
                    new Student(0, "Student1", "Faculty1", 2, "PI"),
                    new Student(1, "Student2", "Faculty2", 3, "TA"),
                    new Student(2, "Student3", "Faculty3", 1, "PI"),
                    new Student(3, "Student4", "Faculty4", 4, "AP"));

            behaviorSubject.onNext("Create data");
        }
    }

    public JPanel getJPanel() {
        return jPanel;
    }
}
