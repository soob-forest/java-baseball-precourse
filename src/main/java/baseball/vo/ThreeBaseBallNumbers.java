package baseball.vo;

import baseball.enums.MatchResult;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeBaseBallNumbers {

    private static final int BALL_COUNT = 3;
    private static final int MIN_NUMBERS = 1;
    private static final int MAX_NUMBERS = 9;

    private List<BaseBallNumber> baseBallNumbers;

    private ThreeBaseBallNumbers(List<BaseBallNumber> baseBallNumbers) {

        this.baseBallNumbers = baseBallNumbers;

        validate();
    }

    public static ThreeBaseBallNumbers createThreeBaseBalls(List<BaseBallNumber> baseBallNumbers) {

        return new ThreeBaseBallNumbers(baseBallNumbers);
    }

    public static ThreeBaseBallNumbers createRandomThreeBaseBalls() {

        return new ThreeBaseBallNumbers(generateRandomBaseBallNumberList());
    }

    private static List<BaseBallNumber> generateRandomBaseBallNumberList() {

        Set<BaseBallNumber> baseBallNumbers = new HashSet<>();

        for (int ballCount = 0; ballCount < BALL_COUNT; ballCount++) {
            baseBallNumbers.add(generateNextBaseBallNumber(baseBallNumbers));
        }

        return new ArrayList<>(baseBallNumbers);
    }

    private static BaseBallNumber generateNextBaseBallNumber(Set<BaseBallNumber> baseBallNumbers) {

        BaseBallNumber nextBaseBallNumber = BaseBallNumber.create(Randoms.pickNumberInRange(MIN_NUMBERS, MAX_NUMBERS));

        while (hasSameBaseBallNumber(baseBallNumbers, nextBaseBallNumber)) {
            nextBaseBallNumber = BaseBallNumber.create(Randoms.pickNumberInRange(MIN_NUMBERS, MAX_NUMBERS));
        }

        return nextBaseBallNumber;
    }

    private static boolean hasSameBaseBallNumber(Set<BaseBallNumber> baseBallNumbers,
                                                 BaseBallNumber target) {

        return baseBallNumbers.contains(target);
    }

    private void validate() {
        if (!isThreeCount()) {
            throw new IllegalArgumentException();
        }

        if (!isUniqueAllBaseBallNumbers()) {
            throw new IllegalArgumentException();
        }

    }

    private boolean isThreeCount() {

        return this.baseBallNumbers.size() == BALL_COUNT;
    }

    private boolean isUniqueAllBaseBallNumbers() {

        Set<BaseBallNumber> BaseBallNumberSet = new HashSet<BaseBallNumber>(this.baseBallNumbers);

        return BaseBallNumberSet.size() == BALL_COUNT;
    }

    public List<BaseBallNumber> getThreeBaseBallNumbers() {
        return this.baseBallNumbers;
    }

    public MatchResult pitch(BaseBallNumber hitterBaseBallNumber, int hitterBaseBallIndex) {

        if (isStrike(hitterBaseBallNumber, hitterBaseBallIndex)) {
            return MatchResult.STRIKE;
        }

        if (isBall(hitterBaseBallNumber, hitterBaseBallIndex)) {
            return MatchResult.BALL;
        }

        return MatchResult.NOTHING;
    }

    private boolean isStrike(BaseBallNumber hitterBaseBallNumber, int hitterBaseBallIndex) {
        return this.baseBallNumbers
                .contains(hitterBaseBallNumber)
                && this.baseBallNumbers.indexOf(hitterBaseBallNumber) == hitterBaseBallIndex;
    }

    private boolean isBall(BaseBallNumber hitterBaseBallNumber, int hitterBaseBallIndex) {
        return this.baseBallNumbers
                .contains(hitterBaseBallNumber)
                && this.baseBallNumbers.indexOf(hitterBaseBallNumber) != hitterBaseBallIndex;
    }
}