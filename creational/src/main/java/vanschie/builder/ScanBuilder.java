package vanschie.builder;

import java.util.Date;

public class ScanBuilder {

    private String type;
    private Date date;

    public static ScanBuilder aScan() {
        return new ScanBuilder();
    }

    public ScanBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public ScanBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    public Scan build() {
        return new Scan(type, date);
    }
}
