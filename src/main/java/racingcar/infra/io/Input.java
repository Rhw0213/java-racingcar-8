package racingcar.infra.io;

import camp.nextstep.edu.missionutils.Console;

public interface Input {
    static String readLine() {
        return Console.readLine();
    }
}