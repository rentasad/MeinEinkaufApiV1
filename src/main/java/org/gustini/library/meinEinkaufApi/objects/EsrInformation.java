package org.gustini.library.meinEinkaufApi.objects;
/**
 * 
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 * gustini.library.meinEinkaufApi
 * org.gustini.library.meinEinkaufApi.objects
 * 
 * @author Matthias Staud
 *
 *
 * Description:ESR Informationen (EsrInformation-Object)
 *
 */
public class EsrInformation
{
    private final String referenceNumber;
    private String bankName;
    private String bankZip;
    private String bankCity;
    private String bankAccount;
    private final String postAccount;
    private final String recipientName;
    private final String recipientStreet;
    private final String recipientHouseNumber;
    private final String recipientZip;
    private final String recipientCity;
    /**
     * @param referenceNumber
     * @param postAccount
     * @param recipientName
     * @param recipientStreet
     * @param recipientHouseNumber
     * @param recipientZip
     * @param recipientCity
     */
    public EsrInformation(
                          String referenceNumber,
                          String postAccount,
                          String recipientName,
                          String recipientStreet,
                          String recipientHouseNumber,
                          String recipientZip,
                          String recipientCity)
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
    /**
     * @return the bankName
     */
    public String getBankName()
    {
        return bankName;
    }
    /**
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }
    /**
     * @return the bankZip
     */
    public String getBankZip()
    {
        return bankZip;
    }
    /**
     * @param bankZip the bankZip to set
     */
    public void setBankZip(String bankZip)
    {
        this.bankZip = bankZip;
    }
    /**
     * @return the bankCity
     */
    public String getBankCity()
    {
        return bankCity;
    }
    /**
     * @param bankCity the bankCity to set
     */
    public void setBankCity(String bankCity)
    {
        this.bankCity = bankCity;
    }
    /**
     * @return the bankAccount
     */
    public String getBankAccount()
    {
        return bankAccount;
    }
    /**
     * @param bankAccount the bankAccount to set
     */
    public void setBankAccount(String bankAccount)
    {
        this.bankAccount = bankAccount;
    }
    /**
     * @return the referenceNumber
     */
    public String getReferenceNumber()
    {
        return referenceNumber;
    }
    /**
     * @return the postAccount
     */
    public String getPostAccount()
    {
        return postAccount;
    }
    /**
     * @return the recipientName
     */
    public String getRecipientName()
    {
        return recipientName;
    }
    /**
     * @return the recipientStreet
     */
    public String getRecipientStreet()
    {
        return recipientStreet;
    }
    /**
     * @return the recipientHouseNumber
     */
    public String getRecipientHouseNumber()
    {
        return recipientHouseNumber;
    }
    /**
     * @return the recipientZip
     */
    public String getRecipientZip()
    {
        return recipientZip;
    }
    /**
     * @return the recipientCity
     */
    public String getRecipientCity()
    {
        return recipientCity;
    }

    
}
