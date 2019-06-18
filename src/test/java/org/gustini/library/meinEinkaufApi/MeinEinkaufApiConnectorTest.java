package org.gustini.library.meinEinkaufApi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.gustini.library.meinEinkaufApi.objects.apiObjects.OrderTest;
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
    public void testHelloWorldSendRequest() throws Exception
    {
        String apiTestUrl ="api.meineinkauf.ch";
        String param =  "/v1/echo/HelloWorld/";
        String apiKey = "MEINEINKAUF_TEST_API_KEY";
        MeinEinkaufApiConnector apiConnector = new MeinEinkaufApiConnector("api", apiKey, apiTestUrl);
        
        String jsonString = JsonBuilder.getJsonStringFromObject(OrderTest.getTestOrder());
        
        String response = apiConnector.sendGetRequest(param).trim();
        String assertString = "{\"echo\":\"HelloWorld\",\"errors\":[],\"success\":true}";
//        System.out.println(response);
//        System.out.println(assertString);
        assertEquals(assertString, response);
//        System.out.println(response);
    }

    @Test
    public void testSendPostRequest() throws Exception
    {
        String apiTestUrl ="api.meineinkauf.ch";
        String param =  "/v1/order";
        String apiKey = "MEINEINKAUF_TEST_API_KEY";
        MeinEinkaufApiConnector apiConnector = new MeinEinkaufApiConnector("api", apiKey, apiTestUrl);
        
        String jsonString = JsonBuilder.getJsonStringFromObject(OrderTest.getTestOrder());
        
        System.out.println(jsonString);
        String responseString =apiConnector.sendPostRequest(jsonString, param);
        System.out.println(responseString);
    }

}
