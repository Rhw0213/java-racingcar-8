package racingcar.view;

import racingcar.infra.io.Input;

public class InputView implements Input {
    private final static String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String TRY_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";

    public static String readCarName() {
        System.out.println(CAR_NAMES_PROMPT);
        return Input.readLine();
    }

    public static String readTryCount() {
        System.out.println(TRY_COUNT_PROMPT);
        return Input.readLine();
    }
}
