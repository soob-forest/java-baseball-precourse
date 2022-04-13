package baseball.vo;

import java.util.Objects;

public class BaseBallNumber {

    private static final int MIN_NUMBERS = 1;
    private static final int MAX_NUMBERS = 9;

    private int number;

    private BaseBallNumber(int number) {
        this.number = number;

        validate();
    }

    public static BaseBallNumber create(int number) {
        return new BaseBallNumber(number);
    }

    private void validate() {
        if (number > MAX_NUMBERS || number < MIN_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseBallNumber that = (BaseBallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
