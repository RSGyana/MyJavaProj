package in.nit.dao;

import java.util.List;


import in.nit.model.SaleOrder;

public interface ISaleOrderdao {
	
	Integer saveSaleOrder(SaleOrder ob);
	List<SaleOrder> getAllSaleOrder();
	  void deleteSaleOrder(Integer id);
	  void updateSaleOrder(SaleOrder ob);
	  SaleOrder getOneSaleOrder(Integer id);
	  

}
