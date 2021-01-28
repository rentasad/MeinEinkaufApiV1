/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.get;

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
    private ProcessingStateHistory[] processingStateHistory;
    private String processingStateChanged;
    /**
     * Eine Auflistung der einzelnen Sendungen der Bestellung mit zusätzlichen Informationen zu dieser Sendung, 
     * erst vorhanden, wenn processingState "exported" oder "exported_partially"
     */
    private Consignment[] consignments;
    /**
     * @param id
     * @param created
     * @param orderNumber
     * @param orderDate
     * @param processingState
     * @param processingStateHistory
     * @param processingStateChanged
     * @param consignments
     */
    public Order(
                 int id,
                 String created,
                 String orderNumber,
                 String orderDate,
                 ProcessingState processingState,
                 ProcessingStateHistory[] processingStateHistory,
                 String processingStateChanged,
                 Consignment[] consignments)
    {
        super();
        this.id = id;
        this.created = created;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.processingState = processingState;
        this.processingStateHistory = processingStateHistory;
        this.processingStateChanged = processingStateChanged;
        this.consignments = consignments;
    }
    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }
    /**
     * @return the created
     */
    public String getCreated()
    {
        return created;
    }
    /**
     * @param created the created to set
     */
    public void setCreated(String created)
    {
        this.created = created;
    }
    /**
     * @return the orderNumber
     */
    public String getOrderNumber()
    {
        return orderNumber;
    }
    /**
     * @param orderNumber the orderNumber to set
     */
    public void setOrderNumber(String orderNumber)
    {
        this.orderNumber = orderNumber;
    }
    /**
     * @return the orderDate
     */
    public String getOrderDate()
    {
        return orderDate;
    }
    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate)
    {
        this.orderDate = orderDate;
    }
    /**
     * Der aktuelle Bearbeitungsstatus der Bestellung.

["open", "arrival_assumed", "arrived", "partial_delivery_arrived", "verified", "verified_partially", "exported", "exported_partially", "not_arrived"]
     * @return the processingState
     */
    public ProcessingState getProcessingState()
    {
        return processingState;
    }
    /**
     * Der aktuelle Bearbeitungsstatus der Bestellung.

["open", "arrival_assumed", "arrived", "partial_delivery_arrived", "verified", "verified_partially", "exported", "exported_partially", "not_arrived"]
     * @param processingState the processingState to set
     */
    public void setProcessingState(ProcessingState processingState)
    {
        this.processingState = processingState;
    }
    /**
     * Der detaillierte Verlauf der Bearbeitungsstatus
     * @return the processingStateHistory
     */
    public ProcessingStateHistory[] getProcessingStateHistory()
    {
        return processingStateHistory;
    }
    /**
     *      Der detaillierte Verlauf der Bearbeitungsstatus
     * @param processingStateHistory the processingStateHistory to set
     */
    public void setProcessingStateHistory(ProcessingStateHistory[] processingStateHistory)
    {
        this.processingStateHistory = processingStateHistory;
    }
    /**
     *      Der Zeitpunkt der letzten Verarbeitungs-Status Änderung
     * @return the processingStateChanged
     */
    public String getProcessingStateChanged()
    {
        return processingStateChanged;
    }
    /**
     *      Der Zeitpunkt der letzten Verarbeitungs-Status Änderung
     * @param processingStateChanged the processingStateChanged to set
     */
    public void setProcessingStateChanged(String processingStateChanged)
    {
        this.processingStateChanged = processingStateChanged;
    }
    /**
     * Eine Auflistung der einzelnen Sendungen der Bestellung mit zusätzlichen Informationen zu dieser Sendung, erst vorhanden, wenn processingState "exported" oder "exported_partially"
     * @return the consignments
     */
    public Consignment[] getConsignments()
    {
        return consignments;
    }
    /**
     * Eine Auflistung der einzelnen Sendungen der Bestellung mit zusätzlichen Informationen zu dieser Sendung, erst vorhanden, wenn processingState "exported" oder "exported_partially"
     * @param consignments the consignments to set
     */
    public void setConsignments(Consignment[] consignments)
    {
        this.consignments = consignments;
    }
    

}
