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
import in.nit.service.IShipmentTypeService;
import in.nit.util.ShipmentTypeUtil;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;
	
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentTypeUtil util;


	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/register")
	public String ShowRegPage(Model model){
		//FORM BACKING OBJECT
		model.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}

	//save operations
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveShipment(
			@ModelAttribute ShipmentType shipmentType,Model model ) {

		Integer id=service.saveShipmentType(shipmentType);

		String message="shipment type'"+id+"'saved";
		model.addAttribute("message",message);

		//FORM BACKING OBJECT
		model.addAttribute("shipmentType",new ShipmentType() );
		return "ShipmentTypeRegister";


	}
	//select operation
	@RequestMapping("/all")
	public String getAllShipmentTypes(Model model) {
		List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}
	//delete operation
	@RequestMapping("/delete")
	public String deleteShipmentType(@RequestParam("sid")Integer id,Model model) {
		service.deleteShipmentType(id);
		String message="shipment'"+id+"' is deleted";
		//after deleting the record to fetch record 
		List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list",list);

		return "ShipmentTypeData";

	}
    //edit
	@RequestMapping("/edit") 
	public String showEditpage(@RequestParam("sid")Integer id,Model model) { 
		ShipmentType st=service.getOneShipmentType(id);

		//send to data to ui page model
		model.addAttribute("shipmentType",st); 


		return "ShipmentTypeEdit"; 
	}

	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType,Model model) {
		service.updateShipmentType(shipmentType);
		String message="shipment "+shipmentType.getShipId()+"updated";
		model.addAttribute("message",message);
		List<ShipmentType> list=service.getAllShipmentType();
		model.addAttribute("list",list);
		return "ShipmentTypeData";

	}
	@RequestMapping("/view")
	public String showOneShipmenType(@RequestParam("sid")Integer id,Model model){


		ShipmentType st= service.getOneShipmentType(id);
		model.addAttribute("ob",st);

		return "ShipmentTypeView";
	}


	@RequestMapping("/excel")
	public ModelAndView shoeExcell(
			@RequestParam(value="id",required=false) Integer id){
		ModelAndView n=new ModelAndView();
		n.setView(new ShipmentTypeExcelView());
		if(id==null) {
			//exports all rows
			List<ShipmentType> list=service.getAllShipmentType();
			n.addObject("list",list);

		}
		else {
			ShipmentType st=service.getOneShipmentType(id);
			n.addObject("list",Arrays.asList(st));
		}
		return n;
	}

	@RequestMapping("/pdf")
	public ModelAndView showpdf(@RequestParam(value="id",required =false)Integer id) {

		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypePdfView());

		if(id==null) {
			//show all
			List<ShipmentType> list=service.getAllShipmentType();
			m.addObject("list",list);
		} 
		else {
			//show one record

			ShipmentType st=service.getOneShipmentType(id);
			m.addObject("list",Arrays.asList(st));

		}
		return m;
	}
	//for piechart and barchart 
	@RequestMapping("/charts")
	public String showCharts() {
	List<Object[]> list=service.getShipmentModeCount();
	String path=context.getRealPath("/");
	util.generatePie(path, list);
	util.generateBar(path, list);
	return "ShipmentTypeCharts";
	}



}

