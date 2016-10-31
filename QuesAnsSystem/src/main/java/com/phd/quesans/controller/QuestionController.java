package com.phd.quesans.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.phd.quesans.dto.SearchEngineDTO;
import com.phd.quesans.model.Question;
import com.phd.quesans.model.SessionSearchEngine;
import com.phd.quesans.service.QuesAnsService;


@Controller
public class QuestionController {
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	@Autowired
	private QuesAnsService quesAnsService;
/*	@RequestMapping(value = "/RequestQuestion", method = RequestMethod.GET)
	public String requestQues(Locale locale, Model model) {
		//Question question = new Question();
		//modelMap.put("question", question);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		//model.addAttribute(question);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("question", new Question()); 
		model.addAttribute("serverTime", formattedDate );		
		return "home";
	}*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession httpSession) {
		logger.info("Welcome QuesAns! The client locale is {}.", locale);
		List<SessionSearchEngine> sessionSearchEngines=new ArrayList<SessionSearchEngine>();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		List<SearchEngineDTO> searchEngineDTOs=quesAnsService.listSearchEngine();
		for(SearchEngineDTO searchEngineDTO:searchEngineDTOs){
			SessionSearchEngine sessionSearchEngine=new SessionSearchEngine();
			sessionSearchEngine.setSearchEngineId(searchEngineDTO.getSearchEngineId());
			sessionSearchEngine.setSearchEngineName(searchEngineDTO.getSearchEngineName());
			sessionSearchEngines.add(sessionSearchEngine);
		}
		httpSession.setAttribute("searchEngineList", sessionSearchEngines);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("question", new Question()); 
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}	
	
	
	@RequestMapping(value = "/getMachedQuestion", method = RequestMethod.GET)
	@ResponseBody
	    public String  getMachedNames(@RequestParam(required=false,value="term") String name){
	    System.out.println("Got Executed:::"+name);
	    List<String> matchName =quesAnsService.listQuestion(name);
	    System.out.println("Question Output String :"+matchName.toString());
	    Gson gson=new Gson();
	    return gson.toJson(matchName);
	    }
}

//class DataCache {
//    
//    static StringBuilder dataCache;
//    static String [] data;
//    static{
//    
//    dataCache = new StringBuilder();
//    dataCache.append("Aaron Hank,Abagnale Frank,Abbey Edward,Abel Reuben,Abelson Hal,"
//        + "Abourezk James,Abrams Creighton,Ace Jane,Ba Jin,Baba Meher,Baba Tupeni,"
//        + "Babbage Charles,Babbitt Milton,Bacevich Andrew,Bach Richard,Bachelard Gaston,"
//        + "Bachelot Roselyne,Bacon Francis,Baddiel David,Baden-Powell Sir Robert (B-P),"
//        + "Badiou, Alain,Badnarik, Michael,Cabell James Branch,Caesar Irving,Caesar Julius,"
//        + "Cage John,Cain Peter,Callaghan James,Calvin John,Cameron Julia,Cameron Kirk,"
//        + "Java Honk,Java Honk Test,Java Honk Test Successful,Java Honk Spring MVC,"
//        + "Java Honk autocomplete,Java Honk Spring MVC autocomplete List");
//    
//    data =dataCache.toString().split(",");
//    }
//    
//    public static List<String> getName(String name) {
//
//    List<String> returnMatchName = new ArrayList<String>();
//    String [] data =dataCache.toString().split(",");    
//    for (String string : data) {
//        if (string.toUpperCase().indexOf(name.toUpperCase())!= -1) {
//        returnMatchName.add(string);
//        }
//    }
//    
//    return returnMatchName;
//    }

//}
//}