package ch.zhaw.exercise.le02.task05;

import javafx.util.StringConverter;

public class DoubleStringConverter extends StringConverter<Double> {

    @Override
    public String toString(Double object) {
        return object == null ? "" : object.toString();
    }

    @Override
    public Double fromString(String string) {
        if (string == null || string.isEmpty()) {
            return null;
        } else {
            try {
                double val = Double.parseDouble(string);
                return val < 0 ? null : val;
            } catch (NumberFormatException ex) {
                return null;
            }
        }
    }
}
