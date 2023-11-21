# MeinEinkaufApiV1 -  Java Implementation V 1.2
MeinEinkauf API v1.2

Implementation of the REST-API from MeinEinkauf.CH

Description of this api in german:
https://docs.meineinkauf.ch

# State of Project:
stable

# Example Request "Send Order"


```
@Test
    public void testHelloWorldSendRequest() throws Exception
    {
        String apiTestUrl ="api-test.meineinkauf.ch";
        String param =  "/v1/echo/HelloWorld/";
        String apiKey = "MEINEINKAUF_TEST_API_KEY";
        MeinEinkaufApiConnector apiConnector = new MeinEinkaufApiConnector("api", apiKey, apiTestUrl);
        
        String jsonString = JsonBuilder.getJsonStringFromObject(OrderTest.getTestOrder());
        
        String response = apiConnector.sendGetRequest(param).trim();
        String assertString = "{\"echo\":\"HelloWorld\",\"errors\":[],\"success\":true}";
        System.out.println("AssertString: " + assertString);
        
        JSONObject obj = new JSONObject(response);
        assertTrue(obj.getBoolean("success"));
        assertEquals(obj.getString("echo"), "HelloWorld");
        assertEquals(obj.getJSONArray("errors").length(), 0);
        
        assertEquals(assertString, response);
        System.out.println("Response: " + response);
    }
```

# pom.xml insert text

For dependency inserting copy & paste in your pom.xml:

```
	<dependency>
		<groupId>gustini</groupId>
		<artifactId>gustini.library.meinEinkaufApi</artifactId>
		<version>1.2</version>
	</dependency>
```


more Informations to start you will find in the Unit Tests: 
[MeinEinkaufApiConnectorTest](src/test/java/org/gustini/library/meinEinkaufApi/MeinEinkaufApiConnectorTest.java)

