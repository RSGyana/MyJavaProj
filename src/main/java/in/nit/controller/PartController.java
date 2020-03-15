 package in.nit.controller;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.Part;
import in.nit.model.Uom;
import in.nit.service.IOrderMethodservice;
import in.nit.service.IPartservice;
import in.nit.service.IUomservice;
import in.nit.service.impl.OrderMethodServiceImpl;
import in.nit.util.CommonUtil;
import in.nit.view.PartExcelView;
import in.nit.view.PartPdfView;


@Controller
@RequestMapping("/part")
public class PartController {
	
	@Autowired
	private IPartservice service;
	@Autowired 
	private IUomservice uomService;
	@Autowired
	private IOrderMethodservice omService;
	//COMMON UI
	private void CommonUi(Model model) {
		//UOM INTEGRETION PART
		List<Object[]> uomlist=uomService.getUomIdAndUomModel();
		Map<Integer,String> uomMap =CommonUtil.convert(uomlist);
		model.addAttribute("uomMap",uomMap);
		//ORDERMETHOD INRGRETION PART
		
		List<Object[]> omSaleList=omService.getOrderIdAndOrderCode("SALE");
		Map<Integer,String> omSaleMap=CommonUtil.convert(omSaleList);
		System.out.println(omSaleMap.toString());
		model.addAttribute("omSaleMap",omSaleMap);
		
		List<Object[]> omPurchaseList=omService.getOrderIdAndOrderCode("PURCHASE");
		Map<Integer,String> omPurchaseMap=CommonUtil.convert(omPurchaseList);
		System.out.println(omPurchaseMap.toString());
		model.addAttribute("omPurchaseMap",omPurchaseMap);

	}

	@RequestMapping("/register")
	public String showPart(Model model) {
		
		//FORM BACKING OBJECT
				model.addAttribute("part",new Part());
				CommonUi(model);
		
		return "PartRegisterPage";
	}

	// save operation 
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String savePart(
			@ModelAttribute Part part,Model model) {
		    Integer id=service.savePart(part);

		String message="part '"+id+"'saved";
		model.addAttribute("message",message);
		
		//FORM BACKING OBJECT
		model.addAttribute("part",new Part());
		CommonUi(model);

		return "PartRegisterPage";
	} 

	//select operation
	@RequestMapping("/all")
	public String loadallPart(Model model) {
		List<Part> list=service.getAllPart();
		model.addAttribute("list",list);
		
		return "PartDataPage";
	}
	//delete operation
	@RequestMapping("/delete")
	public String delete(@RequestParam("sid")Integer id,Model model) {
		service.deletePart(id);
		String Message="shipment'"+id+"' is deleted";
		//after deleting the record to fetch record 
		List<Part> list=service.getAllPart();
		model.addAttribute("list",list);

		return "PartDataPage";

	}


	 @RequestMapping("/edit") 
	  public String showEditpage(@RequestParam("sid")Integer id,Model model) { 
	 Part p=service.getOnePart(id);
	  System.out.println(p);
	  //send to data to ui page model
	  model.addAttribute("part",p); 
	  CommonUi(model);
	 
	  return "PartEditPage"; 
	  }
	  
	  @RequestMapping(value="update",method=RequestMethod.POST)
	 public String updateUom(@ModelAttribute Part part,Model model) {
		  service.updatePart(part);
		  String message="part "+part.getPartId()+"updated";
		  model.addAttribute("message",message);
		  List<Part> list=service.getAllPart();
		  model.addAttribute("list",list);
		  return "PartDataPage";
		 
	 }
	  @RequestMapping("/view")
	  public String showOnePart(@RequestParam("sid")Integer id,Model model){
		  
		  
		 Part p= service.getOnePart(id);
		 model.addAttribute("ob",p);
		  
		  return "PartViewPage";
	  } 

	  @RequestMapping("/excel")
		public ModelAndView shoeExcell(
				@RequestParam(value="id",required=false) Integer id){
			ModelAndView n=new ModelAndView();
			n.setView(new PartExcelView());
			if(id==null) {
				//exports all rows
				List<Part> list=service.getAllPart();
				n.addObject("list",list);

			}
			else {
				Part st=service.getOnePart(id);
				n.addObject("list",Arrays.asList(st));
			}
			return n;
		}

		@RequestMapping("/pdf")
		public ModelAndView showpdf(@RequestParam(value="id",required =false)Integer id) {

			ModelAndView m=new ModelAndView();
			m.setView(new PartPdfView());

			if(id==null) {
				//show all
				List<Part> list=service.getAllPart();
				m.addObject("list",list);
			} 
			else {
				//show one record

				Part st=service.getOnePart(id);
				m.addObject("list",Arrays.asList(st));

			}
			return m;
		}

	
	
		
		
		


		
		
		
		
		
	

}
