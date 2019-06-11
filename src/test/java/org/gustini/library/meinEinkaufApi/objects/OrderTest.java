package org.gustini.library.meinEinkaufApi.objects;

import static org.junit.Assert.assertNotNull;

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
        CurrencyEnum currencyEnum = CurrencyEnum.CHF;
        PaymentTypeEnum paymentType = PaymentTypeEnum.INVOICE;
        Double grossSum = 78.99;
        String customerNumber = "44122265843";
        Customer customer = new Customer(customerNumber);
        customer.setContactEmail("max.mustermann@gustini.de");
        SalutationEnum salutation = SalutationEnum.Herr;
        String firstName = "Max";
        String lastName = "Mustermann";
        String street = "Mustergasse";
        String houseNumber = "15a";
        String zip = "4155";
        String city = "Zürich";
        
        
        /*
         * Artikel definieren
         */
        String articleNumber = "77504"; 
        String name = "Testartikel 1";
        Integer quantity = 12; 
        Double grossPrice = 12.99;
        VatRateEnum vatRateEnum = VatRateEnum.REDUCED;
        
        
        Article article1 = new Article(articleNumber, name, quantity, grossPrice, vatRateEnum);
        Article article2 = new Article(articleNumber, name, quantity, grossPrice, vatRateEnum);
        Article[] articles = {article1, article2};
        Consignment consignment1 = new Consignment(articles);
        Consignment consignment2 = new Consignment(articles);
        
        
        Consignment[] consignments = {consignment1,consignment2};
        Adress  invoiceAddress = new Adress(salutation, firstName, lastName, street, houseNumber, zip, city);
        
        invoiceAddress.setCompany("Mustermann Company");
        
        
        
        
        Order order = new Order(orderNumber, orderDate, currencyEnum, paymentType, grossSum, customer, invoiceAddress);
        order.setConsignments(consignments);
        
        return order;
    }

    @Test
    public void getTestOrderSuffix() throws Exception
    {
        assertNotNull(getTestOrder());
    }

}
