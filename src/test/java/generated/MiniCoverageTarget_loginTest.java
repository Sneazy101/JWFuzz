import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MiniCoverageTarget_loginTest {

    @Test
    public void test_login() {
        MiniCoverageTarget obj = new MiniCoverageTarget();

        // Testing parameter z1 with value: 0
        obj.login(false, false, false);
        // Testing parameter z0 with value: 0
        obj.login(false, false, false);
        // Testing parameter z2 with value: 0
        obj.login(false, false, false);
    }
}
