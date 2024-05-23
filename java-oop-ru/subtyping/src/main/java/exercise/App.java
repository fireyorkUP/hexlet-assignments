package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> dataMap = storage.toMap();
        Map<String, String> newDataMap = new HashMap<>();

        for (Map.Entry<String, String> entry : dataMap.entrySet()) {
            newDataMap.put(entry.getValue(), entry.getKey());
        }

        storage.unsetAll();

        for (Map.Entry<String, String> entry : newDataMap.entrySet()) {
            storage.set(entry.getKey(), entry.getValue());
        }
    }
}
// END
