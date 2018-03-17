package vanschie.state;

public class RunningScanState implements ScanState {

    @Override
    public void start(Scan scan) {
        //Nothing to be done.
    }

    @Override
    public void complete(Scan scan) {
        scan.setState(new CompletedScanState());
    }

    @Override
    public void pause(Scan scan) {
        scan.setState(new PausedScanState());
    }

    @Override
    public ScanStatus getStatus() {
        return ScanStatus.RUNNING;
    }
}
