package baseball.domain;

import baseball.vo.ThreeBaseBallNumbers;

public class Computer {

    private ThreeBaseBallNumbers threeBaseBallNumbers;

    public Computer() {
    }

    public void selectThreeBaseBallNumbers() {

        this.threeBaseBallNumbers = ThreeBaseBallNumbers.createThreeBaseBalls(
                ThreeBaseBallNumbers.generateRandomBaseBallNumberList());
    }

    public ThreeBaseBallNumbers getSelectedBaseBallNumbers() {
        return this.threeBaseBallNumbers;
    }
}
