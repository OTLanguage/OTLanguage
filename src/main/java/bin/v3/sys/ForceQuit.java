package bin.v3.sys;

import work.v3.StartWorkV3;

import java.util.LinkedList;
import java.util.Map;

public class ForceQuit extends StartWorkV3 {
    public ForceQuit(int... counts) {
        super(counts);
    }

    @Override
    public void start(String line, String[] params,
                      LinkedList<Map<String, Map<String, Object>>> repositoryArray) {
        System.exit(0);
    }
}
