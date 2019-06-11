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
 * Description: Sendung (Consignment-Object)
 *Für jede Sendung, die wir von Ihnen erhalten, muss ein Sendungs-Objekt in dem Array enthalten sein
 */
public class Consignment
{
    private double grossWeight;
    private Tracking tracking; 
    private final Article[] articles;
    /**
     * @param articles
     */
    public Consignment(
                       Article[] articles)
    {
        super();
        this.articles = articles;
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
     * @return the tracking
     */
    public Tracking getTracking()
    {
        return tracking;
    }
    /**
     * @param tracking the tracking to set
     */
    public void setTracking(Tracking tracking)
    {
        this.tracking = tracking;
    }
    /**
     * @return the articles
     */
    public Article[] getArticles()
    {
        return articles;
    }


}
