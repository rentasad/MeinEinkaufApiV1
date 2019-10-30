/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

/**
 * Gustini GmbH (2019)
 * Creation: 30.10.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.objects.apiObjects.post
 * 
 * @author Matthias Staud
 *
 *
 *         Description:Die Abmessungen der Sendung
 *
 */
public class Dimensions
{
    private final Integer width;
    private final Integer height;
    private final Integer length;

    /**
     * @return the width
     * 
     *         integer >= 1
     * 
     *         Die Breite der Sendung in mm
     * 
     */
    public Integer getWidth()
    {
        return width;
    }

    /**
     * @return the length
     *         integer >= 1
     * 
     *         Die Länge der Sendung in mm
     * 
     */
    public Integer getLength()
    {
        return length;
    }

    /**
     * @param width
     * @param height
     * @param length
     */
    public Dimensions(
                      Integer width,
                      Integer height,
                      Integer length)
    {
        super();
        this.width = width;
        this.height = height;
        this.length = length;
    }

    /**
     * @return the height
     * Die Höhe der Sendung in mm >= 1
     */
    public Integer getHeight()
    {
        return height;
    }
}
