package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import lombok.Data;

/**
 * Article attributes.
 *
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 *
 * @author Matthias Staud
 */
@Data
public class Attributes
{
    /** Color of the article */
    private String color;

    /** Description of the article */
    private String description;

    /** Material of the article */
    private String material;

    /** URL of the article */
    private String url;

    /** EAN (European Article Number) */
    private String ean;

    /** UPC (Universal Product Code) */
    private String upc;

    /** ASIN (Amazon Standard Identification Number) */
    private String asin;

    /** Custom identification code */
    private String customIdentCode;

    /** Size of the article */
    private String size;
}
