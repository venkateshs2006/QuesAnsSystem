package com.phd.quesans.crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.select.Elements;

/**
 * Example program to list links from a URL.
 */

public class WebpageCrawer {
	private Document doc;

	public String getContent(String url) {

		try {
			doc = Jsoup.connect(url).get();
			String htmlContent = doc.html();
			return htmlContent;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getWikiContent(String url, String id) {
		String output = null;
		try {
			doc = Jsoup.connect(url).get();
			Element e = doc.getElementById(id);
			output = e.html();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			output = null;
		}
		return output;
	}

	public String getGooglecontent(String url) {
		String output = null;
		try {
			output = Jsoup.connect(url).get().html();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			output = null;
		}
		return output;
	}

	public Document getDocument(String url) {
		try {
			Document doc = Jsoup.connect(url).get();
			EscapeMode em = EscapeMode.xhtml;
			em.getMap().clear();

			doc.outputSettings().escapeMode(em);
			return doc;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	public String getSelectedContent(String url, String tag, String id) {
		try {
			// doc = Jsoup.connect(url).get();
			if (url.contains("google")) {
				String keyword = url.substring(url.indexOf("q=") + 2);
				doc = Jsoup
						.connect("https://www.google.com/search?as_q=&as_epq=%22" + keyword
								+ "%22+&as_oq=&as_eq=&as_nlo=&as_nhi=&lr=lang_en&cr=countryCA&as_qdr=all&as_sitesearch=&as_occt=any&safe=images&tbs=&as_filetype=&as_rights=")
						.userAgent("Mozilla").ignoreHttpErrors(true).timeout(0).get();
				System.out.println("https://www.google.com/search?as_q=&as_epq=%22" + keyword
						+ "%22+&as_oq=&as_eq=&as_nlo=&as_nhi=&lr=lang_en&cr=countryCA&as_qdr=all&as_sitesearch=&as_occt=any&safe=images&tbs=&as_filetype=&as_rights=");
			} else {
				doc = Jsoup.connect(url).get();
			}

			String tagContent = "";
			Elements tags = doc.select(tag);
			for (Element src : tags) {
				if (src.id().equalsIgnoreCase(id)) {
					tagContent = src.html();
					System.out.println("Inside If condition :" + tagContent
							.substring(tagContent.indexOf("<li class=\"g\">"), tagContent.indexOf("</li>")));
					break;
				}
			}
			// System.out.println("Whole Content :"+doc.html());

			return url.contains("google") ? Jsoup
					.parse(tagContent.substring(tagContent.indexOf("<li class=\"g\">"), tagContent.indexOf("</li>")))
					.text() : Jsoup.parse(tagContent).text();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	public String getSelectedContent(String url, String tag, String attrib, String id) {
		try {
			if (url.contains("google")) {
				String keyword = url.substring(url.indexOf("q=") + 2);
				doc = Jsoup
						.connect("https://www.google.com/search?as_q=&as_epq=%22" + keyword
								+ "%22+&as_oq=&as_eq=&as_nlo=&as_nhi=&lr=lang_en&cr=countryCA&as_qdr=all&as_sitesearch=&as_occt=any&safe=images&tbs=&as_filetype=&as_rights=")
						.userAgent("Mozilla").ignoreHttpErrors(true).timeout(0).get();
				System.out.println("https://www.google.com/search?as_q=&as_epq=%22" + keyword
						+ "%22+&as_oq=&as_eq=&as_nlo=&as_nhi=&lr=lang_en&cr=countryCA&as_qdr=all&as_sitesearch=&as_occt=any&safe=images&tbs=&as_filetype=&as_rights=");
			} else {
				doc = Jsoup.connect(url).get();
			}
			String tagContent = "";
			Elements tags = doc.select(tag);
			for (Element src : tags) {
				// System.out.println(src.tagName()+" :"+src.id());
				// if(src.className().equalsIgnoreCase(id)) {

				if (src.id().equalsIgnoreCase(id)) {
					tagContent = src.html();
					System.out.println("Inside If condition :" + tagContent
							.substring(tagContent.indexOf("<li class=\"g\">"), tagContent.indexOf("</li>")));
					break;
				}
			}
			// System.out.println("Whole Content :"+doc.html());
			return tagContent.substring(tagContent.indexOf("<li class=\"g\">"), tagContent.indexOf("</li>"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	public String getSelectedContent(String url, String tag, int position) {
		try {
			doc = Jsoup.connect(url).get();
			String tagContent = "";
			Elements tags = doc.select(tag);
			int starting = 1;
			for (Element src : tags) {
				if (starting == position) {
					System.out.println(src.html());
					tagContent = src.text();
					break;
				}
			}
			return tagContent;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	public String getTagContents(String url, String tag) {
		try {
			doc = Jsoup.connect(url).get();
			StringBuilder tagContent = new StringBuilder();
			Elements tags = doc.select(tag);
			for (Element src : tags) {
				tagContent.append(src.text());
				// System.out.println(src.text());

			}
			// System.out.println("Tag contents :"+tagContent);
			return tagContent.toString();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	public String getFirstTagContent(String url, String tag) {
		try {
			doc = Jsoup.connect(url).get();
			String tagContent = "";
			Elements tags = doc.select(tag);
			tagContent = tags.get(0).text();
			return tagContent;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getListOfLinks(String url) {
		try {
			doc = Jsoup.connect(url).get();

			Elements links = doc.select("a[href]");
			String linksDetails = "";
			for (Element link : links) {
				linksDetails += link.attr("abs:href") + "\n";
			}
			return linksDetails;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getImgURL(String url) {
		return null;
	}
	// public String getContent(String url) {
	// Document doc;
	// try {
	// doc = Jsoup.connect(url).get();
	// String htmlContent=doc.html();
	// return htmlContent;
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// return null;
	// }
	// }
	// public Document getDocument(String url) {
	// try {
	// return Jsoup.connect(url).get();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// return null;
	// }
	// }
	// public String getSelectedContent(String url,String tag, String id) {
	// return null;
	// }
	// public String getTagContent(String url, String tag) {
	// return null;
	// }
	// public String getListOfLinks(String url) {
	// return null;
	// }
	// public String getImgURL(String url) {
	// return null;
	// }
	// public static void main(String[] args) throws IOException {
	// // Validate.isTrue(args.length == 1, "usage: supply url to fetch");
	// String url = "http://en.wikipedia.org/wiki/India";
	// print("Fetching %s...", url);
	//
	// Document doc = Jsoup.connect(url).get();
	// String html=doc.html();
	// //XSystem.out.println("\n\n"+html+"\n");
	// //System.exit(0);
	// Elements divTag=doc.select("div");
	// Elements links = doc.select("a[href]");
	// Elements media = doc.select("[src]");
	// Elements imports = doc.select("link[href]");
	// for (Element src : divTag) {
	// System.out.println(src.attr("id").toString());
	// if(src.attr("id").equalsIgnoreCase("content")) {
	// System.out.println(divTag.text());
	// }
	// }
	//
	// System.exit(0);
	// print("\nMedia: (%d)", media.size());
	// for (Element src : media) {
	// if (src.tagName().equals("img"))
	// print(" * %s: <%s> %sx%s (%s)",
	// src.tagName(), src.attr("abs:src"), src.attr("width"),
	// src.attr("height"),
	// trim(src.attr("alt"), 20));
	// else
	// print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
	// }
	//
	// print("\nImports: (%d)", imports.size());
	// for (Element link : imports) {
	// print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"),
	// link.attr("rel"));
	// }
	//
	// print("\nLinks: (%d)", links.size());
	// for (Element link : links) {
	// print(" * a: <%s> (%s)", link.attr("abs:href"), trim(link.text(), 35));
	// }
	// }
	//
	// private static void print(String msg, Object... args) {
	// System.out.println(String.format(msg, args));
	// }
	//
	// private static String trim(String s, int width) {
	// if (s.length() > width)
	// return s.substring(0, width-1) + ".";
	// else
	// return s;
	// }
}
