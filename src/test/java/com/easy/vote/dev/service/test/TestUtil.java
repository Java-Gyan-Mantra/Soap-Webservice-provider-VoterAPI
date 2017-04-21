package com.easy.vote.dev.service.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestUtil {
	/**
	 * This method uses HttpURLConnection to invoke exposed SOAP web service and
	 * returns the response string to the calling client
	 *
	 * @param httpRequestURL
	 * @param requestXmlParam
	 * @return responseXML
	 * @throws IOException
	 */
	public static String testVoterService(String httpRequestURL,
			String requestXmlParam) throws IOException {

		// local variables
		URL url = null;
		HttpURLConnection httpURLConnection = null;
		OutputStreamWriter outputStreamWriter = null;
		String responseMessageFromServer = null;
		String responseXML = null;

		try {
			// set basic request parameters
			url = new URL(httpRequestURL);
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setRequestProperty("Content-Type", "text/xml");
			httpURLConnection.setRequestProperty("Accept", "text/xml");

			// write request XML to the HTTP request
			outputStreamWriter = new OutputStreamWriter(
					httpURLConnection.getOutputStream());
			outputStreamWriter.write(requestXmlParam);
			outputStreamWriter.flush();

			System.out.println("Response code: "
					+ httpURLConnection.getResponseCode());
			if (httpURLConnection.getResponseCode() == 200) {

				responseMessageFromServer = httpURLConnection
						.getResponseMessage();
				System.out.println("ResponseMessageFromServer: "
						+ responseMessageFromServer);
				responseXML = getResponseXML(httpURLConnection);
			}
		} catch (IOException ioex) {
			ioex.printStackTrace();
			throw ioex;
		} finally {
			// finally close all operations
			outputStreamWriter.close();
			httpURLConnection.disconnect();
		}
		return responseXML;
	}

	/**
	 * This method is used to get response XML from the HTTP POST request
	 *
	 * @param httpURLConnection
	 * @return stringBuffer.toString()
	 * @throws IOException
	 */
	public static String getResponseXML(HttpURLConnection httpURLConnection)
			throws IOException {

		// local variables
		StringBuffer stringBuffer = new StringBuffer();
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		String readSingleLine = null;

		try {
			// read the response stream AND buffer the result into a
			// StringBuffer
			inputStreamReader = new InputStreamReader(
					httpURLConnection.getInputStream());
			bufferedReader = new BufferedReader(inputStreamReader);

			// reading the XML response content line BY line
			while ((readSingleLine = bufferedReader.readLine()) != null) {
				stringBuffer.append(readSingleLine);
			}
		} catch (IOException ioex) {
			ioex.printStackTrace();
			throw ioex;
		} finally {
			// finally close all operations
			bufferedReader.close();
			httpURLConnection.disconnect();
		}
		return stringBuffer.toString();
	}
}
