package vanschie.behavioral.observer;

public class SubjectObserverImp implements SubjectObserver {

    private int value = 0;

    public SubjectObserverImp(Subject subject) {
        subject.subscribe(this);
    }

    public int getValue() {
        return value;
    }

    public void update(Subject subject) {
        value = subject.getValue();
    }
}
