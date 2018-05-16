package vanschie.behavioral.chainofresponsibility;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class RequestHandlersTest {

    private static final String HEADER = "header";
    private static final String X = "X";
    private static final String CONTENT = "content";
    private static final String Y = "Y";

    private final RequestListener requestListener = new RequestListener();

    @Test
    public void headerIsRepeated() {
        Request request = new Request(HEADER, X, CONTENT);
        Response response = requestListener.accept(request);

        assertThat(response.completed(), is(true));
        assertThat(response.getHeader(), is("header:header"));
    }

    @Test
    public void typeIsKeptTheSame() {
        Request request = new Request(HEADER, X, CONTENT);
        Response response = requestListener.accept(request);

        assertThat(response.completed(), is(true));
        assertThat(response.getType(), is("X"));
    }

    @Test
    public void xTypeMeansEmptyResponse() {
        Request request = new Request(HEADER, X, CONTENT);
        Response response = requestListener.accept(request);

        assertThat(response.getContent(), is(""));
    }

    @Test
    public void yTypeMeansProcessContent() {
        Request request = new Request(HEADER, Y, CONTENT);
        Response response = requestListener.accept(request);

        assertThat(response.getContent(), is("content,content,content,content,content"));
    }

}
