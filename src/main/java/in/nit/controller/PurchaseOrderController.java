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

import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseOrderservice;
import in.nit.view.PurchaseOrderExcelView;
import in.nit.view.PurchaseOrderPdfView;

@Controller
@RequestMapping("purchaseorder")
public class PurchaseOrderController {
	@Autowired
	private IPurchaseOrderservice service;
	
	

	@RequestMapping("/register")
	public String PurchaseOrderRegisterPage(Model model) {
		// FORM BACKING OBJECT
		model.addAttribute("purchaseOrder", new PurchaseOrder());
		return "PurchaseOrderRegisterPage";
	}

	// save operations
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String PurchaseSaleOrder(@ModelAttribute PurchaseOrder purchaseOrder, Model model) {

		Integer id = service.savePurchaseOrder(purchaseOrder);

		String message = "purchaseOrder'" + id + "'saved";
		model.addAttribute("message", message);

		// FORM BACKING OBJECT
		model.addAttribute("purchaseOrder", new PurchaseOrder());
		return "PurchaseOrderRegisterPage";

	}

	// select operation
	@RequestMapping("/all")
	public String getAllPurchaseOrder(Model model) {
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		model.addAttribute("list", list);
		return "PurchaseOrderData";
	}

	// delete operation
	@RequestMapping("/delete")
	public String deletepurchaseorder(@RequestParam("sid") Integer id, Model model) {
		service.deletePurchaseOrder(id);;
		String message = "purchaseOrder'" + id + "' is deleted";
		// after deleting the record to fetch record
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		model.addAttribute("list", list);

		return "PurchaseOrderData";

	}

	// edit
	@RequestMapping("/edit")
	public String showEditpage(@RequestParam("sid") Integer id, Model model) {
		PurchaseOrder s = service.getOnePurchaseOrder(id);

		// send to data to ui page model
		model.addAttribute("purchaseOrder", s);

		return "PurchaseOrderEdit";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute PurchaseOrder purchaseOrder, Model model) {
		service.updatePurchaseOrder(purchaseOrder);
		;
		String message = "purchase " + purchaseOrder.getPordId() + "updated";
		model.addAttribute("message", message);
		List<PurchaseOrder> list = service.getAllPurchaseOrder();
		model.addAttribute("list", list);
		return "PurchaseOrderData";

	}

	@RequestMapping("/view")
	public String showOnePurchaseOrder(@RequestParam("sid") Integer id, Model model) {
		PurchaseOrder s = service.getOnePurchaseOrder(id);
		model.addAttribute("ob", s);

		return "PurchaseOrderView";
	}
	
	@RequestMapping("/excel")
	public ModelAndView shoeExcell(
			@RequestParam(value="id",required=false) Integer id){
		ModelAndView n=new ModelAndView();
		n.setView(new PurchaseOrderExcelView());
		if(id==null) {
			//exports all rows
			List<PurchaseOrder> list=service.getAllPurchaseOrder();
			n.addObject("list",list);

		}
		else {
			PurchaseOrder st=service.getOnePurchaseOrder(id);
			n.addObject("list",Arrays.asList(st));
		}
		return n;
	}

	@RequestMapping("/pdf")
	public ModelAndView showpdf(@RequestParam(value="id",required = false)Integer id) {

		ModelAndView m=new ModelAndView();
		m.setView(new PurchaseOrderPdfView());

		if(id==null) {
			//show all
			List<PurchaseOrder> list=service.getAllPurchaseOrder();
			m.addObject("list",list);
		} 
		else {
			//show one record

			PurchaseOrder st=service.getOnePurchaseOrder(id);
			m.addObject("list",Arrays.asList(st));

		}
		return m;
	}

}
