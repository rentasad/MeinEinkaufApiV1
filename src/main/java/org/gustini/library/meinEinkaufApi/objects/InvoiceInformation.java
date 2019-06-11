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
 *         Description:
 * 
 *         invoiceDate String 2018-02-21 Nein Das Rechnungsdatum der Rechnung für den Endkunden im Format "YYYY-MM-DD" ISO-8601 (MEZ/MESZ), falls nicht gesetzt, wird das Bestelldatum genommen
 *         dueDate String 2018-03-21 Nein Das Fälligkeitsdatum der Rechnung für den Endkunden im Format "YYYY-MM-DD" ISO-8601 (MEZ/MESZ), falls nicht gesetzt, wird das Rechnungsdatum plus 20 Tage
 *         genommen
 *         additionalInvoiceText String Vielen Dank! Nein Ein zusätzlicher Freitext auf der Rechnung
 *         esrInformation EsrInformation-Object Nein* Die Informationen für den Einzahlungsschein
 * 
 *         Pflicht wenn Zahlart Rechnung
 *
 */
public class InvoiceInformation
{
    private String invoiceDate;
    private String dueDate;
    private String additionalInvoiceText;
    private EsrInformation esrInformation;
    /**
     * @return the invoiceDate
     */
    public String getInvoiceDate()
    {
        return invoiceDate;
    }
    /**
     * @param invoiceDate the invoiceDate to set
     */
    public void setInvoiceDate(String invoiceDate)
    {
        this.invoiceDate = invoiceDate;
    }
    /**
     * @return the dueDate
     */
    public String getDueDate()
    {
        return dueDate;
    }
    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(String dueDate)
    {
        this.dueDate = dueDate;
    }
    /**
     * @return the additionalInvoiceText
     */
    public String getAdditionalInvoiceText()
    {
        return additionalInvoiceText;
    }
    /**
     * @param additionalInvoiceText the additionalInvoiceText to set
     */
    public void setAdditionalInvoiceText(String additionalInvoiceText)
    {
        this.additionalInvoiceText = additionalInvoiceText;
    }
    /**
     * @return the esrInformation
     */
    public EsrInformation getEsrInformation()
    {
        return esrInformation;
    }
    /**
     * @param esrInformation the esrInformation to set
     */
    public void setEsrInformation(EsrInformation esrInformation)
    {
        this.esrInformation = esrInformation;
    }
    /**
     * 
     */
    public InvoiceInformation()
    {
        super();
    }




}
