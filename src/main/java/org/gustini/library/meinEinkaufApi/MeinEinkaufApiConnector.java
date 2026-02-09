/**
 *
 */
package org.gustini.library.meinEinkaufApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Provides a connector for interacting with Mein Einkauf API.
 * This connector supports sending GET and POST requests to the API and handling responses.
 */
@Slf4j
public class MeinEinkaufApiConnector
{
	@Getter private final String apiKey;
	private final String apiHost;
	private final String username;

	/**
	 * Constructs a new MeinEinkaufApiConnector with the specified credentials and API host.
	 *
	 * @param username The username for authentication.
	 * @param apiKey   The API key for authentication.
	 * @param apiHost  The host URL for the Mein Einkauf API.
	 */
	public MeinEinkaufApiConnector(String username, String apiKey, String apiHost)
	{
		this.username = username;
		this.apiKey = apiKey;
		this.apiHost = apiHost;
	}

	/**
	 * Sends a GET request to the specified URL.
	 *
	 * @param urlParam The additional URL parameters to be appended to the base URL.
	 * @return A string representing the response received from the server.
	 * @throws IOException        If an I/O error occurs during the HTTP request.
	 * @throws URISyntaxException If the provided URL is not a valid URI.
	 */
	public String sendGetRequest(final String urlParam) throws IOException, URISyntaxException
	{
		try (CloseableHttpClient httpClient = HttpClients.custom().build())
		{
			URI uri = new URI("https", this.apiHost, urlParam, null);
			final HttpGet httpGet = new HttpGet(uri);
			return executeRequest(httpClient, httpGet);
		}
	}

	/**
	 * Sends a POST request to the specified URL with the provided JSON payload.
	 *
	 * @param jsonString The JSON payload to be included in the request.
	 * @param urlParam   The additional URL parameters to be appended to the base URL.
	 * @return A string representing the response received from the server.
	 * @throws IOException        If an I/O error occurs during the HTTP request.
	 * @throws URISyntaxException If the provided URL is not a valid URI.
	 */
	public String sendPostRequest(final String jsonString, final String urlParam) throws IOException, URISyntaxException
	{
		try (CloseableHttpClient httpClient = HttpClients.custom().build())
		{
			StringEntity requestEntity = new StringEntity(jsonString, ContentType.APPLICATION_JSON.getCharset());
			URI uri = new URI("https", this.apiHost, urlParam, null);
			final HttpPost httpPost = new HttpPost(uri);
			httpPost.setEntity(requestEntity);
			return executeRequest(httpClient, httpPost);
		}
	}

	/**
	 * Executes an HTTP request with authorization header and logging.
	 *
	 * @param httpClient The HTTP client to use for execution.
	 * @param request    The HTTP request to execute.
	 * @return The response body as a string.
	 * @throws IOException If an I/O error occurs during the HTTP request.
	 */
	private String executeRequest(CloseableHttpClient httpClient, org.apache.hc.core5.http.ClassicHttpRequest request) throws IOException, URISyntaxException {
		request.addHeader("Authorization", "Basic " + java.util.Base64.getEncoder()
																	   .encodeToString((this.username + ":" + this.apiKey).getBytes()));
		// log.info("Executing request " + request.getMethod() + " " + request.getUri());

		AtomicReference<String> responseString = new AtomicReference<>();
		httpClient.execute(request, response -> {
			responseString.set(EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8));
			return responseString;
		});

		return responseString.get();
	}
	/**
	 * Converts the input stream to a String.
	 *
	 * @param inputStream The input stream to convert.
	 * @return The String representation of the input stream.
	 * @throws IOException If an I/O error occurs.
	 */
	public static String convertStreamToString(InputStream inputStream) throws IOException
	{
		StringBuilder textBuilder = new StringBuilder();
		try (Reader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)))
		{
			int c = 0;
			while ((c = reader.read()) != -1)
			{
				textBuilder.append((char) c);
			}
		}
		return textBuilder.toString();
	}
	/**
	 * Checks if the given String is a valid JSON.
	 *
	 * @param jsonInString The String to check.
	 * @return True if the String is a valid JSON, false otherwise.
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
