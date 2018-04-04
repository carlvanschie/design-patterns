package vanschie.state;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static vanschie.state.ScanStatus.COMPLETED;
import static vanschie.state.ScanStatus.PAUSED;
import static vanschie.state.ScanStatus.RUNNING;

public class ScanTest {

    private final Scan scan = new Scan("TEST");


    @Test
    public void stateDefaultsToNew() {
        assertThat(scan.getStatus(), is(ScanStatus.NEW));
    }

    @Test
    public void canBeStarted() {
        scan.start();
        assertThat(scan.getStatus(), is(RUNNING));
    }

    @Test(expected = IllegalStateException.class)
    public void cannotBeCompletedFromNew() {
        scan.complete();
    }

    @Test
    public void canBeCompleted() {
        scan.start();
        scan.complete();
        assertThat(scan.getStatus(), is(COMPLETED));
    }

    @Test(expected = IllegalStateException.class)
    public void cannotBeStartedOnceCompleted() {
        scan.start();
        scan.complete();
        scan.start();
    }

    @Test
    public void canBePausedWhenRunning() {
        scan.start();
        scan.pause();
        assertThat(scan.getStatus(), is(PAUSED));
    }

    @Test
    public void canBeStartedWhenPaused() {
        scan.start();
        scan.pause();
        scan.start();
        assertThat(scan.getStatus(), is(RUNNING));
    }

    @Test
    public void canBeCompletedWhenPaused() {
        scan.start();
        scan.pause();
        scan.complete();
        assertThat(scan.getStatus(), is(COMPLETED));
    }

    @Test(expected = IllegalStateException.class)
    public void cannotBePausedWhenCompleted() {
        scan.start();
        scan.complete();
        scan.pause();
    }


    @Test(expected = IllegalStateException.class)
    public void cannotBePausedFromNew() {
        scan.pause();
    }

}
