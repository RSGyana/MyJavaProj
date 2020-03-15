package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IOrderMethoddao;
import in.nit.model.OrderMethod;
@Repository
public class OrderMethoddaoImpl implements IOrderMethoddao {
	
@Autowired
 private HibernateTemplate ht;
 
	
	public Integer saveOrder(OrderMethod ob) {
		return  (Integer)ht.save(ob);

	}

	
	public List<OrderMethod> getAllOrder(){
		return ht.loadAll(OrderMethod.class);

		
	}

	
	public void deleteOrder(Integer id) {
		ht.delete(new OrderMethod(id));

	}


	@Override
	public void updateOrder(OrderMethod ob) {
		ht.update(ob);		
	}


	@Override
	public OrderMethod getOneOrderMethod(Integer id) {
				return ht.get(OrderMethod.class,id);
	}


	@Override
	public List<Object[]> getOrderMethodModeCount() {
		
		String hql=" select orderMethod,count(orderMethod) "
				+ " from in.nit.model.OrderMethod "
				+ " group by orderMethod ";
				return (List<Object[]>) ht.find(hql);

		
	}

	@Override
		public List<Object[]> getOrderIdAndOrderCode(String mode) {
			String hql="select orderId,orderCode from in.nit.model.OrderMethod where orderMode=?0";
			
			return (List<Object[]>) ht.find(hql,mode);
		}
		
		
		
		
		
}
