package ch.zhaw.exercise.le02.task05x2;

import javafx.util.StringConverter;

/**
 * <p>{@link StringConverter} implementation for {@link Integer}
 * (and int primitive) values.</p>
 * @since JavaFX 2.1
 */
public class IntegerStringConverter extends StringConverter<Integer> {
    /** {@inheritDoc} */
    @Override public Integer fromString(String value) {
        // If the specified value is null or zero-length, return null
        if (value == null) {
            return null;
        }

        value = value.trim();

        if (value.length() < 1) {
            return null;
        }

        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    /** {@inheritDoc} */
    @Override public String toString(Integer value) {
        // If the specified value is null, return a zero-length String
        if (value == null) {
            return "";
        }

        return (Integer.toString(value));
    }
}
