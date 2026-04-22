import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MiniCoverageTarget_loginTest {

    @Test
    public void test_login() {
        MiniCoverageTarget obj = new MiniCoverageTarget();

        // Testing parameter z1 with value: true
        obj.login(true, false, false);
        // Testing parameter z1 with value: false
        obj.login(false, false, false);
        // Testing parameter z0 with value: true
        obj.login(false, true, false);
        // Testing parameter z0 with value: false
        obj.login(false, false, false);
        // Testing parameter z2 with value: true
        obj.login(false, false, true);
        // Testing parameter z2 with value: false
        obj.login(false, false, false);
    }
}
