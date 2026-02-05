package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import lombok.Data;
import org.gustini.library.meinEinkaufApi.objects.enums.VatRate;

/**
 * Donation information.
 *
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 *
 * @author Matthias Staud
 */
@Data
public class Donation
{
    /** The name of the donation */
    private final String name;

    /** The gross price of the donation */
    private final double grossPrice;

    /** The VAT rate associated with the donation */
    private final VatRate vatRate;

    /**
     * Constructor for Donation
     *
     * @param name The name of the donation
     * @param grossPrice The gross price of the donation
     * @param vatRate The VAT rate associated with the donation
     */
    public Donation(String name, double grossPrice, VatRate vatRate)
    {
        super();
        this.name = name;
        this.grossPrice = grossPrice;
        this.vatRate = vatRate;
    }
}
