package in.nit.dao;

import java.util.List;

import in.nit.model.Shippping;
import in.nit.model.Uom;

public interface IShipppingdao {
	Integer saveShippping(Shippping u);
	List<Shippping> loadallShippping();
	void deleteShippping(Integer id);
	 
	Shippping getOneShippping(Integer id);
	void updateShippping(Shippping id);

}
