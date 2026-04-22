import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BranchTarget_classifyTest {

    @Test
    public void test_classify() {
        BranchTarget obj = new BranchTarget();

        // Testing with values: [0, true, true, 0, ]
        obj.classify(0, true, true, 0, "");
        // Testing with values: [0, true, true, 0,  ]
        obj.classify(0, true, true, 0, " ");
        // Testing with values: [0, true, true, 0, null]
        obj.classify(0, true, true, 0, "null");
        // Testing with values: [0, true, true, 0, bumblebee]
        obj.classify(0, true, true, 0, "bumblebee");
        // Testing with values: [0, true, true, 1, ]
        obj.classify(0, true, true, 1, "");
        // Testing with values: [0, true, true, 1,  ]
        obj.classify(0, true, true, 1, " ");
        // Testing with values: [0, true, true, 1, null]
        obj.classify(0, true, true, 1, "null");
        // Testing with values: [0, true, true, 1, bumblebee]
        obj.classify(0, true, true, 1, "bumblebee");
        // Testing with values: [0, true, true, -1, ]
        obj.classify(0, true, true, -1, "");
        // Testing with values: [0, true, true, -1,  ]
        obj.classify(0, true, true, -1, " ");
        // Testing with values: [0, true, true, -1, null]
        obj.classify(0, true, true, -1, "null");
        // Testing with values: [0, true, true, -1, bumblebee]
        obj.classify(0, true, true, -1, "bumblebee");
        // Testing with values: [0, true, true, 10, ]
        obj.classify(0, true, true, 10, "");
        // Testing with values: [0, true, true, 10,  ]
        obj.classify(0, true, true, 10, " ");
        // Testing with values: [0, true, true, 10, null]
        obj.classify(0, true, true, 10, "null");
        // Testing with values: [0, true, true, 10, bumblebee]
        obj.classify(0, true, true, 10, "bumblebee");
        // Testing with values: [0, true, true, 20, ]
        obj.classify(0, true, true, 20, "");
        // Testing with values: [0, true, true, 20,  ]
        obj.classify(0, true, true, 20, " ");
        // Testing with values: [0, true, true, 20, null]
        obj.classify(0, true, true, 20, "null");
        // Testing with values: [0, true, true, 20, bumblebee]
        obj.classify(0, true, true, 20, "bumblebee");
        // Testing with values: [0, true, false, 0, ]
        obj.classify(0, true, false, 0, "");
        // Testing with values: [0, true, false, 0,  ]
        obj.classify(0, true, false, 0, " ");
        // Testing with values: [0, true, false, 0, null]
        obj.classify(0, true, false, 0, "null");
        // Testing with values: [0, true, false, 0, bumblebee]
        obj.classify(0, true, false, 0, "bumblebee");
        // Testing with values: [0, true, false, 1, ]
        obj.classify(0, true, false, 1, "");
        // Testing with values: [0, true, false, 1,  ]
        obj.classify(0, true, false, 1, " ");
        // Testing with values: [0, true, false, 1, null]
        obj.classify(0, true, false, 1, "null");
        // Testing with values: [0, true, false, 1, bumblebee]
        obj.classify(0, true, false, 1, "bumblebee");
        // Testing with values: [0, true, false, -1, ]
        obj.classify(0, true, false, -1, "");
        // Testing with values: [0, true, false, -1,  ]
        obj.classify(0, true, false, -1, " ");
        // Testing with values: [0, true, false, -1, null]
        obj.classify(0, true, false, -1, "null");
        // Testing with values: [0, true, false, -1, bumblebee]
        obj.classify(0, true, false, -1, "bumblebee");
        // Testing with values: [0, true, false, 10, ]
        obj.classify(0, true, false, 10, "");
        // Testing with values: [0, true, false, 10,  ]
        obj.classify(0, true, false, 10, " ");
        // Testing with values: [0, true, false, 10, null]
        obj.classify(0, true, false, 10, "null");
        // Testing with values: [0, true, false, 10, bumblebee]
        obj.classify(0, true, false, 10, "bumblebee");
        // Testing with values: [0, true, false, 20, ]
        obj.classify(0, true, false, 20, "");
        // Testing with values: [0, true, false, 20,  ]
        obj.classify(0, true, false, 20, " ");
        // Testing with values: [0, true, false, 20, null]
        obj.classify(0, true, false, 20, "null");
        // Testing with values: [0, true, false, 20, bumblebee]
        obj.classify(0, true, false, 20, "bumblebee");
        // Testing with values: [0, false, true, 0, ]
        obj.classify(0, false, true, 0, "");
        // Testing with values: [0, false, true, 0,  ]
        obj.classify(0, false, true, 0, " ");
        // Testing with values: [0, false, true, 0, null]
        obj.classify(0, false, true, 0, "null");
        // Testing with values: [0, false, true, 0, bumblebee]
        obj.classify(0, false, true, 0, "bumblebee");
        // Testing with values: [0, false, true, 1, ]
        obj.classify(0, false, true, 1, "");
        // Testing with values: [0, false, true, 1,  ]
        obj.classify(0, false, true, 1, " ");
        // Testing with values: [0, false, true, 1, null]
        obj.classify(0, false, true, 1, "null");
        // Testing with values: [0, false, true, 1, bumblebee]
        obj.classify(0, false, true, 1, "bumblebee");
        // Testing with values: [0, false, true, -1, ]
        obj.classify(0, false, true, -1, "");
        // Testing with values: [0, false, true, -1,  ]
        obj.classify(0, false, true, -1, " ");
        // Testing with values: [0, false, true, -1, null]
        obj.classify(0, false, true, -1, "null");
        // Testing with values: [0, false, true, -1, bumblebee]
        obj.classify(0, false, true, -1, "bumblebee");
        // Testing with values: [0, false, true, 10, ]
        obj.classify(0, false, true, 10, "");
        // Testing with values: [0, false, true, 10,  ]
        obj.classify(0, false, true, 10, " ");
        // Testing with values: [0, false, true, 10, null]
        obj.classify(0, false, true, 10, "null");
        // Testing with values: [0, false, true, 10, bumblebee]
        obj.classify(0, false, true, 10, "bumblebee");
        // Testing with values: [0, false, true, 20, ]
        obj.classify(0, false, true, 20, "");
        // Testing with values: [0, false, true, 20,  ]
        obj.classify(0, false, true, 20, " ");
        // Testing with values: [0, false, true, 20, null]
        obj.classify(0, false, true, 20, "null");
        // Testing with values: [0, false, true, 20, bumblebee]
        obj.classify(0, false, true, 20, "bumblebee");
        // Testing with values: [0, false, false, 0, ]
        obj.classify(0, false, false, 0, "");
        // Testing with values: [0, false, false, 0,  ]
        obj.classify(0, false, false, 0, " ");
        // Testing with values: [0, false, false, 0, null]
        obj.classify(0, false, false, 0, "null");
        // Testing with values: [0, false, false, 0, bumblebee]
        obj.classify(0, false, false, 0, "bumblebee");
        // Testing with values: [0, false, false, 1, ]
        obj.classify(0, false, false, 1, "");
        // Testing with values: [0, false, false, 1,  ]
        obj.classify(0, false, false, 1, " ");
        // Testing with values: [0, false, false, 1, null]
        obj.classify(0, false, false, 1, "null");
        // Testing with values: [0, false, false, 1, bumblebee]
        obj.classify(0, false, false, 1, "bumblebee");
        // Testing with values: [0, false, false, -1, ]
        obj.classify(0, false, false, -1, "");
        // Testing with values: [0, false, false, -1,  ]
        obj.classify(0, false, false, -1, " ");
        // Testing with values: [0, false, false, -1, null]
        obj.classify(0, false, false, -1, "null");
        // Testing with values: [0, false, false, -1, bumblebee]
        obj.classify(0, false, false, -1, "bumblebee");
        // Testing with values: [0, false, false, 10, ]
        obj.classify(0, false, false, 10, "");
        // Testing with values: [0, false, false, 10,  ]
        obj.classify(0, false, false, 10, " ");
        // Testing with values: [0, false, false, 10, null]
        obj.classify(0, false, false, 10, "null");
        // Testing with values: [0, false, false, 10, bumblebee]
        obj.classify(0, false, false, 10, "bumblebee");
        // Testing with values: [0, false, false, 20, ]
        obj.classify(0, false, false, 20, "");
        // Testing with values: [0, false, false, 20,  ]
        obj.classify(0, false, false, 20, " ");
        // Testing with values: [0, false, false, 20, null]
        obj.classify(0, false, false, 20, "null");
        // Testing with values: [0, false, false, 20, bumblebee]
        obj.classify(0, false, false, 20, "bumblebee");
        // Testing with values: [1, true, true, 0, ]
        obj.classify(1, true, true, 0, "");
        // Testing with values: [1, true, true, 0,  ]
        obj.classify(1, true, true, 0, " ");
        // Testing with values: [1, true, true, 0, null]
        obj.classify(1, true, true, 0, "null");
        // Testing with values: [1, true, true, 0, bumblebee]
        obj.classify(1, true, true, 0, "bumblebee");
        // Testing with values: [1, true, true, 1, ]
        obj.classify(1, true, true, 1, "");
        // Testing with values: [1, true, true, 1,  ]
        obj.classify(1, true, true, 1, " ");
        // Testing with values: [1, true, true, 1, null]
        obj.classify(1, true, true, 1, "null");
        // Testing with values: [1, true, true, 1, bumblebee]
        obj.classify(1, true, true, 1, "bumblebee");
        // Testing with values: [1, true, true, -1, ]
        obj.classify(1, true, true, -1, "");
        // Testing with values: [1, true, true, -1,  ]
        obj.classify(1, true, true, -1, " ");
        // Testing with values: [1, true, true, -1, null]
        obj.classify(1, true, true, -1, "null");
        // Testing with values: [1, true, true, -1, bumblebee]
        obj.classify(1, true, true, -1, "bumblebee");
        // Testing with values: [1, true, true, 10, ]
        obj.classify(1, true, true, 10, "");
        // Testing with values: [1, true, true, 10,  ]
        obj.classify(1, true, true, 10, " ");
        // Testing with values: [1, true, true, 10, null]
        obj.classify(1, true, true, 10, "null");
        // Testing with values: [1, true, true, 10, bumblebee]
        obj.classify(1, true, true, 10, "bumblebee");
        // Testing with values: [1, true, true, 20, ]
        obj.classify(1, true, true, 20, "");
        // Testing with values: [1, true, true, 20,  ]
        obj.classify(1, true, true, 20, " ");
        // Testing with values: [1, true, true, 20, null]
        obj.classify(1, true, true, 20, "null");
        // Testing with values: [1, true, true, 20, bumblebee]
        obj.classify(1, true, true, 20, "bumblebee");
        // Testing with values: [1, true, false, 0, ]
        obj.classify(1, true, false, 0, "");
        // Testing with values: [1, true, false, 0,  ]
        obj.classify(1, true, false, 0, " ");
        // Testing with values: [1, true, false, 0, null]
        obj.classify(1, true, false, 0, "null");
        // Testing with values: [1, true, false, 0, bumblebee]
        obj.classify(1, true, false, 0, "bumblebee");
        // Testing with values: [1, true, false, 1, ]
        obj.classify(1, true, false, 1, "");
        // Testing with values: [1, true, false, 1,  ]
        obj.classify(1, true, false, 1, " ");
        // Testing with values: [1, true, false, 1, null]
        obj.classify(1, true, false, 1, "null");
        // Testing with values: [1, true, false, 1, bumblebee]
        obj.classify(1, true, false, 1, "bumblebee");
        // Testing with values: [1, true, false, -1, ]
        obj.classify(1, true, false, -1, "");
        // Testing with values: [1, true, false, -1,  ]
        obj.classify(1, true, false, -1, " ");
        // Testing with values: [1, true, false, -1, null]
        obj.classify(1, true, false, -1, "null");
        // Testing with values: [1, true, false, -1, bumblebee]
        obj.classify(1, true, false, -1, "bumblebee");
        // Testing with values: [1, true, false, 10, ]
        obj.classify(1, true, false, 10, "");
        // Testing with values: [1, true, false, 10,  ]
        obj.classify(1, true, false, 10, " ");
        // Testing with values: [1, true, false, 10, null]
        obj.classify(1, true, false, 10, "null");
        // Testing with values: [1, true, false, 10, bumblebee]
        obj.classify(1, true, false, 10, "bumblebee");
        // Testing with values: [1, true, false, 20, ]
        obj.classify(1, true, false, 20, "");
        // Testing with values: [1, true, false, 20,  ]
        obj.classify(1, true, false, 20, " ");
        // Testing with values: [1, true, false, 20, null]
        obj.classify(1, true, false, 20, "null");
        // Testing with values: [1, true, false, 20, bumblebee]
        obj.classify(1, true, false, 20, "bumblebee");
        // Testing with values: [1, false, true, 0, ]
        obj.classify(1, false, true, 0, "");
        // Testing with values: [1, false, true, 0,  ]
        obj.classify(1, false, true, 0, " ");
        // Testing with values: [1, false, true, 0, null]
        obj.classify(1, false, true, 0, "null");
        // Testing with values: [1, false, true, 0, bumblebee]
        obj.classify(1, false, true, 0, "bumblebee");
        // Testing with values: [1, false, true, 1, ]
        obj.classify(1, false, true, 1, "");
        // Testing with values: [1, false, true, 1,  ]
        obj.classify(1, false, true, 1, " ");
        // Testing with values: [1, false, true, 1, null]
        obj.classify(1, false, true, 1, "null");
        // Testing with values: [1, false, true, 1, bumblebee]
        obj.classify(1, false, true, 1, "bumblebee");
        // Testing with values: [1, false, true, -1, ]
        obj.classify(1, false, true, -1, "");
        // Testing with values: [1, false, true, -1,  ]
        obj.classify(1, false, true, -1, " ");
        // Testing with values: [1, false, true, -1, null]
        obj.classify(1, false, true, -1, "null");
        // Testing with values: [1, false, true, -1, bumblebee]
        obj.classify(1, false, true, -1, "bumblebee");
        // Testing with values: [1, false, true, 10, ]
        obj.classify(1, false, true, 10, "");
        // Testing with values: [1, false, true, 10,  ]
        obj.classify(1, false, true, 10, " ");
        // Testing with values: [1, false, true, 10, null]
        obj.classify(1, false, true, 10, "null");
        // Testing with values: [1, false, true, 10, bumblebee]
        obj.classify(1, false, true, 10, "bumblebee");
        // Testing with values: [1, false, true, 20, ]
        obj.classify(1, false, true, 20, "");
        // Testing with values: [1, false, true, 20,  ]
        obj.classify(1, false, true, 20, " ");
        // Testing with values: [1, false, true, 20, null]
        obj.classify(1, false, true, 20, "null");
        // Testing with values: [1, false, true, 20, bumblebee]
        obj.classify(1, false, true, 20, "bumblebee");
        // Testing with values: [1, false, false, 0, ]
        obj.classify(1, false, false, 0, "");
        // Testing with values: [1, false, false, 0,  ]
        obj.classify(1, false, false, 0, " ");
        // Testing with values: [1, false, false, 0, null]
        obj.classify(1, false, false, 0, "null");
        // Testing with values: [1, false, false, 0, bumblebee]
        obj.classify(1, false, false, 0, "bumblebee");
        // Testing with values: [1, false, false, 1, ]
        obj.classify(1, false, false, 1, "");
        // Testing with values: [1, false, false, 1,  ]
        obj.classify(1, false, false, 1, " ");
        // Testing with values: [1, false, false, 1, null]
        obj.classify(1, false, false, 1, "null");
        // Testing with values: [1, false, false, 1, bumblebee]
        obj.classify(1, false, false, 1, "bumblebee");
        // Testing with values: [1, false, false, -1, ]
        obj.classify(1, false, false, -1, "");
        // Testing with values: [1, false, false, -1,  ]
        obj.classify(1, false, false, -1, " ");
        // Testing with values: [1, false, false, -1, null]
        obj.classify(1, false, false, -1, "null");
        // Testing with values: [1, false, false, -1, bumblebee]
        obj.classify(1, false, false, -1, "bumblebee");
        // Testing with values: [1, false, false, 10, ]
        obj.classify(1, false, false, 10, "");
        // Testing with values: [1, false, false, 10,  ]
        obj.classify(1, false, false, 10, " ");
        // Testing with values: [1, false, false, 10, null]
        obj.classify(1, false, false, 10, "null");
        // Testing with values: [1, false, false, 10, bumblebee]
        obj.classify(1, false, false, 10, "bumblebee");
        // Testing with values: [1, false, false, 20, ]
        obj.classify(1, false, false, 20, "");
        // Testing with values: [1, false, false, 20,  ]
        obj.classify(1, false, false, 20, " ");
        // Testing with values: [1, false, false, 20, null]
        obj.classify(1, false, false, 20, "null");
        // Testing with values: [1, false, false, 20, bumblebee]
        obj.classify(1, false, false, 20, "bumblebee");
        // Testing with values: [-1, true, true, 0, ]
        obj.classify(-1, true, true, 0, "");
        // Testing with values: [-1, true, true, 0,  ]
        obj.classify(-1, true, true, 0, " ");
        // Testing with values: [-1, true, true, 0, null]
        obj.classify(-1, true, true, 0, "null");
        // Testing with values: [-1, true, true, 0, bumblebee]
        obj.classify(-1, true, true, 0, "bumblebee");
        // Testing with values: [-1, true, true, 1, ]
        obj.classify(-1, true, true, 1, "");
        // Testing with values: [-1, true, true, 1,  ]
        obj.classify(-1, true, true, 1, " ");
        // Testing with values: [-1, true, true, 1, null]
        obj.classify(-1, true, true, 1, "null");
        // Testing with values: [-1, true, true, 1, bumblebee]
        obj.classify(-1, true, true, 1, "bumblebee");
        // Testing with values: [-1, true, true, -1, ]
        obj.classify(-1, true, true, -1, "");
        // Testing with values: [-1, true, true, -1,  ]
        obj.classify(-1, true, true, -1, " ");
        // Testing with values: [-1, true, true, -1, null]
        obj.classify(-1, true, true, -1, "null");
        // Testing with values: [-1, true, true, -1, bumblebee]
        obj.classify(-1, true, true, -1, "bumblebee");
        // Testing with values: [-1, true, true, 10, ]
        obj.classify(-1, true, true, 10, "");
        // Testing with values: [-1, true, true, 10,  ]
        obj.classify(-1, true, true, 10, " ");
        // Testing with values: [-1, true, true, 10, null]
        obj.classify(-1, true, true, 10, "null");
        // Testing with values: [-1, true, true, 10, bumblebee]
        obj.classify(-1, true, true, 10, "bumblebee");
        // Testing with values: [-1, true, true, 20, ]
        obj.classify(-1, true, true, 20, "");
        // Testing with values: [-1, true, true, 20,  ]
        obj.classify(-1, true, true, 20, " ");
        // Testing with values: [-1, true, true, 20, null]
        obj.classify(-1, true, true, 20, "null");
        // Testing with values: [-1, true, true, 20, bumblebee]
        obj.classify(-1, true, true, 20, "bumblebee");
        // Testing with values: [-1, true, false, 0, ]
        obj.classify(-1, true, false, 0, "");
        // Testing with values: [-1, true, false, 0,  ]
        obj.classify(-1, true, false, 0, " ");
        // Testing with values: [-1, true, false, 0, null]
        obj.classify(-1, true, false, 0, "null");
        // Testing with values: [-1, true, false, 0, bumblebee]
        obj.classify(-1, true, false, 0, "bumblebee");
        // Testing with values: [-1, true, false, 1, ]
        obj.classify(-1, true, false, 1, "");
        // Testing with values: [-1, true, false, 1,  ]
        obj.classify(-1, true, false, 1, " ");
        // Testing with values: [-1, true, false, 1, null]
        obj.classify(-1, true, false, 1, "null");
        // Testing with values: [-1, true, false, 1, bumblebee]
        obj.classify(-1, true, false, 1, "bumblebee");
        // Testing with values: [-1, true, false, -1, ]
        obj.classify(-1, true, false, -1, "");
        // Testing with values: [-1, true, false, -1,  ]
        obj.classify(-1, true, false, -1, " ");
        // Testing with values: [-1, true, false, -1, null]
        obj.classify(-1, true, false, -1, "null");
        // Testing with values: [-1, true, false, -1, bumblebee]
        obj.classify(-1, true, false, -1, "bumblebee");
        // Testing with values: [-1, true, false, 10, ]
        obj.classify(-1, true, false, 10, "");
        // Testing with values: [-1, true, false, 10,  ]
        obj.classify(-1, true, false, 10, " ");
        // Testing with values: [-1, true, false, 10, null]
        obj.classify(-1, true, false, 10, "null");
        // Testing with values: [-1, true, false, 10, bumblebee]
        obj.classify(-1, true, false, 10, "bumblebee");
        // Testing with values: [-1, true, false, 20, ]
        obj.classify(-1, true, false, 20, "");
        // Testing with values: [-1, true, false, 20,  ]
        obj.classify(-1, true, false, 20, " ");
        // Testing with values: [-1, true, false, 20, null]
        obj.classify(-1, true, false, 20, "null");
        // Testing with values: [-1, true, false, 20, bumblebee]
        obj.classify(-1, true, false, 20, "bumblebee");
        // Testing with values: [-1, false, true, 0, ]
        obj.classify(-1, false, true, 0, "");
        // Testing with values: [-1, false, true, 0,  ]
        obj.classify(-1, false, true, 0, " ");
        // Testing with values: [-1, false, true, 0, null]
        obj.classify(-1, false, true, 0, "null");
        // Testing with values: [-1, false, true, 0, bumblebee]
        obj.classify(-1, false, true, 0, "bumblebee");
        // Testing with values: [-1, false, true, 1, ]
        obj.classify(-1, false, true, 1, "");
        // Testing with values: [-1, false, true, 1,  ]
        obj.classify(-1, false, true, 1, " ");
        // Testing with values: [-1, false, true, 1, null]
        obj.classify(-1, false, true, 1, "null");
        // Testing with values: [-1, false, true, 1, bumblebee]
        obj.classify(-1, false, true, 1, "bumblebee");
        // Testing with values: [-1, false, true, -1, ]
        obj.classify(-1, false, true, -1, "");
        // Testing with values: [-1, false, true, -1,  ]
        obj.classify(-1, false, true, -1, " ");
        // Testing with values: [-1, false, true, -1, null]
        obj.classify(-1, false, true, -1, "null");
        // Testing with values: [-1, false, true, -1, bumblebee]
        obj.classify(-1, false, true, -1, "bumblebee");
        // Testing with values: [-1, false, true, 10, ]
        obj.classify(-1, false, true, 10, "");
        // Testing with values: [-1, false, true, 10,  ]
        obj.classify(-1, false, true, 10, " ");
        // Testing with values: [-1, false, true, 10, null]
        obj.classify(-1, false, true, 10, "null");
        // Testing with values: [-1, false, true, 10, bumblebee]
        obj.classify(-1, false, true, 10, "bumblebee");
        // Testing with values: [-1, false, true, 20, ]
        obj.classify(-1, false, true, 20, "");
        // Testing with values: [-1, false, true, 20,  ]
        obj.classify(-1, false, true, 20, " ");
        // Testing with values: [-1, false, true, 20, null]
        obj.classify(-1, false, true, 20, "null");
        // Testing with values: [-1, false, true, 20, bumblebee]
        obj.classify(-1, false, true, 20, "bumblebee");
        // Testing with values: [-1, false, false, 0, ]
        obj.classify(-1, false, false, 0, "");
        // Testing with values: [-1, false, false, 0,  ]
        obj.classify(-1, false, false, 0, " ");
        // Testing with values: [-1, false, false, 0, null]
        obj.classify(-1, false, false, 0, "null");
        // Testing with values: [-1, false, false, 0, bumblebee]
        obj.classify(-1, false, false, 0, "bumblebee");
        // Testing with values: [-1, false, false, 1, ]
        obj.classify(-1, false, false, 1, "");
        // Testing with values: [-1, false, false, 1,  ]
        obj.classify(-1, false, false, 1, " ");
        // Testing with values: [-1, false, false, 1, null]
        obj.classify(-1, false, false, 1, "null");
        // Testing with values: [-1, false, false, 1, bumblebee]
        obj.classify(-1, false, false, 1, "bumblebee");
        // Testing with values: [-1, false, false, -1, ]
        obj.classify(-1, false, false, -1, "");
        // Testing with values: [-1, false, false, -1,  ]
        obj.classify(-1, false, false, -1, " ");
        // Testing with values: [-1, false, false, -1, null]
        obj.classify(-1, false, false, -1, "null");
        // Testing with values: [-1, false, false, -1, bumblebee]
        obj.classify(-1, false, false, -1, "bumblebee");
        // Testing with values: [-1, false, false, 10, ]
        obj.classify(-1, false, false, 10, "");
        // Testing with values: [-1, false, false, 10,  ]
        obj.classify(-1, false, false, 10, " ");
        // Testing with values: [-1, false, false, 10, null]
        obj.classify(-1, false, false, 10, "null");
        // Testing with values: [-1, false, false, 10, bumblebee]
        obj.classify(-1, false, false, 10, "bumblebee");
        // Testing with values: [-1, false, false, 20, ]
        obj.classify(-1, false, false, 20, "");
        // Testing with values: [-1, false, false, 20,  ]
        obj.classify(-1, false, false, 20, " ");
        // Testing with values: [-1, false, false, 20, null]
        obj.classify(-1, false, false, 20, "null");
        // Testing with values: [-1, false, false, 20, bumblebee]
        obj.classify(-1, false, false, 20, "bumblebee");
        // Testing with values: [18, true, true, 0, ]
        obj.classify(18, true, true, 0, "");
        // Testing with values: [18, true, true, 0,  ]
        obj.classify(18, true, true, 0, " ");
        // Testing with values: [18, true, true, 0, null]
        obj.classify(18, true, true, 0, "null");
        // Testing with values: [18, true, true, 0, bumblebee]
        obj.classify(18, true, true, 0, "bumblebee");
        // Testing with values: [18, true, true, 1, ]
        obj.classify(18, true, true, 1, "");
        // Testing with values: [18, true, true, 1,  ]
        obj.classify(18, true, true, 1, " ");
        // Testing with values: [18, true, true, 1, null]
        obj.classify(18, true, true, 1, "null");
        // Testing with values: [18, true, true, 1, bumblebee]
        obj.classify(18, true, true, 1, "bumblebee");
        // Testing with values: [18, true, true, -1, ]
        obj.classify(18, true, true, -1, "");
        // Testing with values: [18, true, true, -1,  ]
        obj.classify(18, true, true, -1, " ");
        // Testing with values: [18, true, true, -1, null]
        obj.classify(18, true, true, -1, "null");
        // Testing with values: [18, true, true, -1, bumblebee]
        obj.classify(18, true, true, -1, "bumblebee");
        // Testing with values: [18, true, true, 10, ]
        obj.classify(18, true, true, 10, "");
        // Testing with values: [18, true, true, 10,  ]
        obj.classify(18, true, true, 10, " ");
        // Testing with values: [18, true, true, 10, null]
        obj.classify(18, true, true, 10, "null");
        // Testing with values: [18, true, true, 10, bumblebee]
        obj.classify(18, true, true, 10, "bumblebee");
        // Testing with values: [18, true, true, 20, ]
        obj.classify(18, true, true, 20, "");
        // Testing with values: [18, true, true, 20,  ]
        obj.classify(18, true, true, 20, " ");
        // Testing with values: [18, true, true, 20, null]
        obj.classify(18, true, true, 20, "null");
        // Testing with values: [18, true, true, 20, bumblebee]
        obj.classify(18, true, true, 20, "bumblebee");
        // Testing with values: [18, true, false, 0, ]
        obj.classify(18, true, false, 0, "");
        // Testing with values: [18, true, false, 0,  ]
        obj.classify(18, true, false, 0, " ");
        // Testing with values: [18, true, false, 0, null]
        obj.classify(18, true, false, 0, "null");
        // Testing with values: [18, true, false, 0, bumblebee]
        obj.classify(18, true, false, 0, "bumblebee");
        // Testing with values: [18, true, false, 1, ]
        obj.classify(18, true, false, 1, "");
        // Testing with values: [18, true, false, 1,  ]
        obj.classify(18, true, false, 1, " ");
        // Testing with values: [18, true, false, 1, null]
        obj.classify(18, true, false, 1, "null");
        // Testing with values: [18, true, false, 1, bumblebee]
        obj.classify(18, true, false, 1, "bumblebee");
        // Testing with values: [18, true, false, -1, ]
        obj.classify(18, true, false, -1, "");
        // Testing with values: [18, true, false, -1,  ]
        obj.classify(18, true, false, -1, " ");
        // Testing with values: [18, true, false, -1, null]
        obj.classify(18, true, false, -1, "null");
        // Testing with values: [18, true, false, -1, bumblebee]
        obj.classify(18, true, false, -1, "bumblebee");
        // Testing with values: [18, true, false, 10, ]
        obj.classify(18, true, false, 10, "");
        // Testing with values: [18, true, false, 10,  ]
        obj.classify(18, true, false, 10, " ");
        // Testing with values: [18, true, false, 10, null]
        obj.classify(18, true, false, 10, "null");
        // Testing with values: [18, true, false, 10, bumblebee]
        obj.classify(18, true, false, 10, "bumblebee");
        // Testing with values: [18, true, false, 20, ]
        obj.classify(18, true, false, 20, "");
        // Testing with values: [18, true, false, 20,  ]
        obj.classify(18, true, false, 20, " ");
        // Testing with values: [18, true, false, 20, null]
        obj.classify(18, true, false, 20, "null");
        // Testing with values: [18, true, false, 20, bumblebee]
        obj.classify(18, true, false, 20, "bumblebee");
        // Testing with values: [18, false, true, 0, ]
        obj.classify(18, false, true, 0, "");
        // Testing with values: [18, false, true, 0,  ]
        obj.classify(18, false, true, 0, " ");
        // Testing with values: [18, false, true, 0, null]
        obj.classify(18, false, true, 0, "null");
        // Testing with values: [18, false, true, 0, bumblebee]
        obj.classify(18, false, true, 0, "bumblebee");
        // Testing with values: [18, false, true, 1, ]
        obj.classify(18, false, true, 1, "");
        // Testing with values: [18, false, true, 1,  ]
        obj.classify(18, false, true, 1, " ");
        // Testing with values: [18, false, true, 1, null]
        obj.classify(18, false, true, 1, "null");
        // Testing with values: [18, false, true, 1, bumblebee]
        obj.classify(18, false, true, 1, "bumblebee");
        // Testing with values: [18, false, true, -1, ]
        obj.classify(18, false, true, -1, "");
        // Testing with values: [18, false, true, -1,  ]
        obj.classify(18, false, true, -1, " ");
        // Testing with values: [18, false, true, -1, null]
        obj.classify(18, false, true, -1, "null");
        // Testing with values: [18, false, true, -1, bumblebee]
        obj.classify(18, false, true, -1, "bumblebee");
        // Testing with values: [18, false, true, 10, ]
        obj.classify(18, false, true, 10, "");
        // Testing with values: [18, false, true, 10,  ]
        obj.classify(18, false, true, 10, " ");
        // Testing with values: [18, false, true, 10, null]
        obj.classify(18, false, true, 10, "null");
        // Testing with values: [18, false, true, 10, bumblebee]
        obj.classify(18, false, true, 10, "bumblebee");
        // Testing with values: [18, false, true, 20, ]
        obj.classify(18, false, true, 20, "");
        // Testing with values: [18, false, true, 20,  ]
        obj.classify(18, false, true, 20, " ");
        // Testing with values: [18, false, true, 20, null]
        obj.classify(18, false, true, 20, "null");
        // Testing with values: [18, false, true, 20, bumblebee]
        obj.classify(18, false, true, 20, "bumblebee");
        // Testing with values: [18, false, false, 0, ]
        obj.classify(18, false, false, 0, "");
        // Testing with values: [18, false, false, 0,  ]
        obj.classify(18, false, false, 0, " ");
        // Testing with values: [18, false, false, 0, null]
        obj.classify(18, false, false, 0, "null");
        // Testing with values: [18, false, false, 0, bumblebee]
        obj.classify(18, false, false, 0, "bumblebee");
        // Testing with values: [18, false, false, 1, ]
        obj.classify(18, false, false, 1, "");
        // Testing with values: [18, false, false, 1,  ]
        obj.classify(18, false, false, 1, " ");
        // Testing with values: [18, false, false, 1, null]
        obj.classify(18, false, false, 1, "null");
        // Testing with values: [18, false, false, 1, bumblebee]
        obj.classify(18, false, false, 1, "bumblebee");
        // Testing with values: [18, false, false, -1, ]
        obj.classify(18, false, false, -1, "");
        // Testing with values: [18, false, false, -1,  ]
        obj.classify(18, false, false, -1, " ");
        // Testing with values: [18, false, false, -1, null]
        obj.classify(18, false, false, -1, "null");
        // Testing with values: [18, false, false, -1, bumblebee]
        obj.classify(18, false, false, -1, "bumblebee");
        // Testing with values: [18, false, false, 10, ]
        obj.classify(18, false, false, 10, "");
        // Testing with values: [18, false, false, 10,  ]
        obj.classify(18, false, false, 10, " ");
        // Testing with values: [18, false, false, 10, null]
        obj.classify(18, false, false, 10, "null");
        // Testing with values: [18, false, false, 10, bumblebee]
        obj.classify(18, false, false, 10, "bumblebee");
        // Testing with values: [18, false, false, 20, ]
        obj.classify(18, false, false, 20, "");
        // Testing with values: [18, false, false, 20,  ]
        obj.classify(18, false, false, 20, " ");
        // Testing with values: [18, false, false, 20, null]
        obj.classify(18, false, false, 20, "null");
        // Testing with values: [18, false, false, 20, bumblebee]
        obj.classify(18, false, false, 20, "bumblebee");
    }
}
