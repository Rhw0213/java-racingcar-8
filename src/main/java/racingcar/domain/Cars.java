package racingcar.domain;

import racingcar.infra.random.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {
    private static final int FORWARD_CAN_NUMBER = 4;
    private static final int MOVE_DISTANCE = 1;
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void moveAll(final RandomNumberGenerator generator) {
        for (final Car car : cars) {
            final int randomNumber = generator.generate();
            if (randomNumber >= FORWARD_CAN_NUMBER) {
                car.move(MOVE_DISTANCE);
            }
        }
    }

    public void register(final Car car) {
        if (containsCarName(car.getName())) {
            throw new IllegalArgumentException("자동차 이름이 중복됩니다");
        }

        this.cars.add(car);
    }

    public void register(final List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("등록할 자동차를 추가해 주세요.");
        }

        cars.forEach(this::register);
    }

    public RoundSnapshot createSnapshot() {
        Map<String, Integer> positions = cars.stream()
                .collect(Collectors.toMap(
                        Car::getName,
                        Car::getPosition
                ));

        return RoundSnapshot.of(positions);
    }

    public final List<String> getWinnerCarNames() {
        final int farDistance = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == farDistance)
                .map(Car::getName)
                .toList();
    }

    private boolean containsCarName(final String name) {
        return cars.stream()
                .anyMatch(car -> car.getName().equals(name));
    }
}
