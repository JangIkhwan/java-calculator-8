package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열은_결과가_0이다() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @ParameterizedTest
    @CsvSource({
            "'*', '2*3:2', 7",
            "'|', '4|5', 9",
            "'.', '2.3.4', 9",
            "'(', '2(3(4', 9",
            "'[', '2[3[4', 9",
            "'{', '2{3{4', 9",
            "'?', '2?3?4', 9",
            "'+', '2+3+4', 9",
            "'$', '2$3$4', 9",
            "'^', '2^3^4', 9"
    })
    void 다양한_커스텀_구분자를_사용해도_성공한다(String delimiter, String numbers, int expected) {
        assertSimpleTest(() -> {
            run("//" + delimiter + "\\n" + numbers);
            assertThat(output()).contains("결과 : " + expected);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
