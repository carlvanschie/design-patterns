package vanschie.creational.singleton;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SingletonTest {

    private static final String FIRST = "FIRST";
    private static final String SECOND = "SECOND";

    @Test
    public void doesCreateSingleton() {

        Singleton singleton = Singleton.get();
        singleton.setValue(FIRST);

        assertThat(singleton.getValue(), is(FIRST));
    }

    @Test
    public void doesCreateOnlyOne() {
        Singleton first = Singleton.get();
        first.setValue(FIRST);
        assertThat(first.getValue(), is(FIRST));

        Singleton second = Singleton.get();
        assertThat(second.getValue(), is(FIRST));
        assertThat(first.getUuid(), is(second.getUuid()));

        second.setValue(SECOND);
        assertThat(first.getValue(), is(SECOND));
        assertThat(second.getValue(), is(SECOND));
        assertThat(first.getUuid(), is(second.getUuid()));

    }

}
