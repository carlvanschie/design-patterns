package vanschie.behavioral.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CommandRunnerTest {

    private final CommandRunner commandRunner = new CommandRunner();

    @Mock
    private CommandPatternImpl commandPatternImpl;

    @Mock
    private CommandPatternImplTwo commandPatternImplTwo;


    @Test
    public void canBeGivenSomeThingToRun() {
        commandRunner.add(commandPatternImpl);
        assertThat(commandRunner.pending(), is(1));
    }

    @Test
    public void canRunElement() {
        commandRunner.add(commandPatternImpl);
        commandRunner.run();

        Mockito.verify(commandPatternImpl).run();
    }

    @Test
    public void canRunTheSameElementMoreThanOnce() {
        commandRunner.add(commandPatternImpl);
        commandRunner.add(commandPatternImpl);
        commandRunner.run();

        Mockito.verify(commandPatternImpl, Mockito.times(2)).run();
    }

    @Test
    public void canRunMultipleElements() {
        commandRunner.add(commandPatternImpl);
        commandRunner.add(commandPatternImplTwo);
        commandRunner.add(commandPatternImpl);
        commandRunner.run();

        Mockito.verify(commandPatternImpl, Mockito.times(2)).run();
        Mockito.verify(commandPatternImplTwo).run();
    }

    @Test
    public void removesElementsOnceRun() {
        commandRunner.add(commandPatternImpl);
        assertThat(commandRunner.pending(), is(1));

        commandRunner.run();
        assertThat(commandRunner.pending(), is(0));
    }

}
