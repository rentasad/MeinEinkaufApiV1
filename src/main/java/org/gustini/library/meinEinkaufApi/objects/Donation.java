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
public class Donation
{
    private final String name;
    private final double grossPrice;// Der Bruttopreis der Spende
    private final VatRateEnum vatRateEnum;
    /**
     * @param name
     * @param grossPrice
     * @param vatRateEnum
     */
    public Donation(
                    String name,
                    double grossPrice,
                    VatRateEnum vatRateEnum)
    {
        super();
        this.name = name;
        this.grossPrice = grossPrice;
        this.vatRateEnum = vatRateEnum;
    }
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
     * @return the vatRateEnum
     */
    public VatRateEnum getVatRateEnum()
    {
        return vatRateEnum;
    }
    
}