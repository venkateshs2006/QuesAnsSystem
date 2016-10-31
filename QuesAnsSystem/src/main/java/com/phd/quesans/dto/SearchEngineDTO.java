package com.phd.quesans.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "searchengine")
public class SearchEngineDTO {
	@Id
	private int searchEngineId;
	private String searchEngineName;
	private String searchEngineURL;
	private String resultTag;
	private String resultTagAttrbName;
	private String resultTagAttrbValue;
	private int tagPosition;
	private String regexDetails;

	public int getTagPosition() {
		return tagPosition;
	}

	public void setTagPosition(int tagPosition) {
		this.tagPosition = tagPosition;
	}

	public int getSearchEngineId() {
		return searchEngineId;
	}

	public void setSearchEngineId(int searchEngineId) {
		this.searchEngineId = searchEngineId;
	}

	public String getSearchEngineName() {
		return searchEngineName;
	}

	public void setSearchEngineName(String searchEngineName) {
		this.searchEngineName = searchEngineName;
	}

	public String getSearchEngineURL() {
		return searchEngineURL;
	}

	public void setSearchEngineURL(String searchEngineURL) {
		this.searchEngineURL = searchEngineURL;
	}

	public String getResultTag() {
		return resultTag;
	}

	public void setResultTag(String resultTag) {
		this.resultTag = resultTag;
	}

	public String getRegexDetails() {
		return regexDetails;
	}
	

	public void setRegexDetails(String regexDetails) {
		this.regexDetails = regexDetails;
	}

	public String getResultTagAttrbName() {
		return resultTagAttrbName;
	}

	public void setResultTagAttrbName(String resultTagAttrbName) {
		this.resultTagAttrbName = resultTagAttrbName;
	}

	public String getResultTagAttrbValue() {
		return resultTagAttrbValue;
	}

	public void setResultTagAttrbValue(String resultTagAttrbValue) {
		this.resultTagAttrbValue = resultTagAttrbValue;
	}

	@Override
	public String toString() {
		return "SearchEnginePojo [searchEngineId=" + searchEngineId + ", searchEngineName=" + searchEngineName
				+ ", searchEngineURL=" + searchEngineURL + ", resultTag=" + resultTag + ", resultTagAttrbName="
				+ resultTagAttrbName + ", resultTagAttrbValue=" + resultTagAttrbValue + ", TagPosition=" + tagPosition
				+ ", regexDetails=" + regexDetails + "]";
	}

}
