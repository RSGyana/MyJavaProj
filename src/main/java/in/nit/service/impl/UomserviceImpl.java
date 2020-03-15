package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomdao;
import in.nit.model.Uom;
import in.nit.service.IUomservice;
@Service
public class UomserviceImpl implements IUomservice {
	@Autowired
	private IUomdao  dao;

	
	@Transactional
	public Integer saveUom(Uom u) {
	
		return dao.saveUom(u);
	}

	@Transactional(readOnly = true)
	public List<Uom> loadallIUom() {
		
		return dao.loadallIUom();
	}

	@Transactional
	public void deleteUom(Integer id) {
	   dao.deleteUom(id);
		
	}


	@Transactional(readOnly = true)
	public Uom getOneUom(Integer id) {
		
		return dao.getOneUom(id);
	}


	@Transactional
	public void updateUom(Uom u) {
		dao.updateUom(u);
		
	}

	@Transactional(readOnly = true)
	public List<Object[]> getUomModeCount() {
		
		return dao.getUomModeCount();
	}
	
	@Transactional(readOnly = true)
	public List<Object[]> getUomIdAndUomModel() {
		
		return dao.getUomIdAndUomModel();
	}
	
	}

