package racingcar.validator;

public class InputValidator {
    private static final String DELIMITER = ",";
    private static final String VALID_CHARS_PATTERN = "[a-zA-Z가-힣" + DELIMITER + "]+";

    private InputValidator() {
    }

    public static void validateCarNames(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("이름들은 비어있을 수 없습니다.");
        }

        if (hasInvalidCharacters(input)) {
            throw new IllegalArgumentException("문자와 구분자 외에 다른 문자는 넣을 수 없습니다.");
        }
    }

    public static void validateIntCount(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("횟수는 비어있을 수 없습니다.");
        }

        if (input.startsWith("0")) {
            throw new IllegalArgumentException("첫 글자에 0이 들어올수 없습니다.");
        }

        if (input.startsWith("+")) {
            throw new IllegalArgumentException("첫 글자에 +기호가 들어올수 없습니다.");
        }

        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효 숫자가 아닙니다.");
        }
    }

    private static boolean hasInvalidCharacters(final String input) {
        return !input.matches(VALID_CHARS_PATTERN);
    }
}