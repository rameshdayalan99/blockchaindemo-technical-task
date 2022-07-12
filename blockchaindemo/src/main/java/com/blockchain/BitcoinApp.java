package com.blockchain;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.blockchain.util.BitcoinUtil;

public class BitcoinApp {

	static Logger logger = Logger.getLogger(BitcoinApp.class.getName());

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the CurrencyCode ??: ");
		String curCode = args[0];

		LocalDate currentDate = LocalDate.now().minusYears(5);
		LocalDate monthDate = currentDate.minusDays(30);

		final String urlAPIMonthlyMax = "https://api.coindesk.com/v1/bpi/historical/close.json?start=" + monthDate
				+ "&end=" + currentDate + "&currency=" + curCode;
		// final String urlAPIMonthlyMax =
		// "https://api.coindesk.com/v1/bpi/historical/close.json?start=2013-09-01&end=2013-09-05&currency=eur";

		final String urlForBitcoinRate = "https://api.coindesk.com/v1/bpi/currentprice/" + curCode.toLowerCase()
				+ ".json";
		BitcoinUtil bitcoinUtil = new BitcoinUtil();
		try {
			bitcoinUtil.getCurrentBitCoinRate(curCode.toUpperCase(), urlForBitcoinRate, "GET");
			bitcoinUtil.callMinMaxBitCoinRate(curCode.toLowerCase(), urlAPIMonthlyMax, "GET");

		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}

}
