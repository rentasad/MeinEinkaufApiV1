/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects;

/**
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 * application.meineinkauf
 * org.gustini.library.meinEinkaufApi.objects
 * 
 * @author Matthias Staud
 *
 *
 *         Description: Lieferkosten (ShippingCost-Object)
 *
 */
public class ShippingCost
{
    private final double grossPrice;
    private final VatRateEnum vatRate;

    /**
     * @param grossPrice
     *            Die Lieferkosten, Pflicht wenn ShippingCost-Object vorhanden
     * @param vatRate
     *            Der Mehrwertsteuerklassifizierung der Versandkosten
     * 
     *            [ "standard", "reduced", "none" ]
     */
    public ShippingCost(
                        double grossPrice,
                        VatRateEnum vatRate)
    {
        super();
        this.grossPrice = grossPrice;
        this.vatRate = vatRate;
    }

    /**
     * Die Lieferkosten, Pflicht wenn ShippingCost-Object vorhanden
     * 
     * @return the grossPrice
     */
    public double getGrossPrice()
    {
        return grossPrice;
    }

    /**
     * Der Mehrwertsteuerklassifizierung der Versandkosten
     * 
     * [ "standard", "reduced", "none" ]
     * 
     * @return the vatRate
     */
    public VatRateEnum getVatRate()
    {
        return vatRate;
    }

}
