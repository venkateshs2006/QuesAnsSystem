package com.phd.quesans.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.phd.quesans.dto.SearchKeywordDTO;
import com.phd.quesans.service.KeywordService;

@Controller
public class AdminKeywordController {

		@Autowired
		private KeywordService keywordService;
		
		@RequestMapping(value = "/KEYSave", method = RequestMethod.POST)
		public ModelAndView saveEmployee(@ModelAttribute("searchKeyword") SearchKeywordDTO searchKeyword, 
				BindingResult result) {
			
			//SearchKeywordDTO searchKeyword = searchKeyword;
			keywordService.addSearchKeyword(searchKeyword);
			System.out.println("Save method");
			return new ModelAndView("redirect:/KEYAdd.html");
		}

		
		@RequestMapping(value = "/KEYAdd", method = RequestMethod.GET)
		public ModelAndView addEmployee(@ModelAttribute("searchKeyword") SearchKeywordDTO searchKeyword,
				BindingResult result) {
			System.out.println("Add method");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("searchKeywordList",  keywordService.getSearchKeywordList());
			return new ModelAndView("addKeyword", model);
		}
		
		@RequestMapping(value = "/KEYIndex", method = RequestMethod.GET)
		public ModelAndView welcome() {
			return new ModelAndView("redirect:/KEYAdd.html");
		}
		
		
		@RequestMapping(value = "/KEYDelete", method = RequestMethod.GET)
		public ModelAndView deleteEmployee(@ModelAttribute("searchKeyword")  SearchKeywordDTO searchKeyword,
				BindingResult result) {
			
			keywordService.deleteSearchKeyword(searchKeyword);
			Map<String, Object> model = new HashMap<String, Object>();
			System.out.println("Delete method");
			model.put("searchKeywordList",  keywordService.getSearchKeywordList());
			return new ModelAndView("addKeyword", model);
		}
		
		@RequestMapping(value = "/KEYEdit", method = RequestMethod.GET)
		public ModelAndView editEmployee(@ModelAttribute("searchKeyword")  SearchKeywordDTO searchKeyword,
				BindingResult result) {
			System.out.println("Edit method");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("searchKeyword", keywordService.getSearchKeyword(searchKeyword.getKeywordid()));
			model.put("searchKeywordList",  keywordService.getSearchKeywordList());
			return new ModelAndView("addKeyword", model);
		}
		
		/*private Employee prepareModel(EmployeeBean employeeBean){
			Employee employee = new Employee();
			employee.setEmpAddress(employeeBean.getAddress());
			employee.setEmpAge(employeeBean.getAge());
			employee.setEmpName(employeeBean.getName());
			employee.setSalary(employeeBean.getSalary());
			employee.setEmpId(employeeBean.getId());
			employeeBean.setId(null);
			return employee;
		}
		
		private List<EmployeeBean> prepareListofBean(List<Employee> employees){
			List<EmployeeBean> beans = null;
			if(employees != null && !employees.isEmpty()){
				beans = new ArrayList<EmployeeBean>();
				EmployeeBean bean = null;
				for(Employee employee : employees){
					bean = new EmployeeBean();
					bean.setName(employee.getEmpName());
					bean.setId(employee.getEmpId());
					bean.setAddress(employee.getEmpAddress());
					bean.setSalary(employee.getSalary());
					bean.setAge(employee.getEmpAge());
					beans.add(bean);
				}
			}
			return beans;
		}
		
		private EmployeeBean prepareEmployeeBean(Employee employee){
			EmployeeBean bean = new EmployeeBean();
			bean.setAddress(employee.getEmpAddress());
			bean.setAge(employee.getEmpAge());
			bean.setName(employee.getEmpName());
			bean.setSalary(employee.getSalary());
			bean.setId(employee.getEmpId());
			return bean;
		}
	}*/

		
}
