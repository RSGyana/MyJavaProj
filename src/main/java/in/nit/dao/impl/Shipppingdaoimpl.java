package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IShipppingdao;
import in.nit.model.Shippping;

@Repository
public class Shipppingdaoimpl implements IShipppingdao {
@Autowired
private HibernateTemplate ht;
	@Override
	public Integer saveShippping(Shippping u) {
	
		return (Integer) ht.save(u);
	}

	@Override
	public List<Shippping> loadallShippping() {
		return ht.loadAll(Shippping.class);
	}

	@Override
	public Shippping getOneShippping(Integer id) {
	
		return ht.get(Shippping.class,id);
	}

	@Override
	public void updateShippping(Shippping id) {
		ht.update(id);
		

	}
	@Override
	public void deleteShippping(Integer id) {
		ht.delete(new Shippping(id));
		
	}
}
