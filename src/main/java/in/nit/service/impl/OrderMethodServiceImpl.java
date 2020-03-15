package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IOrderMethoddao;
import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodservice;
@Service
public class OrderMethodServiceImpl implements IOrderMethodservice {
	@Autowired
	private IOrderMethoddao dao;
	
	

	@Transactional
	public Integer saveOrder(OrderMethod ob) {
		
		return dao.saveOrder(ob);
	}

	@Transactional(readOnly=true)
	public List<OrderMethod> getAllOrder() {
		
		return dao.getAllOrder();
	}

	@Transactional
	public void deleteOrder(Integer id) {
		dao.deleteOrder(id);

	}

	@Transactional
	public void updateOrder(OrderMethod ob) {
	     dao.updateOrder(ob);
		
	}

	@Transactional(readOnly = true)
	public OrderMethod getOneOrderMethod(Integer id) {
		
		return  dao.getOneOrderMethod(id);
	}

	@Transactional(readOnly = true)
	public List<Object[]> getOrderMethodModeCount() {

		return dao.getOrderMethodModeCount();
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getOrderIdAndOrderCode(String mode) {
		
		return dao.getOrderIdAndOrderCode(mode);
	}
	
}
