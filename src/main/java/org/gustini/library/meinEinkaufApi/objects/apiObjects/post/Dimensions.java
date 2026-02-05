package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import lombok.Data;

/**
 * Dimensions of the shipment.
 * 
 * Gustini GmbH (2019)
 * Creation: 30.10.2019
 * 
 * @author Matthias Staud
 * @deprecated This class is deprecated
 */
@Deprecated
@Data
public class Dimensions
{
    /** The width of the shipment in mm (integer >= 1) */
    private final Integer width;
    
    /** The height of the shipment in mm (integer >= 1) */
    private final Integer height;
    
    /** The length of the shipment in mm (integer >= 1) */
    private final Integer length;

    /**
     * Constructor for Dimensions
     * 
     * @param width The width of the shipment in mm
     * @param height The height of the shipment in mm
     * @param length The length of the shipment in mm
     */
    public Dimensions(Integer width, Integer height, Integer length)
    {
        super();
        this.width = width;
        this.height = height;
        this.length = length;
    }
}
