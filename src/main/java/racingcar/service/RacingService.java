package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RaceHistory;
import racingcar.dto.CarName;
import racingcar.dto.RaceResult;
import racingcar.infra.random.DefaultRandomNumberGenerator;
import racingcar.infra.random.RandomNumberGenerator;

import java.util.List;

public class RacingService {
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingService() {
        randomNumberGenerator = new DefaultRandomNumberGenerator();
    }

    public RaceResult runRace(final List<String> racingCars, final int roundCount) {
        Cars cars = createCars(racingCars);
        RaceHistory raceHistory = new RaceHistory();

        for (int i = 0; i < roundCount; i++) {
            cars.moveAll(randomNumberGenerator);
            raceHistory.recordRace(cars);
        }

        return new RaceResult(cars.getWinnerCarNames(), raceHistory);
    }

    private Cars createCars(final List<String> carNames) {
        Cars cars = new Cars();

        carNames.stream()
                .map(CarName::new)
                .map(Car::new)
                .forEach(cars::register);

        return cars;
    }
}
