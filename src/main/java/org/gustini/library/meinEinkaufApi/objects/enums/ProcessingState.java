/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.enums;

/**
 * Gustini GmbH (2019)
 * Creation: 08.07.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.objects.enums
 * 
 * @author Matthias Staud
 *
 *
 * Description:Der aktuelle Bearbeitungsstatus der Bestellung. 
 *
 *Name  Beschreibung
 *
 */
public enum ProcessingState
{
    /**
     * Die Bestellung wurde initial von Ihnen bei uns angekündigt
     */
    open, 
    /**
     * Die Bestellung wurde von uns geprüft und die Ankunft wird erwartet
     */
    arrival_assumed,
    /**
     * Die Bestellung ist bei uns eingegangen und wird bearbeitet
     */
    arrived, 
    /**
     * Ein Teil der Bestellung ist bei uns eingegangen und wird bearbeitet (z.B. wenn eine Bestellung aus mehreren Sendungen besteht)
     */
    partial_delivery_arrived, 
    /**
     * Die Bestellung wurde von uns geprüft und für den Versand vorbereitet
     */
    verified, 
    /**
     * Ein Teil der Bestellung wurde von uns geprüft und für den Versand vorbereitet
     */
    verified_partially, 
    /**
     * Die Bestellung wurde in die Schweiz exportiert
     */
    exported, 
    /**
     * Die Bestellung wurde teilweise in die Schweiz exportiert (z.B. wenn eine Bestellung aus mehreren Sendungen besteht)
     */
    exported_partially, 
    /**
     * Die Bestellung ist nach einem gewissen Zeitraum nicht bei uns eingegangen
     */
    not_arrived,
    /**
     * UPDATE 12.12.2019 - Neues ProcessingState "Problem" - nicht dokumentiert, aber in Verwendung.
     */
    problem,
    /**
     * Update nach Info von MeinEinkauf - ein noch fehlender Status
     */
    cancellation
}
