/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.get;

import org.gustini.library.meinEinkaufApi.objects.apiObjects.post.Consignment;
import org.gustini.library.meinEinkaufApi.objects.enums.ProcessingState;

/**
 * Gustini GmbH (2019)
 * Creation: 08.07.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.objects.apiObjects.get
 * 
 * @author Matthias Staud
 *
 *
 *         Description: Order-Object for GET-Request
 *
 *         Name Typ Hinweis
 *         id Integer Ein eindeutiger Identifizierer der Bestellung
 *         created String Der Zeitpunkt der Bestellungsankündigung
 *         orderNumber String Die Bestellnummer
 *         orderDate String Das Bestelldatum
 * 
 *         processingState Enum[String] Der aktuelle Bearbeitungsstatus der Bestellung.
 * 
 *         ["open", "arrival_assumed", "arrived", "partial_delivery_arrived", "verified", "verified_partially", "exported", "exported_partially", "not_arrived"]
 * 
 *         Eine detaillierte Beschreibung hierzu finden Sie hier.
 *         processingStateHistory Array[processingStateHistory-Object] Der detaillierte Verlauf der Bearbeitungsstatus
 *         processingStateChanged String Der Zeitpunkt der letzten Verarbeitungs-Status Änderung
 *         consignments Array[Consignment-Object] Eine Auflistung der einzelnen Sendungen der Bestellung mit zusätzlichen Informationen zu dieser Sendung, erst vorhanden, wenn processingState
 *         "exported" oder "exported_partially"
 */
public class Order
{
    private int id;
    private String created;
    private String orderNumber;
    private String orderDate;
    private ProcessingState processingState;
    private ProcessingState[] processingStateHistory;
    private String processingStateChanged;
    /**
     * Eine Auflistung der einzelnen Sendungen der Bestellung mit zusätzlichen Informationen zu dieser Sendung, 
     * erst vorhanden, wenn processingState "exported" oder "exported_partially"
     */
    private Consignment[] consignments;
    

}
