package in.nit.service;

import java.util.List;

import in.nit.model.WhUserType;

public interface IWhUserTypeservice {

	
	Integer saveUser(WhUserType u);
	List<WhUserType> loadallIUser();
	void deleteUser(Integer id);
	WhUserType getOneUser(Integer id);
	void updateUser(WhUserType u);
	List<Object[]> getUserModeCount();

	
}
