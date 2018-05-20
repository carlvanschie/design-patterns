package vanschie.behavioral.state;

public class Scan {

    private final String name;
    private ScanState scanState;


    Scan(String name) {
        this.name = name;
        this.scanState = new NewScanState();
    }

    public String getName() {
        return name;
    }

    public ScanStatus getStatus() {
        return scanState.getStatus();
    }

    protected void setState(ScanState scanState) {
        this.scanState = scanState;
    }

    public void start() {
        scanState.start(this);
    }

    public void complete() {
        scanState.complete(this);
    }

    public void pause() {
        scanState.pause(this);
    }
}
