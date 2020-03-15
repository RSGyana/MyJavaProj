package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IWhUserTypedao;
import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeservice;
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeservice {
@Autowired
private IWhUserTypedao dao;

	@Transactional
	public Integer saveUser(WhUserType u) {
		
		return  dao.saveUser(u);
	}

	@Transactional(readOnly = true)
	public List<WhUserType> loadallIUser() {
		
		return dao.loadallIUser();
	}

	@Transactional
	public void deleteUser(Integer id) {
		dao.deleteUser(id);

	}

	@Transactional(readOnly = true)
	public WhUserType getOneUser(Integer id) {
		
		return dao.getOneUser(id);
	}

	@Override
	@Transactional
	public void updateUser(WhUserType u) {
		dao.updateUser(u);
		
	}

	@Transactional(readOnly = true)
	public List<Object[]> getUserModeCount() {
		
		return dao.getUserModeCount();
	}

}
