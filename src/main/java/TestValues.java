import com.google.protobuf.Value;
import fj.data.HashMap;
import soot.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestValues {
    private Map<soot.Value, ArrayList<String>> map; // Tracks different states for each Value to have more branch coverage
    private Map<soot.Value, soot.Type> dataTypes; // Tracks the data type of each Value to ensure we are tracking the correct variables
    private List<soot.Value> functionInputs; // Tracks the input types for each function to ensure we are testing with the correct data types

    public TestValues(Map<soot.Value, ArrayList<String>> map, Map<soot.Value, soot.Type> dataTypes, List<soot.Value> functionInputs) {
        this.map = map;
        this.dataTypes = dataTypes;
        this.functionInputs = functionInputs;
    }

    public TestValues() {
        this.map = new java.util.HashMap<>();
        this.dataTypes = new java.util.HashMap<>();
    }

    public void addValue(soot.Value v, List<String> states) {
        map.computeIfAbsent(v, k -> new ArrayList<>()).addAll(states);
    }

    public void addDataType(soot.Value v, soot.Type t) {
        dataTypes.put(v, t);
    }

    public List<String> getValueStates(Value v) {
        return map.get(v);
    }

    public void merge(TestValues testValues){
        for(soot.Value v : testValues.map.keySet()){
            if(!this.map.containsKey(v)){
                this.map.put(v, new ArrayList<>());
            }
            for(String s : testValues.map.get(v)){
                if(!this.map.get(v).contains(s)){
                    this.map.get(v).add(s);
                }
            }
        }
    }

    public void addNewTestCase(soot.Value v, String newCase) {
        if (!map.containsKey(v)) {
            map.put(v, new ArrayList<>());
        }
        map.get(v).add(newCase);
    }

    public  void copy(TestValues testValues) {
        this.map.clear();
        this.map.putAll(testValues.map);
        // Datatypes are not touched
    }

    public void printTestValues() {
        System.out.println("Current Test Values:");
        for(soot.Value v : functionInputs) {
            System.out.println("Variable: " + v + " of type: " + dataTypes.get(v) + " Size of test case : " + map.get(v).size());
            for(String s : map.get(v)) {
                System.out.println("  Test Values: " + s);
            }
        }
    }
}