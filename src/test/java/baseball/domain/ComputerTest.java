package baseball.domain;


import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.vo.BaseBallNumber;
import baseball.vo.ThreeBaseBallNumbers;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @DisplayName("중복되지 않은 3개의 수 선택")
    @Test
    void 세개의_수_선택() {

        int ballCount = 3;

        Computer computer = new Computer();
        computer.selectThreeBaseBallNumbers();

        ThreeBaseBallNumbers threeBaseBallNumbers = computer.getSelectedBaseBallNumbers();

        Set<BaseBallNumber> BaseBallNumberSet = new HashSet<>(
                threeBaseBallNumbers.getThreeBaseBallNumbers());

        assertEquals(BaseBallNumberSet.size(), ballCount);

        assertEquals(threeBaseBallNumbers.getThreeBaseBallNumbers().size(), ballCount);
    }
}