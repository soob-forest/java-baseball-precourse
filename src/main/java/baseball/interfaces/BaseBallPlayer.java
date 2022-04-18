package baseball.interfaces;

import baseball.vo.ThreeBaseBallNumbers;

public interface BaseBallPlayer {

    void selectThreeBaseBallNumbers(ThreeBaseBallNumbers threeBaseBallNumbers);

    ThreeBaseBallNumbers getSelectedBaseBallNumbers();

}
