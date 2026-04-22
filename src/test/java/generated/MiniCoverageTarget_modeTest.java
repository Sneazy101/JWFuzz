import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MiniCoverageTarget_modeTest {

    @Test
    public void test_mode() {
        MiniCoverageTarget obj = new MiniCoverageTarget();

        // Testing parameter i0 with value: 0
        obj.mode(0);
        // Testing parameter i0 with value: 1
        obj.mode(1);
        // Testing parameter i0 with value: -1
        obj.mode(-1);
    }
}
