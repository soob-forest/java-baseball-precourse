package baseball.domain;

import baseball.interfaces.BaseBallPlayer;
import baseball.vo.ThreeBaseBallNumbers;

public class Player implements BaseBallPlayer {

    private ThreeBaseBallNumbers threeBaseBallNumbers;

    public Player() {
    }

    public void selectThreeBaseBallNumbers(ThreeBaseBallNumbers threeBaseBallNumbers) {

        this.threeBaseBallNumbers = threeBaseBallNumbers;
    }

    public ThreeBaseBallNumbers getSelectedBaseBallNumbers() {
        return this.threeBaseBallNumbers;
    }

}
