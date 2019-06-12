package org.gustini.library.meinEinkaufApi;

import org.gustini.library.meinEinkaufApi.objects.OrderTest;
import org.gustini.library.meinEinkaufApi.utility.JsonBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class MeinEinkaufApiConnectorTest
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
    public void testSendRequest() throws Exception
    {
        String apiTestUrl ="api.meineinkauf.ch";
        String param =  "/v1/echo/HelloWorld";
        String apiKey = "MEINEINKAUF_TEST_API_KEY";
        MeinEinkaufApiConnector apiConnector = new MeinEinkaufApiConnector("api", apiKey, apiTestUrl);
        
        String jsonString = JsonBuilder.getJsonStringFromObject(OrderTest.getTestOrder());
        String response = apiConnector.sendRequest(jsonString, param);
        System.out.println(response);
    }

}
