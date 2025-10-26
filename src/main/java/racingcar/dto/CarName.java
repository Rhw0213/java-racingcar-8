package racingcar.dto;

public record CarName(String name) {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String VALID_CHARS_PATTERN = "[a-zA-Z가-힣]+";

    public CarName {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }

        if (!name.matches(VALID_CHARS_PATTERN)) {
            throw new IllegalArgumentException("문자외엔 다른문자가 들어올 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    name + "이름은 " + MAX_NAME_LENGTH + "자를 넘을 수 없습니다.");
        }
    }
}
