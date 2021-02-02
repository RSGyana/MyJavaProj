package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IShipppingdao;
import in.nit.model.Shippping;
import in.nit.service.IShipppingservice;
@Service
public class Shipppingserviceimpl implements IShipppingservice {
   @Autowired
	private IShipppingdao dao;
	
	  @Transactional
	public Integer saveShippping(Shippping u) {
		
		return dao.saveShippping(u);
	}

    @Transactional(readOnly= true )
	public List<Shippping> loadallShippping() {

		
		return dao.loadallShippping();
	}

	  @Transactional(readOnly = true)
		
	public Shippping getOneShippping(Integer id) {
	
		return dao.getOneShippping(id);
	}

	  @Transactional
	public void updateShippping(Shippping id) {
		dao.updateShippping(id);
		
	}
	  @Transactional
		public void deleteShippping(Integer id) {
	    	dao.deleteShippping(id);
			
		}


}
