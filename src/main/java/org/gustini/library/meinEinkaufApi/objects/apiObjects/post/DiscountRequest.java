package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import lombok.Data;
import org.gustini.library.meinEinkaufApi.objects.enums.VatRate;

/**
 * Discount request information.
 *
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 *
 * @author Matthias Staud
 */
@Data
public class DiscountRequest
{
    /** The name of the discount */
    private final String name;

    /** The gross price of the discount (negative value!) */
    private double grossPrice;

    /** The VAT classification of the discount (e.g., standard, reduced, none) */
    private final VatRate vatRate;

    /**
     * Constructor for DiscountRequest
     *
     * @param name The name of the discount
     * @param grossPrice The gross price of the discount (negative value)
     * @param vatRate The VAT classification of the discount
     */
    public DiscountRequest(String name, double grossPrice, VatRate vatRate)
    {
        super();
        this.name = name;
        this.grossPrice = grossPrice;
        this.vatRate = vatRate;
    }
}
