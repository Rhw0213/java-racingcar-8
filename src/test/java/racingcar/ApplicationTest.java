package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("여러 라운드에서 라운드 사이 빈 줄(개행) 포함하여 출력")
    void 다중라운드_라운드사이개행() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "3");
                    String out = output();

                    assertThat(out).contains("pobi : ");
                    assertThat(out).contains("woni : ");
                    assertThat(out).contains("jun : ");

                    assertThat(out).contains("\n\n");

                    assertThat(out).contains("최종 우승자 : ");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("동점 우승자 여러 명일 때 \", \"로 연결하여 출력")
    void 동점우승자_콤마공백_연결() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output())
                            .contains("최종 우승자 : pobi, jun"); // 예시: pobi와 jun 동점
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("아무도 이동하지 않으면 모든 참가자가 우승자")
    void 전원정지_모두우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "2");
                    assertThat(output())
                            .contains("pobi : ")
                            .contains("woni : ")
                            .contains("jun : ")
                            .contains("최종 우승자 : pobi, woni, jun");
                },
                // 모두 STOP만 나오도록
                STOP, STOP, STOP,
                STOP, STOP, STOP
        );
    }

    @Test
    @DisplayName("이름 길이가 5자를 초과하면 예외 발생")
    void 이름길이제한_예외() {
        // 우테코 규칙: 이름 5자 초과 시 예외 (메시지는 구현체 기준으로 맞추세요)
        assertThatThrownBy(() -> run("pobi,woniisTooLong", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 이름이나 공백만 있는 이름이 있으면 예외 발생")
    void 빈이름_예외() {
        assertThatThrownBy(() -> run("pobi,,woni", "1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> run("   ,pobi", "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 0 또는 음수면 예외 발생")
    void 시도횟수_0_음수_예외() {
        assertThatThrownBy(() -> run("pobi,woni", "0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> run("pobi,woni", "-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외 발생")
    void 시도횟수_비숫자_예외() {
        assertThatThrownBy(() -> run("pobi,woni", "one"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> run("pobi,woni", "1.5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("출력 형식: 이름, 공백, 콜론, 공백, 대시 반복")
    void 출력형식_정확성() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output())
                            .contains("pobi : -")
                            .contains("woni : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("우승자 표시 앞에 라벨과 콜론/공백 포함")
    void 우승자라벨_형식() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output())
                            .contains("최종 우승자 : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
