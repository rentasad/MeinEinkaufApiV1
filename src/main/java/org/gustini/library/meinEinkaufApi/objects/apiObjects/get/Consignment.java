/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.get;

/**
 * Gustini GmbH (2019)
 * Creation: 08.07.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.objects.apiObjects.get
 * 
 * @author Matthias Staud
 *
 *
 * Description:
 *
 */
public class Consignment
{
    /**
     * Die Trackinginformationen zu dieser Sendung
     */
    private TrackingResponse tracking;
    /**
     *      Die GAS-Trackinginformationen zu dieser Sendung
     */
    private TrackingResponse[] gasLabels;
    /**
     * 
     */
    private String externalId; 
    
    
    /**
     * @param tracking
     * @param gasLabels
     */
    public Consignment(
                TrackingResponse trackingResponse,
                TrackingResponse[] gasLabels)
    {
        super();
        this.tracking = trackingResponse;
        this.gasLabels = gasLabels;
    }
    /**
     * @return the tracking
     */
    public TrackingResponse getTracking()
    {
        return tracking;
    }
    /**
     * @param tracking the tracking to set
     */
    public void setTracking(TrackingResponse trackingResponse)
    {
        this.tracking = trackingResponse;
    }
    /**
     * @return the gasLabels
     */
    public TrackingResponse[] getGasLabels()
    {
        return gasLabels;
    }
    /**
     * @param gasLabels the gasLabels to set
     */
    public void setGas(TrackingResponse[] gasLabels)
    {
        this.gasLabels = gasLabels;
    }
    /**
     * @return the externalId
     */
    public String getExternalId()
    {
        return externalId;
    }
    /**
     * @param externalId the externalId to set
     */
    public void setExternalId(String externalId)
    {
        this.externalId = externalId;
    }
}
