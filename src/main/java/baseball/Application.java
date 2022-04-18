package baseball;

import baseball.controller.BaseBallGameController;
import baseball.view.BaseBallGameView;

public class Application {
    public static void main(String[] args) {

        BaseBallGameView view = new BaseBallGameView();

        BaseBallGameController controller = new BaseBallGameController(view);

        controller.start();

        return;
    }
}
