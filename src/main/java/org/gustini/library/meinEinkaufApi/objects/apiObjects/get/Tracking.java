/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.get;

import org.gustini.library.meinEinkaufApi.objects.enums.Carrier;

/**
 * Tracking-Object
 * 
 * @author Matthias Staud
 *
 *
 *         Description:
 *
 */
public class Tracking
{
    private Carrier carrier;
    private String trackingNumber;

    /**
     * Das Versandunternehmenen mit welchem die Sendung in der Schweiz versendet wird.
     * 
     * ["swisspost", "dpd", "spedition"]
     * 
     * @return the carrier
     */
    public Carrier getCarrier()
    {
        return carrier;
    }

    /**
     * Das Versandunternehmenen mit welchem die Sendung in der Schweiz versendet wird.
     * 
     * ["swisspost", "dpd", "spedition"]
     * 
     * @param carrier
     *            the carrier to set
     */
    public void setCarrier(Carrier carrier)
    {
        this.carrier = carrier;
    }

    /**
     * Die Trackingnummer
     * @return the trackingNumber
     */
    public String getTrackingNumber()
    {
        return trackingNumber;
    }

    /**
     * Die Trackingnummer
     * @param trackingNumber
     *            the trackingNumber to set
     */
    public void setTrackingNumber(String trackingNumber)
    {
        this.trackingNumber = trackingNumber;
    }

    /**
     * @param carrier
     *            Das Versandunternehmenen mit welchem die Sendung in der Schweiz versendet wird.
     * 
     *            ["swisspost", "dpd", "spedition"]
     * @param trackingNumber Die Trackingnummer
     */
    public Tracking(
                    Carrier carrier,
                    String trackingNumber)
    {
        super();
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
    }

}
