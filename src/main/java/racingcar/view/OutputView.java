package racingcar.view;

import racingcar.dto.RaceResult;
import racingcar.infra.io.Output;

import java.util.stream.Collectors;

public class OutputView implements Output {
    private static final String RESULT = "실행 결과";
    private static final String WINNERS = "최종 우승자 : ";

    public static void printResult(final RaceResult result) {
        String body =
                result.history()
                        .getRaceRecords()
                        .stream()
                        .map(m -> m.getCarPositions().entrySet()
                                .stream()
                                .map(e -> e.getKey() + " : " + "-".repeat(e.getValue()))
                                .collect(Collectors.joining("\n")))
                        .collect(Collectors.joining("\n\n"));

        String sb = RESULT + '\n' + body + "\n\n" +
                WINNERS + String.join(", ", result.winners());

        System.out.println(sb);
    }
}
