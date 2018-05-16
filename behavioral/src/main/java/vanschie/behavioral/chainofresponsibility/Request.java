package vanschie.behavioral.chainofresponsibility;

public final class Request {

    private final String header;
    private final String type;
    private final String content;

    public Request(String header, String type, String content) {
        this.header = header;
        this.type = type;
        this.content = content;
    }

    public String getHeader() {
        return header;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
