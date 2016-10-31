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

import com.phd.quesans.dto.QuestionDTO;
import com.phd.quesans.service.QuestionService;

@Controller
public class AdminQuestionController {

		@Autowired
		private QuestionService questionService;
		
		@RequestMapping(value = "/QUESSave", method = RequestMethod.POST)
		public ModelAndView saveEmployee(@ModelAttribute("questionBean") QuestionDTO QuestionBean, 
				BindingResult result) {
			
			QuestionDTO question = QuestionBean;
			questionService.addQuestion(question);
			System.out.println("Save method");
			return new ModelAndView("redirect:/QUESAdd.html");
		}

		
		@RequestMapping(value = "/QUESAdd", method = RequestMethod.GET)
		public ModelAndView addEmployee(@ModelAttribute("questionBean")  QuestionDTO QuestionBean,
				BindingResult result) {
			System.out.println("Add method");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("questionList",  questionService.getQuestionList());
			return new ModelAndView("addQuestions", model);
		}
		
		@RequestMapping(value = "/QUESIndex", method = RequestMethod.GET)
		public ModelAndView welcome() {
			return new ModelAndView("redirect:/QUESAdd.html");
		}
		
		
		@RequestMapping(value = "/QUESDelete", method = RequestMethod.GET)
		public ModelAndView deleteEmployee(@ModelAttribute("questionBean")  QuestionDTO QuestionBean,
				BindingResult result) {
			
			questionService.deleteQuestion(QuestionBean);
			Map<String, Object> model = new HashMap<String, Object>();
			System.out.println("Delete method");
			model.put("questionList",  questionService.getQuestionList());
			return new ModelAndView("addQuestions", model);
		}
		
		@RequestMapping(value = "/QUESEdit", method = RequestMethod.GET)
		public ModelAndView editEmployee(@ModelAttribute("questionBean")  QuestionDTO QuestionBean,
				BindingResult result) {
			System.out.println("Edit method");
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("questionBean", questionService.getQuestion(QuestionBean.getQuesid()));
			model.put("questionList",  questionService.getQuestionList());
			return new ModelAndView("addQuestions", model);
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
