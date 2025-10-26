package racingcar.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RoundSnapshot {
    private final Map<String, Integer> carPositions;

    private RoundSnapshot(final Map<String, Integer> carPositions) {
        this.carPositions = new HashMap<>(carPositions);
    }

    public static RoundSnapshot of(final Map<String, Integer> positions) {
        return new RoundSnapshot(positions);
    }

    public Map<String, Integer> getCarPositions() {
        return Collections.unmodifiableMap(carPositions);
    }
}
