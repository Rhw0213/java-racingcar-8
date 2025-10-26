package racingcar.util.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    public static List<String> parseCarNames(final String input, final String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    public static int parseTryCount(final String count) {
        return Integer.parseInt(count);
    }
}
