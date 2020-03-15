package in.nit.dao;

import java.util.List;

 
import in.nit.model.WhUserType;

public interface IWhUserTypedao {
	
	Integer saveUser(WhUserType u);
	List<WhUserType> loadallIUser();
	void deleteUser(Integer id);
	WhUserType getOneUser(Integer id);
	void updateUser(WhUserType u);
	List<Object[]> getUserModeCount();


}
