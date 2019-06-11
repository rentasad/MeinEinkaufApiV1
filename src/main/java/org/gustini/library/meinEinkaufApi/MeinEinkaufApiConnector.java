/**
 * 
 */
package org.gustini.library.meinEinkaufApi;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

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
    private final String apiUrl;

    public String getApiKey()
    {
        return apiKey;
    }

    public String getApiUrl()
    {
        return apiUrl;
    }

    /**
     * @param apiKey
     * @param apiUrl
     */
    public MeinEinkaufApiConnector(
                                   String apiKey,
                                   String apiUrl)
    {
        super();
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
    }

    /**
     * 
     * Description:
     * 
     * @param jsonString
     * @return
     *         Creation: 11.06.2019 by mst
     * @throws IOException
     */
    public String sendRequest(String jsonString) throws IOException
    {
        String responseString = null;
        String httpUsername = "api";
        String httpPassword = this.apiKey;
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(new AuthScope(this.apiUrl, 443), new UsernamePasswordCredentials(httpUsername, httpPassword));
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
        HttpPost httppost = new HttpPost(this.apiUrl);

        // Request parameters and other properties.
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("api", this.apiKey));
        // params.add(new BasicNameValuePair("param-2", "Hello!"));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        try
        {
            HttpGet httpget = new HttpGet(this.apiUrl);

            System.out.println("Executing request " + httpget.getRequestLine());
            CloseableHttpResponse response = httpclient.execute(httpget);
            try
            {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                responseString = response.getStatusLine().toString();
                System.out.println(EntityUtils.toString(response.getEntity()));
            } finally
            {
                response.close();
            }
        } finally
        {
            httpclient.close();
        }

        // //Execute and get the response.
        // HttpResponse response = httpclient.execute(httppost);
        // HttpEntity entity = response.getEntity();
        //
        // if (entity != null) {
        // try (InputStream instream = entity.getContent()) {
        // // do something useful
        // responseString = instream.toString();
        // }
        // }
        // System.out.println(response.toString());
        return responseString;

    }

}
