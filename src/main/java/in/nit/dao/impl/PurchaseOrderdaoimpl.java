package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IPurchaseOrder;

import in.nit.model.PurchaseOrder;
@Repository
public class PurchaseOrderdaoimpl implements IPurchaseOrder {
@Autowired
private HibernateTemplate ht;

	@Override
	public Integer savePurchaseOrder(PurchaseOrder ob) {
		
		return (Integer) ht.save(ob);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrder() {
		
		return ht.loadAll(PurchaseOrder.class);
	}

	@Override
	public void deletePurchaseOrder(Integer id) {
		ht.delete(new PurchaseOrder(id));

	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder ob) {
		ht.update(ob);

	}

	@Override
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		
		return ht.get(PurchaseOrder.class,id);
	}



}
