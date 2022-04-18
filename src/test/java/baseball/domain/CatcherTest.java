package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.interfaces.BaseBallPlayer;
import baseball.vo.BaseBallNumber;
import baseball.vo.MatchHint;
import baseball.vo.ThreeBaseBallNumbers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CatcherTest {
    @DisplayName("매치 테스트")
    @Test
    void 매치_결과() {

        BaseBallPlayer player = new Player();
        BaseBallPlayer computer = new Computer();

        Catcher catcher = new Catcher(player, computer);

        List<BaseBallNumber> hitterNumbers = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(1), BaseBallNumber.create(2), BaseBallNumber.create(3)));

        List<BaseBallNumber> pitcherNumbers = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(1), BaseBallNumber.create(3), BaseBallNumber.create(4)));

        player.selectThreeBaseBallNumbers(ThreeBaseBallNumbers.createThreeBaseBalls(hitterNumbers));
        computer.selectThreeBaseBallNumbers(ThreeBaseBallNumbers.createThreeBaseBalls(pitcherNumbers));

        MatchHint matchHint = catcher.receive();

        assertEquals(1, matchHint.getStrikeCount());
        assertEquals(1, matchHint.getBallCount());

        List<BaseBallNumber> hitterNumbers2 = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(4), BaseBallNumber.create(1), BaseBallNumber.create(3)));

        List<BaseBallNumber> pitcherNumbers2 = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(1), BaseBallNumber.create(3), BaseBallNumber.create(4)));

        player.selectThreeBaseBallNumbers(ThreeBaseBallNumbers.createThreeBaseBalls(hitterNumbers2));
        computer.selectThreeBaseBallNumbers(ThreeBaseBallNumbers.createThreeBaseBalls(pitcherNumbers2));

        MatchHint matchHint2 = catcher.receive();

        assertEquals(0, matchHint2.getStrikeCount());
        assertEquals(3, matchHint2.getBallCount());

        List<BaseBallNumber> hitterNumbers3 = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(7), BaseBallNumber.create(6), BaseBallNumber.create(9)));

        List<BaseBallNumber> pitcherNumbers3 = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(1), BaseBallNumber.create(3), BaseBallNumber.create(4)));

        player.selectThreeBaseBallNumbers(ThreeBaseBallNumbers.createThreeBaseBalls(hitterNumbers3));
        computer.selectThreeBaseBallNumbers(ThreeBaseBallNumbers.createThreeBaseBalls(pitcherNumbers3));

        MatchHint matchHint3 = catcher.receive();

        assertEquals(0, matchHint3.getStrikeCount());
        assertEquals(0, matchHint3.getBallCount());
    }
}