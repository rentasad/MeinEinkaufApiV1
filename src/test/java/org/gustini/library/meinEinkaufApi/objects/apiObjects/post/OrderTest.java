package org.gustini.library.meinEinkaufApi.objects.apiObjects.post;

import static org.junit.Assert.assertNotNull;

import org.gustini.library.meinEinkaufApi.objects.enums.Currency;
import org.gustini.library.meinEinkaufApi.objects.enums.PaymentType;
import org.gustini.library.meinEinkaufApi.objects.enums.Salutation;
import org.gustini.library.meinEinkaufApi.objects.enums.VatRate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTest
{

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }
    
    
    /**
     * 
     * Description: 
     * 
     * @return
     * Creation: 11.06.2019 by mst
     */
    public static Order getTestOrder()
    {
        String orderNumber = "123456789";
        String orderDate = "2019-06-11";
        Currency currency = Currency.chf;
        PaymentType paymentType = PaymentType.other;
        Double grossSum = 623.52;
        String customerNumber = "44122265843";
        Customer customer = new Customer(customerNumber);
        customer.setContactEmail("max.mustermann@gustini.de");
        Salutation salutation = Salutation.Herr;
        String firstName = "Max";
        String lastName = "Mustermann";
        String street = "Mustergasse";
        String houseNumber = "15a";
        String zip = "4155";
        String city = "Zürich";
//        String city = "Z&uuml;rich";
        
        
        /*
         * Artikel definieren
         */
        String articleNumber = "77504"; 
        String name = "Testartikel 1";
        Integer quantity = 12; 
        Double grossPrice = 12.99;
        VatRate vatRate = VatRate.reduced;
        
        
        Article article1 = new Article(articleNumber, name, quantity, grossPrice, vatRate);
        article1.setGrossWeight(1000);
        Article article2 = new Article(articleNumber, name, quantity, grossPrice, vatRate);
        article2.setGrossWeight(500);
        Article[] articles = {article1, article2};
        
        Tracking tracking1 = new Tracking();
        tracking1.setCarrier("DHL");
        tracking1.setTrackingNumber("445892355134");
        Tracking tracking2 = new Tracking();
        tracking2.setCarrier("DHL");
        tracking2.setTrackingNumber("445892355148");
        Consignment consignment1 = new Consignment(articles);
        consignment1.setTracking(tracking1);
        
        consignment1.setGrossWeight(1500);
        
        Consignment consignment2 = new Consignment(articles);
        consignment2.setGrossWeight(1500);
        consignment2.setTracking(tracking2);
        Consignment[] consignments = {consignment1,consignment2};
        
        Adress  invoiceAddress = new Adress(salutation, firstName, lastName, street, houseNumber, zip, city);
        
        invoiceAddress.setCompany("Mustermann Company");
        
        
        
        
        Order order = new Order(orderNumber, orderDate, currency, paymentType, grossSum, customer, invoiceAddress);
        order.setConsignments(consignments);
        
        return order;
    }

    @Test
    public void getTestOrderSuffix() throws Exception
    {
        assertNotNull(getTestOrder());
    }

}
