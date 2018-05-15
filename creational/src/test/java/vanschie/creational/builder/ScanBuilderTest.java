package vanschie.creational.builder;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScanBuilderTest {

    private static final String TYPE = "Type";
    private static final Date DATE = new Date();

    @Test
    public void canCreateScan() {

        Scan scan = ScanBuilder.aScan().withType(TYPE).withDate(DATE).build();

        assertThat(scan.getType(), is(TYPE));
        assertThat(scan.getDate(), is(DATE));
    }
}
