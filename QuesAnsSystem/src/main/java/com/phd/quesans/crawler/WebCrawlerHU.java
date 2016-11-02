package com.phd.quesans.crawler;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebCrawlerHU {
	private static final String PROXY_HOST = "campus-proxy";
	private static final int PROXY_PORT = 8080;
	private static final String USERNAME = "venkatesh.sa";
	private static final String PASSWORD = "Sv25081985";
	private static final String DOMAIN = "HCLTECH";

	public static WebClient getWebConnection() {
		@SuppressWarnings("deprecation")
		WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38, PROXY_HOST, PROXY_PORT);
		DefaultCredentialsProvider cp = (DefaultCredentialsProvider) webClient.getCredentialsProvider();
		cp.addNTLMCredentials(USERNAME, PASSWORD, PROXY_HOST, PROXY_PORT, null, DOMAIN);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		return (webClient);
	}

	public String getPageContent(String URL) {
		WebClient webClient = WebCrawlerHU.getWebConnection();
		HtmlPage currentPage;
		try {
			currentPage = webClient.getPage(URL);
			WebResponse response = currentPage.getWebResponse();
			String content = response.getContentAsString();
			return content;
		} catch (FailingHttpStatusCodeException | IOException e) {
			System.out.println("Content based Exception occured" + e.getMessage());
			return "Page Crawling is Failed. Please Contact Administrator";
		}
	}

	public String getContentById(String URL, String elementId) throws Exception {
		try {
			WebClient webClient = WebCrawlerHU.getWebConnection();
			final HtmlPage page = webClient.getPage(URL);
			final HtmlDivision div = page.getHtmlElementById(elementId);
			return div.getTextContent();
		} catch (Exception e) {
			System.out.println("Element based Exception occured" + e.getMessage());
			return "Page Crawling is Failed. Please Contact Administrator";
		}
	}

	public String getContentByClass(String URL, String tag, String className) throws Exception {
		try {
			WebClient webClient = WebCrawlerHU.getWebConnection();
			final HtmlPage page = webClient.getPage(URL);
			HtmlDivision div = (HtmlDivision) page.getByXPath("//" + tag + "[@class='" + className + "']").get(0);
			return div.asXml();
		} catch (Exception e) {
			System.out.println("Class based exception occured" + e.getMessage());
			return "Page Crawling is Failed. Please Contact Administrator";
		}
	}

	public String getGoogleResult(String URL,String tag, String className) {
		try {
			WebCrawlerHU webCrawlerHU = new WebCrawlerHU();
			String divResultContent = webCrawlerHU
					.getContentByClass(URL, tag, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Google content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}
	public String getWikipediaResult(String URL,String tag, String className) {
		try {
			WebCrawlerHU webCrawlerHU = new WebCrawlerHU();
			String divResultContent = webCrawlerHU
					.getContentByClass(URL, tag, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Wiki content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		try {
			WebCrawlerHU webCrawlerHU = new WebCrawlerHU();
			File google=new File("google.html");
			File wiki=new File("wiki.html");
			FileUtils.writeStringToFile(google, webCrawlerHU.getGoogleResult("http://www.google.co.in/search?q=Father of Facebook","div","_RBg"));
			FileUtils.writeStringToFile(wiki, webCrawlerHU.getWikipediaResult("https://en.wikipedia.org/wiki/Larry_Page","div","mw-body-content"));
		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
	}
}
