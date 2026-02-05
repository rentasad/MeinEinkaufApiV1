/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.response;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;

/**
 * Gustini GmbH (2019)
 * Creation: 09.07.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.objects.apiObjects
 * 
 * @author Matthias Staud
 *
 *
 *         Description:
 *
 */
@Setter
public class ResponseObject
{

    @Getter
    boolean success;

    @Getter
    ResponseErrorObject[] errors;

    @Getter
    JSONArray ordersJSONArray;

    boolean hasValues;

    @Getter
    int limit;

    @Getter
    int count;

    @Getter
    int offset;

    /**
     * Constructs a new ResponseObject.
     *
     * @param success a boolean indicating whether the operation was successful
     * @param errors an array of ResponseErrorObject instances representing the errors encountered
     */
    public ResponseObject(
                          boolean success,
                          ResponseErrorObject[] errors)
    {
        super();
        this.success = success;
        this.errors = errors;
    }


    /**
     * Return true if ResponseObject contains Order Informations
     * @return the hasValues
     */
    public boolean hasValues()
    {
        return hasValues;
    }


}
