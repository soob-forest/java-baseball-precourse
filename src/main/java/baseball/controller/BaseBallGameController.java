package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.enums.EndOrContinueStatus;
import baseball.view.BaseBallGameView;
import baseball.vo.BaseBallNumber;
import baseball.vo.MatchHint;
import baseball.vo.ThreeBaseBallNumbers;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGameController {
    private BaseBallGameView view;

    public BaseBallGameController(BaseBallGameView baseBallGameView) {
        this.view = baseBallGameView;
    }

    public void start() {

        Computer computer = new Computer();
        Player player = new Player();

        EndOrContinueStatus endOrContinueStatus = EndOrContinueStatus.CONTINUE;

        while (endOrContinueStatus.equals(EndOrContinueStatus.CONTINUE)) {

            run(computer, player);

            this.view.outputSuccess();
            this.view.outputEndOrContinue();

            endOrContinueStatus = selectEndOrContinue();
        }
    }

    private EndOrContinueStatus selectEndOrContinue() {

        String playerInput = this.view.inputEndOrContinue();

        if (EndOrContinueStatus.CONTINUE.equals(parseToInt(playerInput))) {
            return EndOrContinueStatus.CONTINUE;
        }
        return EndOrContinueStatus.END;
    }

    private void run(Computer computer, Player player) {

        computer.selectThreeBaseBallNumbers(ThreeBaseBallNumbers.createRandomThreeBaseBalls());

        boolean isRun = true;
        while (isRun) {
            this.view.outputEnterNumber();
            MatchHint matchHint = matchWithPlayer(computer, player);

            this.view.outputMatchHint(matchHint);

            isRun = reRun(matchHint);
        }
    }

    private MatchHint matchWithPlayer(Computer computer, Player player) {
        String playerInput = this.view.inputBaseBallNumbers();

        List<BaseBallNumber> baseBallNumbers = parseToBaseBallNumberArray(playerInput);

        player.selectThreeBaseBallNumbers(ThreeBaseBallNumbers.createThreeBaseBalls(baseBallNumbers));

        MatchHint matchHint = player.playWith(computer);

        return matchHint;
    }

    private List<BaseBallNumber> parseToBaseBallNumberArray(String playerInput) {
        List<Integer> playerNumbers = parseToIntArray(playerInput);

        List<BaseBallNumber> baseBallNumbers = new ArrayList<>();

        for (int number : playerNumbers) {

            baseBallNumbers.add(BaseBallNumber.create(number));
        }
        return baseBallNumbers;
    }

    private boolean reRun(MatchHint matchHint) {
        return matchHint.getStrikeCount() != 3;
    }

    private List<Integer> parseToIntArray(String stringNumber) {
        try {
            List<Integer> result = new ArrayList<>();

            for (char c : stringNumber.toCharArray()) {
                result.add(Character.getNumericValue(c));
            }

            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private int parseToInt(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

}