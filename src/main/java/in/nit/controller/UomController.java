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

import in.nit.model.Uom;
import in.nit.service.IUomservice;
import in.nit.util.UomUtil;
import in.nit.view.UomExcelView;
import in.nit.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomservice service;
	
	@Autowired
	private ServletContext context;
	@Autowired
	private UomUtil util;


	@RequestMapping("/register")
	public String showUom(Model model) {
		
		//FORM BACKING OBJECT
	model.addAttribute("uom",new Uom());
		
		return "UomRegisterpage";
	}

	// save operation 
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUom(
			@ModelAttribute Uom uom,Model model) {
		    Integer id=service.saveUom(uom);

		String message="shipment type'"+id+"'saved";
		model.addAttribute("message",message);
		
		//FORM BACKING OBJECT
		model.addAttribute("uom",new Uom());
		return "UomRegisterpage";
	}

	//select operation
	@RequestMapping("/all")
	public String loadallUom(Model model) {
		List<Uom> list=service.loadallIUom();
		model.addAttribute("list",list);
		return "UomDataPage";
	}
	//delete operation
	@RequestMapping("/delete")
	public String delete(@RequestParam("sid")Integer id,Model model) {
		service.deleteUom(id);
		String Message="shipment'"+id+"' is deleted";
		//after deleting the record to fetch record 
		List<Uom> list=service.loadallIUom();
		model.addAttribute("list",list);

		return "UomDataPage";

	}


	 @RequestMapping("/edit") 
	  public String showEditpage(@RequestParam("sid")Integer id,Model model) { 
	 Uom u=service.getOneUom(id);
	  //send to data to ui page model
	  model.addAttribute("uom",u); 
	  return "UomEditPage"; 
	  }
	  
	  @RequestMapping(value="update",method=RequestMethod.POST)
	 public String updateUom(@ModelAttribute Uom uom,Model model) {
		  service.updateUom(uom);
		  String message="shipment "+uom.getUomId()+"updated";
		  model.addAttribute("message",message);
		  List<Uom> list=service.loadallIUom();
		  model.addAttribute("list",list);
		  return "UomDataPage";
		 
	 }
	  @RequestMapping("/view")
	  public String showOneUom(@RequestParam("sid")Integer id,Model model){
		  
		  
		 Uom u= service.getOneUom(id);
		 model.addAttribute("ob",u);
		  
		  return "UomViewPage";
	  } 
	  
	  @RequestMapping("/excel")
		public ModelAndView shoeExcell(
				@RequestParam(value="id",required=false) Integer id){
			ModelAndView n=new ModelAndView();
			n.setView(new UomExcelView());
			if(id==null) {
				//exports all rows
				List<Uom> list=service.loadallIUom();
				n.addObject("list",list);

			}
			else {
				Uom st=service.getOneUom(id);
				n.addObject("list",Arrays.asList(st));
			}
			return n;
		}

		@RequestMapping("/pdf")
		public ModelAndView showpdf(@RequestParam(value="id",required =false)Integer id) {

			ModelAndView m=new ModelAndView();
			m.setView(new UomPdfView());

			if(id==null) {
				//show all
				List<Uom> list=service.loadallIUom();
				m.addObject("list",list);
			} 
			else {
				//show one record

				Uom st=service.getOneUom(id);
				m.addObject("list",Arrays.asList(st));

			}
			return m;
		}
		
		//for piechart and barchart 
		@RequestMapping("/charts")
		public String showCharts() {
		List<Object[]> list=service.getUomModeCount();
		String path=context.getRealPath("/");
		util.generatePie(path, list);
		util.generateBar(path, list);
		return "UomCharts";
		}




	
}




