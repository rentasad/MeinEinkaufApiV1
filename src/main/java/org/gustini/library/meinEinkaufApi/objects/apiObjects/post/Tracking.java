package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import lombok.Data;

/**
 * Tracking information for shipments.
 * 
 * ONLY FOR POST-REQUEST
 * 
 * @author Matthias Staud
 */
@Data
public class Tracking
{
    /** The German carrier service of the shipment from you to us */
    private final String carrier;
    
    /** The German tracking number of the shipment from you to us. 
     * This is used to identify the incoming shipment for the order */
    private final String trackingNumber;

    /**
     * Constructor for Tracking
     * 
     * @param carrier The German carrier service of the shipment from you to us
     * @param trackingNumber The German tracking number of the shipment from you to us
     */
    public Tracking(String carrier, String trackingNumber)
    {
        super();
        this.carrier = carrier;
        this.trackingNumber = trackingNumber;
    }
}
