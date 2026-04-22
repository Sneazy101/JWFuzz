import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MiniCoverageTarget_bucketTest {

    @Test
    public void test_bucket() {
        MiniCoverageTarget obj = new MiniCoverageTarget();

        // Testing parameter i0 with value: 0
        obj.bucket(0);
        // Testing parameter i0 with value: 10
        obj.bucket(10);
        // Testing parameter i0 with value: 100
        obj.bucket(100);
    }
}
