package org.gustini.library.meinEinkaufApi.utility;

import org.gustini.library.meinEinkaufApi.objects.Order;
import org.gustini.library.meinEinkaufApi.objects.OrderTest;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class JsonBuilderTest
{

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void testGetJsonStringFromObject() throws Exception
    {
        Order order = OrderTest.getTestOrder();
        String jsonString = JsonBuilder.getJsonStringFromObject(order);
        System.out.println(jsonString);
    }


}
