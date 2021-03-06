package vanschie.behavioral.chainofresponsibility.handler;

import vanschie.behavioral.chainofresponsibility.Request;
import vanschie.behavioral.chainofresponsibility.Response;

public class RequestTypeHandler implements RequestHandler {

    private static final String X = "X";

    private final RequestHandler requestHandler;

    public RequestTypeHandler(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    @Override
    public void handle(final Request request, final Response response) {
        String type = request.getType();
        response.setType(type);

        if (X.equalsIgnoreCase(type)) {
            return;
        }

        requestHandler.handle(request, response);
    }
}
