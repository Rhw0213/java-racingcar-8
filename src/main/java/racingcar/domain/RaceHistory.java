package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceHistory {
    private final List<RoundSnapshot> raceRecords;

    public RaceHistory() {
        raceRecords = new ArrayList<>();
    }

    public void recordRace(final Cars cars) {
        raceRecords.add(cars.createSnapshot());
    }

    public final List<RoundSnapshot> getRaceRecords() {
        return Collections.unmodifiableList(raceRecords);
    }
}
