package in.nit.dao;

import java.util.List;


import in.nit.model.PurchaseOrder;

public interface IPurchaseOrder {
	
	Integer savePurchaseOrder(PurchaseOrder ob);
	List<PurchaseOrder> getAllPurchaseOrder();
	  void deletePurchaseOrder(Integer id);
	  void updatePurchaseOrder(PurchaseOrder ob);
	  PurchaseOrder getOnePurchaseOrder(Integer id);


}
