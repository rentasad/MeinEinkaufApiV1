/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.response;

/**
 * Gustini GmbH (2019)
 * Creation: 09.07.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.objects.apiObjects.response
 * 
 * @author Matthias Staud
 *
 *
 * Description:
 *
 */
public class ResponseErrorObject
{
    String code;
    String message;
    String property;
    String jsonValue;
    /**
     * @return the code
     */
    public String getCode()
    {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code)
    {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message)
    {
        this.message = message;
    }



    /**
     * @return the property
     */
    public String getProperty()
    {
        return property;
    }

    /**
     * @param property the property to set
     */
    public void setProperty(String property)
    {
        this.property = property;
    }

    /**
     * @param code
     * @param message
     * @param property
     */
    public ResponseErrorObject(
                               String code,
                               String message,
                               String property)
    {
        super();
        this.code = code;
        this.message = message;
        this.property = property;
    }

    /**
     * @return the jsonValue
     */
    public String getJsonValue()
    {
        return jsonValue;
    }

    /**
     * @param jsonValue the jsonValue to set
     */
    public void setJsonValue(String jsonValue)
    {
        this.jsonValue = jsonValue;
    }

}
