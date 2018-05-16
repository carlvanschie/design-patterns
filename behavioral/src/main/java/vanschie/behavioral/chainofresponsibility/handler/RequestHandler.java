package vanschie.behavioral.chainofresponsibility.handler;

import vanschie.behavioral.chainofresponsibility.Request;
import vanschie.behavioral.chainofresponsibility.Response;

interface RequestHandler {

    void handle(final Request request, final Response response);

}
