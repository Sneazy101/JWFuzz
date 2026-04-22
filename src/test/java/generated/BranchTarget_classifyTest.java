import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BranchTarget_classifyTest {

    @Test
    public void test_classify() {
        BranchTarget obj = new BranchTarget();

        // Testing parameter i0 with value: 0
        obj.classify(0, false, false, 0);
        // Testing parameter i0 with value: 1
        obj.classify(1, false, false, 0);
        // Testing parameter i0 with value: -1
        obj.classify(-1, false, false, 0);
        // Testing parameter i0 with value: 18
        obj.classify(18, false, false, 0);
        // Testing parameter z1 with value: true
        obj.classify(0, true, false, 0);
        // Testing parameter z1 with value: false
        obj.classify(0, false, false, 0);
        // Testing parameter z0 with value: true
        obj.classify(0, false, true, 0);
        // Testing parameter z0 with value: false
        obj.classify(0, false, false, 0);
        // Testing parameter i1 with value: 0
        obj.classify(0, false, false, 0);
        // Testing parameter i1 with value: 1
        obj.classify(0, false, false, 1);
        // Testing parameter i1 with value: -1
        obj.classify(0, false, false, -1);
        // Testing parameter i1 with value: 10
        obj.classify(0, false, false, 10);
        // Testing parameter i1 with value: 20
        obj.classify(0, false, false, 20);
    }
}
