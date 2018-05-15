package vanschie.creational.structural.proxy;

import java.util.UUID;

public class ScanImpProxy implements Scan {

    private final String name;
    private final NastyExpensiveScanRestClient nastyApiClient;

    private ScanImp scan;

    private ScanState scanState;


    public ScanImpProxy(String name, NastyExpensiveScanRestClient nastyApiClient) {
        this.name = name;
        this.nastyApiClient = nastyApiClient;
        this.scanState = ScanState.NEW;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public UUID getExternalServiceId() {
        createScanIfNull();
        return scan.getExternalServiceId();
    }


    @Override
    public ScanState getState() {
        if(scan == null) {
            return scanState;
        }
        return scan.getState();
    }

    @Override
    public void start() {
        if(scanState == ScanState.DELETED) {
            throw new IllegalStateException();
        }
        createScanIfNull();
        scan.start();
    }

    @Override
    public void stop() {
        if(scan == null) {
            throw new IllegalStateException();
        }
        scan.stop();
    }

    @Override
    public void delete() {
        if(scan != null) {
            scan.delete();
        }
        scanState = ScanState.DELETED;
        scan = null; // Remove pointer here as no longer in use.
    }

    private void createScanIfNull() {
        if (scan == null) {
            scan = new ScanImp(name, nastyApiClient);
        }
    }

}
