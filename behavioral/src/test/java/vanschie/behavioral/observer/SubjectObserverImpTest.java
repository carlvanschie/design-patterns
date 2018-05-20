package vanschie.behavioral.observer;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SubjectObserverImpTest {

    @Test
    public void isUpdatedWhenSubjectIs() {

        Subject subject = new Subject();

        SubjectObserverImp subjectObserverImp = new SubjectObserverImp(subject);
        subject.setValue(2);

        assertThat(subjectObserverImp.getValue(), is(2));
    }

}
