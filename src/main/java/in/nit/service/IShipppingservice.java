package in.nit.service;

import java.util.List;

import in.nit.model.Shippping;


public interface IShipppingservice {
	Integer saveShippping(Shippping u);
	List<Shippping> loadallShippping();
	void deleteShippping(Integer id);
	Shippping getOneShippping(Integer id);
	void updateShippping(Shippping id);

}
