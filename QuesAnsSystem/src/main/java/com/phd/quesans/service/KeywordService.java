package com.phd.quesans.service;

import java.util.List;

import com.phd.quesans.dto.SearchKeywordDTO;

public interface KeywordService {
	public SearchKeywordDTO getSearchKeyword(int id);
	public List<SearchKeywordDTO> getSearchKeywordList();
	public int addSearchKeyword(SearchKeywordDTO searchKeywordDTO);
	public int deleteSearchKeyword(SearchKeywordDTO searchKeywordDTO);
	
}
