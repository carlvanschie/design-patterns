package vanschie.structural.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private String name;
    private int value;
    private List<SubjectObserver> observers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        this.publish();
    }

    public void subscribe(SubjectObserver subjectObserver) {
        this.observers.add(subjectObserver);
    }

    private void publish() {
        observers.forEach(o -> o.update(this));
    }

    public void unsubscribe(SubjectObserver subjectObserverOne) {
        observers.remove(subjectObserverOne);
    }
}
