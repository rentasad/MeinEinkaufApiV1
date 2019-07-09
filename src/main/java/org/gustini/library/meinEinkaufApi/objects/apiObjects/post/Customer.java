/**
 * 
 */
package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

/**
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 * application.meineinkauf
 * org.gustini.library.meinEinkaufApi.objects
 * 
 * @author Matthias Staud
 *
 *
 *         Description:
 *         Name Typ Beispiel Pflichtfeld Hinweis
 *         customerNumber String kunde1234 Ja Eine eindeutige Refernz auf Ihren Kunden, z.B. die Kundennummer
 *         contactEmail String max@muster.de Nein Kontakt-Email-Adresse des Kunden z.B. f�r den Avisierungsservice der SwissPost
 *
 */
public class Customer
{

    /**
     * Eine eindeutige Refernz auf Ihren Kunden, z.B. die Kundennummer
     * 
     * @param customerNumber
     */
    public Customer(
                    String customerNumber)
    {
        this.customerNumber = customerNumber;
    }

    /**
     * @param customerNumber Eine eindeutige Refernz auf Ihren Kunden, z.B. die Kundennummer
     * @param contactEmail Kontakt-Email-Adresse des Kunden z.B. für den Avisierungsservice der SwissPost
     */
    public Customer(
                    String customerNumber,
                    String contactEmail)
    {
        this.customerNumber = customerNumber;
        this.contactEmail = contactEmail;
    }

    private final String customerNumber;
    private String contactEmail;

    /**
     * Kontakt-Email-Adresse des Kunden z.B. für den Avisierungsservice der SwissPost
     * @return the contactEmail
     */
    public String getContactEmail()
    {
        return contactEmail;
    }

    /**
     * @param contactEmail
     *            the contactEmail to set
     */
    public void setContactEmail(String contactEmail)
    {
        this.contactEmail = contactEmail;
    }

    /**
     * Eine eindeutige Refernz auf Ihren Kunden, z.B. die Kundennummer
     * @return the customerNumber
     */
    public String getCustomerNumber()
    {
        return customerNumber;
    }

}
