package vanschie.behavioral.command;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.UUID.randomUUID;

public class CommandPatternImpl implements CommandPattern {

    private static final Logger LOG = Logger.getLogger(CommandPatternImpl.class.getName());

    private boolean complete = false;

    @Override
    public void run() {
        LOG.log(Level.INFO, "RUNNING: {0}", randomUUID());
        complete = true;
    }


    @Override
    public boolean isComplete() {
        return complete;
    }

}
