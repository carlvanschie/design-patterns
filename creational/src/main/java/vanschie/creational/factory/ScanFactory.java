package vanschie.creational.factory;

public class ScanFactory {

    private static final String COMPLEX = "complex";
    private static final String SIMPLE = "simple";

    private ScanFactory() {

    }

    public static Scan createSimpleScan() {
        return new Scan(SIMPLE);
    }

    public static Scan createComplexScan() {
        return new Scan(COMPLEX);
    }
}
