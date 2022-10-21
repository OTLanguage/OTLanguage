package bin.math.sum.set;

import bin.orign.variable.list.get.GetList;
import bin.orign.variable.set.get.GetSet;
import bin.token.LoopToken;
import work.ReturnWork;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FloatSetSum implements ReturnWork, LoopToken, GetSet {
    private final String value = orMerge(VARIABLE_ACCESS, NUMBER_LIST);
    private final String patternText =
            VARIABLE_GET_S + value + SET_SUM + VARIABLE_GET_E;
    private final Matcher matcher = Pattern.compile(patternText).matcher("");

    @Override
    public boolean check(String line) {
        return (matcher.reset(line)).find();
    }

    @Override
    public String start(String line,
                        Map<String, Map<String, Object>>[] repositoryArray) {
        matcher.reset();
        while (matcher.find()) {
            String group = matcher.group();
            String groups = bothEndCut(group)
                    .replaceFirst(SET_SUM + END, "");
            if (groups.matches(VARIABLE_ACCESS)) {
                int accessCount = accessCount(groups);
                var repository1 = repositoryArray[accessCount].get(SET_FLOAT);
                var repository2 = repositoryArray[accessCount].get(SET_DOUBLE);
                String variableName = groups.replaceAll(ACCESS, "");
                if (repository1.containsKey(variableName)) {
                    LinkedHashSet<Float> list = (LinkedHashSet<Float>) repository1.get(variableName);
                    String sum = Double.toString(list.stream().mapToDouble(v -> v).sum());
                    line = line.replace(group, sum);
                } else if (repository2.containsKey(variableName)) {
                    LinkedHashSet<Double> list = (LinkedHashSet<Double>) repository2.get(variableName);
                    String sum = Double.toString(list.stream().mapToDouble(v -> v).sum());
                    line = line.replace(group, sum);
                }
            } else {
                // 변환이 불가능하면 에러발생
                try {
                    LinkedHashSet<Double> list = getDoubleSet(groups);
                    String sum = Double.toString(list.stream().mapToDouble(v -> v).sum());
                    line = line.replace(group, sum);
                } catch (Exception ignored) {}
            }
        }
        return line;
    }

    @Override
    public ReturnWork first() {
        return this;
    }
}