package racingcar.infra.io;

public class ConsoleOutput implements Output {
    @Override
    public void printLine(final String message) {
        System.out.println(message);
    }
}