package vanschie.behavioral.command;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.UUID.randomUUID;

public class CommandPatternImplTwo implements CommandPattern {

    private static final Logger LOG = Logger.getLogger(CommandPatternImplTwo.class.getName());

    @Override
    public void run() {
        LOG.log(Level.INFO, "RUNNING: {0}", randomUUID());
    }

    @Override
    public boolean isComplete() {
        return false;
    }
}
