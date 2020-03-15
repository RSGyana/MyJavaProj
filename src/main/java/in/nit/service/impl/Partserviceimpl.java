package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IPartdao;
import in.nit.model.Part;
import in.nit.service.IPartservice;
@Service
public class Partserviceimpl implements IPartservice {
@Autowired
    private IPartdao dao;

	@Transactional
	public Integer savePart(Part ob) {
		
		return dao.savePart(ob);
	}

	@Transactional(readOnly=true)
	public List<Part> getAllPart() {
		
		return dao.getAllPart();
	}

	@Transactional
	public void deletePart(Integer id) {
		dao.deletePart(id);

	}

	@Transactional
	public void updatePart(Part ob) {
		dao.updatePart(ob);

	}

	@Transactional(readOnly=true)
	public Part getOnePart(Integer id) {
		
		return dao.getOnePart(id);
	}

}
