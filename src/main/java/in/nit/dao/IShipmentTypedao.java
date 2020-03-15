package in.nit.dao;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypedao {
	
	Integer saveShipmentType(ShipmentType ob);
	List<ShipmentType> getAllShipmentType();
	  void deleteShipmentType(Integer id);
	ShipmentType getOneShipmentType(Integer id);
	void updateShipmentType(ShipmentType ob);
	List<Object[]> getShipmentModeCount();

 
}
