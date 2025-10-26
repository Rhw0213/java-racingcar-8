package racingcar.infra.random;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {
    public static final int GENERATE_START_NUMBER = 0;
    public static final int GENERATE_END_NUMBER = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(GENERATE_START_NUMBER, GENERATE_END_NUMBER);
    }
}