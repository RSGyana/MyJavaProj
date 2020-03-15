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

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodservice;
import in.nit.util.OrderMethodUtil;
import in.nit.view.OrderMethodExcelView;
import in.nit.view.OrderMethodPdfView;

@Controller
@RequestMapping("/order")
public class OrderMethodController {
	@Autowired
	private IOrderMethodservice service;
	
	@Autowired
	private ServletContext context;
	@Autowired
	private OrderMethodUtil util;

	  
	@RequestMapping("/register")
	public String orderResgisterpage(Model model) {
		//FORM BACKIING OBJECTS
		model.addAttribute("orderMethod",new OrderMethod());
		return "OrderMethodRegisterPage";
	}
	
	// save operation 
		@RequestMapping(value="/save",method=RequestMethod.POST)
		public String saveUom(
				@ModelAttribute OrderMethod orderMethod,Model model ) {

			Integer id=service.saveOrder(orderMethod);

			String message="shipment type'"+id+"'saved";
			model.addAttribute("message",message);
			//FORM BACKIING OBJECTS
			model.addAttribute("orderMethod",new OrderMethod());
			return "OrderMethodRegisterPage";
		}
		
		
		//select operation
		@RequestMapping("/all")
		public String loadallUom(Model model) {
			List<OrderMethod> list=service.getAllOrder();
			model.addAttribute("list",list);
			return "OrderMethodDataPage";
		}
		
		
		//delete operation
		@RequestMapping("/delete")
		public String delete(@RequestParam("sid")Integer id,Model model) {
			service.deleteOrder(id);
			String Message="shipment'"+id+"' is deleted";
			//after deleting the record to fetch record 
			List<OrderMethod> list=service.getAllOrder();
			model.addAttribute("list",list);

			return "OrderMethodDataPage";

		}
		
		@RequestMapping("/edit")
		public String editOrder(@RequestParam("sid")Integer id,Model model) {
		OrderMethod om	=service.getOneOrderMethod(id);
		//send to ui page
		model.addAttribute("orderMethod",om);
			return "OrderMethodEditPage";
			
		}
		
		@RequestMapping(value="update",method=RequestMethod.POST)
		public String UpdateOrder(@ModelAttribute OrderMethod orderMethod,Model model) {
			service.updateOrder(orderMethod);
			String message="orderMethod '"+orderMethod.getOrderId()+"'updated";
			model.addAttribute("message",message);
			List<OrderMethod> list=service.getAllOrder();
			model.addAttribute("list", list);
			return "OrderMethodDataPage";
		}
		
		 @RequestMapping("/view")
		  public String showOneOrderMethod(@RequestParam("sid")Integer id,Model model){
			  
			  
			 OrderMethod om= service.getOneOrderMethod(id);
			 model.addAttribute("ob",om);
			  
			  return "OrderMethodView";
		  } 


		 @RequestMapping("/excel")
			public ModelAndView shoeExcell(
					@RequestParam(value="id",required=false) Integer id){
				ModelAndView n=new ModelAndView();
				n.setView(new OrderMethodExcelView());
				if(id==null) {
					//exports all rows
					List<OrderMethod> list=service.getAllOrder();
					n.addObject("list",list);

				}
				else {
					OrderMethod st=service.getOneOrderMethod(id);
					n.addObject("list",Arrays.asList(st));
				}
				return n;
			}

			@RequestMapping("/pdf")
			public ModelAndView showpdf(@RequestParam(value="id",required = false)Integer id) {

				ModelAndView m=new ModelAndView();
				m.setView(new OrderMethodPdfView());

				if(id==null) {
					//show all
					List<OrderMethod> list=service.getAllOrder();
					m.addObject("list",list);
				} 
				else {
					//show one record

					OrderMethod st=service.getOneOrderMethod(id);
					m.addObject("list",Arrays.asList(st));

				}
				return m;
			}
	
			//for piechart and barchart 
			@RequestMapping("/charts")
			public String showCharts() {
			List<Object[]> list=service.getOrderMethodModeCount();
			String path=context.getRealPath("/");
			util.generatePie(path, list);
			util.generateBar(path, list);
			return "OrderMethodCharts";
			}


}
