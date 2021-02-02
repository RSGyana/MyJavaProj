package in.nit.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodservice;

@RestController
@RequestMapping("/rest/order")
public class OrderMethodRestControlller {
	@Autowired
	private IOrderMethodservice service;
	//FETCH ALL RECORDS
	@GetMapping("/all")
	public ResponseEntity<?> fetchAllRecords(){
		ResponseEntity<?> resp=null;
		try {
			List<OrderMethod> list=service.getAllOrder();
			if(list==null && list.isEmpty())

				resp=new ResponseEntity<>("records not found ",HttpStatus.NO_CONTENT);
			else {
				resp=new ResponseEntity<List<OrderMethod>>(list,HttpStatus.OK);
			}
		}
		catch (Exception e) {
			resp=new ResponseEntity<String>("unable to fetch",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}


	//FETCH ONE RECORD
	@GetMapping("/one/{id}")
	public ResponseEntity<?> FetchOneOrderMethod(@PathVariable("id")Integer id){

		OrderMethod om=service.getOneOrderMethod(id);
		ResponseEntity<?> resp=null;
		try {
			if(om==null) {
				resp=new ResponseEntity<String>("id"+id+" not there ",HttpStatus.NO_CONTENT);
			}
			else{
				resp=new ResponseEntity<OrderMethod>(om,HttpStatus.OK);			}
		} 
		catch (Exception e) {
			resp=new ResponseEntity<OrderMethod>(om,HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;

	}

	//DELETE ONE RECORD
	@DeleteMapping("/delete/{id}")
	
	public ResponseEntity<?> deleteOneOrdermethod(@PathVariable("id")Integer id){
		
		ResponseEntity<?> resp=null;
		try {
			service.deleteOrder(id);
			resp=new ResponseEntity<String>("order method '"+id+"'deleted",HttpStatus.OK);
			
			
		} catch (Exception e) {
	   resp=new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
			
		}
		return resp;
		}
	
	//UPDATE  RECORD
	
	
	@PutMapping("/edit")
	 public ResponseEntity<?> UpdateOrderMethod(@RequestBody OrderMethod ordermethod){
		
		ResponseEntity<?> resp=null;
		
		try {
			service.updateOrder(ordermethod);
			resp=new  ResponseEntity<String>("order method updated",HttpStatus.OK);
			
		} catch (Exception e) {
			resp=new ResponseEntity<String>(" not updated",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	//SAVE RECORD
	@PostMapping("/save")
	public ResponseEntity<?> SaveOrderMethod(@RequestBody OrderMethod orderMethod){
		ResponseEntity<?> resp=null;
		try {
			Integer id=service.saveOrder(orderMethod);
			resp=new ResponseEntity<String>("order method "+id+"saved",HttpStatus.CREATED);
		} catch ( Exception e) {
			resp=new ResponseEntity<String>("not saved",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	
	
}
