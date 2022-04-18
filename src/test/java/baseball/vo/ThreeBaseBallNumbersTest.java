package baseball.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.enums.MatchResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ThreeBaseBallNumbersTest {

    @DisplayName("생성 테스트")
    @Test
    void 생성_테스트() {

        List<BaseBallNumber> baseBallNumbers = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(1), BaseBallNumber.create(2), BaseBallNumber.create(3)));

        ThreeBaseBallNumbers threeBaseBallNumbers = ThreeBaseBallNumbers.createThreeBaseBalls(baseBallNumbers);

        for (BaseBallNumber number : baseBallNumbers) {

            assertTrue(threeBaseBallNumbers.getThreeBaseBallNumbers().contains(number));

            assertThat(threeBaseBallNumbers.getThreeBaseBallNumbers().indexOf(number)).isEqualTo(
                    baseBallNumbers.indexOf(number)
            );
        }
    }

    @DisplayName("중복되지 않은 값 생성")
    @Test
    void 중복되지_않은_값_생성() {

        int ballCount = 3;

        ThreeBaseBallNumbers threeBaseBallNumbers = ThreeBaseBallNumbers.createRandomThreeBaseBalls();
        Set<BaseBallNumber> BaseBallNumberSet = new HashSet<>(
                threeBaseBallNumbers.getThreeBaseBallNumbers());

        assertEquals(BaseBallNumberSet.size(), ballCount);
    }

    @DisplayName("세개의 값이 생성")
    @Test
    void 세개의_값_생성() {

        int ballCount = 3;

        ThreeBaseBallNumbers threeBaseBallNumbers = ThreeBaseBallNumbers.createRandomThreeBaseBalls();

        assertEquals(threeBaseBallNumbers.getThreeBaseBallNumbers().size(), ballCount);
    }

    @DisplayName("스트라이크 피치 결과 테스트")
    @Test
    void 스트라이크_피치_결과() {

        List<BaseBallNumber> pitcherNumbers = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(1), BaseBallNumber.create(3), BaseBallNumber.create(4)));

        ThreeBaseBallNumbers pitcherBaseBallNumbers = ThreeBaseBallNumbers.createThreeBaseBalls(pitcherNumbers);

        assertThat(pitcherBaseBallNumbers.pitch(BaseBallNumber.create(1), 0)).isEqualTo(MatchResult.STRIKE);

    }

    @DisplayName("볼 피치 결과 테스트")
    @Test
    void 볼_피치_결과() {

        List<BaseBallNumber> pitcherNumbers = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(1), BaseBallNumber.create(3), BaseBallNumber.create(4)));

        ThreeBaseBallNumbers pitcherBaseBallNumbers = ThreeBaseBallNumbers.createThreeBaseBalls(pitcherNumbers);

        assertThat(pitcherBaseBallNumbers.pitch(BaseBallNumber.create(1), 2)).isEqualTo(MatchResult.BALL);

    }

    @DisplayName("낫싱 피치 결과 테스트")
    @Test
    void 낫싱_피치_결과() {

        List<BaseBallNumber> pitcherNumbers = new ArrayList<>(
                Arrays.asList(BaseBallNumber.create(1), BaseBallNumber.create(3), BaseBallNumber.create(4)));

        ThreeBaseBallNumbers pitcherBaseBallNumbers = ThreeBaseBallNumbers.createThreeBaseBalls(pitcherNumbers);

        assertThat(pitcherBaseBallNumbers.pitch(BaseBallNumber.create(5), 2)).isEqualTo(MatchResult.NOTHING);

    }

}