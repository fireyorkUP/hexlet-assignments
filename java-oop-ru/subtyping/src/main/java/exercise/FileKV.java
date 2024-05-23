package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String filePath;
    private Map<String, String> data;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = filePath;
        this.data = new HashMap<>(initialData);
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        data.remove(key);
        Utils.writeFile(filePath, Utils.serialize(data));
    }

    @Override
    public void unsetAll() {
        data.clear();
        Utils.writeFile(filePath, Utils.serialize(data));
    }

    @Override
    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(data);
    }
}
// END
