/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import org.gustini.library.meinEinkaufApi.objects.enums.VatRate;

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
public class DiscountRequest
{
    private final String name;
    private double grossPrice;// (Negativer Wert!)
    private final VatRate vatRate;

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    /**
     * @return the grossPrice
     */
    public double getGrossPrice()
    {
        return grossPrice;
    }
    /**
     * @return the vatRate
     */
    public VatRate getVatRateEnum()
    {
        return vatRate;
    }
    /**
     * @param name
     * @param grossPrice
     * @param vatRate
     */
    public DiscountRequest(
                    String name,
                    double grossPrice,
                    VatRate vatRate)
    {
        super();
        this.name = name;
        this.grossPrice = grossPrice;
        this.vatRate = vatRate;
    }
    /**
     * @return the vatRate
     */
    public VatRate getVatRate()
    {
        return vatRate;
    }
    /**
     * @param grossPrice the grossPrice to set
     */
    public void setGrossPrice(double grossPrice)
    {
        this.grossPrice = grossPrice;
    }

    
}
