package in.nit.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import  static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.Shippping;

import in.nit.service.IShipppingservice;


@Controller
@RequestMapping("/shipping")
public class ShipppingController {

	@Autowired
	private IShipppingservice service;

	@RequestMapping("/register")
	public String showUom(Model model) {
		
		//FORM BACKING OBJECT
	model.addAttribute("shippping",new Shippping());
	
		return "ShipppingRegisterpage";
	}

	// save operation 
	@RequestMapping(value="/save",method=POST)
	public String saveShippping(
			@ModelAttribute Shippping shippping,Model model) {
		    Integer id=service.saveShippping(shippping);

		String message="shippping type'"+id+"'saved";
		model.addAttribute("message",message);
		
		//FORM BACKING OBJECT
		model.addAttribute("shipping",new Shippping());
		return "ShipppingRegisterpage";
	}

	//select operation
	@RequestMapping("/all")
	public String loadallShippping(Model model) {
		List<Shippping> list=service.loadallShippping();
		model.addAttribute("list",list);
		System.out.println(list);
		return "ShipppingDataPage";
	}
	//delete operation
	@RequestMapping("/delete")
	public String delete(@RequestParam("sid")Integer id,Model model) {
		service.deleteShippping(id);
		String Message="shipment'"+id+"' is deleted";
		//after deleting the record to fetch record 
		List<Shippping> list=service.loadallShippping();
		model.addAttribute("list",list);
   
		return "ShipppingDataPage";

	}


	 @RequestMapping("/edit") 
	  public String showEditpage(@RequestParam("sid")Integer id,Model model) { 
		 Shippping u=service.getOneShippping(id);
	  //send to data to ui page model
	  model.addAttribute("shippping",u); 
	  return "ShipppingEditPage"; 
	  }
	  
	  @RequestMapping(value="update",method=POST)
	 public String updateShippping(@ModelAttribute Shippping shippping,Model model) {
		  service.updateShippping(shippping);
		  String message="shipment "+shippping.getShippId()+"updated";
		  model.addAttribute("message",message);
		  List<Shippping> list=service.loadallShippping();
		  model.addAttribute("list",list);
		  return "ShipppingDataPage";
		 
	 }
	  @RequestMapping("/view")
	  public String showOneShippping(@RequestParam("sid")Integer id,Model model){
		  
		  
		  Shippping u= service.getOneShippping(id);
		 model.addAttribute("ob",u);
		  
		  return "ShipppingViewPage";
	  } 

	
}
