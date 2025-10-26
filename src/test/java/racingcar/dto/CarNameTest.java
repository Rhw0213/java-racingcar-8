package racingcar.dto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "다롱이", "다롱이맛숑", "a"})
    void 자동차이름들_입력_유효값(final String input) {
        assertDoesNotThrow(() -> new CarName(input));
    }

    @ParameterizedTest
    @NullSource
    void 자동차이름들_입력_NULL(final String input) {
        assertThatThrownBy(() -> new CarName(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            // 1. 빈 값/공백
            "", "   ", "\t", "\n", "\n ", " \t", "     ",

            // 2. 특수문자 포함
            "pobi!", "crong@", "jun#", "test$", "car%",
            "name&", "test*", "car()", "name[]", "test{}",
            "pobi.", "crong-", "jun_", "test+", "car=",

            // 3. 한글 + 특수문자
            "포비!", "크롱@", "준#", "자동차$", "이름%",

            // 4. 공백 포함 (중간 공백)
            "po bi", "cr ong", "j un", "포비 크롱", "포 비",

            // 5. 6자 이상 (길이 초과) - 수정!
            "pobiii", "cronggg", "junsik", "testcar", "nameee",
            "포비이이이이", "크롱롱롱롱롱", "자동차이름름", "테스트카카카",
            "이름이길어어", "abcdef", "abcdefg", "포비크롱준준", "verylongname",

            // 6. 쉼표 포함
            "pobi,crong", "jun,", ",test",

            // 7. 이모지
            "pobi😀", "crong🚗",

            // 8. 기타
            ".", "-", "_", "123", "!!!"})
    void 자동차이름들_입력_유효하지않는값(final String input) {
        assertThatThrownBy(() -> new CarName(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
