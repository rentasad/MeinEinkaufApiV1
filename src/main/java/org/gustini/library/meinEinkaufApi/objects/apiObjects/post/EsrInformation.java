package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import lombok.Data;

/**
 * ESR (Swiss payment slip) information.
 *
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 *
 * @author Matthias Staud
 */
@Data
public class EsrInformation
{
    /** The unique reference number associated with the ESR information */
    private final String referenceNumber;

    /** The bank name */
    private String bankName;

    /** The bank ZIP code */
    private String bankZip;

    /** The bank city */
    private String bankCity;

    /** The bank account */
    private String bankAccount;

    /** The postal account associated with the ESR information */
    private final String postAccount;

    /** The name of the recipient for the ESR transaction */
    private final String recipientName;

    /** The street address of the recipient */
    private final String recipientStreet;

    /** The house number of the recipient */
    private final String recipientHouseNumber;

    /** The ZIP code of the recipient's address */
    private final String recipientZip;

    /** The city of the recipient's address */
    private final String recipientCity;

    /**
     * Constructor for EsrInformation
     *
     * @param referenceNumber The unique reference number
     * @param postAccount The postal account
     * @param recipientName The name of the recipient
     * @param recipientStreet The street address of the recipient
     * @param recipientHouseNumber The house number of the recipient
     * @param recipientZip The ZIP code of the recipient
     * @param recipientCity The city of the recipient
     */
    public EsrInformation(String referenceNumber, String postAccount, String recipientName,
                          String recipientStreet, String recipientHouseNumber,
                          String recipientZip, String recipientCity)
    {
        super();
        this.referenceNumber = referenceNumber;
        this.postAccount = postAccount;
        this.recipientName = recipientName;
        this.recipientStreet = recipientStreet;
        this.recipientHouseNumber = recipientHouseNumber;
        this.recipientZip = recipientZip;
        this.recipientCity = recipientCity;
    }
}
