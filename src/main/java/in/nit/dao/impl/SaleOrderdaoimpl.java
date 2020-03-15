package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.ISaleOrderdao;
import in.nit.model.SaleOrder;
@Repository
public class SaleOrderdaoimpl implements ISaleOrderdao {
@Autowired
private HibernateTemplate ht;
	@Override
	public Integer saveSaleOrder(SaleOrder ob) {
		
		return (Integer) ht.save(ob);
	}

	@Override
	public List<SaleOrder> getAllSaleOrder() {
		
		return ht.loadAll(SaleOrder.class);
	}

	@Override
	public void deleteSaleOrder(Integer id) {
	ht.delete(new SaleOrder(id));

	}

	@Override
	public void updateSaleOrder(SaleOrder ob) {
		ht.update(ob);

	}

	@Override
	public SaleOrder getOneSaleOrder(Integer id) {
		
		return ht.get(SaleOrder.class,id);
	}

}
