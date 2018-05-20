package vanschie.structural.observer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class SubjectTest {

    private final Subject subject = new Subject();

    @Mock
    private SubjectObserver subjectObserverOne;

    @Mock
    private SubjectObserver subjectObserverTwo;

    @Before
    public void setUp() {
        subject.setName("Test");
        subject.setValue(2);

        subject.subscribe(subjectObserverOne);
        subject.subscribe(subjectObserverTwo);

    }

    @Test
    public void canBeCreated() {
        assertThat(subject.getName(), is("Test"));
        assertThat(subject.getValue(), is(2));
    }

    @Test
    public void updatesObservers() {
        subject.setValue(1);

        verify(subjectObserverTwo).update(subject);
        verify(subjectObserverOne).update(subject);
    }

    @Test
    public void removesObserver() {
        subject.unsubscribe(subjectObserverOne);
        subject.setValue(1);

        verifyZeroInteractions(subjectObserverOne);
    }
}
