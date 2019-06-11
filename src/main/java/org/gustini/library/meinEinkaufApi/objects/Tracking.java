/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects;

/**
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.objects
 * 
 * @author Matthias Staud
 *
 *
 * Description:
 *
 */
public class Tracking
{
    private String carrier;
    private String trackingNumber;
    /**
     * @return the carrier
     */
    public String getCarrier()
    {
        return carrier;
    }
    /**
     * @param carrier the carrier to set
     */
    public void setCarrier(String carrier)
    {
        this.carrier = carrier;
    }
    /**
     * @return the trackingNumber
     */
    public String getTrackingNumber()
    {
        return trackingNumber;
    }
    /**
     * @param trackingNumber the trackingNumber to set
     */
    public void setTrackingNumber(String trackingNumber)
    {
        this.trackingNumber = trackingNumber;
    }
    
}
