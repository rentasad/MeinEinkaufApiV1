package org.gustini.library.meinEinkaufApi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.gustini.library.meinEinkaufApi.objects.apiObjects.post.OrderTest;
import org.gustini.library.meinEinkaufApi.utility.JsonBuilder;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * 21.01.2020
 * Unit Tests for learning to start/use/test the api
 * 
 * @author mst
 *
 */
public class MeinEinkaufApiConnectorTest
{


    @Test
    public void testHelloWorldSendRequest() throws Exception
    {
        String apiTestUrl ="api.meineinkauf.ch";
        String param =  "/v1/echo/HelloWorld/";
        String apiKey = "MEINEINKAUF_TEST_API_KEY";
        
        MeinEinkaufApiConnector apiConnector = new MeinEinkaufApiConnector("api", apiKey, apiTestUrl);
        
//        String jsonString = JsonBuilder.getJsonStringFromObject(OrderTest.getTestOrder());
        
        String response = apiConnector.sendGetRequest(param).trim();
        String assertString = "{\"echo\":\"HelloWorld\",\"errors\":[],\"success\":true}";
//        System.out.println(response);
//        System.out.println(assertString);
        
        JSONObject obj = new JSONObject(response);
        assertTrue(obj.getBoolean("success"));
        assertEquals(obj.getString("echo"), "HelloWorld");
       // assertEquals(obj.getString("errors"), "");
        assertEquals(obj.getJSONArray("errors").length(), 0);
        
        assertEquals(assertString, response);
//        System.out.println(response);
    }
    
    
    @Test
    public void testGetOrdersInfoRequest() throws Exception
    {
        String apiTestUrl ="api.meineinkauf.ch";
        String param =  "/v1/order";
        String apiKey = "MEINEINKAUF_TEST_API_KEY";
        MeinEinkaufApiConnector apiConnector = new MeinEinkaufApiConnector("api", apiKey, apiTestUrl);
        
//        String jsonString = JsonBuilder.getJsonStringFromObject(OrderTest.getTestOrder());
        
        String response = apiConnector.sendGetRequest(param).trim();
        String assertString = "{\"echo\":\"HelloWorld\",\"errors\":[],\"success\":true}";
        System.out.println(response);
        System.out.println(assertString);
        
        JSONObject obj = new JSONObject(response);
        assertTrue(obj.getBoolean("success"));

    }
    @Test
    public void testOrderProcessing()
    {
        String jsonString = "{\r\n" + 
                    "    \"orders\": [\r\n" + 
                    "        {\r\n" + 
                    "            \"id\": 1234,\r\n" + 
                    "            \"created\": \"2019-02-28T14:50:28+01:00\",\r\n" + 
                    "            \"orderNumber\": \"1518180121\",\r\n" + 
                    "            \"orderDate\": \"2019-02-28\",\r\n" + 
                    "            \"processingState\": \"arrival_assumed\",\r\n" + 
                    "            \"processingStateHistory\" : [\r\n" + 
                    "                {\r\n" + 
                    "                    \"state\": \"open\",\r\n" + 
                    "                    \"changed\": \"2019-02-28T14:50:28+01:00\"\r\n" + 
                    "                },\r\n" + 
                    "                {\r\n" + 
                    "                    \"state\": \"arrival_assumed\",\r\n" + 
                    "                    \"changed\": \"2019-02-28T16:25:21+01:00\"\r\n" + 
                    "                }\r\n" + 
                    "            ],\r\n" + 
                    "            \"processingStateChanged\": \"2019-02-28T16:25:21+01:00\"\r\n" + 
                    "        },\r\n" + 
                    "        {\r\n" + 
                    "            \"id\": 1235,\r\n" + 
                    "            \"created\": \"2019-02-28T14:50:28+01:00\",\r\n" + 
                    "            \"orderNumber\": \"1518180122\",\r\n" + 
                    "            \"orderDate\": \"2019-02-28\",\r\n" + 
                    "            \"processingState\": \"exported\",\r\n" + 
                    "            \"processingStateHistory\" : [\r\n" + 
                    "                {\r\n" + 
                    "                    \"state\": \"open\",\r\n" + 
                    "                    \"changed\": \"2019-02-28T14:50:28+01:00\"\r\n" + 
                    "                },\r\n" + 
                    "                {\r\n" + 
                    "                    \"state\": \"arrival_assumed\",\r\n" + 
                    "                    \"changed\": \"2019-02-28T16:25:21+01:00\"\r\n" + 
                    "                },\r\n" + 
                    "                {\r\n" + 
                    "                    \"state\": \"arrived\",\r\n" + 
                    "                    \"changed\": \"2019-03-02T09:36:12+01:00\"\r\n" + 
                    "                },\r\n" + 
                    "                {\r\n" + 
                    "                    \"state\": \"exported\",\r\n" + 
                    "                    \"changed\": \"2019-03-02T15:53:47+01:00\"\r\n" + 
                    "                }\r\n" + 
                    "            ],\r\n" + 
                    "            \"processingStateChanged\": \"2019-03-02T15:53:47+01:00\",\r\n" + 
                    "            \"consignments\": [\r\n" + 
                    "                {\r\n" + 
                    "                    \"tracking\": {\r\n" + 
                    "                        \"carrier\": \"swisspost\",\r\n" + 
                    "                        \"trackingNumber\": \"996006631900000003\"\r\n" + 
                    "                    },\r\n" + 
                    "                    \"gas\": {\r\n" + 
                    "                        \"carrier\": \"swisspost\",\r\n" + 
                    "                        \"trackingNumber\": \"996006631900000426\"\r\n" + 
                    "                    }\r\n" + 
                    "                }\r\n" + 
                    "            ]\r\n" + 
                    "        }\r\n" + 
                    "    ],\r\n" + 
                    "    \"count\": 2102,\r\n" + 
                    "    \"offset\": 0,\r\n" + 
                    "    \"limit\": 2,\r\n" + 
                    "    \"errors\": [],\r\n" + 
                    "    \"success\": true\r\n" + 
                    "}";
        
        JSONObject obj = new JSONObject(jsonString);
        System.out.println(obj.length());
        
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

    /**
     * Send a Request to get Orderinformations to an open Order - test will not successfull for the reason the order was not found
     * @throws Exception
     */
    @Test
    public void testSendGetRequest() throws Exception
    {
        String orderNr = "6019123456";
        String apiTestUrl ="api.meineinkauf.ch";
        String param =  "/v1/order/" + orderNr;
        String apiKey = "MEINEINKAUF_TEST_API_KEY";
        MeinEinkaufApiConnector apiConnector = new MeinEinkaufApiConnector("api", apiKey, apiTestUrl);
        
        
        String response = apiConnector.sendGetRequest(param).trim();
        System.out.println(response);
        
        JSONObject obj = new JSONObject(response);
        assertFalse(obj.getBoolean("success"));
        assertEquals(obj.getJSONArray("errors").getJSONObject(0).getString("message"), "No order found for given ordernumber 6019123456");
    }
    

}
