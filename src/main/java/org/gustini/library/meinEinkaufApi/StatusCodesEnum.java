/**
 * 
 */
package org.gustini.library.meinEinkaufApi;

import org.gustini.library.meinEinkaufApi.objects.apiObjects.MeinEinkaufRequestException;

/**
 * Gustini GmbH (2019)
 * Creation: 17.06.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi
 * 
 * @author Matthias Staud
 *
 *
 * Description:
 * 
    200 OK - Der Request war erfolgreich.
    201 Created - Die übermittelten Daten wurden erfolgreich verarbeitet und es wurde zum Beispiel eine Bestellung erstellt.
    400 Bad Request - Der Endpunkt existiert nicht oder wurde mit einer falschen HTTP-Methode aufgerufen.
    401 Unauthorized - Der Request konnte nicht authentifiziert werden.
    422 Unprocessable Entity - Die übermittelten Daten waren nicht valide.
    500 Internal Server Error - Es gab ein Problem auf unserer Seite und wir arbeiten schnellstmöglich an einer Lösung. Die übermittelten Daten wurden in der Regel nicht verarbeitet und ihr System muss den Request zu einem späteren Zeitpunkt erneut senden.
    503 Service Unavailable - Während planmäßiger Wartungsarbeiten wird dieser Status zurückgegeben. Die übermittelten Daten wurden nicht verarbeitet und ihr System muss den Request zu einem späteren Zeitpunkt erneut senden.

 *
 */
public enum StatusCodesEnum
{
    /**
     * 200 OK - Der Request war erfolgreich.
     */
    OK_200,
    /**
     * 201 Created - Die übermittelten Daten wurden erfolgreich verarbeitet und es wurde zum Beispiel eine Bestellung erstellt.
     */
    CREATED_201,
    /**
     * 400 Bad Request - Der Endpunkt existiert nicht oder wurde mit einer falschen HTTP-Methode aufgerufen.
     */
    BAD_REQUEST_400,
    /**
     * 401 Unauthorized - Der Request konnte nicht authentifiziert werden.
     */
    UNAUTHORIZED_401,
    /**
     * 422 Unprocessable Entity - Die übermittelten Daten waren nicht valide.
     */
    UNPROCESSABLE_ENTITY_422,
    /**
     * 500 Internal Server Error - Es gab ein Problem auf unserer Seite und wir arbeiten schnellstmöglich an einer Lösung. Die übermittelten Daten wurden in der Regel nicht verarbeitet und ihr System muss den Request zu einem späteren Zeitpunkt erneut senden.
     */
    INTERNAL_SERVER_ERROR_500,
    /**
     * 503 Service Unavailable - Während planmäßiger Wartungsarbeiten wird dieser Status zurückgegeben. Die übermittelten Daten wurden nicht verarbeitet und ihr System muss den Request zu einem späteren Zeitpunkt erneut senden.
     */
    SERVICE_UNAVAILABLE_503;
    
    
    /**
     * 
     * Description: 
     * 
     * @param statusInt
     * @return
     * @throws MeinEinkaufRequestException
     * Creation: 17.06.2019 by mst
     */
    public static StatusCodesEnum getStatusCodesEnumFromStatusInteger (final int statusInt) throws MeinEinkaufRequestException
    {
        switch (statusInt)
        {
            case 200:
                return StatusCodesEnum.OK_200;
            case 201:
                return StatusCodesEnum.CREATED_201;
            case 400:
                return StatusCodesEnum.BAD_REQUEST_400;
            case 401:
                return StatusCodesEnum.UNAUTHORIZED_401;
            case 500:
                return StatusCodesEnum.INTERNAL_SERVER_ERROR_500;
            case 503:
                return StatusCodesEnum.SERVICE_UNAVAILABLE_503;
            case 422:
                return StatusCodesEnum.UNPROCESSABLE_ENTITY_422;
            default:
                throw new MeinEinkaufRequestException("Unkown Statuscode returned: " + statusInt);
        }
        
    }
    
}


