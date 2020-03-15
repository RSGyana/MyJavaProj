package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ShipmentType;
import in.nit.model.Uom;
import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeservice;
import in.nit.util.ShipmentTypeUtil;
import in.nit.util.WhUserTypeUtil;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;
import in.nit.view.WhUserTypeExcelView;
import in.nit.view.WhUserTypePdfView;

@Controller
@RequestMapping("/user")
public class WhUserTypeController {
	@Autowired
	private IWhUserTypeservice service;

	@Autowired
	private ServletContext context;
	@Autowired
	private WhUserTypeUtil util;

	
	@RequestMapping("/register")
	public String showUserRegisterPage(Model model) {

		//FORM BACKING OBJECT
		model.addAttribute("user",new WhUserType() );


		return "UserRegisterPage";
	}

	//save operation
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String Usersave(@ModelAttribute WhUserType whUserType ,Model model) {

		Integer id=service.saveUser(whUserType);
		String message="user '"+id+"'save";
		model.addAttribute("message",message);

		//FORM BACKING OBJECT
		model.addAttribute("user",new WhUserType() );

		return "UserRegisterPage";

	}

	@RequestMapping("/all")
	public String loadallUser(Model model) {
		List<WhUserType> list=service.loadallIUser();
		model.addAttribute("list",list);
		return "UserDataPage";
	}

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam("sid")Integer id,Model model) {
		service.deleteUser(id);
		String message="record'"+id+"' deleted";
		//after deleting the record again fetch
		List<WhUserType> list=service.loadallIUser();
		model.addAttribute("list",list);


		return "UserDataPage";
	}
	
	@RequestMapping("/edit")
	public String showeditPage(@RequestParam("sid")Integer id,Model model){
		
		WhUserType whUserType=service.getOneUser(id);
		model.addAttribute("user", whUserType);
		return "UserEditPage";
	} 
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String ShowUpadate(@ModelAttribute WhUserType whUserType,Model model) {
		service.updateUser(whUserType);
		String message="user"+whUserType.getUserId()+"updated";
		//send  data to ui page
		model.addAttribute("message",message);
		//fetching all record
		List<WhUserType> list=service.loadallIUser();
		//send to ui page
		model.addAttribute("list",list);
		
		return "UserDataPage";
	}
	
	@RequestMapping("/view")
	public String ShowUserPage(@RequestParam("sid")Integer id,Model model) {
		
		WhUserType u=service.getOneUser(id);
		model.addAttribute("ob", u);
		return"UserViewPage";
	}
	
	
	@RequestMapping("/excel")
	public ModelAndView shoeExcell(
			@RequestParam(value="id",required=false) Integer id){
		ModelAndView n=new ModelAndView();
		n.setView(new WhUserTypeExcelView());
		if(id==null) {
			//exports all rows
			List<WhUserType> list=service.loadallIUser();
			n.addObject("list",list);

		}
		else {
			WhUserType st=service.getOneUser(id);
			n.addObject("list",Arrays.asList(st));
		}
		return n;
	}

	@RequestMapping("/pdf")
	public ModelAndView showpdf(@RequestParam(value="id",required =false)Integer id) {

		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypePdfView());

		if(id==null) {
			//show all
			List<WhUserType> list=service.loadallIUser();
			m.addObject("list",list);
		} 
		else {
			//show one record

			WhUserType st=service.getOneUser(id);
			m.addObject("list",Arrays.asList(st));

		}
		return m;
	}
	//for piechart and barchart 
		@RequestMapping("/charts")
		public String showCharts() {
		List<Object[]> list=service.getUserModeCount();
		System.out.println(Arrays.toString(list.get(0)));
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "UserCharts";
		}


	
}


