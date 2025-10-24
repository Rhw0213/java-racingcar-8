package racingcar.infra.random;

import camp.nextstep.edu.missionutils.Randoms;

public class DefaultRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public int generator(final int begin, final int end) {
        return Randoms.pickNumberInRange(begin, end);
    }
}