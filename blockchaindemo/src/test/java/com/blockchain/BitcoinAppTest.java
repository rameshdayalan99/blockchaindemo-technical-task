package com.blockchain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Scanner;

import org.junit.Test;

import com.blockchain.util.BitcoinUtil;

/**
 * Unit test for simple App.
 */
public class BitcoinAppTest 
{
	String curCode = "EUR";
	BitcoinUtil bitcoinUtil = new BitcoinUtil();

	LocalDate currentDate = LocalDate.now().minusYears(5);// format(DateTimeFormatter.ofPattern("YY-mm-dd"));
//	System.out.println("CURRET DDDD " + currentDate);
	LocalDate monthDate = currentDate.minusDays(30);
	
	public  String urlAPIMonthlyMax = "https://api.coindesk.com/v1/bpi/historical/close.json?start="+currentDate+"&end="+currentDate+"&currency="+curCode;
	//final String urlAPIMonthlyMax = "https://api.coindesk.com/v1/bpi/historical/close.json?start=2013-09-01&end=2013-09-05&currency=eur";
	public  String urlForBitcoinRate = "https://api.coindesk.com/v1/bpi/currentprice/"+curCode.toLowerCase()+"json";
	public static String inr_json ="{\"time\":{\"updated\":\"Jul 10, 2022 15:33:00 UTC\",\"updatedISO\":\"2022-07-10T15:33:00+00:00\",\"updateduk\":\"Jul 10, 2022 at 16:33 BST\"},\"disclaimer\":\"This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org\",\"bpi\":{\"USD\":{\"code\":\"USD\",\"rate\":\"20,946.3018\",\"description\":\"United States Dollar\",\"rate_float\":20946.3018},\"INR\":{\"code\":\"INR\",\"rate\":\"1,658,089.5131\",\"description\":\"Indian Rupee\",\"rate_float\":1658089.5131}}}";
	HttpURLConnection conn = null;	
	public Scanner scan = null;
	public String requestMethod="GET";
	URL url= null;
	
	
	/*
	 * @BeforeClass public void setUp() {
	 * 
	 * try { url = new URL(urlAPIMonthlyMax); conn = (HttpURLConnection)
	 * url.openConnection(); conn.setRequestMethod(requestMethod); //conn.connect();
	 * //int responseCode = conn.getResponseCode(); }catch(Exception e) {} }
	 */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    
	/*
	 * @Test public void callAPITestSuccess() throws Exception { url = new
	 * URL(urlAPIMonthlyMax); conn = (HttpURLConnection) url.openConnection();
	 * conn.setRequestMethod(requestMethod); conn.connect(); int responseCode =
	 * conn.getResponseCode(); assertEquals("Values is 200",200,responseCode); }
	 * 
	 * @Test public void callAPIFailForCurrencyTest() throws Exception {
	 * 
	 * String curCode="AUS"; urlAPIMonthlyMax =
	 * "https://api.coindesk.com/v1/bpi/historical/close.json?start="+currentDate+
	 * "&end="+currentDate+"&currency="+curCode; url = new URL(urlAPIMonthlyMax);
	 * conn = (HttpURLConnection) url.openConnection();
	 * conn.setRequestMethod(requestMethod); conn.connect(); int responseCode =
	 * conn.getResponseCode(); assertEquals("Values is  404",404,responseCode); }
	 * 
	 * @Test public void callAPISuccessForCurrencyTest()throws Exception{ scan =
	 * bitcoinUtil.callAPI(curCode, urlAPIMonthlyMax, "GET"); assertNotNull(scan); }
	 */
    
}
