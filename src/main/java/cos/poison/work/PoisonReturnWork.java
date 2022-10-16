package cos.poison.work;

import com.sun.net.httpserver.Headers;

import java.util.Map;

public interface PoisonReturnWork {
    boolean check(String line);
    String start(String line, String origen, Headers requestHeader,
                 Map<String, Map<String, Object>>[] repositoryArray);
}
