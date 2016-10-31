package com.phd.quesans.crawler;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Webcrawler {
	public static void main(String args[]){
		try {
			WebClient webClient = new WebClient();
			HtmlPage currentPage = webClient.getPage("https://en.wikipedia.org/wiki/Main_Page");
			System.out.println("Current Page :"+currentPage.asText());
			HtmlAnchor advancedSearchAn = 
					currentPage.getAnchorByText("Wikipedia");
			
				currentPage = advancedSearchAn.click();
				System.out.println("Google Advanced Search "+currentPage.getTitleText());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception occured"+e.getMessage());
			}
			
		}
}
