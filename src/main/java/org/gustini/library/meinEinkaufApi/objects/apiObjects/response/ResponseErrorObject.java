/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.response;

import lombok.Getter;
import lombok.Setter;

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
@Setter
@Getter
public class ResponseErrorObject
{
    /**
     * -- GETTER --
     *
     *
     * -- SETTER --
     *
     @return the code
      * @param code
      *            the code to set
     */
    String code;
    /**
     * -- GETTER --
     *
     *
     * -- SETTER --
     *
     @return the message
      * @param message
      *            the message to set
     */
    String message;
    /**
     * -- GETTER --
     *
     *
     * -- SETTER --
     *
     @return the property
      * @param property the property to set
     */
    String property;
    /**
     * -- GETTER --
     *
     *
     * -- SETTER --
     *
     @return the jsonValue
      * @param jsonValue the jsonValue to set
     */
    String jsonValue;


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

}
