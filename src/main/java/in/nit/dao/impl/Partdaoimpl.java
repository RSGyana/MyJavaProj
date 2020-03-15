package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IPartdao;
import in.nit.model.Part;
@Repository
public class Partdaoimpl implements IPartdao {
@Autowired
private HibernateTemplate ht;

	public Integer savePart(Part ob) {
		
		return (Integer)ht.save(ob);
	}

	@Override
	public List<Part> getAllPart() {
		
		return ht.loadAll(Part.class);
	}

	@Override
	public void deletePart(Integer id) {
		ht.delete(new Part(id));

	}

	@Override
	public void updatePart(Part ob) {
		ht.update(ob);

	}

	@Override
	public Part getOnePart(Integer id) {
		
		return ht.get(Part.class, id);
	}

}
