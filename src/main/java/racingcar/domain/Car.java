package racingcar.domain;

import racingcar.dto.CarName;

public class Car {
    private final CarName name;
    private int position;

    public Car(final CarName name) {
        this.name = name;
        this.position = 0;
    }

    public Car(final String name) {
        this(new CarName(name));
    }

    public void move(final int distance) {
        position += distance;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name.name();
    }
}
