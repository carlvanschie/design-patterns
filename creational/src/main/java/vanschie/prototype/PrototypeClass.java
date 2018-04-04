package vanschie.prototype;

public class PrototypeClass extends BaseClass {

    private final long one;
    private final long two;
    private final long three;

    public PrototypeClass(long one, long two, long three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    @Override
    public PrototypeClass clone() throws CloneNotSupportedException {
        return (PrototypeClass) super.clone();
    }

    public long getOne() {
        return one;
    }

    public long getTwo() {
        return two;
    }

    public long getThree() {
        return three;
    }
}
