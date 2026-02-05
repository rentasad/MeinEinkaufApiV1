/**
 *
 */
package org.gustini.library.meinEinkaufApi.utility;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.utility
 *
 * @author Matthias Staud
 * <p>
 * <p>
 * Description:Utility to
 * - generate JSON-String from Java Object
 * - Validate JSON String
 * - get JsonObject from JSonString
 *
 */
@Slf4j
public class JsonBuilder {
    /**
     * Converts a given Java object into its JSON string representation.
     *
     * @param object The Java object to be serialized into a JSON string.
     * @return A JSON string representation of the provided object.
     * @throws JsonProcessingException If an error occurs during the serialization process.
     */
    public static String getJsonStringFromObject(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        // Java object to JSON file
        // mapper.writeValue(new File("c:\\temp\\staff.json"), new Staff());

        // Java object to JSON string
        mapper.setDefaultPropertyInclusion(Include.NON_NULL);
        return mapper.writeValueAsString(object);
    }

    /**
     * Validates if the given string is a valid JSON. The method supports validation
     * for both JSON objects and JSON arrays.
     * Source: <a href="https://stackoverflow.com/questions/10174898/how-to-check-whether-a-given-string-is-valid-json-in-java">...</a>
     *
     * @param jsonString The string to be checked for valid JSON format.
     * @return {@code true} if the input string is a valid JSON object or array,
     * {@code false} otherwise.
     */
    public static boolean isJSONValid(String jsonString) {
        try {
            new JSONObject(jsonString);
        } catch (JSONException ex) {
            // edited, to include @Arthur's comment
            // e.g. in case JSONArray is valid as well...
            try {
                new JSONArray(jsonString);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Converts a JSON string into a {@code JSONObject}.
     *
     * @param jsonString The JSON string to be converted into a {@code JSONObject}.
     *                   Must not be null or empty, and must represent a valid JSON object.
     * @return A {@code JSONObject} representation of the provided JSON string.
     * @throws JSONException If the provided string is not a valid JSON object.
     */
    public static JSONObject getJsonObjectFromJsonString(String jsonString) {
        return new JSONObject(jsonString);
    }

}
