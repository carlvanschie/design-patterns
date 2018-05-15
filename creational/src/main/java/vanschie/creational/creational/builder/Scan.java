package vanschie.creational.creational.builder;

import java.util.Date;

public class Scan {

    private final Date date;
    private final String type;

    Scan(String type, Date date) {
        this.type = type;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }
}
