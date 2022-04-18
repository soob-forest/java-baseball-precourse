package baseball.domain;

import baseball.vo.BaseBallNumber;
import baseball.vo.ThreeBaseBallNumbers;
import java.util.ArrayList;
import java.util.List;

public class Player {
    
    private ThreeBaseBallNumbers threeBaseBallNumbers;

    public Player() {
    }

    public void selectThreeBaseBallNumbers(List<Integer> numbers) {

        List<BaseBallNumber> baseBallNumbers = new ArrayList<>();

        for (int number : numbers) {

            baseBallNumbers.add(BaseBallNumber.create(number));
        }

        threeBaseBallNumbers = ThreeBaseBallNumbers.createThreeBaseBalls(baseBallNumbers);
    }

    public ThreeBaseBallNumbers getSelectedBaseBallNumbers() {
        return this.threeBaseBallNumbers;
    }
}
