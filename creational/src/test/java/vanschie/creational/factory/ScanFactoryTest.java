package vanschie.creational.factory;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ScanFactoryTest {

    @Test
    public void canCreateSimpleScan() {
        Scan simpleScan = ScanFactory.createSimpleScan();
        assertThat(simpleScan.getType(), is("simple"));
    }

    @Test
    public void canCreateComplexScan() {
        Scan complexScan = ScanFactory.createComplexScan();
        assertThat(complexScan.getType(), is("complex"));
    }

}
