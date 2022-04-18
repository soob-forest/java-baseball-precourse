package baseball.enums;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EndOrContinueStatusTest {

    @DisplayName("동일한 값 비교")
    @Test
    public void 동일한_값_비교() {

        EndOrContinueStatus continue1 = EndOrContinueStatus.CONTINUE;
        EndOrContinueStatus continue2 = EndOrContinueStatus.CONTINUE;
        assertThat(continue1.equals(continue2)).isTrue();

        EndOrContinueStatus end1 = EndOrContinueStatus.END;
        EndOrContinueStatus end2 = EndOrContinueStatus.END;
        assertThat(end1.equals(end2)).isTrue();

    }

    @DisplayName("다른 값 비교")
    @Test
    public void 다른_값_비교() {

        EndOrContinueStatus continue1 = EndOrContinueStatus.CONTINUE;
        EndOrContinueStatus end1 = EndOrContinueStatus.END;

        assertThat(continue1.equals(end1)).isFalse();

        EndOrContinueStatus continue2 = EndOrContinueStatus.CONTINUE;
        EndOrContinueStatus end2 = EndOrContinueStatus.END;
        assertThat(continue2.equals(end2)).isFalse();
        
    }
}