package org.gustini.library.meinEinkaufApi.objects.apiObjects;
/**
 * 
 * Gustini GmbH (2019)
 * Creation: 17.06.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.objects.apiObjects
 * 
 * @author Matthias Staud
 *
 *
 * Description:
 *
 */

import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpResponse;

@Setter
@Getter
public class MeinEinkaufRequestException extends Exception
{
    /**
     * -- GETTER --
     *
     *
     * -- SETTER --
     *
     @return the httpResponse
      * @param httpResponse the httpResponse to set
     */
    private HttpResponse httpResponse = null;
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * @param httpResponse
     */
    public MeinEinkaufRequestException(
                                       HttpResponse httpResponse)
    {
        super();
        this.httpResponse = httpResponse;
    }

    /**
     * 
     */
    public MeinEinkaufRequestException()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     */
    public MeinEinkaufRequestException(
                                       String arg0,
                                       Throwable arg1,
                                       boolean arg2,
                                       boolean arg3)
    {
        super(arg0, arg1, arg2, arg3);
        // TODO Auto-generated constructor stub
    }
    /**
     * @param arg0
     * @param arg1
     */
    public MeinEinkaufRequestException(
                                       String arg0,
                                       Throwable arg1)
    {
        super(arg0, arg1);
        // TODO Auto-generated constructor stub
    }
    /**
     * @param arg0
     */
    public MeinEinkaufRequestException(
                                       String arg0)
    {
        super(arg0);
        // TODO Auto-generated constructor stub
    }
    /**
     * @param arg0
     */
    public MeinEinkaufRequestException(
                                       Throwable arg0)
    {
        super(arg0);
        // TODO Auto-generated constructor stub
    }

}
