package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    public void testGetExistingKey() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        assertEquals(storage.get("key", "default"), "value");
    }

    @Test
    public void testPutNewKey() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        storage.set("newKey", "newValue");
        assertEquals(storage.get("newKey", "default"), "newValue");
    }

    @Test
    public void testRemoveKey() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        storage.unset("key");
        assertEquals(storage.get("key", "default"), "default");
    }
        // END
}
