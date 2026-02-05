package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import lombok.Data;

/**
 * Customer information.
 *
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 *
 * @author Matthias Staud
 */
@Data
public class Customer
{
    /** A unique reference to your customer, e.g. the customer number */
    private final String customerNumber;

    /** Contact email address of the customer, e.g. for the SwissPost notification service */
    private String contactEmail;

    /**
     * Constructor for Customer with customer number only
     *
     * @param customerNumber A unique reference to your customer, e.g. the customer number
     */
    public Customer(String customerNumber)
    {
        this.customerNumber = customerNumber;
    }

    /**
     * Constructor for Customer with customer number and contact email
     *
     * @param customerNumber A unique reference to your customer, e.g. the customer number
     * @param contactEmail Contact email address of the customer, e.g. for the SwissPost notification service
     */
    public Customer(String customerNumber, String contactEmail)
    {
        this.customerNumber = customerNumber;
        this.contactEmail = contactEmail;
    }
}
