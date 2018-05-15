package vanschie.creational.prototype;

abstract class BaseClass implements Cloneable {

    @Override
    public BaseClass clone() throws CloneNotSupportedException {
        return (BaseClass) super.clone();
    }

}
