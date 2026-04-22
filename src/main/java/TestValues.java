import com.google.protobuf.Value;
import fj.data.HashMap;
import soot.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestValues {
    private Map<soot.Value, ArrayList<Object>> map; // Tracks different states for each Value to have more branch coverage
    private Map<soot.Value, soot.Type> dataTypes; // Tracks the data type of each Value to ensure we are tracking the correct variables
    private List<soot.Value> functionInputs; // Tracks the input types for each function to ensure we are testing with the correct data types

    public TestValues(Map<soot.Value, ArrayList<Object>> map, Map<soot.Value, soot.Type> dataTypes, List<soot.Value> functionInputs) {
        this.map = map;
        this.dataTypes = dataTypes;
        this.functionInputs = functionInputs;
    }

    public TestValues() {
        this.map = new java.util.HashMap<>();
        this.dataTypes = new java.util.HashMap<>();
    }

    public void addValue(soot.Value v, List<Object> states) {
        map.computeIfAbsent(v, k -> new ArrayList<>()).addAll(states);
    }

    public void addDataType(soot.Value v, soot.Type t) {
        dataTypes.put(v, t);
    }

    public List<Object> getValueStates(Value v) {
        return map.get(v);
    }

    public void addNewTestCase(soot.Value v, Object newCase) {
        if (!map.containsKey(v)) {
            map.put(v, new ArrayList<>());
        }
        if (!map.get(v).contains(newCase)) {
            map.get(v).add(newCase);
        }
    }

    public ArrayList<ArrayList<Object>> generateTestCases() {
        ArrayList<ArrayList<Object>> testCases = new ArrayList<>();
        testCases.add(new ArrayList<>());

        int total = 1;
        for (soot.Value v : functionInputs) {
            List<Object> inputData = map.get(v);
            if (inputData == null || inputData.isEmpty()) {
                System.out.println("No input data found for variable: " + v);
                return new ArrayList<>();
            }
            total *= inputData.size();
        }

        System.out.println("The number of tests to be generated -> " + total);

        for (soot.Value v : functionInputs) {
            ArrayList<ArrayList<Object>> temp = new ArrayList<>();
            List<Object> inputData = map.get(v);

            for (ArrayList<Object> currentTestCase : testCases) {
                for (Object o : inputData) {
                    ArrayList<Object> newTestCase = new ArrayList<>(currentTestCase);
                    newTestCase.add(o);
                    temp.add(newTestCase);
                }
            }

            testCases = temp;
        }

        System.out.println("Printing all test cases");
        for (ArrayList<Object> testCase : testCases) {
            System.out.println("Generated Test Case: " + testCase);
        }

        return testCases;
    }

    public String generateJUnitTest(String targetClassName, String methodName) {

        ArrayList<ArrayList<Object>> testArray = generateTestCases();
        // Clean up method name for class name (remove special characters if any)
        String safeMethodName = methodName.replaceAll("[^a-zA-Z0-9_]", "_");
        String testClassName = targetClassName + "_" + safeMethodName + "Test";

        StringBuilder sb = new StringBuilder();
        sb.append("import org.junit.jupiter.api.Test;\n");
        sb.append("import static org.junit.jupiter.api.Assertions.*;\n\n");
        sb.append("public class ").append(testClassName).append(" {\n\n");
        sb.append("    @Test\n");
        sb.append("    public void test_").append(safeMethodName).append("() {\n");
        sb.append("        ").append(targetClassName).append(" obj = new ").append(targetClassName).append("();\n\n");

        boolean hasTests = false;

        // Iterate through each parameter
        for (int i = 0; i < functionInputs.size(); i++) {
            soot.Value targetParam = functionInputs.get(i);
            List<Object> valuesToTest = map.get(targetParam);

            if (valuesToTest == null || valuesToTest.isEmpty()) continue;

            // Generate a test call for each value of this parameter
            for (Object testVal : valuesToTest) {
                hasTests = true;
                sb.append("        // Testing parameter ").append(targetParam).append(" with value: ").append(testVal).append("\n");
                sb.append("        obj.").append(methodName).append("(");

                // Construct arguments
                for (int j = 0; j < functionInputs.size(); j++) {
                    soot.Value argParam = functionInputs.get(j);
                    String argType = dataTypes.get(argParam).toString();
                    String argValue;

                    if (i == j) {
                        // Use the specific test value for the target parameter
                        argValue = formatValue(argType, testVal);
                    } else {
                        // Use a default value for other parameters
                        argValue = getDefaultValue(argType);
                    }

                    sb.append(argValue);
                    if (j < functionInputs.size() - 1) {
                        sb.append(", ");
                    }
                }
                sb.append(");\n");
            }
        }

        if (!hasTests) {
            sb.append("        // No boundary test cases were generated for this method.\n");
        }

        sb.append("    }\n");
        sb.append("}\n");
        return sb.toString();
    }


    private String formatValue(String type, Object value) {
        if (value == null) return "null";
        String strVal = value.toString();
        if (type.equals("boolean")) {
            return strVal.equals("0") ? "false" : (strVal.equals("false") ? "false" : "true");
        } else if (type.equals("int") || type.equals("byte") || type.equals("short") || type.equals("long")) {
            return strVal;
        } else if (type.equals("float") || type.equals("double")) {
            return strVal + (type.equals("float") ? "f" : "d");
        } else if (type.equals("java.lang.String")) {
            return "\"" + strVal + "\"";
        }
        return "null";
    }

    private String getDefaultValue(String type) {
        if (type.equals("boolean")) return "false";
        if (type.equals("int") || type.equals("byte") || type.equals("short") || type.equals("long")) return "0";
        if (type.equals("float") || type.equals("double")) return "0.0";
        if (type.equals("java.lang.String")) return "\"\"";
        return "null";
    }
}