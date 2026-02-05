package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import lombok.Data;

/**
 * Consignment object.
 * 
 * For each shipment we receive from you, a consignment object must be included in the array.
 * 
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 * 
 * @author Matthias Staud
 */
@Data
public class Consignment
{
    /** The gross weight of the consignment */
    private double grossWeight;
    
    /** Tracking information */
    private Tracking tracking; 
    
    /** The articles included in this consignment */
    private final Article[] articles;
    
    /** External identifier */
    private String externalId;
    
    /**
     * Constructor for Consignment
     * 
     * @param articles The articles included in this consignment
     */
    public Consignment(Article[] articles)
    {
        super();
        this.articles = articles;
    }
}
