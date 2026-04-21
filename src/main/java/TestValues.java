import com.google.protobuf.Value;
import fj.data.HashMap;
import soot.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestValues {
    private Map<soot.Value, ArrayList<String>> map;
    private Map<soot.Value, soot.Type> dataTypes;

    public TestValues(Map<soot.Value, ArrayList<String>> map, Map<soot.Value, soot.Type> dataTypes) {
        this.map = map;
        this.dataTypes = dataTypes;
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

    public  void copy(TestValues testValues) {
        this.map.clear();
        this.map.putAll(testValues.map);
        // commenting this out right now because data types are fixed and do not change X_X
//        this.dataTypes.clear();
//        this.dataTypes.putAll(testValues.dataTypes);
    }
}