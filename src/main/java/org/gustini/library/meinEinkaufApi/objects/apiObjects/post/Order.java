package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import org.gustini.library.meinEinkaufApi.objects.enums.Currency;
import org.gustini.library.meinEinkaufApi.objects.enums.PaymentType;

/**
 * 
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 * application.meineinkauf
 * org.gustini.library.meinEinkaufApi.objects
 * 
 * @author Matthias Staud
 *
 *
 *         Description:
 *         �ber den Order-Endpunkt k�nnen sie einerseits Ihre Bestelldaten direkt aus Ihrem Online-Shop in unser System �bertragen.
 *         Andererseits k�nnen sie sich auch einen Status dieser Bestellungen
 *         abrufen. Dieser Status beinhaltet zum Beispiel die Trackingnummer des Schweizer Versandunternehmens,
 *         welche Sie dann an Ihre Kunden zum Verfolgen der Lieferung weitergeben k�nnen.
 * 
 * 
 *         Das Objekt wird Daten in JSON-Tauglichen strings speichern.
 */
public class Order
{

    private final String orderNumber;
    private final String orderDate;
    private final Currency currency;
    private final PaymentType paymentType;
    /*
     * Die Brutto Bestellsumme (inklusive Lieferkosten)
     */
    private final Double grossSum;

    private ShippingCost shippingCost;
    private final Customer customer;
    private final Adress invoiceAddress;
    private Adress shippingAddress;
    private Consignment[] consignments;
    private DiscountRequest[] discounts;
    private Donation[] donations;
    private InvoiceInformation invoiceInformation;

    /**
     * @param orderNumber
     * @param orderDate
     * @param currency
     * @param paymentType
     * @param grossSum
     * @param customer
     *            Die Kundendaten
     * @param invoiceAddress
     *            Die Rechnungsadresse
     */
    public Order(
                 String orderNumber,
                 String orderDate,
                 Currency currency,
                 PaymentType paymentType,
                 Double grossSum,
                 Customer customer,
                 Adress invoiceAddress)
    {
        super();
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.currency = currency;
        this.paymentType = paymentType;
        this.grossSum = grossSum;
        this.customer = customer;
        this.invoiceAddress = invoiceAddress;
    }

    /**
     * Die Lieferkosten
     * 
     * @return the shippingCost
     */
    public ShippingCost getShippingCost()
    {
        return shippingCost;
    }

    /**
     * Die Lieferkosten
     * 
     * @param shippingCost
     *            the shippingCost to set
     */
    public void setShippingCost(ShippingCost shippingCost)
    {
        this.shippingCost = shippingCost;
    }

    /**
     * Die Lieferadresse, wenn leer, wird die Rechnungsadresse als Lieferadresse genutzt
     * 
     * @return the shippingAddress
     */
    public Adress getShippingAddress()
    {
        return shippingAddress;
    }

    /**
     * Die Lieferadresse, wenn leer, wird die Rechnungsadresse als Lieferadresse genutzt
     * 
     * @param shippingAddress
     *            the shippingAddress to set
     */
    public void setShippingAddress(Adress shippingAddress)
    {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Für jede Sendung, die wir von Ihnen erhalten, muss ein Sendungs-Objekt in dem Array enthalten sein
     * 
     * @return the consignments
     * 
     */
    public Consignment[] getConsignments()
    {
        return consignments;
    }

    /**
     * Für jede Sendung, die wir von Ihnen erhalten, muss ein Sendungs-Objekt in dem Array enthalten sein
     * 
     * @param consignments
     *            the consignments to set
     */
    public void setConsignments(Consignment[] consignments)
    {
        this.consignments = consignments;
    }

    /**
     * Die möglichen Rabatte auf die Bestellung
     * 
     * @return the discounts
     */
    public DiscountRequest[] getDiscounts()
    {
        return discounts;
    }

    /**
     * Die möglichen Rabatte auf die Bestellung
     * 
     * @param discounts
     *            the discounts to set
     */
    public void setDiscounts(DiscountRequest[] discounts)
    {

        this.discounts = discounts;
    }

    /**
     * Die möglichen Spenden zusätlich zur Bestellung
     * 
     * @return the donations
     */
    public Donation[] getDonations()
    {
        return donations;
    }

    /**
     * Die möglichen Spenden zusätlich zur Bestellung
     * 
     * @param donations
     *            the donations to set
     */
    public void setDonations(Donation[] donations)
    {
        this.donations = donations;
    }

    /**
     * Informationen zur Rechnungsstellung
     * 
     * @return the invoiceInformation
     */
    public InvoiceInformation getInvoiceInformation()
    {
        return invoiceInformation;
    }

    /**
     * Informationen zur Rechnungsstellung
     * 
     * @param invoiceInformation
     *            the invoiceInformation to set
     */
    public void setInvoiceInformation(InvoiceInformation invoiceInformation)
    {
        this.invoiceInformation = invoiceInformation;
    }

    /**
     * Ihre Bestellnummer
     * 
     * @return the orderNumber
     */
    public String getOrderNumber()
    {
        return orderNumber;
    }

    /**
     * Ihre Bestellnummer
     * 
     * @return the orderDate
     */
    public String getOrderDate()
    {
        return orderDate;
    }

    /**
     * Die Währung der Bestellung
     * 
     * ["eur", "chf"]
     * 
     * @return the currency
     */
    public Currency getCurrency()
    {
        return currency;
    }

    /**
     * 
     * Die Zahlart, z.B. Kreditkarte, Paypal, Vorkasse, Rechnung etc.
     * 
     * ["mastercard", "visa", "amex", "creditcard", "paypal", "prepayment", "invoice", "other"]
     * 
     * @return the paymentType
     */
    public PaymentType getPaymentType()
    {
        return paymentType;
    }

    /**
     * Die Brutto Bestellsumme (inklusive Lieferkosten)
     * @return the grossSum
     */
    public Double getGrossSum()
    {
        return grossSum;
    }

    /**
     * Die Kundendaten
     * @return the customer
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /**
     *      Die Rechnungsadresse
     * @return the invoiceAddress
     */
    public Adress getInvoiceAddress()
    {
        return invoiceAddress;
    }

}
