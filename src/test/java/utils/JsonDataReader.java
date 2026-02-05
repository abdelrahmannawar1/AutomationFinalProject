package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonDataReader {

    private static JsonNode jsonData;
    public static void loadJsonFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonData = mapper.readTree(
                    JsonDataReader.class
                            .getClassLoader()
                            .getResourceAsStream("testdata/users.json")
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to load JSON file", e);
        }
    }




    public static String getData(String parent, String key) {
        if (jsonData == null) {
            throw new RuntimeException("JSON file not loaded. Call loadJsonFile() first.");
        }
        return jsonData.get(parent).get(key).asText();
    }
}
