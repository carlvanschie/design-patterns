package vanschie.behavioral.state;

public interface ScanState {

    void start(Scan scan);

    void complete(Scan scan);

    void pause(Scan scan);

    ScanStatus getStatus();
}
