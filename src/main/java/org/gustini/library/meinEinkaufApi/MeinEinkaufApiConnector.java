/**
 * 
 */
package org.gustini.library.meinEinkaufApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.BasicConfigurator;
import org.gustini.library.meinEinkaufApi.objects.apiObjects.MeinEinkaufRequestException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Gustini GmbH (2019)
 * Creation: 11.06.2019
 * application.meineinkauf
 * gustini.application.meineinkauf.module.meinEinkaufApi.connector
 * 
 * @author Matthias Staud
 *
 *
 *         Description:
 * 
 *         Aufruf:
 * 
 *         curl https://api.meineinkauf.ch/v1/echo/HelloWorld \
 *         -X GET \
 *         -u 'api:MEINEINKAUF_TEST_API_KEY'
 * 
 *         Antwort:
 * 
 *         {
 *         "echo": "HelloWorld",
 *         "errors": [],
 *         "success": true,
 *         "testMode": true
 *         }
 * 
 * 
 *         HTTP Status Codes
 * 
 *         200 OK - Der Request war erfolgreich.
 *         201 Created - Die �bermittelten Daten wurden erfolgreich verarbeitet und es wurde zum Beispiel eine Bestellung erstellt.
 *         400 Bad Request - Der Endpunkt existiert nicht oder wurde mit einer falschen HTTP-Methode aufgerufen.
 *         401 Unauthorized - Der Request konnte nicht authentifiziert werden.
 *         422 Unprocessable Entity - Die �bermittelten Daten waren nicht valide.
 *         500 Internal Server Error - Es gab ein Problem auf unserer Seite und wir arbeiten schnellstm�glich an einer L�sung. Die �bermittelten Daten wurden in der Regel nicht verarbeitet und ihr
 *         System muss den Request zu einem sp�teren Zeitpunkt erneut senden.
 *         503 Service Unavailable - W�hrend planm��iger Wartungsarbeiten wird dieser Status zur�ckgegeben. Die �bermittelten Daten wurden nicht verarbeitet und ihr System muss den Request zu einem
 *         sp�teren Zeitpunkt erneut senden.
 * 
 *         API Error Codes
 * 
 *         E0000 ApiKey is missing - Sie haben keinen ApiKey angegeben.
 *         E0001 Unknown ApiKey - Der angegebene ApiKey ist unbekannt.
 *         E1000 Invalid JSON - Die �bermittelten Daten sind nicht valide. Eine detaillierte Fehlermeldung wird ebenfalls zur�ckgegeben.
 *         E1001 No order found for given ordernumber - Die angegebene Bestellung existiert nicht.
 *         E1002 No return consignment found for given reference - Die angegebene Retoure existiert nicht.
 *
 * 
 */
public class MeinEinkaufApiConnector
{
    private final String apiKey;
    private final String apiHost;
    private final String username;

    public String getApiKey()
    {
        return apiKey;
    }

    /**
     * @param apiKey
     * @param apiUrl
     */
    public MeinEinkaufApiConnector(
                                   String username,
                                   String apiKey,
                                   String apiHost)
    {
        super();
        this.username = username;
        this.apiKey = apiKey;
        this.apiHost = apiHost;
        BasicConfigurator.configure();
    }

    /**
     * 
     * Description:
     * 
     * @param urlParam
     * @return
     * @throws IOException
     *             Creation: 11.06.2019 by mst
     */
    public String sendGetRequest(final String urlParam) throws IOException
    {
        String responseString = null;
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        HttpHost targetHost = new HttpHost(this.apiHost, 443, "https");
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(new AuthScope(targetHost.getHostName(), targetHost.getPort()), new UsernamePasswordCredentials("api", this.apiKey));

        // Create AuthCache instance
        AuthCache authCache = new BasicAuthCache();
        // Generate BASIC scheme object and add it to the local auth cache
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(targetHost, basicAuth);

        // Add AuthCache to the execution context
        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);
        context.setAuthCache(authCache);

        HttpGet httpget = new HttpGet(urlParam);
        for (int i = 0; i < 1; i++)
        {
            CloseableHttpResponse response = httpclient.execute(targetHost, httpget, context);
            try
            {
                HttpEntity entity = response.getEntity();
                responseString = convertStreamToString(response.getEntity().getContent());
                System.out.println(responseString);
            } finally
            {
                response.close();
            }
        }
        return responseString;
    }
    
    /**
     * 
     * Description: 
     * 
     * @param jsonString
     * @param urlParam
     * @return
     * @throws IOException
     * @throws MeinEinkaufRequestException
     * Creation: 17.06.2019 by mst
     */
    public String sendPostRequest(final String jsonString, final String urlParam) throws IOException, MeinEinkaufRequestException
    {
        String responseString = null;
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        HttpHost targetHost = new HttpHost(this.apiHost, 443, "https");
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(new AuthScope(targetHost.getHostName(), targetHost.getPort()), new UsernamePasswordCredentials("api", this.apiKey));

        // Create AuthCache instance
        AuthCache authCache = new BasicAuthCache();
        // Generate BASIC scheme object and add it to the local auth cache
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(targetHost, basicAuth);

        // Add AuthCache to the execution context
        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);
        context.setAuthCache(authCache);
        
        StringEntity requestEntity = new StringEntity(jsonString, ContentType.APPLICATION_JSON.getCharset());
        HttpPost httpPost = new HttpPost(urlParam);
        httpPost.setEntity(requestEntity);
        for (int i = 0; i < 1; i++)
        {
            StringBuilder textBuilder = new StringBuilder();
            try (Reader reader = new BufferedReader(new InputStreamReader
              (requestEntity.getContent(), Charset.forName(StandardCharsets.UTF_8.name())))) {
                int c = 0;
                while ((c = reader.read()) != -1) {
                    textBuilder.append((char) c);
                }
            }
            
            
            System.out.println(textBuilder.toString());
            CloseableHttpResponse response = httpclient.execute(targetHost, httpPost, context);
            try
            {
                int statusCode;
                statusCode = response.getStatusLine().getStatusCode();
                if (StatusCodesEnum.getStatusCodesEnumFromStatusInteger(statusCode) == StatusCodesEnum.CREATED_201)
                {
//                        HttpEntity responsEntity = response.getEntity();
                        responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
                        System.out.println(responseString);
                }else
                {
                    responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
                    System.out.println("ResponseString:");
                    System.out.println(responseString);
                    throw new MeinEinkaufRequestException(response);
                }

            } finally
            {
                response.close();
            }
        }
        return responseString;
    }

    /**
     * @return the apiHost
     */
    public String getApiHost()
    {
        return apiHost;
    }

    /**
     * 
     * Description: 
     * 
     * @param is
     * @return
     * Creation: 17.06.2019 by mst
     */
    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    
    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * 
     * Description: Verify validity of JSON String
     * 
     * @param jsonInString
     * @return
     *         Creation: 13.06.2019 by mst
     */
    public static boolean isJSONValid(String jsonInString)
    {
        try
        {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(jsonInString);
            return true;
        } catch (IOException e)
        {
            return false;
        }
    }
}
