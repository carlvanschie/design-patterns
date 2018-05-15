package vanschie.creational.prototype;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrototypeClassTest {

    private PrototypeClass prototypeClass;
    private PrototypeClass clone;

    @Before
    public void setup() throws Exception {
        prototypeClass = new PrototypeClass(1, 2, 3);
        clone = prototypeClass.clone();
    }

    @Test
    public void canCreate() throws Exception {
        assertThat(prototypeClass.getOne(), is(1L));
        assertThat(prototypeClass.getTwo(), is(2L));
        assertThat(prototypeClass.getThree(), is(3L));
    }

    @Test
    public void canClone() throws Exception {

        assertThat(clone.getOne(), is(1L));
        assertThat(clone.getTwo(), is(2L));
        assertThat(clone.getThree(), is(3L));
    }

    @Test
    public void canCloneAClone() throws Exception {
        PrototypeClass clonedClone = clone.clone();

        assertThat(clonedClone.getOne(), is(1L));
        assertThat(clonedClone.getTwo(), is(2L));
        assertThat(clonedClone.getThree(), is(3L));
    }

}
