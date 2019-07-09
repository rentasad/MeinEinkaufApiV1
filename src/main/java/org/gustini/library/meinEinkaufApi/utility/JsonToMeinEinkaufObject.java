/**
 * 
 */
package org.gustini.library.meinEinkaufApi.utility;

import java.util.ArrayList;
import java.util.Set;

import org.gustini.library.meinEinkaufApi.objects.apiObjects.response.ResponseErrorObject;
import org.gustini.library.meinEinkaufApi.objects.apiObjects.response.ResponseObject;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Gustini GmbH (2019)
 * Creation: 09.07.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.utility
 * 
 * @author Matthias Staud
 *
 *
 *         Description:
 *
 */
public class JsonToMeinEinkaufObject
{
    /**
     * 
     * Description:
     * 
     * @param resultJsonString
     * @return
     *         Creation: 09.07.2019 by mst
     */
    public static ResponseObject getResponseObjectFromJsonString(String resultJsonString)
    {
        ResponseObject responseObject = null;
        if (JsonBuilder.isJSONValid(resultJsonString))
        {
            JSONObject jo = JsonBuilder.getJsonObjectFromJsonString(resultJsonString);
            if (isValidResponseValueFromMeinEinkauf(jo))
            {
                boolean success = jo.getBoolean("success");
                ArrayList<ResponseErrorObject> errorsArrayList = new ArrayList<>();
                JSONArray joArray = jo.getJSONArray("errors");
                // Wenn Fehler vorhanden sind erstelle ResponseErrorObjects
                for (Object errorJsonObject : joArray)
                {
                    if (errorJsonObject instanceof JSONObject)
                    {
                        String code = ((JSONObject) errorJsonObject).getString("code");
                        String message = ((JSONObject) errorJsonObject).getString("message");
                        ResponseErrorObject errorObject = new ResponseErrorObject(code, message);
                        errorsArrayList.add(errorObject);
                    }
                    
                }
                responseObject = new ResponseObject(success, errorsArrayList.toArray(new ResponseErrorObject[0]));
                // Prüfe ob es Orders gibt
                if (jo.has("orders"))
                {
                    boolean hasValues = true;
                    int limit = jo.getInt("limit");
                    int count = jo.getInt("count");;
                    int offset = jo.getInt("offset");
                    responseObject.setOffset(offset);
                    responseObject.setLimit(limit);
                    responseObject.setCount(count);
                    responseObject.setOrdersJSONArray(jo.getJSONArray("orders"));
                    responseObject.setHasValues(hasValues);
                }
                
                
                
                

            }

            return responseObject;
        } else
        {
            return null;
        }

    }

    /**
     * 
     * Description: Prüft ob die Elemente der ersten Ebene des JSONObjekts vorhanden sind.
     * 
     * @param jo
     * @return
     *         Creation: 09.07.2019 by mst
     */
    protected static boolean isValidResponseValueFromMeinEinkauf(JSONObject jo)
    {
        String[] neededKeys =
        { "success", "errors" };
        Set<String> avaibleKeySet = jo.keySet();
        boolean valid = true;
        for (String key : neededKeys)
        {
            valid = valid && jo.has(key);
        }

        return valid;
    }

    /**
     * 
     * Description: 
     * 
     * @param orderJsonArray
     * Creation: 09.07.2019 by mst
     */
    public static void getOrderResponsesFromJsonarray(JSONArray orderJsonArray)
    {
        
        
        
    }

}
