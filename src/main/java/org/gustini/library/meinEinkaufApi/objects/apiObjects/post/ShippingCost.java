package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import lombok.Data;
import org.gustini.library.meinEinkaufApi.objects.enums.VatRate;

/**
 * Shipping cost information.
 *
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 *
 * @author Matthias Staud
 */
@Data
public class ShippingCost
{
    /** The shipping costs. Required when ShippingCost object is present */
    private final double grossPrice;

    /** The VAT classification of the shipping costs ["standard", "reduced", "none"] */
    private final VatRate vatRate;

    /**
     * Constructor for ShippingCost
     *
     * @param grossPrice The shipping costs (required when ShippingCost object is present)
     * @param vatRate The VAT classification of the shipping costs ["standard", "reduced", "none"]
     */
    public ShippingCost(double grossPrice, VatRate vatRate)
    {
        super();
        this.grossPrice = grossPrice;
        this.vatRate = vatRate;
    }
}
