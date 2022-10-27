package bin.v3.console.priority;

import work.v3.StartWorkV3;

import java.util.LinkedList;
import java.util.Map;

public class PriorityPrint extends StartWorkV3 {
    public PriorityPrint(int... counts) {
        super(counts);
    }

    @Override
    public void start(String line, String[] params,
                      LinkedList<Map<String, Map<String, Object>>> repositoryArray) {
        System.out.println(params[0]);
    }
}
