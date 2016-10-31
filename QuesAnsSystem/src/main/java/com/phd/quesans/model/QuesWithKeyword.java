package com.phd.quesans.model;

import java.util.List;

public class QuesWithKeyword {
	private int quesid;
	private String question;
	private String answer;
	//private int searchengineid;
	private List<String> keywords;
	public int getQuesid() {
		return quesid;
	}
	public void setQuesid(int quesid) {
		this.quesid = quesid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	/*public int getSearchengineid() {
		return searchengineid;
	}
	public void setSearchengineid(int searchengineid) {
		this.searchengineid = searchengineid;
	}*/
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
}
