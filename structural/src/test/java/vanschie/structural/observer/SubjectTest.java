package vanschie.structural.observer;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

public class SubjectTest {

    private final Subject subject = new Subject();


    @Test
    public void canBeCreated() {
        subject.setName("Test");
        subject.setValue(2);

        assertThat(subject.getName(), is("Test"));
        assertThat(subject.getValue(), is(2));
    }

    @Test
    public void updatesObservers() {
        SubjectObserver subjectObserverOne = mock(SubjectObserver.class);
        SubjectObserver subjectObserverTwo = mock(SubjectObserver.class);

        subject.subscribe(subjectObserverOne);
        subject.subscribe(subjectObserverTwo);

        subject.setValue(1);

        verify(subjectObserverTwo).update(subject);
        verify(subjectObserverOne).update(subject);
    }

    @Test
    public void removesObserver() {
        SubjectObserver subjectObserverOne = mock(SubjectObserver.class);
        subject.subscribe(subjectObserverOne);

        subject.unsubscribe(subjectObserverOne);
        subject.setValue(1);

        verifyZeroInteractions(subjectObserverOne);
    }
}
