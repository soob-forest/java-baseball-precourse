package baseball.interfaces;

import baseball.vo.MatchHint;
import baseball.vo.ThreeBaseBallNumbers;

public interface BaseBallPlayer {

    void selectThreeBaseBallNumbers(ThreeBaseBallNumbers threeBaseBallNumbers);

    ThreeBaseBallNumbers getSelectedBaseBallNumbers();

    MatchHint playWith(BaseBallPlayer baseBallPlayer);
}
