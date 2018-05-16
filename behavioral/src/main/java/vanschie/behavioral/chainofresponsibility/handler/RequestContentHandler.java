package vanschie.behavioral.chainofresponsibility.handler;

import vanschie.behavioral.chainofresponsibility.Request;
import vanschie.behavioral.chainofresponsibility.Response;

public class RequestContentHandler implements RequestHandler {

    private static final int NUMBER_OF_DUPLICATES = 5;

    @Override
    public void handle(final Request request, final Response response) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < NUMBER_OF_DUPLICATES; i++) {
            builder.append(request.getContent()).append(",");
        }
        response.setContent(builder.toString().substring(0, builder.length() - 1));
    }
}
