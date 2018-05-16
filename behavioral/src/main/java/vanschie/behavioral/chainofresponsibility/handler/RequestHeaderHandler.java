package vanschie.behavioral.chainofresponsibility.handler;

import vanschie.behavioral.chainofresponsibility.Request;
import vanschie.behavioral.chainofresponsibility.Response;

public class RequestHeaderHandler implements RequestHandler {

    private RequestHandler requestHandler;

    public RequestHeaderHandler(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void handle(final Request request, final Response response) {
        response.setHeader(request.getHeader() + ":" + request.getHeader());
        requestHandler.handle(request, response);
    }
}
