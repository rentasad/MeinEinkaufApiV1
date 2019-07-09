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
     * @param code
     * @param message
     */
    public ResponseErrorObject(
                               String code,
                               String message)
    {
        super();
        this.code = code;
        this.message = message;
    }

}
