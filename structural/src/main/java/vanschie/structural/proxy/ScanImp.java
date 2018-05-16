package vanschie.structural.proxy;

import java.util.UUID;


public class ScanImp implements Scan {

    private final String name;
    private final UUID externalServiceId;
    private final NastyExpensiveScanRestClient nastyApiClient;

    private ScanState state;

    ScanImp(String name, NastyExpensiveScanRestClient nastyApiClient) {
        this.name = name;
        this.nastyApiClient = nastyApiClient;
        this.state = ScanState.NEW;

        // This would/should do something expensive DB write for Id, call external service for ect...
        this.externalServiceId = nastyApiClient.create();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ScanState getState() {
        return state;
    }


    @Override
    public UUID getExternalServiceId() {
        return externalServiceId;
    }

    @Override
    public void start() {
        // Some external service call here....
        state = ScanState.RUNNING;
        nastyApiClient.start();
    }

    @Override
    public void stop() {
        // Some external service call here...
        state = ScanState.STOPPED;
        nastyApiClient.stop();
    }

    @Override
    public void delete() {
        if (state == ScanState.RUNNING) {
            stop();
        }

        // Some external service call here...
        state = ScanState.DELETED;
        nastyApiClient.delete();
    }
}
