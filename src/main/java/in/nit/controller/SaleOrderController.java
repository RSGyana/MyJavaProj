package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.SaleOrder;
import in.nit.service.ISaleOrderservice;
import in.nit.view.SaleOrderExcelView;
import in.nit.view.SaleOrderPdfView;

@Controller
@RequestMapping("/saleorder")
public class SaleOrderController {

	@Autowired
	private ISaleOrderservice service;
	
	

	@RequestMapping("/register")
	public String SaleOrderRegisterPage(Model model) {
		// FORM BACKING OBJECT
		model.addAttribute("saleOrder", new SaleOrder());
		return "SaleOrderRegisterPage";
	}

	// save operations
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveSaleOrder(@ModelAttribute SaleOrder saleOrder, Model model) {

		Integer id = service.saveSaleOrder(saleOrder);

		String message = "saleorder'" + id + "'saved";
		model.addAttribute("message", message);

		// FORM BACKING OBJECT
		model.addAttribute("saleOrder", new SaleOrder());
		return "SaleOrderRegisterPage";

	}

	// select operation
	@RequestMapping("/all")
	public String getAllSaleOrder(Model model) {
		List<SaleOrder> list = service.getAllSaleOrder();
		model.addAttribute("list", list);
		return "SaleOrderTypeData";
	}

	// delete operation
	@RequestMapping("/delete")
	public String deleteShipmentType(@RequestParam("sid") Integer id, Model model) {
		service.deleteSaleOrder(id);
		String message = "saleorders'" + id + "' is deleted";
		// after deleting the record to fetch record
		List<SaleOrder> list = service.getAllSaleOrder();
		model.addAttribute("list", list);

		return "SaleOrderTypeData";

	}

	// edit
	@RequestMapping("/edit")
	public String showEditpage(@RequestParam("sid") Integer id, Model model) {
		SaleOrder s = service.getOneSaleOrder(id);

		// send to data to ui page model
		model.addAttribute("saleOrder", s);

		return "SaleOrderEdit";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute SaleOrder saleOrder, Model model) {
		service.updateSaleOrder(saleOrder);
		;
		String message = "shipment " + saleOrder.getSordId() + "updated";
		model.addAttribute("message", message);
		List<SaleOrder> list = service.getAllSaleOrder();
		model.addAttribute("list", list);
		return "SaleOrderTypeData";

	}

	@RequestMapping("/view")
	public String showOneSaleOrder(@RequestParam("sid") Integer id, Model model) {

		SaleOrder s = service.getOneSaleOrder(id);
		model.addAttribute("ob", s);

		return "SaleOrderView";
	}
	
	@RequestMapping("/excel")
	public ModelAndView shoeExcell(
			@RequestParam(value="id",required=false) Integer id){
		ModelAndView n=new ModelAndView();
		n.setView(new SaleOrderExcelView());
		if(id==null) {
			//exports all rows
			List<SaleOrder> list=service.getAllSaleOrder();
			n.addObject("list",list);

		}
		else {
			SaleOrder st=service.getOneSaleOrder(id);
			n.addObject("list",Arrays.asList(st));
		}
		return n;
	}

	@RequestMapping("/pdf")
	public ModelAndView showpdf(@RequestParam(value="id",required = false)Integer id) {

		ModelAndView m=new ModelAndView();
		m.setView(new SaleOrderPdfView());

		if(id==null) {
			//show all
			List<SaleOrder> list=service.getAllSaleOrder();
			m.addObject("list",list);
		} 
		else {
			//show one record

			SaleOrder st=service.getOneSaleOrder(id);
			m.addObject("list",Arrays.asList(st));

		}
		return m;
	}
}
