package exercise;

import java.util.Map;

public interface KeyValueStorage {
    void set(String key, String value);
    void unset(String key);
    void unsetAll();
    String get(String key, String defaultValue);
    Map<String, String> toMap();
}
