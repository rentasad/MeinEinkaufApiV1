/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

/**
 * Tracking-Informationen (Tracking-Object)
 * ONLY FOR POST-REQUEST
 * @author Matthias Staud
 *
 *
 * Description:
 *
 */
public class Tracking
{
    private final String carrier;
    private final String trackingNumber;

    /**
     * @param carrier  Der deutsche Lieferdienst der Sendung von Ihnen zu uns.
     * @param trackingNumber Die deutsche Trackingnummer der Sendung von Ihnen zu uns. Dies dient für uns zur Identifizierung der eingehenden Sendung zur Bestellung
     */
    public Tracking(
                    String carrier,
                    String trackingNumber)
    {
        super();
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
    }

    /**
     * 
     * Der deutsche Lieferdienst der Sendung von Ihnen zu uns.
     * @return the carrier
     */
    public String getCarrier()
    {
        return carrier;
    }

    /**
     * Die deutsche Trackingnummer der Sendung von Ihnen zu uns. Dies dient für uns zur Identifizierung der eingehenden Sendung zur Bestellung
     * @return the trackingNumber
     */
    public String getTrackingNumber()
    {
        return trackingNumber;
    } 

}
