package baseball.vo;

import baseball.enums.MatchResult;

public class MatchHint {

    private int strikeCount;
    private int ballCount;

    private MatchHint(int strikeCount, int ballCount) {

        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    static public MatchHint match(ThreeBaseBallNumbers hitterBaseBassNumbers,
                                  ThreeBaseBallNumbers pitcherBaseBallNumbers) {

        int strikeCount = 0;
        int ballCount = 0;

        for (int hitterIndex = 0; hitterIndex < hitterBaseBassNumbers.getThreeBaseBallNumbers().size(); hitterIndex++) {

            BaseBallNumber hitterBaseBallNumber = hitterBaseBassNumbers.getThreeBaseBallNumbers().get(hitterIndex);

            MatchResult matchResult = pitcherBaseBallNumbers.pitch(hitterBaseBallNumber, hitterIndex);

            strikeCount = sumMatchResultCount(matchResult, MatchResult.STRIKE, strikeCount);
            ballCount = sumMatchResultCount(matchResult, MatchResult.BALL, ballCount);
        }

        return new MatchHint(strikeCount, ballCount);
    }

    private static int sumMatchResultCount(MatchResult matchResult, MatchResult matchResultType, int hitCount) {
        if (matchResult == matchResultType) {
            hitCount++;
        }
        return hitCount;
    }


    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

}
