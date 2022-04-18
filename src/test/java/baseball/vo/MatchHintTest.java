package baseball.vo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatchHintTest {

    @ParameterizedTest(name = "정상 범위 테스트 [{arguments}]")
    @CsvSource(value = {"1,1", "1,2", "2,1", "0,0"})
    void 생성_테스트(int strikeCount, int ballCount) {

        assertThat(MatchHint.create(strikeCount, ballCount));
    }

    @ParameterizedTest(name = "예외 범위 테스트")
    @CsvSource(value = {"-1, 1", "2,2", "5,0"})
    void 예외_테스트(int strikeCount, int ballCount) {

        assertThatThrownBy(() -> MatchHint.create(strikeCount, ballCount)).isInstanceOf(IllegalArgumentException.class);
    }
}