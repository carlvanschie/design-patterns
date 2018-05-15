package vanschie.behavioral.visitor;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class VisitorTest {
    private static final String KEY = "k";
    private static final String VALUE = "v";
    private static final String EXPECTED_RESULT = "{\"key\":\""+ KEY +"\",\"value\":\""+ VALUE +"\"}";

    private final TestClass testClass = new TestClass(KEY, VALUE);
    private final JsonVisitor jsonVisitor = new JsonVisitor();

    @Test
    public void shouldReturnJson() throws Exception {
        String result = jsonVisitor.convert(testClass);

        assertThat(result, is(EXPECTED_RESULT));
    }
}
