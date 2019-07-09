/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.get;

/**
 * Gustini GmbH (2019)
 * Creation: 08.07.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.objects.apiObjects.get
 * 
 * @author Matthias Staud
 *
 *
 * Description:
 *
 */
public class Consignment
{
    /**
     * Die Trackinginformationen zu dieser Sendung
     */
    private String tracking;
    /**
     *      Die GAS-Trackinginformationen zu dieser Sendung
     */
    private String gas;
    /**
     * @param tracking
     * @param gas
     */
    public Consignment(
                       String tracking,
                       String gas)
    {
        super();
        this.tracking = tracking;
        this.gas = gas;
    }
    /**
     * @return the tracking
     */
    public String getTracking()
    {
        return tracking;
    }
    /**
     * @param tracking the tracking to set
     */
    public void setTracking(String tracking)
    {
        this.tracking = tracking;
    }
    /**
     * @return the gas
     */
    public String getGas()
    {
        return gas;
    }
    /**
     * @param gas the gas to set
     */
    public void setGas(String gas)
    {
        this.gas = gas;
    }
}
