package vanschie.behavioral.chainofresponsibility.handler;

import vanschie.behavioral.chainofresponsibility.Request;
import vanschie.behavioral.chainofresponsibility.Response;

interface RequestHandler {

    void handle(Request request, Response response);

}
