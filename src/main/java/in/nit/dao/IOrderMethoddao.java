package in.nit.dao;

import java.util.List;

import in.nit.model.OrderMethod;



public interface IOrderMethoddao {
	Integer saveOrder(OrderMethod ob);
	List<OrderMethod> getAllOrder();
	  void deleteOrder(Integer id);
	  void updateOrder(OrderMethod ob);
	  OrderMethod getOneOrderMethod(Integer id);
	  
	  List<Object[]> getOrderMethodModeCount();
	  List<Object[]> getOrderIdAndOrderCode(String mode);



}
