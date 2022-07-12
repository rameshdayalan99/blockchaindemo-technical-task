package com.blockchain.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

public class BitcoinUtil {
	public static Logger logger = Logger.getLogger("BitcoinUtil");

	public BitcoinUtil() {

	}

	public void callMinMaxBitCoinRate(String currencyCode, String apiUrl, String apiMethod) throws Exception {

		Scanner scan;

		try {
			scan = callAPI(currencyCode, apiUrl, apiMethod);
			while (scan.hasNext()) {
				String jsonRead = scan.nextLine();
				JsonReaderForMaxMin(jsonRead, currencyCode);
			}
		} catch (Exception e) {
			System.out.println("Error while parsing " + e.getMessage());
			logger.log(Level.SEVERE, e.getMessage());
		}
	}

	public void getCurrentBitCoinRate(String currencyCode, String apiUrl, String apiMethod) {

		Scanner scan;
		try {
			scan = callAPI(currencyCode, apiUrl, apiMethod);
			String jsonReadValue = null;
			while (scan.hasNext()) {
				jsonReadValue = scan.nextLine();
			}
			jsonReadCurrentBitCoinRate(jsonReadValue, currencyCode);
		} catch (Exception e) {
			System.out.println("Error while parsing " + e.getMessage());
			logger.log(Level.SEVERE, e.getMessage());
		}
	}

	public Scanner callAPI(String currencyCode, String apiUrl, String requstMethod) throws IOException {

		HttpURLConnection conn = null;
		Scanner scan = null;
		try {
			URL url = new URL(apiUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(requstMethod);
			conn.connect();
			int responseCode = conn.getResponseCode();
			if (responseCode == 200) {
				scan = new Scanner(url.openStream());
			} else if (responseCode == 404) {
				logger.log(Level.INFO, "Currency Not Found");
			}
			return scan;
		} catch (Exception e) {
			throw e;
		}
	}

	public void JsonReaderForMaxMin(String json, String currencyCode) {// JSON_DATA ) {
		ArrayList<Double> minMaxRate = new ArrayList<>();
		JSONObject obj = new JSONObject(json);
		JSONObject ss = obj.getJSONObject("bpi");// .getJSONArray("{");//.getString("pageName");
		Iterator<String> it = ss.keys();
		while (it.hasNext()) {
			String dates = (String) it.next();
			Double values = (Double) ss.getDouble(dates);
			minMaxRate.add(values);

		}
		Collections.sort(minMaxRate);
		logger.log(Level.INFO, "BITCOIN  MAX RATE in last 30 DAYS is  = " + minMaxRate.get(minMaxRate.size() - 1));
		logger.log(Level.INFO, "BITCOIN  MIN RATE  in last 30 DAYS  is =" + minMaxRate.get(0));
	}

	public void jsonReadCurrentBitCoinRate(String json, String currencyCode) {
		JSONObject obj = new JSONObject(json);
		JSONObject objtime = obj.getJSONObject("time");
		JSONObject CurrentRate = obj.getJSONObject("bpi").getJSONObject(currencyCode);
		String curCode = CurrentRate.getString("code");
		String currentBitCoinRate = CurrentRate.getString("rate");
		String description = CurrentRate.getString("description");
		Float rate_flate = CurrentRate.getFloat("rate_float");
		logger.log(Level.INFO, "Current Bit Coin Rate for   " + curCode + "   :::: is  " + currentBitCoinRate);
	}
}
