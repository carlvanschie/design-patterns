package vanschie.command;

import java.util.UUID;

public class CommandPatternImplTwo implements CommandPattern {

    @Override
    public void run() {
        System.out.println("RUNNING:" + UUID.randomUUID() + " - " + CommandPatternImpl.class.getName());
    }

    @Override
    public boolean isComplete() {
        return false;
    }
}
