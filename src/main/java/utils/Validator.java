package utils;

import racingcar.domain.setting.EngineSetting;
import racingcar.exception.InvalidNameException;
import racingcar.exception.InvalidNumberException;

import java.util.Arrays;

public class Validator {

    public Validator() {
    }

    public static void validateNames(String[] input) {

        if (hasBlank(input)) {
            throw new InvalidNameException();
        }

        if (hasDuplicate(input)) {
            throw new InvalidNameException(input);
        }

        if (isLengthOver(input)) {
            throw new InvalidNameException();
        }

    }

    public static void validateRepeat(String input) {

        if (!isNumeric(input)) {
            throw new InvalidNumberException(input);
        }

        double number = Double.parseDouble(input);
        if (number != (int) number) {
            throw new InvalidNumberException(input);
        }

        if (number <= 0) {
            throw new InvalidNumberException(input);
        }
    }

    private static boolean hasBlank(String[] names) {

        for (String name : names) {
            if (name.length() == 0 || name.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isLengthOver(String[] names) {

        for (String name : names) {
            if (name.length() > EngineSetting.NAME_MAX_LENGTH) {
                return true;
            }
        }
        return false;
    }


    private static boolean hasDuplicate(String[] names) {
        return Arrays.stream(names)
                .distinct()
                .count() != names.length;
    }

    private static boolean isNumeric(String count) {
        try {
            Integer.parseInt(count);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
