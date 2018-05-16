package vanschie.behavioral.chainofresponsibility;

import vanschie.behavioral.chainofresponsibility.handler.RequestContentHandler;
import vanschie.behavioral.chainofresponsibility.handler.RequestHeaderHandler;
import vanschie.behavioral.chainofresponsibility.handler.RequestTypeHandler;

public class RequestListener {

    private final RequestHeaderHandler requestHeaderHandler;

    public RequestListener() {
        requestHeaderHandler = new RequestHeaderHandler(new RequestTypeHandler(new RequestContentHandler()));
    }

    public Response accept(Request request) {
        Response response = new Response();
        requestHeaderHandler.handle(request, response);
        return response;
    }
}
