package baseball.view;

import baseball.vo.MatchHint;
import camp.nextstep.edu.missionutils.Console;


public class BaseBallGameView {

    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String END_OR_CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료 하려면 2를 입력하세요.";
    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String BALL_MESSAGE = "%d볼";
    private static final String NOTHING_MESSAGE = "낫싱";

    public BaseBallGameView() {
    }

    public void outputEnterNumber() {
        System.out.print(ENTER_NUMBER_MESSAGE);
    }

    public String inputBaseBallNumbers() {

        return Console.readLine();
    }

    public void outputSuccess() {
        System.out.println(SUCCESS_MESSAGE);
    }

    public void outputEndOrContinue() {
        System.out.println(END_OR_CONTINUE_MESSAGE);
    }

    public String inputEndOrContinue() {

        return Console.readLine();
    }

    public void outputMatchHint(MatchHint matchHint) {

        int strikeCount = matchHint.getStrikeCount();
        int ballCount = matchHint.getBallCount();

        printBallCount(ballCount);

        printStrikeCount(strikeCount);

        printNothing(strikeCount, ballCount);

        System.out.println();
    }

    private void printNothing(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print(NOTHING_MESSAGE);
        }
    }

    private void printStrikeCount(int strikeCount) {
        if (strikeCount > 0) {
            System.out.print(String.format(STRIKE_MESSAGE, strikeCount));
        }
    }

    private void printBallCount(int ballCount) {
        if (ballCount > 0) {
            System.out.print(String.format(BALL_MESSAGE, ballCount));
            System.out.print(" ");
        }
    }
}
