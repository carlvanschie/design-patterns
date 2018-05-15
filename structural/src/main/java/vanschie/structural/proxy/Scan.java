package vanschie.structural.proxy;

import java.util.UUID;

public interface Scan {

    String getName();

    ScanState getState();

    UUID getExternalServiceId();

    void start();

    void stop();

    void delete();
}
