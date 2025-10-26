package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundSnapshotTest {
    @Test
    void of_메서드로_생성() {
        Map<String, Integer> positions = new HashMap<>();
        positions.put("pobi", 3);
        positions.put("jun", 1);

        RoundSnapshot snapshot = RoundSnapshot.of(positions);

        assertThat(snapshot.getCarPositions()).hasSize(2);
        assertThat(snapshot.getCarPositions().get("pobi")).isEqualTo(3);
        assertThat(snapshot.getCarPositions().get("jun")).isEqualTo(1);
    }
}
