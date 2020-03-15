package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.ISaleOrderdao;
import in.nit.model.SaleOrder;
import in.nit.service.ISaleOrderservice;
@Service
public class SaleOrderserviceimpl implements ISaleOrderservice {
@Autowired
private ISaleOrderdao dao;
	@Transactional
	public Integer saveSaleOrder(SaleOrder ob) {
		
		return dao.saveSaleOrder(ob);
	}

	@Transactional(readOnly = true)
	public List<SaleOrder> getAllSaleOrder() {
		
		return dao.getAllSaleOrder();
	}

	@Transactional
	public void deleteSaleOrder(Integer id) {
		dao.deleteSaleOrder(id);

	}

	@Transactional
	public void updateSaleOrder(SaleOrder ob) {
		dao.updateSaleOrder(ob);

	}

	@Transactional(readOnly = true)
	public SaleOrder getOneSaleOrder(Integer id) {
		
		return dao.getOneSaleOrder(id);
	}

}
