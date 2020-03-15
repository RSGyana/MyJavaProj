package in.nit.service;

import java.util.List;


import in.nit.model.PurchaseOrder;

public interface IPurchaseOrderservice {
	
	Integer savePurchaseOrder(PurchaseOrder ob);
	List<PurchaseOrder> getAllPurchaseOrder();
	  void deletePurchaseOrder(Integer id);
	  void updatePurchaseOrder(PurchaseOrder ob);
	  PurchaseOrder getOnePurchaseOrder(Integer id);



}
