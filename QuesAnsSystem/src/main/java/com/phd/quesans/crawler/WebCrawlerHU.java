package com.phd.quesans.crawler;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebCrawlerHU {
	private static final String PROXY_HOST = "campus-proxy";
	private static final int PROXY_PORT = 8080;
	private static final String USERNAME = "venkatesh.sa";
	private static final String PASSWORD = "Sv25081985";
	private static final String DOMAIN = "HCLTECH";

	public static WebClient getWebConnection() {
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38, PROXY_HOST, PROXY_PORT);
		DefaultCredentialsProvider cp = (DefaultCredentialsProvider) webClient.getCredentialsProvider();
		cp.addNTLMCredentials(USERNAME, PASSWORD, PROXY_HOST, PROXY_PORT, null, DOMAIN);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		return (webClient);
	}
public String getPageContent(){
	
	return null;
}
	public static void main(String args[]) {
		try {
			WebClient webClient=WebCrawlerHU.getWebConnection();
			HtmlPage currentPage = webClient.getPage("http://www.google.co.in/search?q=Father of Facebook");
			// System.out.println("Current Page :" + currentPage.asText());
			// HtmlAnchor advancedSearchAn =
			// currentPage.getAnchorByText("Next");
			// currentPage = advancedSearchAn.click();
			System.out.println("Google Advanced Search " + currentPage.getWebResponse().getStatusCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception occured" + e.getMessage());
		}

	}
}
