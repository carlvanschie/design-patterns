package vanschie.command;

import java.util.LinkedList;
import java.util.List;

public class CommandRunner {

    private final List<CommandPattern> queue = new LinkedList<>();

    public void add(CommandPattern commandPattern) {
        queue.add(commandPattern);
    }

    public int pending() {
        return queue.size();
    }

    public void run() {

        while(!queue.isEmpty()) {
            CommandPattern commandPattern = queue.remove(0);
            commandPattern.run();
        }
    }

}
