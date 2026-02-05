package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import lombok.Data;
import org.gustini.library.meinEinkaufApi.objects.enums.VatRate;

/**
 * Article information.
 *
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 *
 * @author Matthias Staud
 */
@Data
public class Article
{
    /** The article number */
    private final String articleNumber;

    /** The name of the article */
    private final String name;

    /** The quantity of the article */
    private final Integer quantity;

    /** The gross weight of the article */
    private double grossWeight;

    /** The gross price of the article */
    private final double grossPrice;

    /** The VAT rate for the article */
    private final VatRate vatRate;

    /** External identifier */
    private String externalId;

    /** Article attributes (optional) */
    private Attributes attributes;

    /**
     * Constructor for Article
     *
     * @param articleNumber The article number
     * @param name The name of the article
     * @param quantity The quantity
     * @param grossPrice The gross price
     * @param vatRate The VAT rate
     */
    public Article(String articleNumber, String name, Integer quantity,
                   double grossPrice, VatRate vatRate)
    {
        super();
        this.articleNumber = articleNumber;
        this.name = name;
        this.quantity = quantity;
        this.grossPrice = grossPrice;
        this.vatRate = vatRate;
    }
}
