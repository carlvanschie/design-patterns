package vanschie.behavioral.state;

public class PausedScanState implements ScanState {

    @Override
    public void start(Scan scan) {
        scan.setState(new RunningScanState());
    }

    @Override
    public void complete(Scan scan) {
        scan.setState(new CompletedScanState());
    }

    @Override
    public void pause(Scan scan) {
        // Empty due to being an example class
    }

    @Override
    public ScanStatus getStatus() {
        return ScanStatus.PAUSED;
    }
}
