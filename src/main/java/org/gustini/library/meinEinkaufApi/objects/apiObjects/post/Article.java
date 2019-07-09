/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import org.gustini.library.meinEinkaufApi.objects.enums.VatRate;

/**
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 * application.meineinkauf
 * org.gustini.library.meinEinkaufApi.objects
 * 
 * @author Matthias Staud
 *
 *
 * Description:
 *
 */
public class Article
{
    
    private final String articleNumber;
    private final String name;
    private final Integer quantity;
    private double grossWeight;
    private final double grossPrice;
    private final VatRate vatRate;
    private Attributes attributes;
    /**
     * @param articleNumber
     * @param name
     * @param quantity
     * @param grossPrice
     * @param vatRate
     */
    public Article(
                   String articleNumber,
                   String name,
                   Integer quantity,
                   double grossPrice,
                   VatRate vatRate)
    {
        super();
        this.articleNumber = articleNumber;
        this.name = name;
        this.quantity = quantity;
        this.grossPrice = grossPrice;
        this.vatRate = vatRate;
    }
    /**
     * @return the grossWeight
     */
    public double getGrossWeight()
    {
        return grossWeight;
    }
    /**
     * @param grossWeight the grossWeight to set
     */
    public void setGrossWeight(double grossWeight)
    {
        this.grossWeight = grossWeight;
    }
    /**
     * @return the attributes
     */
    public Attributes getAttributes()
    {
        return attributes;
    }
    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(Attributes attributes)
    {
        this.attributes = attributes;
    }
    /**
     * @return the articleNumber
     */
    public String getArticleNumber()
    {
        return articleNumber;
    }
    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }
    /**
     * @return the quantity
     */
    public Integer getQuantity()
    {
        return quantity;
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
    public VatRate getVatRate()
    {
        return vatRate;
    }



}
