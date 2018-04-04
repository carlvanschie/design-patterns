package vanschie.state;

public class NewScanState implements ScanState {

    public static final String NOT_STARTED = "Scan has not been started";

    @Override
    public void start(Scan scan) {
        // Start scan logic
        scan.setState(new RunningScanState());
    }

    @Override
    public void complete(Scan scan) {
        throw new IllegalStateException(NOT_STARTED);
    }

    @Override
    public void pause(Scan scan) {
        throw new IllegalStateException(NOT_STARTED);
    }

    @Override
    public ScanStatus getStatus() {
        return ScanStatus.NEW;
    }
}
