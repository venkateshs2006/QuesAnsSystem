package com.phd.quesans.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SearchKeyword")
public class SearchKeywordDTO {
	@Id
	private int keywordid;
	private int searchengineid;
	private int quesid; 
	private String keyword;
	public int getKeywordid() {
		return keywordid;
	}
	public void setKeywordid(int keywordid) {
		this.keywordid = keywordid;
	}
	public int getSearchengineid() {
		return searchengineid;
	}
	public void setSearchengineid(int searchengineid) {
		this.searchengineid = searchengineid;
	}
	public int getQuesid() {
		return quesid;
	}
	public void setQuesid(int quesid) {
		this.quesid = quesid;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "SearchKeyword [keywordid=" + keywordid + ", searchengineid=" + searchengineid + ", quesid=" + quesid
				+ ", keyword=" + keyword + "]";
	}
	
}
