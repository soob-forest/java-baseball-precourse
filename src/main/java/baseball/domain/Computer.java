package baseball.domain;

import baseball.vo.ThreeBaseBallNumbers;

public class Computer {

    private ThreeBaseBallNumbers threeBaseBallNumbers;

    public Computer() {
    }

    public void selectThreeBaseBallNumbers(ThreeBaseBallNumbers threeBaseBallNumbers) {

        this.threeBaseBallNumbers = threeBaseBallNumbers;
    }

    public ThreeBaseBallNumbers getSelectedBaseBallNumbers() {
        return this.threeBaseBallNumbers;
    }
}
