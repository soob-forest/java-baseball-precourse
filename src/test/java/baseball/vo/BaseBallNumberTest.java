package baseball.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseBallNumberTest {

    @DisplayName("1 ~ 9 범위의 숫자의 공 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 숫자범위_정상_생성(int number) {

        assertThat(BaseBallNumber.create(number));
    }

    @DisplayName("1 ~ 9 범위의 숫자가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 0, 10})
    void 숫자범위_예외(int number) {

        assertThatThrownBy(
                () -> BaseBallNumber.create(number)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("동일한 값 비교")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    public void 동일한_값_비교(int number) {
        BaseBallNumber compare1 = BaseBallNumber.create(number);
        BaseBallNumber compare2 = BaseBallNumber.create(number);

        assertTrue(compare1.equals(compare2));
    }

    @DisplayName("다른 값 비교")
    @Test
    public void 다른_값_비교() throws Exception {

        BaseBallNumber compare1 = BaseBallNumber.create(1);
        BaseBallNumber compare2 = BaseBallNumber.create(2);

        assertFalse(compare1.equals(compare2));

        BaseBallNumber compare5 = BaseBallNumber.create(5);
        BaseBallNumber compare7 = BaseBallNumber.create(7);

        assertFalse(compare5.equals(compare7));

        BaseBallNumber compare9 = BaseBallNumber.create(9);
        BaseBallNumber compare4 = BaseBallNumber.create(4);

        assertFalse(compare9.equals(compare4));

        BaseBallNumber compare3 = BaseBallNumber.create(3);
        BaseBallNumber compare8 = BaseBallNumber.create(8);

        assertFalse(compare3.equals(compare8));
    }

}