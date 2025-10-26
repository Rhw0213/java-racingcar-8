package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 이름확인() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 전진() {
        Car car = new Car("pobi");
        car.move(1);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 정지() {
        Car car = new Car("pobi");
        car.move(0);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 여러번_전진() {
        Car car = new Car("pobi");
        car.move(1);
        car.move(1);
        car.move(1);
        assertThat(car.getPosition()).isEqualTo(3);
    }
}
