import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MiniCoverageTarget_signTest {

    @Test
    public void test_sign() {
        MiniCoverageTarget obj = new MiniCoverageTarget();

        // Testing parameter i0 with value: 0
        obj.sign(0);
        // Testing parameter i0 with value: 1
        obj.sign(1);
        // Testing parameter i0 with value: -1
        obj.sign(-1);
    }
}
