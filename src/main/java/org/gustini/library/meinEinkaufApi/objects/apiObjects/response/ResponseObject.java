/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.response;

import org.json.JSONArray;
import org.json.JSONObject;

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
public class ResponseObject
{
    boolean success;
    ResponseErrorObject[] errors;
    JSONArray ordersJSONArray;
    boolean hasValues;
    int limit;
    int count;
    int offset;
    /**
     * @param success
     * @param errors
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
     * @return the success
     */
    public boolean isSuccess()
    {
        return success;
    }

    /**
     * @param success
     *            the success to set
     */
    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    /**
     * @return the errors
     */
    public ResponseErrorObject[] getErrors()
    {
        return errors;
    }

    /**
     * @param errors
     *            the errors to set
     */
    public void setErrors(ResponseErrorObject[] errors)
    {
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

    /**
     * @param hasValues the hasValues to set
     */
    public void setHasValues(boolean hasValues)
    {
        this.hasValues = hasValues;
    }

    /**
     * @return the limit
     */
    public int getLimit()
    {
        return limit;
    }

    /**
     * @param limit the limit to set
     */
    public void setLimit(int limit)
    {
        this.limit = limit;
    }

    /**
     * @return the count
     */
    public int getCount()
    {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count)
    {
        this.count = count;
    }

    /**
     * @return the offset
     */
    public int getOffset()
    {
        return offset;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(int offset)
    {
        this.offset = offset;
    }

    /**
     * @return the ordersJSONArray
     */
    public JSONArray getOrdersJSONArray()
    {
        return ordersJSONArray;
    }

    /**
     * @param ordersJSONArray the ordersJSONArray to set
     */
    public void setOrdersJSONArray(JSONArray ordersJSONArray)
    {
        this.ordersJSONArray = ordersJSONArray;
    }


}
