package com.phd.quesans.crawler;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class WebSearchEngine {
	private WebCrawlerHU webCrawlerHU;
	public String getGoogleResult(String URL, String tag, String className) {
		try {
			webCrawlerHU = new WebCrawlerHU();
			String divResultContent = webCrawlerHU.getContentByClass(URL, tag, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Google content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}

	public String getWikipediaResult(String URL, String tag, String className) {
		try {
			webCrawlerHU = new WebCrawlerHU();
			String divResultContent = webCrawlerHU.getContentByClass(URL, tag, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Wiki content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}

	public String getBingResult(String URL, String tag, String className) {
		try {
			webCrawlerHU = new WebCrawlerHU();
			String divResultContent = webCrawlerHU.getContentByClass(URL, tag, className);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Bing content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}

	public String getYahooResult(String URL, String tag, String elementId) {
		try {
			webCrawlerHU = new WebCrawlerHU();
			String divResultContent = webCrawlerHU.getContentByTagId(URL, tag, elementId);
			return divResultContent;
		} catch (Exception e) {
			System.out.println("Error while fetching Bing content" + e.getMessage());
			return "Page Crawling is failed. Please contact administrator";
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		try {
			WebSearchEngine webSearchEngine = new WebSearchEngine();
			File google = new File("google.html");
			File wiki = new File("wiki.html");
			File bing = new File("bing.html");
			File yahoo = new File("yahoo.html");
			FileUtils.writeStringToFile(google,
					webSearchEngine.getGoogleResult("http://www.google.co.in/search?q=Father of Facebook", "div", "_RBg"));
			System.out.println("Google Completed");
			FileUtils.writeStringToFile(wiki, webSearchEngine.getWikipediaResult("http://en.wikipedia.org/wiki/Larry_Page",
					"div", "mw-body-content"));
			System.out.println("Wikipage Completed");
			FileUtils.writeStringToFile(bing,
					webSearchEngine.getBingResult("http://www.bing.com/search?q=larry+page", "div", "b_entityTP"));
			System.out.println("Bing Completed");
			FileUtils.writeStringToFile(yahoo,
					webSearchEngine.getYahooResult("http://search.yahoo.com/search?p=Mark+Zuckerberg", "div", "right"));
			System.out.println("Yahoo Completed");
		} catch (Exception e) {
			System.out.println("Exception occured" + e.getMessage());
		}
	}
}
