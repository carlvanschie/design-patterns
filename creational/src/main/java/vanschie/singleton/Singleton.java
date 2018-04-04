package vanschie.singleton;

import java.util.UUID;

class Singleton {

    private static Singleton singleton;
    private final UUID uuid = UUID.randomUUID();
    private String value;

    private Singleton() {

    }

    static Singleton get() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    UUID getUuid() {
        return uuid;
    }

    String getValue() {
        return value;
    }

    void setValue(String value) {
        this.value = value;
    }
}
