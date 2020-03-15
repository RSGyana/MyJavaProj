package in.nit.service;

import java.util.List;

import in.nit.model.SaleOrder;

public interface ISaleOrderservice {
	
	Integer saveSaleOrder(SaleOrder ob);
	List<SaleOrder> getAllSaleOrder();
	  void deleteSaleOrder(Integer id);
	  void updateSaleOrder(SaleOrder ob);
	  SaleOrder getOneSaleOrder(Integer id);
	  



}
