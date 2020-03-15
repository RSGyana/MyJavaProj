package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IPurchaseOrder;

import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseOrderservice;
@Service
public class PurchaseOrderserviceimpl implements IPurchaseOrderservice {
@Autowired
private IPurchaseOrder dao;
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder ob) {
		
		return dao.savePurchaseOrder(ob);
	}

	@Transactional(readOnly =  true)
	public List<PurchaseOrder> getAllPurchaseOrder() {
		
		return dao.getAllPurchaseOrder();
	}

	@Transactional
	public void deletePurchaseOrder(Integer id) {
		dao.deletePurchaseOrder(id);

	}

	@Transactional
	public void updatePurchaseOrder(PurchaseOrder ob) {
		dao.updatePurchaseOrder(ob);
	}

	@Transactional(readOnly = true)
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		
		return dao.getOnePurchaseOrder(id);
	}

}
