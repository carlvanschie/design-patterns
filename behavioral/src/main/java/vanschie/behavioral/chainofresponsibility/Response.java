package vanschie.behavioral.chainofresponsibility;

public class Response {

    private String header;
    private String type;
    private String content = "";

    public Response() {
    }

    public String getHeader() {
        return header;
    }

    public boolean completed() {
        return true;
    }

    public String getType() {
        return type;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
