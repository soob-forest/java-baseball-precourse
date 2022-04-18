package baseball.vo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchHintTest {

    @DisplayName("매치 테스트")
    @Test
    void 매치_결과() {

        List<BaseBallNumber> hitterNumbers = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(1), BaseBallNumber.create(2), BaseBallNumber.create(3)));

        List<BaseBallNumber> pitcherNumbers = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(1), BaseBallNumber.create(3), BaseBallNumber.create(4)));

        ThreeBaseBallNumbers hitter = ThreeBaseBallNumbers.createThreeBaseBalls(hitterNumbers);
        ThreeBaseBallNumbers pitcher = ThreeBaseBallNumbers.createThreeBaseBalls(pitcherNumbers);

        MatchHint matchHint = MatchHint.match(hitter, pitcher);

        assertEquals(1, matchHint.getStrikeCount());
        assertEquals(1, matchHint.getBallCount());

        List<BaseBallNumber> hitterNumbers2 = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(4), BaseBallNumber.create(1), BaseBallNumber.create(3)));

        List<BaseBallNumber> pitcherNumbers2 = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(1), BaseBallNumber.create(3), BaseBallNumber.create(4)));

        ThreeBaseBallNumbers hitter2 = ThreeBaseBallNumbers.createThreeBaseBalls(hitterNumbers2);
        ThreeBaseBallNumbers pitcher2 = ThreeBaseBallNumbers.createThreeBaseBalls(pitcherNumbers2);

        MatchHint matchHint2 = MatchHint.match(hitter2, pitcher2);

        assertEquals(0, matchHint2.getStrikeCount());
        assertEquals(3, matchHint2.getBallCount());

        List<BaseBallNumber> hitterNumbers3 = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(7), BaseBallNumber.create(6), BaseBallNumber.create(9)));

        List<BaseBallNumber> pitcherNumbers3 = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(1), BaseBallNumber.create(3), BaseBallNumber.create(4)));

        ThreeBaseBallNumbers hitter3 = ThreeBaseBallNumbers.createThreeBaseBalls(hitterNumbers3);
        ThreeBaseBallNumbers pitcher3 = ThreeBaseBallNumbers.createThreeBaseBalls(pitcherNumbers3);

        MatchHint matchHint3 = MatchHint.match(hitter3, pitcher3);

        assertEquals(0, matchHint3.getStrikeCount());
        assertEquals(0, matchHint3.getBallCount());
    }
}