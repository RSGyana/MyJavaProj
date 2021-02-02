package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IWhUserTypedao;
import in.nit.model.WhUserType;
@Repository
public class WhUserTypedaoimpl implements IWhUserTypedao {
@Autowired
private HibernateTemplate ht;

	
	public Integer saveUser(WhUserType u) {
		
		return (Integer)ht.save(u);
	}

	
	public List<WhUserType> loadallIUser() {
		
		return ht.loadAll(WhUserType.class);
	}


	public void deleteUser(Integer id) {
	ht.delete(new WhUserType(id));

	}


	
	public WhUserType getOneUser(Integer id) {
		
		return ht.get(WhUserType.class,id);
	}


	
	public void updateUser(WhUserType u) {
		ht.update(u);
	}


	@Override
	public List<Object[]> getUserModeCount() {
		
		String hql=" select userType,count(userType) "
				+ " from in.nit.model.User "
				+ " group by userType ";
				return (List<Object[]>) ht.find(hql);

	}

}
