package vanschie.structural.proxy;

import java.util.UUID;

/*
 * Place holder that could have some nasty time consuming API calls or DB calls
 * ect which would take a while to deliver, hence only creating one when really needed. (PROXY)
 */
public class NastyExpensiveScanRestClient {

    public UUID create() {
        return UUID.randomUUID();
    }


    public void stop() {
        // Empty due to being an example class
    }

    public void start() {
        // Empty due to being an example class
    }

    public void delete() {
        // Empty due to being an example class
    }
}
