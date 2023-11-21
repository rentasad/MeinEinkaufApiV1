package org.gustini.library.meinEinkaufApi;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.StatusLine;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class TestMain {
	public static void main(String[] args) {
		String apiTestUrl = "api.meineinkauf.ch";
		String apiKey = "MEINEINKAUF_TEST_API_KEY";
		String username = "api";

		try {
			URI uri = new URI("https", apiTestUrl, "/v1/echo/HelloWorld/", null);

			try (final CloseableHttpClient httpclient = HttpClients.custom()
																   .build()) {

				final HttpGet httpget = new HttpGet(uri);
				httpget.addHeader("Authorization", "Basic " + java.util.Base64.getEncoder().encodeToString((username + ":" + apiKey).getBytes()));

				System.out.println("Executing request " + httpget.getMethod() + " " + httpget.getUri());
				httpclient.execute(httpget, response -> {
					System.out.println("----------------------------------------");
					System.out.println(httpget + "->" + new StatusLine(response));
					EntityUtils.consume(response.getEntity());
					return null;
				});
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}


	private static String convertStreamToString(InputStream inputStream) throws IOException
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

}
