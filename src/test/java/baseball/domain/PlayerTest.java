package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.vo.BaseBallNumber;
import baseball.vo.ThreeBaseBallNumbers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("중복되지 않은 3개의 수 선택")
    @Test
    void 세개의_수_선택() {

        Player player = new Player();

        List<Integer> playersNumber = new ArrayList<>(Arrays.asList(1, 2, 3));

        player.selectThreeBaseBallNumbers(playersNumber);

        ThreeBaseBallNumbers threeBaseBallNumbers = player.getSelectedBaseBallNumbers();

        for (int index = 0; index < threeBaseBallNumbers.getThreeBaseBallNumbers().size(); index++) {

            assertEquals(threeBaseBallNumbers.getThreeBaseBallNumbers().get(index),
                    BaseBallNumber.create(playersNumber.get(index)));
        }
    }
}