package racingcar.controller;

import racingcar.dto.RaceResult;
import racingcar.service.RacingService;
import racingcar.util.parser.InputParser;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final RacingService racingService;

    public RacingController() {
        racingService = new RacingService();
    }

    public void run() {
        //입력
        String carNamesInput = InputView.readCarName();
        String tryCountInput = InputView.readTryCount();

        //검증
        InputValidator.validateCarNames(carNamesInput);
        InputValidator.validateIntCount(tryCountInput);

        //파싱
        List<String> carNames = InputParser.parseCarNames(carNamesInput, ",");
        int tryCount = InputParser.parseTryCount(tryCountInput);

        //실행
        RaceResult result = racingService.runRace(carNames, tryCount);

        //출력
        OutputView.printResult(result);
    }
}
