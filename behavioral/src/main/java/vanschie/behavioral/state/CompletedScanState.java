package vanschie.behavioral.state;

public class CompletedScanState implements ScanState {

    @Override
    public void start(Scan scan) {
        throw new IllegalStateException("Cannot start completed scan");
    }

    @Override
    public void complete(Scan scan) {
        //Nothing to be done.
    }

    @Override
    public void pause(Scan scan) {
        throw new IllegalStateException("Cannot pause completed scan");
    }

    @Override
    public ScanStatus getStatus() {
        return ScanStatus.COMPLETED;
    }
}
