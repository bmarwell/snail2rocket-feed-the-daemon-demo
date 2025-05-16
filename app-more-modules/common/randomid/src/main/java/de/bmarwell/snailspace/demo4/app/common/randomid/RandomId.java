package de.bmarwell.snailspace.demo4.app.common.randomid;

import java.util.Base64;
import java.util.Locale;
import java.util.random.RandomGenerator;

public class RandomId {

    private final String value;

    public RandomId() {
        byte[] bb = new byte[64];
        RandomGenerator.getDefault().nextBytes(bb);
        this.value = Base64.getEncoder().encodeToString(bb).toLowerCase(Locale.ROOT);
    }

    public static RandomId randomId() {
        return new RandomId();
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public final boolean equals(Object other) {
        if (!(other instanceof RandomId randomId)) {
            return false;
        }

        return getValue().equals(randomId.getValue());
    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }

    @Override
    public String toString() {
        return this.value;
    }
}
