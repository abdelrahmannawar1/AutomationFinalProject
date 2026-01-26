package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;

public class JsonDataReader {

    private static JsonNode jsonData;

    public static void loadJsonFile(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = JsonDataReader.class.getClassLoader().getResourceAsStream(filePath);

            if (is == null) {
                throw new RuntimeException("JSON file not found: " + filePath);
            }

            jsonData = mapper.readTree(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load JSON: " + filePath, e);
        }
    }

    public static String getData(String key1, String key2) {
        return jsonData.get(key1).get(key2).asText();
    }
}
