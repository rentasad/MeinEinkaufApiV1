package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import lombok.Data;
import org.gustini.library.meinEinkaufApi.objects.enums.Currency;
import org.gustini.library.meinEinkaufApi.objects.enums.PaymentType;

/**
 * Order endpoint object for transferring order data to the system.
 *
 * The Order endpoint allows you to transfer your order data directly from your online shop to our system.
 * You can also retrieve the status of these orders. This status includes, for example, the tracking number
 * of the Swiss shipping company, which you can then pass on to your customers to track the delivery.
 *
 * This object stores data in JSON-compatible strings.
 *
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 *
 * @author Matthias Staud
 */
@Data
public class Order
{

    /** Your order number */
    private final String orderNumber;
    
    /** Your order date */
    private final String orderDate;
    
    /** The currency of the order ["eur", "chf"] */
    private final Currency currency;
    
    /** The payment method, e.g. credit card, PayPal, prepayment, invoice, etc. 
     * ["mastercard", "visa", "amex", "creditcard", "paypal", "prepayment", "invoice", "other"] */
    private final PaymentType paymentType;
    
    /** The gross order total (including shipping costs) */
    private final Double grossSum;

    /** The shipping costs */
    private ShippingCost shippingCost;
    
    /** The customer data */
    private final Customer customer;
    
    /** The invoice address */
    private final Adress invoiceAddress;
    
    /** The shipping address. If empty, the invoice address will be used as shipping address */
    private Adress shippingAddress;
    
    /** For each shipment we receive from you, a consignment object must be included in the array */
    private Consignment[] consignments;
    
    /** The possible discounts on the order */
    private DiscountRequest[] discounts;
    
    /** The possible donations in addition to the order */
    private Donation[] donations;
    
    /** Information about invoicing */
    private InvoiceInformation invoiceInformation;

    /**
     * Constructor for Order
     *
     * @param orderNumber Your order number
     * @param orderDate Your order date
     * @param currency The currency
     * @param paymentType The payment method
     * @param grossSum The gross order total (including shipping costs)
     * @param customer The customer data
     * @param invoiceAddress The invoice address
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
}
