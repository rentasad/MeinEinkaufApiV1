/**
 * 
 */
package org.gustini.library.meinEinkaufApi.utility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.utility
 * 
 * @author Matthias Staud
 *
 *
 *         Description:Utility to
 *         - generate JSON-String from Java Object
 *         - Validate JSON String
 *         - get JsonObject from JSonString
 *
 */
public class JsonBuilder
{
    /**
     * 
     * Description: Convert Object to JSON String
     * 
     * @param object
     * @return
     * @throws JsonProcessingException
     *             Creation: 11.06.2019 by mst
     */
    public static String getJsonStringFromObject(Object object) throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        // Java object to JSON file
        // mapper.writeValue(new File("c:\\temp\\staff.json"), new Staff());

        // Java object to JSON string
        mapper.setSerializationInclusion(Include.NON_NULL);
        String jsonString = mapper.writeValueAsString(object);
        return jsonString;
    }
    
    /**
     * 
     * Description: Return true if it's valid JSON 
     * Source: https://stackoverflow.com/questions/10174898/how-to-check-whether-a-given-string-is-valid-json-in-java
     * 
     * @param jsonString
     * @return
     * Creation: 09.07.2019 by mst
     */
    public static  boolean isJSONValid(String jsonString) {
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
     * 
     * Description: 
     * 
     * @param jsonString
     * @return
     * Creation: 09.07.2019 by mst
     */
    public static JSONObject getJsonObjectFromJsonString(String jsonString)
    {
        return new JSONObject(jsonString);
    }
    
    


}
