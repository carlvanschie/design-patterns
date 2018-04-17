package vanschie.proxy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import static vanschie.proxy.ScanState.*;

@RunWith(MockitoJUnitRunner.class)
public class ScanTest {

    private static final String NAME = "name";

    private Scan scan;

    @Mock
    private NastyExpensiveScanRestClient nastyApiClient;

    @Before
    public void setup() {
        scan = new ScanImpProxy(NAME, nastyApiClient);
        when(nastyApiClient.create()).thenReturn(UUID.randomUUID());
    }

    @Test
    public void canCreateScan() {
        assertThat(scan.getName(), is(NAME));
        assertThat(scan.getState(), is(NEW));
        verify(nastyApiClient,  never()).create();
    }

    @Test
    public void canGetExternalServiceId() {
        assertThat(scan.getExternalServiceId(), any(UUID.class));
        verify(nastyApiClient).create();
    }

    @Test
    public void canStartScan() {
        scan.start();

        assertThat(scan.getState(), is(RUNNING));
        verify(nastyApiClient).create();
        verify(nastyApiClient).start();
    }

    @Test
    public void canStopRunningScan() {
        scan.start();
        scan.stop();

        assertThat(scan.getState(), is(STOPPED));
        verify(nastyApiClient).stop();

    }

    @Test(expected = IllegalStateException.class)
    public void cannotStopNewScan() {
        scan.stop();
    }

    @Test
    public void shouldNotMakeApiCallWhenStoppingNewScan() {
        try {
            scan.stop();
        } catch (IllegalStateException e) {
            // gulp
        }

        verify(nastyApiClient,  never()).create();
    }

    @Test
    public void canDeleteRunningScan() {
        scan.start();
        scan.delete();

        assertThat(scan.getState(), is(DELETED));
    }

    @Test
    public void shouldStopScanBeforeDeleting() {
        scan.start();
        scan.delete();

        verify(nastyApiClient).stop();
    }

    @Test
    public void canDeleteStoppedScan() {
        scan.start();
        scan.stop();
        scan.delete();

        assertThat(scan.getState(), is(DELETED));
    }

    @Test
    public void canDeleteNewScan() {
        scan.delete();
        assertThat(scan.getState(), is(DELETED));
    }

    @Test
    public void deletingNewScanDoesNotCreateScanImp() {
        scan.delete();
        verify(nastyApiClient, never()).create();
    }

    @Test
    public void cannotStartDeletedScan() {
        scan.delete();
        try {
            scan.start();
            fail("Should have thrown exception");
        } catch(IllegalStateException e) {
            //Gulp
        }
        assertThat(scan.getState(), is(DELETED));
    }

    @Test
    public void canStartStoppedScan() {
        scan.start();
        scan.stop();
        scan.start();
        assertThat(scan.getState(), is(RUNNING));
    }

    @Test
    public void cannotStopDeletedScan() {
        scan.delete();

        try {
            scan.stop();
            fail("Should have thrown exception");
        } catch(IllegalStateException e) {
            //Gulp
        }

        assertThat(scan.getState(), is(DELETED));

        verify(nastyApiClient, never()).create();
    }

}

