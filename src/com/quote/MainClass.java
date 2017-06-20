package com.quote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import com.quote.*;

public class MainClass {

	static String quote, author, category;
	final public static String GET_URL = "https://andruxnet-random-famous-quotes.p.mashape.com/";

	public static String getQuote() {
		return quote;
	}

	public static void setQuote(String quote) {
		MainClass.quote = quote;
	}

	public static String getAuthor() {
		return author;
	}

	public static void setAuthor(String author) {
		MainClass.author = author;
	}

	public static String getCategory() {
		return category;
	}

	public static void setCategory(String category) {
		MainClass.category = category;
	}

	
	public static void main(String[] args) throws IOException, JSONException {

		String getResponse = GETData(GET_URL);

		MainClass.ExtractJSONData(getResponse);

		ShowWindow.myinit();

	}

	public static void ExtractJSONData(String jsonData) throws JSONException {

		JSONObject jsonResult = new JSONObject(jsonData);

		quote = jsonResult.getString("quote");
		author = jsonResult.getString("author");
		category = jsonResult.getString("category");

		StringBuilder sb = new StringBuilder(quote);

		int i = 0;
		while ((i = sb.indexOf(" ", i + 35)) != -1) {
			sb.replace(i, i + 1, "\n");
		}

		quote = sb.toString();
		MainClass.setQuote(quote);
		MainClass.setAuthor(author);
		MainClass.setCategory(category);
		
		System.out.println("Quote : " + jsonResult.getString("quote"));
		System.out.println("Author : " + jsonResult.getString("author"));
		System.out.println("Category : " + jsonResult.getString("category"));

	}

	public static String GETData(String GET_URL) throws IOException {

		System.out.println("clicked");
		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("X-Mashape-Key", "lHWSL4srIOmshnsBGDnGTx7jZCqEp1PSDdRjsnanZ8UF5maKIL");
		con.setRequestProperty("Accept", "application/json");

		int responseCode = con.getResponseCode();
		StringBuffer response = new StringBuffer();

		// System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// System.out.println(response.toString());
		} else {
			// System.out.println("GET request not worked");
		}
		return response.toString();
	}

}
