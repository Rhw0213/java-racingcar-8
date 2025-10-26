package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.CarName;
import racingcar.infra.random.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    void 자동차_등록() {
        Car car = new Car(new CarName("pobi"));
        Cars cars = new Cars();

        cars.register(car);
        cars.moveAll(new RandomNumberGenerator() {
            @Override
            public int generate() {
                return 1;
            }
        });

        assertThat(cars.getWinnerCarNames()).hasSize(1);
    }

    @Test
    void 중복된이름으로_등록불가() {
        Cars cars = new Cars();

        cars.register(new Car(new CarName("pobi")));
        assertThatThrownBy(() -> cars.register(new Car(new CarName("pobi"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이동() {
        Cars cars = new Cars();
        Car car = new Car(new CarName("pobi"));
        cars.register(car);

        cars.moveAll(new RandomNumberGenerator() {
            @Override
            public int generate() {
                //TODO : 상수값 한곳에서 처리
                return 4;
            }
        });

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_이동불가() {
        Cars cars = new Cars();
        Car car = new Car(new CarName("pobi"));

        cars.register(car);

        cars.moveAll(new RandomNumberGenerator() {
            @Override
            public int generate() {
                return 3;
            }
        });

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 우승자_1명() {
        Cars cars = new Cars();

        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));
        Car car3 = new Car(new CarName("jun"));

        cars.register(car1);
        cars.register(car2);
        cars.register(car3);

        car1.move(4);
        car2.move(3);
        car3.move(3);

        assertThat(cars.getWinnerCarNames()).contains("pobi");
    }

    @Test
    void 우승자_여러명() {
        Cars cars = new Cars();

        Car car1 = new Car(new CarName("pobi"));
        Car car2 = new Car(new CarName("woni"));
        Car car3 = new Car(new CarName("jun"));
        Car car4 = new Car(new CarName("tom"));

        cars.register(car1);
        cars.register(car2);
        cars.register(car3);
        cars.register(car4);

        car1.move(4);
        car2.move(3);
        car3.move(4);
        car4.move(3);

        assertThat(cars.getWinnerCarNames()).contains("pobi", "jun");
    }
}
