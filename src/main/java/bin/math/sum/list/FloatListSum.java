package bin.math.sum.list;

import bin.orign.variable.list.get.GetList;
import bin.token.LoopToken;
import work.ReturnWork;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FloatListSum implements ReturnWork, LoopToken, GetList {
    private final String type = FLOAT_VARIABLE;
    private final String value = orMerge(VARIABLE_ACCESS, NUMBER_LIST);
    private final String patternText =
            VARIABLE_GET_S + value + LIST_SUM + VARIABLE_GET_E;
    private final Pattern pattern = Pattern.compile(patternText);

    @Override
    public boolean check(String line) {
        return pattern.matcher(line).find();
    }

    @Override
    public String start(String line,
                        Map<String, Map<String, Object>>[] repositoryArray) {
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String group = matcher.group();
            String groups = bothEndCut(group)
                    .replaceFirst(LIST_SUM + END, "");
            if (groups.matches(VARIABLE_ACCESS)) {
                int accessCount = accessCount(groups);
                var repository1 = repositoryArray[accessCount].get(FLOAT_VARIABLE);
                var repository2 = repositoryArray[accessCount].get(DOUBLE_VARIABLE);
                String variableName = groups.replaceAll(ACCESS, "");
                if (repository1.containsKey(variableName)) {
                    LinkedList<Double> list = (LinkedList<Double>) repository1.get(variableName);
                    String sum = Double.toString(list.stream().mapToDouble(v -> v).sum());
                    line = line.replace(group, sum);
                } else if (repository2.containsKey(variableName)) {
                    LinkedList<Float> list = (LinkedList<Float>) repository2.get(variableName);
                    String sum = Double.toString(list.stream().mapToDouble(v -> v).sum());
                    line = line.replace(group, sum);
                }
            } else {
                try {
                    LinkedList<Double> list = getDoubleList(groups);
                    String sum = Double.toString(list.stream().mapToDouble(v -> v).sum());
                    line = line.replace(group, sum);
                } catch (Exception ignored) {}
            }
        }
        return line;
    }
}
