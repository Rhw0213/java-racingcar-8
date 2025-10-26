package racingcar.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InputValidatorTest {
    @ParameterizedTest
    @NullSource
    void 자동차이름들_입력_NULL(final String input) {
        assertThatThrownBy(() -> InputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", ", ", "\n", "\t", "\n ", " \t"})
    void 자동차이름들_입력_빈문자(final String input) {
        assertThatThrownBy(() -> InputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "pobi,roni,jun",
            "pobi,roni,jun,",
            ",pobi,roni,jun",
            "다롱이,개냥이,붕어빵",
            "다롱이,개냥이,붕어빵,",
            ",다롱이,개냥이,붕어빵"
    })
    void 자동차이름들_입력_유효값(final String input) {
        assertDoesNotThrow(() -> InputValidator.validateCarNames(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            // 영문 + 특수문자
            "pobi!", "pobi@crong", "pobi#crong", "pobi$crong",
            "pobi%crong", "pobi&crong", "pobi*crong", "pobi(crong)",
            "pobi.crong", "pobi-crong", "pobi_crong", "pobi+crong",
            "pobi crong", "pobi; crong", "pobi:crong", "pobi'crong",

            // 한글 + 특수문자
            "포비!", "크롱@준", "준#포비", "포비$크롱",
            "포비%크롱", "준&포비", "크롱*준", "포비(크롱)",
            "준.포비", "포비-크롱", "크롱_준", "포비+크롱",
            "포비 크롱", "준; 포비", "크롱:준", "포비'크롱",

            // 영문 + 숫자 + 특수문자
            "pobi123!", "crong456@jun", "jun789#pobi", "pobi1$crong2",
            "test99%demo", "abc123&def", "code789*test", "user1.user2",

            // 한글 + 숫자 + 특수문자
            "포비123!", "크롱456@준", "준789#포비", "포비1$크롱2",
            "포비99%크롱", "준123&포비", "크롱789*준", "포비1.크롱2",

            // 혼합 (영문 + 한글 + 숫자 + 특수문자)
            "pobi포비123!", "crong크롱456@", "jun준789#", "포비pobi1$",
            "포비!크롱,준", "pobi@,crong#,jun", "포비123!,크롱456@",

            // 공백 혼합
            "test 123", "포비 123", "abc 123 def", "포비 123 크롱"
    })
    void 자동차이름들_입력_유효하지않는값(final String input) {
        assertThatThrownBy(() -> InputValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234512"})
    void 라운드횟수_입력_유효값(final String input) {
        assertDoesNotThrow(() -> InputValidator.validateIntCount(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            // 1. 빈 값/공백
            "", "   ", "\t", "\n",

            // 2. 숫자가 아닌 문자
            "abc", "one", "test", "횟수", "포비",

            // 3. 문자 + 숫자 혼합
            "1a", "a1", "1abc", "abc1", "1test1",
            "1포비", "포비1", "12크롱34",

            // 4. 0 이하
            "0", "-1", "-5", "-100", "-999",

            // 5. 소수점
            "1.5", "3.14", "0.5", "10.99",

            // 6. 쉼표 포함
            "1,000", "10,000", "1,234", "999,999",

            // 7. 공백 포함
            " 1", "1 ", " 1 ", "1 2", "1 0",
            "  5", "10  ", "  100  ",

            // 8. 특수문자 포함
            "5!", "10@", "3#", "7$", "9%",
            "1&2", "5*3", "10+5", "20-5",
            "1()", "5[]", "10{}", "3<>",

            // 9. Integer 범위 초과
            "2147483648", "9999999999", "99999999999999",

            // 10. 기타
            "+5", "++5", "--5", "+-5",
            "5.0", "1e10", "0x10", "010"

    })
    void 라운드횟수_입력_유효하지않는값(final String input) {
        assertThatThrownBy(() -> InputValidator.validateIntCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
