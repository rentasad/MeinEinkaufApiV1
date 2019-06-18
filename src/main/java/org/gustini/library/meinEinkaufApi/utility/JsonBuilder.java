/**
 * 
 */
package org.gustini.library.meinEinkaufApi.utility;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.utility
 * 
 * @author Matthias Staud
 *
 *
 *         Description:
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

}
