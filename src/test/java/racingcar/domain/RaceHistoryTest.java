package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceHistoryTest {
    @Test
    void 라운드_기록_저장() {
        Cars cars = new Cars();

        cars.register(new Car("pobi"));
        cars.register(new Car("woni"));

        RaceHistory raceHistory = new RaceHistory();
        raceHistory.recordRace(cars);

        assertThat(raceHistory.getRaceRecords()).hasSize(1);
    }

    @Test
    void 여러_라운드_기록_저장() {
        Cars cars = new Cars();
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        cars.register(pobi);
        cars.register(woni);

        RaceHistory raceHistory = new RaceHistory();

        raceHistory.recordRace(cars);
        pobi.move(1);
        raceHistory.recordRace(cars);
        pobi.move(1);
        raceHistory.recordRace(cars);

        assertThat(raceHistory.getRaceRecords()).hasSize(3);
    }

    @Test
    void 각_라운드마다_자동차_위치_기록() {
        Cars cars = new Cars();
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        cars.register(pobi);
        cars.register(woni);

        RaceHistory raceHistory = new RaceHistory();

        // 1라운드
        raceHistory.recordRace(cars);
        RoundSnapshot round1 = raceHistory.getRaceRecords().get(0);

        assertThat(round1.getCarPositions().get("pobi")).isEqualTo(0);
        assertThat(round1.getCarPositions().get("woni")).isEqualTo(0);

        // 2라운드
        pobi.move(1);
        raceHistory.recordRace(cars);
        RoundSnapshot round2 = raceHistory.getRaceRecords().get(1);

        assertThat(round2.getCarPositions().get("pobi")).isEqualTo(1);
        assertThat(round2.getCarPositions().get("woni")).isEqualTo(0);

        // 3라운드
        woni.move(1);
        raceHistory.recordRace(cars);
        RoundSnapshot round3 = raceHistory.getRaceRecords().get(2);

        assertThat(round3.getCarPositions().get("pobi")).isEqualTo(1);
        assertThat(round3.getCarPositions().get("woni")).isEqualTo(1);
    }
}
