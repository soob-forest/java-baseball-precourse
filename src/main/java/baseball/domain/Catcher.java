package baseball.domain;

import baseball.enums.MatchResult;
import baseball.interfaces.BaseBallPlayer;
import baseball.vo.BaseBallNumber;
import baseball.vo.MatchHint;
import java.util.List;

public class Catcher {

    private BaseBallPlayer hitter;
    private BaseBallPlayer pitcher;

    public Catcher(BaseBallPlayer hitter, BaseBallPlayer pitcher) {
        this.hitter = hitter;
        this.pitcher = pitcher;
    }

    public MatchHint receive() {

        int strikeCount = 0;
        int ballCount = 0;

        List<BaseBallNumber> hitterBaseBallNumbers = hitter.getSelectedBaseBallNumbers().getThreeBaseBallNumbers();

        for (int hitterIndex = 0; hitterIndex < hitterBaseBallNumbers.size(); hitterIndex++) {

            MatchResult matchResult = pitch(hitterIndex);

            strikeCount = sumMatchResultCount(matchResult, MatchResult.STRIKE, strikeCount);
            ballCount = sumMatchResultCount(matchResult, MatchResult.BALL, ballCount);
        }
        return MatchHint.create(strikeCount, ballCount);
    }

    private int sumMatchResultCount(MatchResult matchResult, MatchResult matchResultType, int hitCount) {
        if (matchResult == matchResultType) {
            hitCount++;
        }
        return hitCount;
    }

    private MatchResult pitch(int hitterBaseBallIndex) {

        if (isStrike(hitterBaseBallIndex)) {
            return MatchResult.STRIKE;
        }

        if (isBall(hitterBaseBallIndex)) {
            return MatchResult.BALL;
        }

        return MatchResult.NOTHING;
    }

    private boolean isStrike(int hitterBaseBallIndex) {

        List<BaseBallNumber> pitcherBaseBallNumbers = pitcher.getSelectedBaseBallNumbers().getThreeBaseBallNumbers();

        BaseBallNumber hitterBaseBallNumber = hitter.getSelectedBaseBallNumbers().getThreeBaseBallNumbers()
                .get(hitterBaseBallIndex);

        return pitcherBaseBallNumbers.contains(hitterBaseBallNumber)
                && pitcherBaseBallNumbers.indexOf(hitterBaseBallNumber)
                == hitterBaseBallIndex;
    }

    private boolean isBall(int hitterBaseBallIndex) {

        List<BaseBallNumber> pitcherBaseBallNumbers = pitcher.getSelectedBaseBallNumbers().getThreeBaseBallNumbers();
        
        BaseBallNumber hitterBaseBallNumber = hitter.getSelectedBaseBallNumbers().getThreeBaseBallNumbers()
                .get(hitterBaseBallIndex);

        return pitcherBaseBallNumbers.contains(hitterBaseBallNumber)
                && pitcherBaseBallNumbers.indexOf(hitterBaseBallNumber)
                != hitterBaseBallIndex;
    }

}
