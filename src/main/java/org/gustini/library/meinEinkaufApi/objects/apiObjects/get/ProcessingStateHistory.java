/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.get;

import org.gustini.library.meinEinkaufApi.objects.enums.ProcessingState;

/**
 * Gustini GmbH (2019)
 * Creation: 08.07.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.objects.apiObjects.post
 * 
 * @author Matthias Staud
 *
 *
 *         Description:
 *
 */
public class ProcessingStateHistory
{
    private final String state;
    private final String changed;

    /**
     * @param Der
     *            entsprechende Bearbeitungsstatus
     * @param changed
     *            Der Zeitpunkt wann die Bestellung in den entsprechenden Status ging (Format ISO-8601)
     */
    public ProcessingStateHistory(
                                  String state,
                                  String changed)
    {
        super();
        this.state = state;
        this.changed = changed;
    }

    public ProcessingStateHistory(
                                  ProcessingState state,
                                  String changed)
    {
        super();
        this.state = state.name();
        this.changed = changed;
    }

    /**
     * Der entsprechende Bearbeitungsstatus
     * 
     * @return the state
     */
    public String getState()
    {
        return state;
    }

    /**
     * Der Zeitpunkt wann die Bestellung in den entsprechenden Status ging (Format ISO-8601)
     * 
     * @return the changed
     */
    public String getChanged()
    {
        return changed;
    }
}
