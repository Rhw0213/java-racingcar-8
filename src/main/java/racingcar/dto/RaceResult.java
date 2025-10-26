package racingcar.dto;

import racingcar.domain.RaceHistory;

import java.util.List;

public record RaceResult(List<String> winners, RaceHistory history) {
}
