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
    private Tracking tracking;
    /**
     *      Die GAS-Trackinginformationen zu dieser Sendung
     */
    private Tracking gas;
    /**
     * @param tracking
     * @param gas
     */
    public Consignment(
                Tracking tracking,
                Tracking gas)
    {
        super();
        this.tracking = tracking;
        this.gas = gas;
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
     * @return the gas
     */
    public Tracking getGas()
    {
        return gas;
    }
    /**
     * @param gas the gas to set
     */
    public void setGas(Tracking gas)
    {
        this.gas = gas;
    }
}
