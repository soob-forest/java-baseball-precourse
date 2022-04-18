package baseball.vo;

public class MatchHint {

    private static final int MIN_COUNT = 0;
    private static final int MAX_COUNT = 3;
    private int strikeCount;
    private int ballCount;

    private MatchHint(int strikeCount, int ballCount) {

        this.strikeCount = strikeCount;
        this.ballCount = ballCount;

        validate();
    }

    static public MatchHint create(int strikeCount, int ballCount) {
        return new MatchHint(strikeCount, ballCount);
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    private void validate() {
        if (strikeCount < MIN_COUNT || MAX_COUNT < strikeCount) {
            throw new IllegalArgumentException();
        }
        if (ballCount < MIN_COUNT || MAX_COUNT < ballCount) {
            throw new IllegalArgumentException();
        }
        if (MAX_COUNT < ballCount + strikeCount) {
            throw new IllegalArgumentException();
        }
    }

}
