package vanschie.behavioral.command;

import java.util.UUID;

public class CommandPatternImpl implements CommandPattern {

    private boolean complete = false;

    @Override
    public void run() {
        System.out.println("RUNNING:" + UUID.randomUUID() + " - " + CommandPatternImpl.class.getName());
        complete = true;
    }


    @Override
    public boolean isComplete() {
        return complete;
    }

}
