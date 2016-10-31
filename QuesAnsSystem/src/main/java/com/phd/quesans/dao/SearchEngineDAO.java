package com.phd.quesans.dao;

import java.util.List;

import com.phd.quesans.dto.SearchEngineDTO;

public interface SearchEngineDAO {
	public SearchEngineDTO getSearchEngine(int id);
	public List<SearchEngineDTO> getSearchEngineList();
	public int addSearchEngine(SearchEngineDTO searchEngine);
	public int deleteSearchEngine(SearchEngineDTO searchEngine);
}
